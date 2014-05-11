# compiles the first --- seperated block into page.data.front, and the second
# into page.data.back, and removes both from the file content

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
            page.data['title'] = blocks[0][0]
            page.data['back'] = converter.convert(blocks[1].join(''))
          end

          page.content = page.content.gsub(/.*^---$/m,'')
        end
      end
    end

  end

end
