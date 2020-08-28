<template>
  <CardLayout>
    <header class="p-8 bg-indigo">
      <h1 class="title">Table of Contents</h1>
    </header>
    <div class="prose p-6">
      <p>This is an alphabetical index of the cards in the Xebia Essentials deck.</p>
      <ul>
        <li v-for="card in cards" :key="card.id">
          <g-link :to="card.path">{{ card.excerpt }}</g-link>
        </li>
      </ul>
    </div>
    <banner />
  </CardLayout>
</template>

<script>
import Banner from '@/layouts/Banner';

export default {
  metaInfo: {
    title: 'Table of Contents',
  },
  components: {
    Banner,
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
