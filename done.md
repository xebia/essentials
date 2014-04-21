---
layout: card
title: It ain't over till it's done
category: collaboration
---

### Motivation

Have you ever come across the situation when you walked up to the story wall, picked up your story and proudly moved it to Done state? Moments later, the tester comes to you and asks "is it deployed on the Test server, so that I can test that?", the Scrum Master asks "has that shown to the Product Owner?" Another dev asks "are there still pending tests cases to commit 'cause I see some of them missing here". And you response was probably: "No".

Scrum provides the Definition of DONE (DoD), which is a shared checklist of criteria for a story to be considered DONE. Tasks in the definition are mutually agreed between the development team and the Product Owner.

### Applicability

Definitions of DONE can be applied to any business or technical story and may differ a bit in different kinds of activities. There may be multiple Definitions of DONE for different sorts of activities, although you should try to keep things simple; in many cases it will suffice to just skip a step as "not applicable". For example, a Refactoring technical story done as a part of removing technical debt may not be showcased to the Product Owner.

### Application

DoD can be put as points on a sheet of paper against your story wall. In teams using a digital wall such as Mingle, ScrumWorks, GreenHopper or Rally, it is generally put up in the wiki and cross referenced when a story is completed.

The sprint retrospective is a good time to check if the prevailing Definition of DONE needs to be amended or updated.

### Consequences

The definition of done prevents unpleasant, last minute surprises. It puts everyone on the same page. It also leads to better story estimation because you don't just estimate for the lines of code to make that feature working but other things as well.

### Samples

Sample definition of DONE:

Have all the [acceptance criteria](acceptance-criteria) implemented as specified in the story.
Sufficient unit test around the code (let's say 80%).
Code's [peer review](code-review) is done if necessary.
The story is deployed on the testing environment using CI.
The story is [deployed in production](done-is-live).
Functional tests are written for the story.
Story is signed off by the product owner.
Related cards

## Code Review

* [Code R:view](code-review)
* [Test Everything](test-everything)
* [Done is Live](done-is-live)
* [Brutal Transparency](brutal-transparency)
