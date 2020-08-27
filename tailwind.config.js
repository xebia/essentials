const plugin = require('tailwindcss/plugin');

module.exports = {
  theme: {
    colors: {
      blue: '#257dc1',
      green: '#71be44',
      orange: '#f47a26',
      gray: '#A0A0A0',
      red: '#ee2768',
      purple: '#6c1d5f',
      white: '#ffffff',
    },
    fontFamily: {
      sans: 'Open Sans, Roboto, Helvetica Neue, Helvetica, Arial, sans-serif',
    },
    container: {
      center: true,
      padding: '2rem',
    },
  },
  plugins: [
    plugin(({ addBase }) => {
      addBase({
        html: {
          fontSize: '14px',
        },
      });
    }),
  ],
};
