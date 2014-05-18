---
layout: card
title: "Categories"
category: other
---

<div id="category-index" class="container">
  <ul id="categories">
    {% for type in site.card_types %}
    {% unless type.name == 'other' %}
      <li><a href="{{site.url}}/categories/{{type.name}}">{{type.name}}</a></li>
    {% endunless %}
    {% endfor %}
  </ul>
</div>
