---
layout: card
category: craftmanship
---
Work in small increments
---
<p>Every commit should be a change from one stable state of the system to another stable state of the system, and should not represent more than two hours of work.</p>
---

### Motivation

The natural tendency of developers is to fix the world as they move through it. This is a good habit, but each small fix there should isolated. Stop the world refactorings are doomed to fail, so you should strive to avoid them.

### Applicability

In any situation where you are changing a working system. Usually we apply this to software, but it works equally well in teams, cars and households.

### Application

Learn to limit the amount of work you do between commits. This forces you to break your work into small, coherent changes, often a number of changes that preserve existing functionality while paving the way for the new features, followed by one more more changes that enable the new behaviour.

Run your test suite before every commit.

### Consequences

Easier integration: fewer merge conflicts occur and when they do they're much easier to resolve.
Higher quality: you can't break your work into small, coherent changes without a clear understanding of your goal and how to get there. The small, coherent changes are easier to keep in your head at once. These factors combined tend to improve the quality of your code and reduce the number of defects.
All changes are optional. If you decide to keep the new feature, but not to deprecate the old API you can revert the deprecation in isolation. This is also useful to limit impact if you need to cut your losses and back out of a bad idea.
Reordering of changes becomes possible. When changes depend on each other this becomes a non trivial exercise, but it is usually possible to change the order of changes in retrospect.

### References

* [one-change-at-a-time](one-change-at-a-time)
* [thirty-minute-methods](thirty-minute-methods)

