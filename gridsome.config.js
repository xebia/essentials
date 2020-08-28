// This is where project configuration and plugin options are located.
// Learn more: https://gridsome.org/docs/config

// Changes here require a server restart.
// To restart press CTRL + C in terminal and run `gridsome develop`

module.exports = {
  siteName: 'Xebia Essentials',
  icon: {
    favicon: './src/touch-icon.png',
    touchicon: './src/touch-icon.png',
  },
  plugins: [
    {
      use: 'gridsome-plugin-tailwindcss',
      options: {
        shouldPurge: process.env.NODE_ENV === 'production',
        purgeConfig: {
          content: ['./{src,cards}/**/*.vue', './{src,cards}/**/*.js', './{src,cards}/**/*.html', './cards/**/*.md'],
          keyframes: false,
          whitelist: ['body', 'html', 'img', 'a', 'g-image', 'g-image--lazy', 'g-image--loaded'],
          defaultExtractor: content => content.match(/[\w-/:]+(?<!:)/g) || [],
        },
      },
    },
    {
      use: '@gridsome/source-filesystem',
      options: {
        path: '**/*.md',
        baseDir: './cards',
        typeName: 'Card',
        refs: {
          category: {
            typeName: 'Category',
            create: true,
          },
        },
        remark: {
          grayMatter: {
            excerpt: (file, options) => {
              // Strip out the middle blocks, because they are for physical cards (back and front)
              const [content, ...meta] = file.content.split('---\n').reverse();
              file.excerpt = meta[meta.length - 1];
              file.content = content;
            },
          },
        },
      },
    },
  ],
  templates: {
    Category: [{ path: '/categories/:id' }],
  },
};
