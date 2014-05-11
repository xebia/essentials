---
layout: card
category: realisation
---
Assert against improper behaviour
---
<div class="blockquote">
<p>If it can't happen, use assertions to assure it won't.</p>
</div>
<div class="attribution">Andrew Hunt, David Thomas</div>
---

### Motivation

Ideally, the compiler would be able to verify all of your assumptions. In reality, they can't. Next question is if you would be able to write tests for all of those situations. After all, that's what you normally do for all circumstances in which the compiler is not helping. In reality, that doesn't work out either. The combinatorial explosion of states your modules might go into is just overwhelming.

This is where assertions come to the rescue. Assertions allow you to validate pre- and postconditions and can help you to assure your invariants hold. Putting in assertions will make sure your code fails early before causing anymore damage. It also works as a mental flag.

* You think you're sure something will never happen =&gt;
* The rule tells you to put an assertion in =&gt;
* You start to consider if your assumption actually holds in all circumstances =&gt;
* You might alter your code based on the conclusion =&gt;
* You put in an assertion

### Applicability

Always. Don't go overboard and assert everything though. As I said, one of the most important reasons for having assertions is to train your consciousness to find the conditions in which your assumptions no longer hold.

### Application

There are a couple of flavors for doing assertions in Java out there.

Java keyword:

    assert (x > 3);

Disadvantage: they get disabled by default.

Spring Assert class:

    Assert.isTrue(x > 3);

Disadvantage: no isolated jar; you pull in a significant number of classes.

Guava [Preconditions](http://docs.guava-libraries.googlecode.com/git-history/release/javadoc/com/google/common/base/Preconditions.html) class:

    Preconditions.checkArgument(x > 3)

### Consequences

If you put in assertions, then your code will fail if the assertions are violated. Don't try to catch these exceptions. If you are catching AssertionErrors, then you probably misused assertions for some other purpose.

### References

1. *Programming Defensively* Interview with Andy Hunt and Dave Thomas, <a href="http://www.artima.com/intv/defense.html">http://www.artima.com/intv/defense.html</a>
