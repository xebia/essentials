---

layout: card
category: testing

---

Make room for exploratory testing

---

Following a test script means you're consistent, but predictable.  Exploratory
testing reveals the things you hadn't thought to script. Be curious, go outside
the beaten path.

---

### Motivation

Users tend to use an application in unexpected ways. Conventional happy path testing is not sufficient. Event with failure path testing only a subset of the possible ways to work your way through an application are tested.

Exploratory testing is a disciplined method to test (corner) cases in the application.

### Applicability

Listen to your curiosity
Define what you're curious about and explore ASAP.

### Application

Despite the "exploratory" nature of the tests, it is required to do some preparation upfront. The expedition should be prepared, you have to define a goal of the exploration. No need to wander of the path: take notes about alternative paths that can be investigated in future expeditions.

### Consequences

Parts of the system, or flows through the system, that are not commonly checked are tested. Possible issues can be resolved and tested with automated tests.

### Samples

Create a simple Test Charter Card which describes your curiosity with the following format:

Explore: A target
With: Resources
To Discover: Information

By target we mean: What are you exploring? e.g. UI input fields, Login pages or XML responses?
By resources we mean: What resources will you be using? e.g. JavaScript / SQL injection or Spoofed URLs & POSTS
Information: What kind of information are you hoping to find? e.g. Can an user access content which they are not allowed to access or any other security vulnerabilities

### References

[http://pragprog.com/book/ehxta/explore-it](http://pragprog.com/book/ehxta/explore-it)


