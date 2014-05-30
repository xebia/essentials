---

layout: card
category: craftsmanship

---

Keep the build clean

---

The build logs should tell a clear story about failures, errors, but also warnings.

---

### Also known as

Aim to keep the build clean.

### Motivation

When we start a new project from scratch, the build is clean and initially there are no warnings, no problems. As the code base grows, we start to see warnings in the build log. If we don't pay attention, the warnings start piling up.

When there's a lot of noise, it's much harder to find the warning that I really want to read among the hundreds of warnings I don't care about.

### Applicability

Whenever you build the code.

### Application

Don't wait for a pile of warnings before you start cleaning up. The moment the warnings are seen, deal with them to ensure that they don't turn up into noise very soon.

### Consequences

Warnings from the build are useful. To get the focus on to the warnings, it is essential to get rid of the noise. If the build has little or no noise, it is easy to spot a new warning easily.

It is easier for someone to take over my work, if the build is clean. He doesn't have to scratch his head to figure out if the warning is to be ignored or fixed.

### Samples

### References
