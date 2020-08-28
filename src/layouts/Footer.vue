<template>
  <footer class="text-gray mt-4 flex justify-between">
    <span>&copy; Copyright 2011-{{ new Date().getFullYear() }} Xebia</span>
    <a rel="author" href="https://www.xebia.com"><img class="h-6" :src="logo"/></a>
  </footer>
</template>

<script>
import logo from '@/assets/images/logo.jpg';

export default {
  data() {
    return { logo };
  },
};
</script>
