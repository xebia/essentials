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
            category: page.data['category'],
            title: page.data['title'],
            back: page.data['back'],
          })
        end
      end

      api = {
        cards: cards,
        categories: site.config['card_types'],
        mailto: site.config['mailto'],
        url: site.config['url'],
        name: site.config['name'],
        description: site.config['description'],
        timestamp: Time.now
      }

      f =File.new(File.join(site.config['source'], 'api.json'), 'w+')
      f.puts api.to_json
    end

  end

end
