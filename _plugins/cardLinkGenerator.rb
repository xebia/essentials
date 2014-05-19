module Jekyll

  class CardLinkGenerator < Generator
    priority :high

    def card_link(name, text = '')
      if text.nil? || !defined?(text) || (text == '') then
        text = name.split("-").map(&:capitalize).join(" ")
      end
      "<a href=\"#{name}\" title=\"The Xebia Essentials [#{name}] Card\">#{text}</a>"
    end

    def generate(site)
      site.pages.each do |page|
        related = Set.new page.data['related']
        page.content.scan(/\[%([^]]*)\](?:\(([^)]*)\))?/).each do |match|
          related.add(match[0])
          page.content = page.content.sub(/\[%([^]]*)\](?:\(([^)]*)\))?/, card_link(match[0], match[1]))
        end
        page.data['related'] = related.to_a
        puts page.data['related']
      end
    end
  end

end
