<template>
  <CardLayout>
    <header class="p-8 bg-indigo">
      <h1 class="title">{{ $page.category.title }}</h1>
    </header>
    <div class="prose p-6">
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
  name: 'Category',
  components: { Banner },
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

<style lang="postcss" scoped>
.title {
  @apply h-64 text-white text-5xl font-bold;
}
</style>
