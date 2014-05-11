module Jekyll
  require 'json'

  class ApiGenerator < Generator
    safe false
    priority :high

    def generate(site)
      converter = site.getConverterImpl(Jekyll::Converters::Markdown)
      cards = Array.new

      site.pages.each do |page|
        if page.data['layout'] == 'card' then
          blocks = page.content.scan(/(.*?)---/m)
          if blocks.length == 2 then
            cards.push({
              name: page.url.gsub(/\//, ''),
              title: page.data['category'],
              front: converter.convert(blocks[0].join('')),
              back: converter.convert(blocks[1].join(''))
            })
            #page.content.gsub(/.*---/m,'')
          end
        end
      end

      api = {
        cards: cards,
        mailto: site.config['mailto'],
        url: site.config['url'],
        name: site.config['name'],
        description: site.config['description'],
        types: site.config['card_types']
      }



      f =File.new(File.join(site.config['destination'], '../api.json'), 'w+')
      f.puts api.to_json
    end

  end

end
