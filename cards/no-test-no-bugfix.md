---

layout: card
category: craftsmanship

---

No change without a failing test

---

* Don't fix a bug before you have a broken test
* A feature is only considered done once you have tests for it
* Don't refactor before you have sufficient test coverage

---

### Motivation

If it ain't broke don't fix it goes the old saying. This is often used to resist changes, but resisting change isn't all bad. In fact, changes are risky and should only be done if there is sufficient reason. A broken test case is proof of a bug (if the test case makes sense) and demanding reproducible breakage before undertaking a risky change is a good recipe to avoid awkward discussions.

### Applicability

Before you do anything you should have a reason. Especially in a situation where you will potentially be held accountable for your actions having a good reason for them is essential. Proving that something is broken before you fiddle with it is mandatory, in code this means changing or creating a test first and only then changing the code. There is still some discussion on the effectiveness of test driven development. Measurements are not entirely conclusive, suggesting that there are situations where test driven development is not applicable. We suggest to at least ensure there is an objective way to verify the results of the change (keeping some leeway in the method).

### Application

Whenever we attempt a change, we first figure out if we can prove that we've succeeded when we are done with our change. Once we have a method to prove if our change was successful we carry on. In the process we strive to leave an automated solution to make sure our change is never broken unintentionally. This is often but not always done through a unit test.

### Consequences

Acting this way results in higher code coverage and more sensible test cases. It may sometimes require extra effort to get started with a change.

### Samples

In a large code base of a longer running project a bug was logged on some parsing issue. A developer went into the code and changed the parser to deal differently with a certain character. A few weeks later another parsing issue was logged; another developer went in and changed the logic back. Both developers saw from the single example in the issue that their fix would solve the problem for the particular example. Then the first bug was reopened and the first developer got furious, reverted the change that removed the check and committed. Then a bit later the second bug was reopened. If only they both had created test cases there wouldn't have been a problem at all.

### References

* [On the Effectiveness of Test-first Approach to Programming][oetap] Hakan Erdogmus, National Research Council Canada.

[oetap]: http://www.researchgate.net/publication/3188484_On_the_effectiveness_of_the_test-first_approach_to_programming
