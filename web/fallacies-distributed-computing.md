---
layout: card
title: Remember the fallacies of distributed computing
category: realisation
---

### Motivation

Peter Deutsch asserted that programmers new to distributed applications invariably make a set of assumptions known as the Fallacies of Distributed Computing and that all of these assumptions ultimately prove false, resulting either in the failure of the system, a substantial reduction in system scope, or in large unplanned expenses required to redesign the system to meet its original goals.

### Applicability

More often than not, we at Xebia work on distributed systems. In our industry, it is not uncommon to ignore the fallacies of distributed computing.

1. The network is reliable.
2. Latency is zero.
3. Bandwidth is infinite.
3. The network is secure.
4. Topology doesn't change.
5. There is one administrator.
6. Transport cost is zero.
7. The network is homogeneous.

Ignoring these properties will lead to brittle systems. We don't want to create brittle systems; we want to create robust systems. Systems that survive network failure. Systems that do not need he constant presence of a network administrator in order to survive. Systems that are resilient to changes to the network topology.

### Application

First of all, you need to be aware of the existence of this list and understand that there is no such thing as a free ride. When the network is getting involved, you need to be be aware of the consequences, and design for it.

In addition to that: Many attempts have been made to hide the complexity of coping with the characteristics of a distributed system. Be careful with those solutions. Solutions that suggest that you should not worry about the network and allow you to create software as though the network wasn't there are suspicious.

### Consequences

It is one thing to be aware of the consequences of your decisions when designing for a distributed solution. By carefully choosing from your options, you can most definitely increase the resilience of your system against network failures. However, increasing the robustness of your system might also increase the complexity of the programming model.

Jini is an example of a technology that definitely took the 8 fallacies of distributed computing seriously, and I think it's fair to say it was much more resilient to networking issues than Java EE solutions coming about around that same time frame. However, it did put a burden to the developer. You had to write more code in order to be able to deal with whatever could go wrong.

Now, question is if your solutions always need to have the same properties as Jini-based solutions, especially if there is a price you will have to pay for it. Probably not. In the end, it's just a balancing act, balancing factors such as the price business is willing to pay for ultimate availability, the characteristics of the data center(s) and the experience of the team you are working with.

References

* [Wikipedia](http://en.wikipedia.org/wiki/Fallacies_of_Distributed_Computing)

