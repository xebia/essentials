# Statically generated site for the Xebia Essentials cards

The site is generated using [Jekyll](http://jekyllrb.com/) and the content is
written in [Markdown](http://daringfireball.net/projects/markdown).

The top section of each markdown file contains the metadata, an optional second
and third section contain the card's front and back, while the last block
contains the actual web content.

Configuration is done through `_config` and all files not prefixed with an
underscore will be compiled and copied over to `{{site.url}}/filename`

**Pull requests are more than welcome!**

### Local development

- [Ruby](https://www.ruby-lang.org/en/)

To install Jekyll run:

    gem install jekyll

To locally serve the statically generated site, and automatically rebuild when
any file is changed, run from the project root directory:

    jekyll serve -w --trace

Be sure that in `_config.yml`, the property `url` is set to localhost port
4000. This ensures that the dynamically generated urls will point to the
correct domain.

    url: "http://localhost:4000"

### PLugins

## Generators

# categoriesGenerator.rb

This generator will create an overview page for each category under
`/categories/{{category_name}}/` and a global overview under `/all/`.

# frontAndBackGenerator.rb

This generator will take all `cards`, grab the second dashes-separated block
and add it to `data.title` and converts the third dashes-separated block from
markdown to html and stores it under `data.back`.

It is important to note that the first block should be a plaintext string,
while the second block can contain a variety of markdown.

# apiGenerator.rb

Will generate `api.json` representing all data and metadata, used by the mobile
applications.

**note**: it is important that this generator runs *after* all others, to
reflect the final state  of the project

### Deploying to essentials.xebia.com

Ensure your public key has been added to user `essentials` on
`applications.xebia.com` under `/home/essentials/.ssh/authorized_keys`

Then simply run:

    _scripts/publish
