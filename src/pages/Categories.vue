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
  metaInfo() {
    return {
      title: 'Categories',
      meta: [
        {
          property: 'og:url',
          content: this.$page.metadata.siteUrl + '/categories/',
        },
        {
          property: 'og:title',
          content: 'Categories',
        },
        {
          property: 'og:summary',
          content: 'List of all card categories',
        },
      ],
    };
  },
  components: {
    Header,
  },
  computed: {
    categories() {
      return this.$page.allCategory.edges.filter(e => 'other' !== e.node.title).map(e => e.node);
    },
  },
};
</script>

<page-query>
query {
  metadata {
    siteUrl
  }
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
