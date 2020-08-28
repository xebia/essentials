<template>
  <CardLayout>
    <Header :title="$page.category.title" color="indigo" />
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
import Header from '@/layouts/Header';

export default {
  name: 'Category',
  components: { Header },
  computed: {
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
  category(id: $id) {
    title
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
