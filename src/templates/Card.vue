<template>
  <CardLayout :show-banner="!$page.card.no_banner">
    <Header v-if="$page.card.header_image" :title="$page.card.title" color="purple" centered>
      <div class="grid grid-cols-4">
        <div class="bg-red h-3" />
        <div class="bg-orange h-3" />
        <div class="bg-blue h-3" />
        <div class="bg-green h-3" />
      </div>
    </Header>
    <Header v-else :title="$page.card.excerpt" :color="color" />

    <article class="prose p-6" v-html="$page.card.content" />
  </CardLayout>
</template>

<script>
import Header from '@/layouts/Header';

export default {
  name: 'Card',
  metaInfo() {
    return {
      title: this.$page.card.excerpt,
      meta: [
        {
          property: 'og:url',
          content: this.$page.metadata.siteUrl + this.$page.card.path,
        },
        {
          property: 'og:title',
          content: this.$page.card.header_image ? this.$page.card.title : this.$page.card.excerpt,
        },
        // Unable to extract summary from MD with current setup
        // {
        //   property: 'og:summary',
        //   content: this.$page.card.summary,
        // },
        // {
        //   property: 'og:description',
        //   content: this.$page.card.summary,
        // },
      ],
    };
  },
  components: {
    Header,
  },
  computed: {
    categories() {
      return this.$page.allCategory.edges.map(e => e.node);
    },
    color() {
      return (
        {
          realisation: 'blue',
          craftsmanship: 'red',
          testing: 'green',
          collaboration: 'orange',
          other: 'indigo',
        }[this.$page.card.category.title] || 'indigo'
      );
    },
  },
};
</script>

<page-query>
query Card ($path: String!) {
  metadata {
    siteUrl
  }
  card: card (path: $path) {
   id
   path
   category {
     title
   }
   title
   content
   excerpt
   no_banner
   header_image
  }
}
</page-query>

<style lang="postcss" scoped>
.title {
  @apply h-64 text-white text-5xl font-bold;
}
</style>
