<template>
  <CardLayout>
    <Header title="Table of Contents" color="indigo" />
    <div class="prose p-6">
      <p>This is an alphabetical index of the cards in the Xebia Essentials deck.</p>
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
  metaInfo: {
    title: 'Table of Contents',
  },
  components: {
    Header,
  },
  computed: {
    cards() {
      return this.$page.allCard.edges
        .filter(e => ['collaboration', 'craftsmanship', 'realisation', 'testing'].includes(e.node.category.title))
        .map(e => e.node);
    },
  },
};
</script>

<page-query>
query {
  allCard(sortBy: "excerpt", order: ASC) {
    edges {
      node {
        id
        excerpt
        title
        path
        category {
          title
        }
      }
    }
  }
}
</page-query>

<style lang="postcss" scoped>
.title {
  @apply h-64 text-white text-5xl font-bold;
}
</style>
