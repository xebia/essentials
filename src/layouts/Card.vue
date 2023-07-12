<template>
  <div class="container layout">
    <div class="my-4 min-h[1.5rem]"><slot name="crumbpath" /></div>
    <div class="page">
      <slot />
      <Banner v-if="showBanner" />
      <Footer />
    </div>
  </div>
</template>

<script>
import Crumbpath from '@/components/Crumbpath';
import Banner from '@/layouts/Banner';
import Footer from '@/layouts/Footer';

export default {
  components: { Banner, Crumbpath, Footer },
  props: { showBanner: { type: Boolean, default: true } },
};
</script>

<style lang="postcss" scoped>
.layout {
  max-width: 65ch;
}
.page {
  @apply bg-white p-4 my-4;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
}
</style>
