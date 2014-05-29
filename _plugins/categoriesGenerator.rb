module Jekyll

  class CategoryPage < Page
    def initialize(site, base, dir, category)
      @site = site
      @base = base
      @dir = dir
      @name = 'index.html'

      self.process(@name)
        self.read_yaml(File.join(base, '_layouts'), 'list.html')
      self.data['category'] = 'other'
      category_title_prefix = site.config['category_title_prefix'] || 'category: '
      self.data['title'] = "#{category_title_prefix}#{category}"
      self.data['cards'] = []
      site.pages.each do |page|
        if page.data && page.data['category'] == category
          self.data['cards'] << page.basename
        end
      end
    end
  end

  class CategoryPageGenerator < Generator
    safe true
    def generate(site)
      site.config["card_types"].each do |category|
        site.pages << CategoryPage.new(site, site.source, File.join("categories", category['name']), category['name'])
      end
    end
  end

end
