<template>
  <div class="layout container">
    <slot />
    <Banner v-if="showBanner" />
    <Footer />
  </div>
</template>

<script>
import Banner from '@/layouts/Banner';
import Footer from '@/layouts/Footer';

export default {
  components: { Banner, Footer },
  props: { showBanner: { type: Boolean, default: true } },
};
</script>

<style lang="postcss" scoped>
.layout {
  @apply bg-white p-4 my-4;
  max-width: 65ch;
}
</style>
