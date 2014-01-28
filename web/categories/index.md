---
layout: card
title: "Categories"
category: other
---

<div id="category-index" class="container">
  <ul id="categories">
    {% for type in site.card_types %}
    <li><a href="{{site.url}}/categories/{{type}}">{{type}}</a></li>
    {% endfor %}
  </ul>
</div>
