---
layout: card
category: craftmanship
---
Prevent your code base from turning into a museum
---
<p>There is no point in keeping dead code lying around in
      your code base. Get rid of it. Your version history will always
      allow you to get it back if you need to. The same goes for
      commented-out code: get rid of it.</p>
<p>Keeping your codebase free of reminiscences of the past
      will make it easier to navigate and understand.</p>
---

### Also known as

HEAD is not a museum.

### Motivation

The purpose of an SCM system is to store a history of your work, so there's no need to keep unused code or comments in your current build.

### Applicability

Whenever you see commented-out or unused code and/or outdated comments in source code or documentation.

### Application

Remove unused variables, methods etc., any code commented-out without an accompanying explanation (e.g. a temporary workaround for a blocking issue), any tests ignored without explanation and any outdated comments or documentation from your source code and update your SCM system. Also, remind your colleagues that these items should be removed.

### Consequences

The HEAD of your project will reflect the current state of your code, not an arbitrary mix or current code any stuff hanging around because nobody is 100% sure whether it is in use or not.

### Samples

### References
