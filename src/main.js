import CardLayout from '~/layouts/Card.vue';

export default function(Vue, { router, head, isClient }) {
  Vue.component('CardLayout', CardLayout);

  head.link.push({
    href: '//fonts.googleapis.com/css?family=Open+Sans:400,600',
    rel: 'stylesheet',
    type: 'text/css',
  });
  head.link.push({ href: '/cards', rel: 'index' });
  head.meta.push({ name: 'twitter:card', content: 'summary' });
  head.meta.push({ name: 'twitter:site', content: '@xebia' });
  head.meta.push({ content: 'website', property: 'og:type' });
  head.meta.push({ content: 'en_US', property: 'og:locale' });
  head.meta.push({ content: 'image/jpeg', property: 'og:image:type' });
  head.meta.push({ content: '//essentials.xebia.com/images/XebiaEssentialsCards.jpg', property: 'og:image' });
  head.meta.push({ content: '1200', property: 'og:image:width' });
  head.meta.push({ content: '630', property: 'og:image:height' });
}
