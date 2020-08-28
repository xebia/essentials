<template>
  <header>
    <div :class="['bg-' + color, centered ? 'centered' : '']" class="p-8 h-64">
      <h1>{{ title }}</h1>
    </div>
    <slot />
  </header>
</template>

<script>
export default {
  name: 'Header',
  props: {
    color: { type: String, default: 'indigo' },
    centered: { type: Boolean },
    title: { type: String, required: true },
  },
};
</script>

<style lang="postcss" scoped>
h1 {
  @apply text-white text-5xl font-bold;
}
.centered {
  @apply flex justify-center items-center;
}
</style>
