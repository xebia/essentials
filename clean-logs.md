---
layout: card
title: Keep your logs clean
category: testing
---

### Motivation

Logging is one of those deceptively simple concerns. “How hard can it be?”

### Applicability

Logging is a very common [requirement](non-functionals) that tends to get not much thought unless the logging volume is huge.

### Application

# Log at the right level

Establish (and follow) a common convention for assigning event priorities.

For example, use the INFO level to report the actual (as used) configuration settings during start-up and inform of system status changes such as "Started successfully" or "Shutdown initiated by <admin name>". Use the WARNING level to report things that a developer or operator should look at, but that don't threaten the immediate operation. Use the ERROR level to report things that need immediate action, such as an unreachable database or a backed up message queue. Use the DEBUG level for everything else. You should be able to tie a pager to ERROR events and not lose sleep over trivialities, nor miss out on fatalities (mind you, alerting is hard).

# Log every message once

Anything more than that adds confusion and wastes disk space. It's quite common for exceptions to be logged more than once. Avoid this if you can.

# Throw meaningful exceptions

An exception message in your log file is of no use if it doesn't help you figure out what's wrong. Use a clear message and provide context. Use custom exception types so that different groups of problem types can be handled separately in different catch blocks.

# Keep auditing information separately

The audit trail should have its own, dedicated destination (log file, database, what have you). The audit trail may have different archiving demands than the application log file.

# Don't cry wolf

If your log file raises a lot of false alarms, it will get ignored and any real problems won't become apparent until the phones start ringing.

Don't put yourself in a position where you have to say "Please ignore those exceptions you see in the logs, they are normal". An exception stack trace stands out like a sore thumb in any log file. If you work with functional exceptions, you have to catch them and handle them in a way they do not appear in your technical logs.

# Allow tuning of a running system

For long running systems, embed some troubleshooting tools, like the ability to generate more verbose logging; possibly tied to a specific user session.

### References

Code complete, 2nd Edition. Steve McConnell, Microsoft Press.

