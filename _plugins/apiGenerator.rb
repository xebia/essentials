require 'json'
module Jekyll

  class JSONIndex < Page
    def initialize(site, base, dir, name, json)
      @site = site
      @base = base
      @dir = dir
      @name = name

      self.process(@name)
      self.read_yaml(File.join(base, '_layouts'), 'page.json')
      self.data['data'] = json
    end
  end

  class ApiGenerator < Generator
    safe true
    priority :lowest

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
        timestamp: Time.now,
        enableCustomerSupport: true
      }

      #f =File.new(File.join(site.config['source'], 'api.json'), 'w+')
      #f.puts api.to_json
      site.pages << JSONIndex.new(site, site.source, '', 'api.json', api.to_json)

    end
  end

end

# Filter to output JSON data

module JsonFilter
  def json(hash)
    hash.delete('next')
    hash.delete('previous')
    hash.to_json
  end

  Liquid::Template.register_filter self
end
