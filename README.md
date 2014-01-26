# Statically generated site for the Xebia Essentials cards

The site is generated using [Jekyll](http://jekyllrb.com/) and the content is writting in [Markdown](http://daringfireball.net/projects/markdown).

Every markdown file not prefixed with an underscore will be converted to html, injected into the specified layout and published under `{{site.url}}/filename` and linked to from both it's category and `{{site.url}}/all`. This behaviour is specified under `_plugins/categories.rb`.

Pull requests are more than welcome!

If you locally want to preview your changes, read on.

### Local development

- [Ruby](https://www.ruby-lang.org/en/)

To install Jekyll run:

    gem install jekyll

To locally serve the statically generated site, and automatically rebuild when any file is changed, run from the project root directory:

    jekyll serve -w

Be sure that in `\_config.yml` to property `url` is set to localhost port 4000. This ensures that the dynimically generated urls will point to the correct domain.

    url: "http://localhost:4000"
