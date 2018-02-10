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

This repository contains the static site generator for the [Xebia Essentials](http://essentials.xebia.com), along with all the cards' content and metadata. Each page contains [YAML](http://www.yaml.org/) [front matter](http://jekyllrb.com/docs/frontmatter/), two optional [markdown](http://daringfireball.net/projects/markdown) sections for the front and backsites of the [printed cards](http://xebia.com/books/xebia-essentials?utm_source=readme&utm_medium=web&utm_campaign=essentials) followed by a final markdown section that will be converted into the corresponding web page.

This results in the following layout:

    ---
    metadata
    ---
    front
    ---
    back
    ---
    webpage

Configuration is done through `_config` and all files not prefixed with an
underscore will be compiled and copied over to `{{site.url}}/filename`

**Pull requests are more than welcome, see the [open issues](https://github.com/xebia/essentials/issues?state=open)!**

## Licence

![CC-BY-NC](http://i.creativecommons.org/l/by-nc/3.0/88x31.png)

The content is lienced under [CC BY-NC 4.0](https://creativecommons.org/licenses/by-nc/4.0/), with the exception of
the images and text-content of the cards for which the copyright is maintained.

## Local development

### Running in Docker

You might not want to install a bunch of Ruby directly on your machine. You can throw in these two
commands before everything else to build the website in isolation:

```
user@laptop$ docker run --publish 4000:4000 --volume $PWD:/essentials --workdir /essentials -it ruby:latest bash
root@container$ apt-get update && apt-get install shellcheck
````

### Dependencies

Install all dependencies through

```bash
    bundle install
```

### Build & Serve

To locally serve the statically generated site, and automatically rebuild when
any file is changed, run from the project root directory:

```bash
    $ ./_scripts/serve [--host 0.0.0.0]
```

If you're running inside docker, include the `--host` directive. Otherwise, omit it.

### Test

To test simply run. Ensure you've installed [shellcheck](https://github.com/koalaman/shellcheck) through your package manager.

```bash
    $ ./_scripts/test
```

### Plugins

#### categoriesGenerator.rb

This generator will create an overview page for each category under
`/categories/{{category_name}}/` and a global overview under `/all/`.

#### frontAndBackGenerator.rb

This generator will take all `cards`, grab the second dashes-separated block
and add it to `data.title` and converts the third dashes-separated block from
markdown to html and stores it under `data.back`.

It is important to note that the first block should be a plaintext string,
while the second block can contain a variety of markdown.

#### apiGenerator.rb

Will generate `api.json` representing all data and metadata, used by the mobile
applications.

**note**:

- it is important that this generator runs *after* all others, to reflect the final state  of the project
- the api.json contains a key ```enableCustomerSupport```, this is the kill switch to disable the customer support feature in the iOS app

## Deploying to essentials.xebia.com

Ensure your public key has been added to user `essentials` on
`applications.xebia.com` under `/home/essentials/.ssh/authorized_keys`.

Then simply run:

```bash
    $ ./_scripts/publish
```
