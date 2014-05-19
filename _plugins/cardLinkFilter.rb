module Jekyll
  module CardLinkFilter
    def card_link(name)
      pretty_name = name.split("-").map(&:capitalize).join(" ")
      "<a href=\"#{name}\">#{pretty_name}</a>"
    end
  end
end

Liquid::Template.register_filter(Jekyll::CardLinkFilter)
