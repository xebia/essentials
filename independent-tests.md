---

layout: card
category: testing

---

Tests should be fast, reliable and independent

---

Independent unit tests can be run regardless of ordering and are easy to run in parallel. Speed and reliability optimize feedback.

* Don't share objects between tests.
* Minimize external dependencies, use mocks.
* Give each test the smallest possible scope.
* Optimize slow tests to make them not slow.
* Optimize flaky tests to make them reliable.

---

### Also known as

Listen to your tests.

### Motivation

Make sure tests run independent and do not rely on external factors in order to succeed. In doing so, tests can be executed in isolation (for example with a debugger) as well as in sets. You're also relying less on the execution engine, which can be considered a good thing.

By isolating tests it's easier to track down issues.

In the end, it's all about feedback.

### Applicability

This approach is applicable throughout the application delivery process.

# Don't share objects between tests.


Sharing objects (or more commonly state) between tests makes it hard to find an issue in a test. You're always relying on some other "thing" to prepare the test state for your test. Note that state can be object state as well as state in external systems (see also next point).

Minimize external dependencies, use mocks.


Mocks give you the ability to tailor the behaviour of the "external" dependencies.

# Give each test the smallest possible scope.


Make one test per feature. Even if the second test is building on the first test, make a new test.

Keep your tests functional (what is the observable behaviour?).

# Optimize slow tests to make them not slow.


Listen to your tests.

Why is your test slow? It's worth investigating.

# Optimize flaky tests to make them reliable.

Why is a test flaky? Are there multiple concerns to the object under test? Are you mixing application layers?


### Application

Start with this when writing your code. Start with a test, TDD style: describe what an entity should do. Implement it and describe the next feature. Keep a piece of paper next to you to write down notes while implementing. In doing so, you drive the code through tests. Tests are the most concrete way to describe a piece of functionality: since they're written in a programming language, they can only be interpreted in one way. No ambiguity.

### Consequences

You wouldn't believe what proper tests can do to code.

### References

* [TDD Shapes Design](tdd-shapes-design)
