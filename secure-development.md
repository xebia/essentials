---
layout: card
title: Develop for security
category: realisation
---

### Motivation

The internet hasn't been the safe, naive place it once was for a couple of decades now. Any connected system runs the risk of being targeted for a variety of kinds of attack, or used as an intermediary to attack some other target.

### Applicability

Security is often an implied requirement; few words are spent on the topic, but customers expect their systems to be built secure. Practical security is a tradeoff: it's not feasible to be 100% secure. Different systems emphasize different aspects of security and attract different kinds of attackers. Therefore, what's adequate for one system is overkill (or completely missing the point) for another.

### Application

Security is not something that can be bolted on after release, nor is it something that only concerns development. Securing a system starts during its initial, broad-strokes design and lasts all the way through its maintenance phase until the system is decommissioned. Identify which security properties are important, both to yourself (e.g. availability) and to your users (e.g. protection from identity theft). Embed these in your [Acceptance Criteria](acceptance-criteria). Identify which legal or industry standards apply. Employ secure coding practices. Identify abuse cases and test against them. Think about security aspects while [reviewing code](code-review). Consider incident response. Be aware that it's a perfectly valid decision to accept certain risks, just do so knowingly.

References

There is an enormous amount of literature, tools and online documentation on this subject. The [OWASP project](https://www.owasp.org/index.php/Main_Page) has extensive, free resources and is a good place to start looking. The [Security Development Lifecycle](http://www.microsoft.com/security/sdl/default.aspx) is a system that Microsoft adopted in the mid-2000's to address these concerns at every stage.
