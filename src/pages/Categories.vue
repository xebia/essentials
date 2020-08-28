<template>
  <CardLayout>
    <Header title="Categories" color="indigo" />
    <div class="prose p-6">
      <ul>
        <li v-for="category in categories" :key="category.title">
          <g-link :to="category.path">{{ category.title }}</g-link>
        </li>
      </ul>
    </div>
  </CardLayout>
</template>

<script>
import Header from '@/layouts/Header';

export default {
  metaInfo: {
    title: 'Categories',
  },
  components: {
    Header,
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
