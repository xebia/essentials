---
layout: card
title: Write small and focused interfaces
category: realisation
---

### Also known as

Interface Segregation Principle: Clients should not be forced to depend upon interfaces that they don't use.

Alternate Definition: The dependency of one class to another one should depend on the smallest possible interface

### Motivation

How do I design a interface?

### Applicability

As we define our interfaces, it becomes important that we clearly understand the role the interface plays within the context of our application, when defining the operation on an interface, we should do so in a manner that doesn't accommodate multiple roles. Therefore, an interface should be responsible for allowing an object to assume a SINGLE ROLE, assuming the class of which that object is an instance implements that interface.

### Application

Like every principle Interface Segregation Principle is one principle which require additional time and effort spent to apply it during the design time and increase the complexity of code. But it produce a flexible design. If we are going to apply it more than is necessary it will result a code containing a lot of interfaces with single methods, so applying should be done based on experience and common sense in identifying the areas where extension of code are more likely to happens in the future..

### Consequences

This principle is important because it encourages two very important ingredients of a good software design

High cohesion - Keep all related methods together

Low coupling  - Keep dependence of one another to the bare minimum

Changes to fat interfaces tend to cause a ripple affect to classes who shouldn't have been affected in the first place.

### Samples

Java Collection API is a good example on interface segregation. Classes can depend on Collection, List , Set, SortedSet etc depending on what type of collection they want to use. If eveything was bundled in a single interface then any change to that interface would mean a ripple effect in all collection classes. All types of Lists maintain a high cohesion. Client code is dependent on minimal interface required.

### References

* [http://www.objectmentor.com/resources/articles/isp.pdf](http://www.objectmentor.com/resources/articles/isp.pdf)
* The [LCOM4 metric in Sonar](http://www.sonarsource.org/clean-up-design-at-class-level-with-sonar/) can help reveal violations of this principle in an existing code base.

