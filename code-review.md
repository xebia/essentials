---

layout: card
category: collaboration

---

Review code

---

The primary goal of code review is to increase its quality. Can be used as an
additional safety net alongside pair programming.

It is also a good way to share knowledge and pick up some new tricks.

---

### Motivation

We care about quality. Since everyone makes mistakes we reduce the risk of mistakes escaping to production by reviewing all code. Together with [Pair Programming](pair-programming) this practice ensures that always two pairs of eyes have seen all production code.

### Applicability

Reviewing code is a great way to get an overview of a code base; to learn the style and the domain. It is also a way to view the code from an unusual standpoint and see inconsistencies that would otherwise stay out of focus. The only way to truly know the internal quality of a code base is to read the code. Apply reviews when you're not sure about the code quality, or when you want to coach a team to better quality code through concrete feedback.

### Application

Reviewing can be done in several ways. First there is the old fashioned way: just take a text editor (with highlighting if you can) and read the code file by file. It can be useful to load the code in an IDE, but since you're not here to check if it will compile this might just as well be an unneeded distraction. While reading the code write down concretely what you would change if you were refactoring. Share this with the developers through a simple text.

Then there is the per commit reviewing style, that allows the reviewer to review changes rather than the end result. This is perfect for quick feedback on developer behaviour, rather than the result of the behaviour. It takes more time and discipline to review all commits.

A great way of code reviewing is by using Pull Requests. Pull requests are a feature of most DVCS hosting tools. If your project is on a distributed version control system (DVCS) like Git or Mercurial, you can use such a system. It's basically a pending merge from one branch into another, accompanied by a commenting system. The great thing about pull requests is that they're asynchronous (you don't have to interrupt a colleague in their work), persistent (the reviewing comments are archived), up-to-date (the scope of the code review automatically updates as further commits are made on the development branch) and public (pull requests are visible to the entire team, anyone can chip in). At GitHub, it's not uncommon for a pull request to live for months before being merged. There's a great talk about how they use them: [How GitHub uses GitHub to build GitHub](http://zachholman.com/talk/how-github-uses-github-to-build-github/).

Note that Code Reviewing and [Pair Programming](pair-programming) are not interchangeable, because they serve different goals.

### Consequences

Increased shared ownership is attained when reviewing is done by team members. When reviews are done it is important to invest time in dealing with the comments. Otherwise the (sometimes mundane) task of reviewing is not rewarded properly and will feel like a waste of time.

### Samples

There are tools that help reviewing greatly, such as Crucible (commercial) and of free tools around the git vcs, like Gerrit and the GitHub review system. Especially when reviewing per commit, decent tooling is a must have.
