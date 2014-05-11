---
layout: card
title: One feature at a time
category: collaboration
---
<p>One feature at a time</p>
---
<p>First complete what you started before starting something
      new. It decreases time to market and allows you to apply
      experience gained during development of the first feature in the
      development of the next one.</p>
---

### Motivation

There is no point in trying to aim for everything, all in one go. If you are able to complete something early, you can move it into production and start feeding the ROI into the development of next features. If you are working on many things at the same time, you are basically denying yourself money.

Other than that, doing many things at the same time comes with a cost. If a computer has to do many things at the same time, it will waste cycles switching between these different tasks. Your brain is not any different. Doing many tasks at the same time is like a juggling act. Juggling is way easier with just one ball. Juggling with just one ball is not only easier. It also increases that likeliness you will be able to complete your act without letting it drop on the floor.

### Applicability

More often than not.

### Application

Break the entire idea up into Minimal Marketable Features. You _could_ consider calculating the net present value of each of these features, as "Software by Numbers" suggests. Alternatively, you take a slightly less scientific approach, and just sort the stories in the order you expect them to return most value early on. (However, bear mind that some features would earn you way more if you implement them _now_, rather than later on. The approach suggested by "Software by Numbers" factors this in.)

Once you understand desired order for releasing the minimal marketable features, it's just a matter of feeding that to your teams in the appropriate order, and make sure the definition of done is clearly communicated. If we say "one feature at a time", we really mean "one feature at a time". In other words, that one features should really be completed, as much as possible. Getting it out there might require a bit more effort, but you will also enjoy the benefits of tapping into revenue streams early on.

### Consequences

Question is how you deal with "one feature at a time" if you have many teams working on the same product. The solution is not to redefine minimal to "whatever these teams can accomplish". It will require you to carefully consider the dependencies between these Minimal Marketable Features and minimize them as much as possible. That includes making sure the architecture allows these Minimal Marketable Features to be developed independently as much as possible.

At first glance, the easiest (but not necessarily most desirable) way to distribute work on Minimal Marketable Features between teams would be to have teams focusing on a particular layer or tier of your architecture. However, as a consequence, your teams will no longer be focused on completing the minimal marketable feature. They will instead have time left to work on other features as well. Chances are that - in the end, with all of the painful coordination between teams - you are left with a number of half-baked half-completed features, instead of a couple of features that are ready to be put out there.

Instead of having teams that focus on particular architectural layers and tiers, it might be worth considering teams capable of completing the entire minimal marketable feature on their own. That makes an architecture that accommodates this a more attractive option.

#### References

1. Software by Numbers, Mark Denne and Jane Cleland-Huang, [http://www.softwarebynumbers.org/](http://www.softwarebynumbers.org/)
2. Service Integration at the Presentation Layer, Wilfred Springer, [http://blog.xebia.com/2010/07/21/service-integration-at-the-presentation-layer/](http://blog.xebia.com/2010/07/21/service-integration-at-the-presentation-layer/)
