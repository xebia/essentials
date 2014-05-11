---
layout: card
title: Diagnose before cure
category: craftmanship
---
<p>Diagnose before cure</p>
---
<p>Measure first, make an isolated change, repeat until satisfied.</p>
<p>Before you tune performance, first measure it. Then fix the worst bottleneck and measure again. Commonly you will find that bottlenecks shift, and you are most effective when continuously measuring your progress.</p>
---

When solving problems in a software system, make sure you're attacking them from the right angle. This is true in general, but particularly so for problems meeting your [non-functional](non-functionals) requirements, like throughput and scalability. Bottlenecks in your performance characteristics may not be where you think they are. Your hands may be itching to tune that one really complicated database operation, but if your most pressing problem is synchronization for a System.out.println call that was accidentally left in, than tuning that query may be an utter waste of time.

### Applicability

When performance tuning an application.

### Application

Before you tune performance, first measure it. Then fix the worst bottleneck and measure again. Measure, then fix one problem, verify that it worked, then repeat. Plan, do, check, adapt. Commonly you will find unexpected results and you are most effective when measuring your progress.

### Consequences

You actually identify and fix those bottlenecks that are causing contention in your application, rather than tweaking where things "look bad".


