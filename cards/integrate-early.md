---

layout: card
category: realisation

---

Integrate early

---

The point where two independently developed modules or systems meet tends to be
the locus of problems. Tackle these early on.

---

### Motivation

It's not uncommon for two connected systems to be developed completely independently, sharing only an interface definition. Time and again, it turns out that the development teams involved interpret the same spec subtly (or wildly) differently. Furthermore, teams have a tendency to delay actually tying the two systems together to the very last moment ("it's not ready yet!"). Inevitably, the systems turn out not to fit together without modification and a lot of stress, finger pointing and bad language ensues.

### Applicability

Applies on any boundary between two independently developed systems or subsystems.

### Application

Instead of agreeing on a spec and parting ways, realize the interface as early as possible, backed by as much stubbing and gaffer tape as needed. Coordinate between teams on the order in which the different facets of the interface are fleshed out and on any interface changes that emerge. Run automated integration tests that touch the other system. Going live in production should be a first anniversary, not a first date.
