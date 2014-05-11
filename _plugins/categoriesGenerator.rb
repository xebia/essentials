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

  class OverviewPage < Page
    def initialize(site, name)
      @site = site
      @base = site.source
      @dir = name
      @name = 'index.html'
      self.process(@name)
        self.read_yaml(File.join(site.source, '_layouts'), 'list.html')
      self.data['category'] = 'other'
      self.data['title'] = 'all'
      self.data['cards'] = []
      site.pages.each do |page|
        if page.data && page.data['category'] != 'other'
          self.data['cards'] << page.basename
        end
      end
    end
  end

  class CategoryPageGenerator < Generator
    safe true
    def generate(site)
      site.config["card_types"].each do |category|
        site.pages << CategoryPage.new(site, site.source, File.join("categories", category), category)
      end
      site.pages << OverviewPage.new(site, 'all')
    end
  end

end
