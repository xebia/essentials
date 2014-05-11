module Jekyll
  require 'json'

  class CardFrontAndBackGenerator < Generator
    safe true
    priority :high

    def generate(site)
      converter = site.getConverterImpl(Jekyll::Converters::Markdown)

      site.pages.each do |page|
        if page.data['layout'] == 'card' then
          blocks = page.content.scan(/(.*?)---/m)
          if blocks.length == 2 then
            page.data['front'] = converter.convert(blocks[0].join(''))
            page.data['back'] = converter.convert(blocks[1].join(''))
          end
        end
      end
    end

  end

end
