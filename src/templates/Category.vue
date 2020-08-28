<template>
  <CardLayout>
    <template #crumbpath>
      <Crumbpath :items="[{ label: 'Home', to: '/' }, { label: title }]" />
    </template>
    <Header :title="title" color="indigo" />
    <div class="prose p-6">
      <ul>
        <li v-for="card in cards" :key="card.id">
          <g-link :to="card.path">{{ card.excerpt }}</g-link>
        </li>
      </ul>
    </div>
  </CardLayout>
</template>

<script>
import Crumbpath from '@/components/Crumbpath';
import Header from '@/layouts/Header';

export default {
  name: 'Category',
  metaInfo() {
    return {
      title: this.title,
      meta: [
        {
          property: 'og:url',
          content: this.$page.metadata.siteUrl + this.$page.category.path,
        },
        {
          property: 'og:title',
          content: this.$page.category.title,
        },
        {
          property: 'og:summary',
          content: `List of all cards in category ${this.$page.category.title}`,
        },
      ],
    };
  },
  components: { Crumbpath, Header },
  computed: {
    title() {
      return this.$page.category.title.charAt(0).toUpperCase() + this.$page.category.title.slice(1);
    },
    cards() {
      return this.$page.category.belongsTo.edges
        .map(e => e.node)
        .sort((a, b) => (a.excerpt < b.excerpt ? -1 : a.excerpt > b.excerpt ? 1 : 0));
    },
  },
};
</script>

<page-query>
query($id: ID!) {
  metadata {
    siteUrl
  }
  category(id: $id) {
    title
    path
    belongsTo {
      edges {
        node {
          ... on Card {
            id
            path
            title
            excerpt
          }
        }
      }
    }
  }
}
</page-query>
