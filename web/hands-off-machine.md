---
layout: card
title: Keep your hands off the machine.
category: realisation
---

### Motivation

Operating systems and middleware and managed and maintained manually. Changes can only be made by system administrators and operators through a formal change procedure. This makes any change slow due to the hand-offs and error prone. As it is a lengthy process, developers are often given more privileges on development and test machines to experiment with changes to middleware or operating system configurations. As these changes are often forgotten in the installation instructions for QA and production environments, errors popup that were solved in the developer maintained environments.

### Applicability

Anywhere, where multiple machines are managed manually this principle is applicable.

### Application

Automate the installation and configuration of the machine, the operating system and the middleware by using tools like Puppet, Ansible, Salt Stack or Chef. Remove the need to login to the machine by providing everything that is needed to develop and run an application:from easy access to the log messages, application health dashboard, control of the application deployments and the ability to restart the application servers.

### Consequences

Configuration drift between environments will be eliminated, The cost of system maintenance will dramatically be reduced and you will end up with more stable environments.
