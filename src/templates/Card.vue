<template>
  <CardLayout>
    <header v-if="$page.card.header_image" class="bg-purple">
      <h1 class="title centered">{{ $page.card.title }}</h1>
      <div class="grid grid-cols-4">
        <div class="bg-red h-3" />
        <div class="bg-orange h-3" />
        <div class="bg-blue h-3" />
        <div class="bg-green h-3" />
      </div>
    </header>
    <header v-else class="p-8" :class="categoryClass">
      <h1 class="title">{{ $page.card.excerpt }}</h1>
    </header>
    <article class="prose p-6" v-html="$page.card.content" />
    <banner v-if="!$page.card.no_banner" />
  </CardLayout>
</template>

<script>
import Banner from '@/layouts/Banner';

export default {
  name: 'Card',
  metaInfo() {
    return {
      title: this.$page.card.excerpt,
    };
  },
  components: {
    Banner,
  },
  computed: {
    categoryClass() {
      return (
        {
          realisation: 'bg-blue',
          craftsmanship: 'bg-red',
          testing: 'bg-green',
          collaboration: 'bg-orange',
          other: 'bg-indigo',
        }[this.$page.card.category.title] || 'bg-indigo'
      );
    },
  },
};
</script>

<page-query>
query Card ($path: String!) {
  card: card (path: $path) {
   id
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
.centered {
  @apply flex justify-center items-center;
}
</style>
