<template>
  <div class="layout container">
    <header>
      <div class="title">Xebia Essentials</div>
      <div class="grid grid-cols-4">
        <div class="bg-red h-3" />
        <div class="bg-orange h-3" />
        <div class="bg-blue h-3" />
        <div class="bg-green h-3" />
      </div>
    </header>
    <slot />
    <footer class="text-gray mt-4 flex justify-between">
      <span>&copy; Copyright 2011-{{ new Date().getFullYear() }} Xebia</span>
      <a rel="author" href="https://www.xebia.com"><img class="h-6" :src="logo"/></a>
    </footer>
  </div>
</template>

<script>
import logo from '@/assets/images/logo.jpg';

export default {
  data() {
    return {
      logo,
    };
  },
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
body {
  background: #827d78;
}
.layout {
  @apply bg-white p-4;
}
.title {
  @apply h-64 bg-purple text-white text-5xl font-bold flex justify-center items-center;
}
</style>
