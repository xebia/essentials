<template>
  <CardLayout :show-banner="!$page.card.no_banner">
    <div v-if="$page.card.header_image">
      <Header :title="$page.card.title" color="purple" centered>
        <div class="grid grid-cols-4">
          <div class="bg-red h-3" />
          <div class="bg-orange h-3" />
          <div class="bg-blue h-3" />
          <div class="bg-green h-3" />
        </div>
      </Header>
      <p class="my-4">
        <g-link class="button small mr-2" to="/cards">Card index</g-link>
        <g-link class="button small" to="/categories">Categories</g-link>
      </p>
    </div>
    <div v-else>
      <Header :title="$page.card.excerpt" :color="color" />
    </div>

    <template v-if="!$page.card.header_image" #crumbpath>
      <Crumbpath :items="[{ label: 'Home', to: '/' }, ...crumbs]" />
    </template>

    <article class="prose p-6" v-html="$page.card.content" />
  </CardLayout>
</template>

<script>
import Crumbpath from '@/components/Crumbpath';
import Header from '@/layouts/Header';

export default {
  name: 'Card',
  metaInfo() {
    return {
      title: this.$page.card.header_image ? this.$page.card.title : this.$page.card.excerpt,
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
    Crumbpath,
    Header,
  },
  computed: {
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
    crumbs() {
      const { title, path } = this.$page.card.category;
      const label = title.charAt(0).toUpperCase() + title.slice(1);
      return [{ label, to: path }, { label: this.$page.card.excerpt }];
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
     path
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
