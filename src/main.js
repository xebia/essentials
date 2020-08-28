import CardLayout from '~/layouts/Card.vue';

export default function(Vue, { router, head, isClient }) {
  Vue.component('CardLayout', CardLayout);

  head.link.push({
    href: '//fonts.googleapis.com/css?family=Open+Sans:400,600',
    rel: 'stylesheet',
    type: 'text/css',
  });
}
