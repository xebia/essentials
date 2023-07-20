---
layout: card
category: testing
---

Test Driven Development shapes design

---

Well-structured code follows naturally from the test-driven development (TDD) process.

However, locally emergent architecture without an overall vision can become
incoherent in the large.

---

### Also known as

Red-Green-Refactor.

### Motivation

There are many ways to start a software project. Why not start with requirements. No, we're not back in the 80's!

Start with a basic requirement, craft it into a test and let those tests drive development.

### Applicability

This is extremely useful when it comes to writing applications. By performing the red-green-refactor cycle you:

1. Write down a feature in test code. Do not be concerned about compiler errors. It's the thought process that counts. What is it I want to achieve.
2. Implement the actual (production) code. Only to the extend that the test passes. While writing code you might come up more cases to test. Write those down (e.g. on a piece of paper), we're focused on making the test at hand pass.
3. Tidy up. Make sure your code is ready for the next cycle. Is the code self-descriptive?

### Application

Whenever you're writing an application this approach is applicable.

There are a few corner cases where this approach is less applicable: when you're learning yourself a new library, for example. In those cases you have no idea how the library behaves and you're basically just testing the library.

### Consequences

You'll find out that you have to write less tests and code in general. Since all you're implementing are the features that you describe in your test cases, the code is as good as the test cases. Therefore it's important to have clear, readable tests. Nothing is more confusing than a test whose intention is unclear.

### References

[Freeman, Price: Growing Object-Oriented Software, Guided by Tests](https://www.amazon.com/Growing-Object-Oriented-Software-Guided-Tests/dp/0321503627/)
