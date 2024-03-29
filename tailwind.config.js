const plugin = require('tailwindcss/plugin');

module.exports = {
  theme: {
    colors: {
      blue: '#107FD5',
      green: '#6DC726',
      indigo: '#4C2F5C',
      orange: '#FC7A25',
      gray: '#A0A0A0',
      red: '#F80068',
      purple: '#6C1D5F',
      white: '#FFFFFF',
      yellow: '#E3AF01',
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
    require('@tailwindcss/typography'),
    plugin(({ addBase }) => {
      addBase({
        html: {
          fontSize: '14px',
        },
        body: {
          background: '#eae0d6',
        },
      });
    }),
    plugin(({ addComponents, theme }) => {
      addComponents({
        // Can not easily style stuff from Markdown files from within )scoped) Vue file, so we do it globally
        // Override prose style
        '.button': {
          background: theme('colors.yellow'),
          display: 'inline-block',
          color: `${theme('colors.white')} !important`,
          padding: `${theme('spacing.2')} ${theme('spacing.3')}`,
          textDecoration: 'none !important',
        },
        '.button.small': {
          padding: `${theme('spacing.1')} ${theme('spacing.2')}`,
          fontSize: theme('fontSize.sm'),
        },
      });
    }),
  ],
};
