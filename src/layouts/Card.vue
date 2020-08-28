<template>
  <div class="layout container">
    <slot />
    <Footer />
  </div>
</template>

<script>
import Footer from '@/layouts/Footer';

export default {
  components: { Footer },
};
</script>

<static-query>
query {
  metadata {
    siteName
  }
}
</static-query>

<style lang="postcss">
.layout {
  @apply bg-white p-4 my-4;
  max-width: 65ch;
}
</style>
