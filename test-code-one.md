---
layout: card
title: Think of code and test as one
category: testing
---

### Motivation

The card actually says it all. Writing the code while keeping in mind how you're going to test it will change the way you write your code. There is a fair chance you want to test your module in isolation. That imposes some restrictions on the design of your module: it forces you to minimize coupling as much as possible. And as it turns out, that's a desirable property of software any way.

The reverse effect obviously also occurs when you are writing the test. You don't just write random test code. You carefully consider the different states in which your module might end up being in, and you adjust your way of testing around that.

### Applicability

Always. This is one of the reasons why having accepting test criteria associated with your user stories is important.

### Application

There are two ways of writing your code. You either start with your code, or you start with your test. Test driven development is about starting with your test, and never start writing code before you have a test that is failing. That way, your code basically flows from your tests. Consequently, your code is influence by the tests only, and not the other way around.

My personal suggestion would be to go back and forth between your code and your tests.

### Consequences

Circling around between test and code might make it harder to define a stop criterion. And 80% test coverage rule might help. Getting up to 100% test coverage will be hard or (in many cases) impossible. Using assertions inside your code will definitely help to make up for the remaining 20%. Testing your code forces you to take some design decision consciously; adding assertions will have the same effect.

### References

The Way of Testivus - Unit Testing Wisdom From An Ancient Software Start-up, Albert Savoia, [http://www.agitar.com/downloads/TheWayOfTestivus.pdf](http://www.agitar.com/downloads/TheWayOfTestivus.pdf), 2007
