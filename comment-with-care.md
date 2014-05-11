---
layout: card
category: craftmanship
---
Comment with care
---
<ul>
<li>Don't document bad code &ndash; rewrite it</li>
<li>Don't repeat the code &ndash; clarify its intent</li>
<li>Document surprises and workarounds</li>
<li>Make every comment count</li>
</ul>
---

### Motivation

Getting the comments right is as hard (and important) as getting the source code right. Having too many comments in a file can be as detrimental to maintainability as having too few [citation needed], comments can be useless and the worst are incorrect or misleading.

Source code comments can assert intellectual property ownership and licensing terms.

### Applicability

Every modern programming language I'm aware of supports source code comments.

### Application

* In an object-oriented language such as Java 1, it's fair to demand a type-level JavaDoc header that describes the intent and responsibility of the class or interface on every public or protected type.
* On APIs intended for use by others, every public method should be appropriately documented.
* Use the standard documentation system for the platform. In Python, that's doc strings. In Java, that's JavaDoc. The standard documentation system is not only familiar to humans, most IDEs and some editors know how to read it too. As obvious as this may seem, I once had the displeasure of using a closed-source API documented using a proprietary HTML layout not in any way resembling standard JavaDoc 2. It was painful.

Guidelines aside, whenever you find yourself wondering: "I wonder whether this'll make sense to me later", you know it's time for a comment. Ensure the comment contains information that cannot be obtained by simply reading the code itself.

Beware if inline comments, though! Most of the time when you find yourself adding comments to a particular line of code, it's time to move that code to it's own function or method and provide that with a descriptive name.

### Consequences

Effective use of source code comments improves the maintainability of program code. Coming back to your or someone else's code to add a feature or carry out a fix will take a matter of minutes or hours, rather than days or weeks.

### Samples

# Don't document bad code - rewrite it.

The [Wikipedia article on commenting](http://en.wikipedia.org/wiki/Comment_%28computer_programming%29) ascribes this aphorism to The Elements of Programming Style [3]. It's a good general guideline, but it may not always be feasible, especially in maintenance projects.

# Don't repeat the code - clarify its intent.

Code Complete [1] illustrates this with a nice example. Which is more clarifying?

    // If account flag is zero
    if (accountFlag == 0) ...

or

    // If establishing a new account
    if (accountFlag == 0) ...

Maybe the intent can be clarified just as much without a comment:

    if (establishNewAccount()) ...

    private boolean establishNewAccount() {
        return accountFlag == 0;
    }

# Document surprises and workarounds.

"Surprises and workarounds" is deliberately vague, as it's very hard to qualify. A common scenario is that you add a special case in a method to fix a bug or when you find out that a library behaves differently than you thought it would because it bites you during testing.

An example of this is when I found out that a Java 1.5 ThreadPoolExecutor with a corePoolSize of 0, a maxPoolSize of 50 and an unbounded task queue does not idle at 0 threads and execute at 50, but rather, starts 0 threads and executes nothing at all. When I dug into this, I found out that Java 1.5 has no way to make a ThreadPoolExecutor idle at 0 threads (Java 1.6 does) and that in both versions maxPoolSize is meaningless with an unbounded queue. I put a short note above the variable declaration to benefit any maintenance programmer that needs to adjust the pool sizes.

A special case of this is where source code analysis tools report a false positive. The flagship example of this is the [Debian OpenSSL](http://digitaloffense.net/tools/debian-openssl/) fiasco of a few years back. The random number generator contained what appears to be bad use of uninitialized memory (and was reported as such by code analysis tools), but which was essential to seeding the random number generator. Someone removed the line in a clean-up effort and the result was two years' worth of SSL certificates each of which could be brute-forced in at most 32768 attempts.

# Make every comment count.

Excessive comments are just clutter.

# Good: The java.util.concurrent package

The JavaDoc comments in the java.util.concurrent package are outstanding. They're short and to the point where possible, meticulously detailed where required.

# Bad: Eclipse getters and setters

Eclipse's default template for the JavaDoc comment on getters and setters is horrible.

    /**
     * @param foo the foo to set
     */
    public void setFoo(String foo) {
        this.foo = foo
    };

    /**
     * @return the foo
     */
    public String getFoo() {
        return foo
    };

These comments are grammatically ugly. Worse, the comments don't add any value: we know what a getter or setter does and if a method does something else it shouldn't masquerade as a getter or setter in the first place. Don't generate comments using this template, just leave them out.

If your architect/analysis tool/spouse won't let you get away with undocumented getters and setters, at least replace the template by something grammatically correct.

# Good: Unit, bounds, resolution, precision

When dealing with measurements and amounts, make sure the unit, resolution and bounds are apparent. It's often possible and desirable to make this information programmatically available, such as with java.util.Currency or JSR-275. Failing that, you can resort to code comments such as in the next example.

    <xsd:element name="admission" type="xsd:dateTime">
        <xsd:annotation>
            <xsd:documentation>
                The date and time of admission. Precision is in minutes, the
                seconds are always 00. UTC offset is not included, all values
                are in the Europe/Amsterdam time zone.
            </xsd:documentation>
        </xsd:annotation>
    </xsd:element>

The xsd:dateTime has a resolution in seconds (optionally milliseconds) and an optional UTC offset. The UTC offset is required to unambiguously pinpoint a calendar date and time on the time continuum. If the actual offset is unavailable, a time zone is the next best thing. The fact that we"re using an xsd:dateTime instead of an xsd:string has documentary value in and of itself.

### References

1. Code Complete (Steve McConnell, Microsoft Press), pages 777-817.
2. The Pragmatic Programmer (Hunt/Thomas, Addison Wesley), page 249-251.
3. The Elements of Programming Style (Kernighan/Plauger, Mcgraw-Hill)

### Footnotes

1. Some argue Java isn't an object oriented language. It's close enough for the purposes of this article.
2. I'm looking at you, TIBCO iProcess Server Objects Java.


