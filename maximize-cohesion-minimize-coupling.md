---
layout: card
title: Maximize cohesion Minimize coupling
category: realisation
---
<p>Maximize cohesion</p>
<p>Minimize coupling</p>
---
<p>Maximizing cohesion and minimizing coupling reduces complexity and increases testability.</p>
---

### Motivation

*Coupling* is the degree to which each program module relies on each one of the other modules. So, coupling is all about the relation between modules. Tightly coupled systems have a number of undesirable properties:

* Changes in one module tend to have a ripple effect on other modules. (So it's hard to make isolated changes.)
* It will be hard to test a module in isolation.
* It will be hard to reuse a module in an alternative context.

*Cohesion* is a measure of how strongly-related or focused the responsibilities of a single module are. Systems with minimal cohesion have a number of undesirable properties:

* (When applied to source code) code tends to be less readable.
* Code is likely to be less reusable in alternative contexts.
* Complexity is high. (It's hard to figure out what belongs where and why.)

As a consequence, you should *minimize* coupling and *maximimze* cohesion when designing your modules.

### Applicability

*Minimal coupling*, *maximal cohesion* is applicable to many contexts. Traditionally, it's often associated to source code level design practices, but it is by no means restricted to that context. Many people have argued that it is equally applicable in enterprise scale problems[2], and I have no problem considering it applicable to hardware design as well. The standardization of USB, PCI, memory modules - it all seems to be driven by a desire to minimize coupling (allowing us to use it in many contexts) as well a maximizing cohesion (this piece of hardware serves one function only).

### Application

In order to maximize cohesion, make sure you are always able to summarize the purpose of a single module in a single phrase. If it turns out to be impossible to capture the purpose of a module into a single discriminative phrase, then that's a smell. At the other hand, don't go totally overboard by making everything a separate module; it will have a dramatic effect on the number of dependencies between modules, and therefore hurt you in terms of coupling.

One of the tools that might help you organizing your dependencies is the Dependency Structure Matrix.

### Consequences

Applying this principle makes it more likely that pieces of your software will survive over time.

### References

1. Structured Design, W. Stevens, G. Myers, L. Constantine, IBM Systems Journal, 13 (2), 115-139, 1974.
2. Simple Architectures for Complex Enterprises, R. Sessions, Microsoft Press, 2008

