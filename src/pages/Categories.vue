<template>
  <CardLayout>
    <header class="p-8 bg-indigo">
      <h1 class="title">Categories</h1>
    </header>
    <div class="prose p-6">
      <ul>
        <li v-for="category in categories" :key="category">
          <g-link :to="category.path">{{ category.title }}</g-link>
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
    title: 'Categories',
  },
  components: {
    Banner,
  },
  computed: {
    categories() {
      return this.$page.allCategory.edges.map(e => e.node);
    },
  },
};
</script>

<page-query>
query {
  allCategory(sortBy: "title", order: ASC) {
    edges {
      node {
        id
        title
        path
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
