---

layout: card
category: realisation

---

Beware of anemic domain models

---

Anemic domain models are data structures without any behaviour. They are a sign
of poor object-oriented modelling.

Domain-Driven Design (Eric Evans) is an alternative that takes better advantage
of the object-oriented model's strengths and improves code maintainability.

---

In **Object Oriented Programming**, an Anemic Domain Model is a program design consisting of data classes without any behaviour and procedural of "service" classes to manipulate them. These systems tend to spawn utility classes full of static methods in an effort to [fight code duplication](dry-principle). As the number of utility functions increases, developers lose track and the utilities themselves start to get duplicated. The result is a system that's not cohesive and [tightly coupled](maximize-cohesion-minimize-coupling). Overall, the high level design appears to be pretty clear, but the source code design tends to get messy. Most simply put, these systems suffer the extra complexity of using an Object Oriented programming language, without reaping any of the benefits.

It must be noted that "structs and procedures" is itself a perfectly valid software design. It's just not a very good fit for Object Oriented programming languages.

One of the core ideas of the Object Oriented model is to bring code and data together. [Domain-Driven Design](http://en.wikipedia.org/wiki/Domain-driven_design)(a technique described by Eric Evans in [a book](http://www.bol.com/nl/p/domain-driven-design/1001004001984629) of the same name) is a technique that fully embraces this idea. Systems modeled in this way naturally follow the SOLID principles and naturally avoid code duplication. They make the most of the object oriented model.

There's a middle ground between the two, where an anemic domain model system is improved by bringing some of the behaviour into the domain model. The easiest place to begin is all those utility functions, starting with simple things like validations and formatting rules. Taking these out of the utility classes and pushing them into the model classes makes them easier to find (avoiding accidental duplication) and improves code cohesion. This approach can be a good fit for request processing systems, such as web apps, where embracing a full object oriented domain model might make things harder to parallelize.


