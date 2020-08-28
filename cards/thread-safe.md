---

layout: card
category: realisation

---

Aim for thread safety

---

In order of decreasing safety:

* Stateless services
* Immutable shared state
* Encapsulated locks
* Not thread safe

---

### Motivation

When your code should be thread safe but isn't, you will find out too late at an inconvenient time. This can lead to embarrassing situations where you need to fix a hard problem under high pressure. Not good. If you apply these simple rules you will avoid this.

### Applicability

Whenever you use objects in multiple threads they must be thread safe. This can go for services that are shared, but also for value objects that are passed along.

### Application

The only risk of thread unsafe code is that state is not appropriately shared, so all the rules apply to state.

The first rule applies to services. If an object simply doesn't hold any state it is always thread safe. Virtually all applications must hold state to be useful. In particular services need to collaborate with other services. The rules are bent usually, when people say "stateless service" they usually mean "services that don't hold any state, but the immutable references to other services".

Immutable objects are usually the objects passed around in an application. If the state in an object cannot be changed after creation, there is no risk of one client seeing a different state than another. Creating an object as being immutable should be the default choice. Anything that mutates state is potentially dangerous.

Encapsulated locks is the last resort. If an object has to be changed during its lifetime, this is the only way to ensure thread safety. Locking on the object itself is also thread safe, but it can cause unwanted locking and even deadlocks if others are locking on it too.

Non thread safe code is not a problem in many situations. As long as objects are not shared with multiple threads, making them thread safe is adding complexity that is not needed. Many web applications are built around non thread safe domains, and this is not a problem. Be sure to make it clear that code is not thread safe and will not be used out of the safe context it is supposed to be used in.

### References

Brian Goetz: Java Concurrency in Practice


