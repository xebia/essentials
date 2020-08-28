<template>
  <ul>
    <li class="inline text-gray" v-for="(item, index) in items" :key="index">
      <g-link v-if="item.to" :to="item.to" class="underline">{{ item.label }}</g-link>
      <span v-else>{{ item.label }}</span
      ><span v-if="index < items.length - 1" class="mx-2">&rsaquo;</span>
    </li>
  </ul>
</template>

<script>
export default {
  name: 'Crumbpath',
  props: { items: { type: Array, required: true } },
};
</script>
