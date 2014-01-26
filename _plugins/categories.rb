module Jekyll

  class CategoryPage < Page
    def initialize(site, base, dir, category)
      @site = site
      @base = base
      @dir = dir
      @name = 'index.html'


      self.process(@name)
        self.read_yaml(File.join(base, '_layouts'), 'list.html')
      self.data['category'] = category
      category_title_prefix = site.config['category_title_prefix'] || 'category: '
      self.data['title'] = "#{category_title_prefix}#{category}"
      self.data['cards'] = ['alone-time']
    end
  end

  class CategoryPageGenerator < Generator
    safe true

    def generate(site)
      p 'a'
      site.config["card_types"].each do |category|
        p category
        site.pages << CategoryPage.new(site, site.source, File.join("categories", category), category)
      end
    end
  end

end
