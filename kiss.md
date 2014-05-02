---
layout: card
title: Your solution should not be more complicated than the problem
category: realisation
---

### Also known as

* The simplest thing that could possibly work
* Keep It Simple, Stupid (KISS)
* Less is more
* You Ain't Gonna Need It (YAGNI)

### Motivation

When designing systems or finding solutions for problems in software development, we go for the simplest possible solution. We make things more complicated when we have concrete requirements for them no sooner. The core idea behind this is that it is a waste to spend time on things you may not need in the future.

### Applicability

This applies to all the engineering that we do. This does not mean that there should have no design, on the contrary design is often a very important activity. We state that design has to be based on real and current requirements.

### Application

On the topic of software development it means that we do not design our objects for possible future needs and architectures. Instead we design them for the current need that we have right now, and refactor once we come up against a new requirement or challenge.

### Consequences

When we do this right we achieve three things:

1. We avoid unnecessary work, since many of the things we might need in the future will prove to be useless
2. We avoid unnecessary complexity, since we only have to deal with our current actual requirements, and the dead code of point 1 will not get in the way
3. We follow the agile principle of deciding at the last responsible moment. By only implementing what is actually necessary we implement things at the time when we know most about them, not sooner, leading to better design

### Samples

Every project has examples of overcomplicating matters. It often starts with the technology and infrastructure choices we make. Does this client indeed require webframework X and database Y and workflowengine Z? It goes down to code we write.

### References

* [http://en.wikipedia.org/wiki/KISS_principle](http://en.wikipedia.org/wiki/KISS_principle)
* [http://people.apache.org/~fhanik/kiss.html](http://people.apache.org/~fhanik/kiss.html)


