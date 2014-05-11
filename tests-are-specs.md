---
layout: card
title: Tests are Specifications
category: testing
---
<p>Tests are Specifications</p>
---
<p>Don't test an implementation, test its conformance to a required behaviour. Tests
      written in this way become executable specifications, stories and examples. They document
      what the code is intended to do, not cast in cement how it does so.</p>
---

### Also known as

Tests are Specifications

### Motivation

A good test describes a certain aspect of your system on a functional level. In this sense, a test is not much different from a specification. While traditionally specifications have been written up-front and tests afterwards, this trend has changed.

A [specification written at the beginning of a project](acceptance-criteria) needs to be continuously maintained to stay relevant in rapidly-changing environments - and today, all environments change rapidly. As such, the specification has become a living part of the product, just like production code and tests.

Conversely, with software being developed and deployed iteratively, tests are written earlier in the process, sometimes [before the actual features are implemented](definition-of-ready). This is a good thing.

Due to these trends the distinction between functional tests and specifications is quickly disappearing: it often helps to think of tests as specifications and specifications as tests.

### Applicability

Tests that don't look like specifications are not very good tests: often they test how a feature is implemented, not that.

Specifications that don't look like tests are not very good specifications: often they are too vague, sometimes giving a [false sense of consensus](shared-design-understanding) on the feature.

### Consequences

Your process probably no longer has separate 'waterfall' phases for specification (up-front) and testing (afterwards). However, in many organizations, specification and testing are still the responsibilities of disparate roles or even teams. When you consider tests are specifications, the consequence is that specification and testing should be the [joint responsibility of a multidisciplinary team](testing-is-shared-responsibility) consisting of both people with a background in specification/requirements engineering and people with a background in testing/test automation.

### References

http://www.specificationbyexample.com


