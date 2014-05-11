---
layout: card
title: You get what you measure
category: collaboration
---
<p>You get what you measure</p>
---
<p>Metrics are useful, but beware of tunnel vision. If you focus exclusively
      on any specific quality attributes (like code coverage), other attributes may suffer.</p>
<p>This effect is magnified when the carrot or the stick is involved, such as a target
      code coverage ordained by management.</p>
---

Whenever you introduce some sort of [visible metric](make-it-visible), like Code Coverage Analysis or a [Sonar](http://sonarqube.org/) violations count, you introduce a pressure to improve that metric. You can multiply the effect by setting a goal or KPI or cash bonus on achieving some sort of target value. Worse still, you can set a penalty on not reaching that target value. Goals and target values are pretty arbitrary anyway. Sure, 80% coverage is better than 78%, but why not aim for 82?

The greater you make this pressure, the more you run the risk of (a) people gaming the system and (b) people over-optimizing to the detriment of aspects unmeasured. Your metric may end up doing more harm than good.

All this notwithstanding, metrics and measurement are generally good things. They're a useful tool for [improving](improve-continuously) your software development practice, or indeed any other. To avoid these pitfalls:

* pick a range of complementary metrics, to avoid too narrow a focus
* be honest about whether any metrics improvement is of actual benefit or just window-dressing
* periodically reevaluate whether you're still measuring the right things
* aim for an improving trend in all metrics, rather than specific threshold values.
