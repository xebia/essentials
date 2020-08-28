![Xebia Essentials](https://raw.githubusercontent.com/xebia/essentials/master/img/XebiaEssentialsCards.jpg?token=3891755__eyJzY29wZSI6IlJhd0Jsb2I6eGViaWEvZXNzZW50aWFscy9tYXN0ZXIvaW1nL1hlYmlhRXNzZW50aWFsc0NhcmRzLmpwZyIsImV4cGlyZXMiOjE0MDI4NjA4MDZ9--390a00c227c472015e94b6b0e613cc1785ef4bb0)

[Website](http://essentials.xebia.com) |
[Api](http://essentials.xebia.com/api.json) |
[iOS source](https://github.com/xebia/ios-essentials) |
[Android source](https://github.com/xebia/android-essentials) |
[Xebia](http://www.xebia.com) |
[Blog](http://blog.xebia.com)

[![Build Status](https://travis-ci.org/xebia/essentials.svg?branch=master)](https://travis-ci.org/xebia/essentials)
[![Stories in Ready](https://badge.waffle.io/xebia/essentials.png?label=ready)](https://waffle.io/xebia/essentials)

# Xebia Essentials static site generator

This repository contains the static site generator for the [Xebia Essentials](http://essentials.xebia.com), along with all the cards' content and metadata. Each page contains [YAML](http://www.yaml.org/) [front matter](https://gridsome.org/docs/data-store-api/#preprocessing-markdown-frontmatter), two optional [markdown](http://daringfireball.net/projects/markdown) sections for the front and backsites of the [printed cards](http://xebia.com/books/xebia-essentials?utm_source=readme&utm_medium=web&utm_campaign=essentials) followed by a final markdown section that will be converted into the corresponding web page.

This results in the following layout:

    ---
    metadata
    ---
    front
    ---
    back
    ---
    webpage

Configuration is done through Gridsome's `gridsome.config.js` and `gridsome.server.js`.

**Pull requests are more than welcome, see the [open issues](https://github.com/xebia/essentials/issues?state=open)!**

## Licence

![CC-BY-NC](http://i.creativecommons.org/l/by-nc/3.0/88x31.png)

The content is lienced under [CC BY-NC 4.0](https://creativecommons.org/licenses/by-nc/4.0/), with the exception of
the images and text-content of the cards for which the copyright is maintained.

## Local development

### Dependencies

The project expects you to have NodeJS installed.

Install all dependencies through

```bash
npm install
```

### Build & Serve

To locally serve the statically generated site at `http://localhost:8080`, and automatically rebuild when
any file is changed, run from the project root directory:

```bash
npm run develop
```

GraphQL Playground is at `http://localhost:8080/___explore`.

Build the static site using

```bash
npm run build
```

## Deploying to essentials.xebia.com

TBD
