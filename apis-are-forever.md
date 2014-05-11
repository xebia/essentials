---
layout: card
title: APIs, like diamonds, are forever
category: realisation
---
<p>APIs, like diamonds, are forever</p>
---
<p>So craft them carefully:</p>
<div class="blockquote">
<ul>
<li>APIs should be self-documenting</li>
<li>Obey the principle of least astonishment</li>
<li>Use consistent parameter ordering across methods</li>
<li>APIs should be easy to use, and hard to misuse</li>
</ul>
</div>
<div class="attribution">Joshua Bloch</div>
---

### Motivation

You want to be careful crafting your API. If you don't, then you might end up with something that hurt you forever. It's not hard to come up with examples of bad API design. Java's XML processing libraries are notoriously awkward to use. Things that should be simple require tons of boilerplate code.

Joshua Bloch presented his ideas on API design in a talk named 'How to Design a Good API and Why it Matters' at OOPSLA 2006. It comprises a set of criteria that are fairly easy to remember, as they are all small enough to fit on a bumper sticker:

* All programmers are API designers
* APIs can be among your greatest assets or liabilities
* Public APIs, like diamonds, are forever
* APIs should be easy to use and hard to misuse
* APIs should be self-documenting
* When designing an API, first gather requirements - with a healthy degree of skepticism
* Structure requirements as use-cases
* Early drafts of APIs should be short
* Code the use-cases against your API before you implement it
* Maintain the code for use-cases as the API evolves
* Example code should be exemplary
* You can't please everyone so aim to displease everyone equally
* Expect API-design mistakes due to failures of your imagination
* API design is not a solitary activity
* Avoid fixed limits on input sizes
* Names matter
* If it's hard to find good names, go back to the drawing board
* When in doubt leave it out
* Keep APIs free of implementation details
* Minimize mutability
* Documentation matters
* Consider the performance of consequences of an API design decisions, but don't warp an API to achieve performance gains
* When in Rome, do as the Romans do
* Minimize accessibility
* Subclass only if you can say with a straight face that every instance of the subclass is an instance of the superclass
* Design and document for inheritance or else prohibit it
* Don't make the client do anything the library could do
* Obey the principle of the last astonishment
* Fail fast
* Provide programmatic access to all data available in string form
* Overload with care
* Use the right data type for the job
* Use consistent parameter ordering across methods
* Avoid long parameter names
* Avoid return values that demand exceptional processing
* Throw exceptions only to indicate exceptional conditions
* Throw unchecked exceptions unless clients can realistically recover from the failure
* API design is an art, not a science

### Applicability

Always.

### Application

* Use it while designing the API
* Use it while coding
* Use it while reviewing code
* Use it while pair programming

It might be good idea to read the list before you go off to design something significant, or always have a printed version of the list close to where you are.

### Consequences

The only negative consequence I can imagine related to trying to follow the guidelines given by Josh are - perhaps - analysis paralysis. Pair programming will prevent that. In fact, just by pair programming and have your buddy remind you of API design bumper stickers, you might have all the benefits without the chance of analysis paralysis.

Now, some people might argue that following these standards doesn't address a particular business value for the customer, but then I disagree. It is your responsibility as a programmer to create good code. Don't be tempted to create something messy just because you are in a hurry. Chances are that - if you work like that - it will bite back and result in major head aches when you need to overhaul your code later on.

In order to avoid any discussions on taking the time to work according the guidelines given above, consider making it part of your definition of done, and make sure everybody agrees on that.

### Samples

Less than great API design samples, often serving in examples in Joshua Bloch's talk: JAXP

### References

* [InfoQ Article](http://www.infoq.com/articles/API-Design-Joshua-Bloch)
* [Video recorded at JavaPolis](http://www.infoq.com/presentations/effective-api-design)
* [code-review](code-review)
* [comment-with-care](comment-with-care)


