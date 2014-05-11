module Jekyll
  require 'json'

  class ApiGenerator < Generator
    safe false
    priority :low

    def generate(site)
      cards = Array.new
      site.pages.each do |page|
        if page.data['layout'] == 'card' && page.data['category'] != 'other' then
          cards.push({
            name: page.url.gsub(/\//, ''),
            title: page.data['category'],
            front: page.data['front'],
            back: page.data['back'],
          })
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
