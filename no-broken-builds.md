---

layout: card
category: collaboration

---

Sleep easy on a green build

---

It's the team's code; it's also the team's responsibility to have a running
build. If the person who broke the build isn't around, that's no excuse.

---

### Also known as

Nobody goes home until the build is fixed

### Motivation

Your build state is your code's heartbeat. A broken build means you're not delivering value, and you certainly don't have production-ready software.

### Applicability

If you're using a continuous build system (you are, aren't you?), you should have trouble sleeping if the build isn't green.

### Application

Ensure you receive automatic alerts when your build breaks and also when it is fixed. If a build is broken it is the responsibility of the entire team to ensure the build is fixed. Of course, the person responsible for the check-in that broke the build is the most natural person to delegate this task to, but if s/he is only holiday that's not an excuse to ignore the problem!

### Consequences

If you have a broken build (and certainly if you were responsible for it breaking!) you should feel bad if you're working on anything other than fixing it. If your team starts ignoring build failure notifications - or even starts setting up mail filters for them! - consider if the build setup is still relevant to your project's needs. For instance, there's no point in having a quality build that fails continuously because it is verifying style rules the team is no longer using.

If your failing build(s) are still relevant to your project and the team is ignoring them anyway, raise the alarm.

### Samples

### References

There are also a number of "build league tables" and other plugins for many continuous build tools that can make keeping the build green a bit more fun and exciting.


