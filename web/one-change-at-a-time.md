---
layout: card
title: One change at a time
category: craftmanship
---

A single commit should contain only changes related to a single user story or issue. For instance, don't mix formatting changes with bug fixes. In other words: A change should have only one reason to be reverted.

### Motivation

In case of problems it is very helpful to be able to blame just a few lines that were changed, instead of 20 files that contain everything from reformatting, refactoring log statements to changes in the transaction API.

### Applicability

All projects where source control is used.

### Application

* Apply changes one at a time, e.g. when you fix two issue tracker tickets in the same file, record the changes for both fixes as separate commits in version control.
* Separate code clean up from functional changes. So Don't combine formatting changes and semantic changes in a single commit.
* Check each changeset before you push it to the central repository, to see if it communicates your intention.

### Effects

* Easier to inspect and review changes in SCM history.
* Enables cherry-picking of changes.
* Reduces hassle if a change needs to be reverted

### References

* [Work in small increments](small-increments)

