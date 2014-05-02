---
layout: card
title: If something is too complex to understand, it must be wrong
category: realisation
---

### History

Originally used as a joke between Spring developers. Arjen Poutsma originally formulated the principle as:

> If something is too complex for me to understand it must be wrong

The card was reformulated to be more generally applicable. Note the correspondence with a famous quote from Calvin and Hobbes:

> As far as I'm concerned, if something is so complicated that you can't explain it in 10 seconds, then it's probably not worth knowing anyway.

### Motivation

Sticking to this principle means that you will not allow things that you don't understand to survive. In some cases, the exercise of proving something wrong will result in understanding rather than proof, in some cases it will simply result in proof.

### Applicability

Use this principle to attack parts of the code base that are no go areas or considered dangerous to change based on no apparent good reasons. The principle can also be applied to processes and rules in organizations to help them change.

### Application

Write a test case. In an organization rather than a code base your only weapon is reason, so you have to create a solid argument that proves the complexity is in fact wrong.

### Consequences

Not allowing complexity to remain unchallenged takes time and effort. We cannot attack all problems that we encounter. It is better to challenge one thing fully then to challenge many things but failing to provide any proof. This means that a few complexities will be taken out, and some are left for another day.

### Samples

In the early days of Spring Integration developers struggled with the model of allowing both chains of endpoints and connections between endpoints through channels. We also had DirectChannel that worked both ways (send and receive). This meant that we had channels implementing MessageSource and MessageTarget and endpoints implementing similar interfaces. Through the application of the original Poutsma principle we ended up with a simple and clear solution: anything in the framework is related to either a Message, an Endpoint, or a Channel.

### References

Related Cards: [Keep It Simple](kiss)


