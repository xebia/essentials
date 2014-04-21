---
layout: card
title: Don't Repeat Yourself
category: craftmanship
---

### Also known as

* The DIE Principle : Duplication is Evil
* SPOT : Single Point Of Truth

### Motivation

Duplication leads to maintenance hell and logic contradictions, reducing seems a Good Things(tm).

### Applicability

The original authors of the quotes stated that it could be applied to "database schemas, test plans, the build system, even documentation.". So pratically it could be applied almost in any aspect of work. It applies very well to code duplication.

### Application

The DRY principle applied to code can reduces the amount of code you have to deal with. It improved readability and thus makes maintenance easier. When coding you can use a wide variety of options to limit duplication, OO paradigms, refactoring options etc...

The DRY principle should also be used beyond plain coding in the design phase : Two concepts which are not bound in the system should not be bound by code. This is a little bit more difficult to apply.

### Consequences

Whenever the principle is correctly applied it any change to any element in the system should not imply modification to other element of the system which are not directly related. Likewise, the modification should imply predictable and uniform change to all related elements.

### Samples

TBD
Stories from the trenches? Horror stories? Source code? Customer references? Samples of technology that can be used to put it into practice?

References

* [Orthogonality and the DRY principle](http://www.artima.com/intv/dryP.html)
* [DRY Principle not applied to Unit Test](http://codebetter.com/blogs/karlseguin/archive/2009/09/12/unit-testing-do-repeat-yourself.aspx)
