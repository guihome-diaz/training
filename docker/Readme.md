DOCKER and KUBERNETES training notes

* Course: https://www.udemy.com/course/docker-and-kubernetes-the-complete-guide/
* Trainer: Stephen Grider
* Training period: 2022-01-03

# Copyright

* The **text** is my **personal notes**. Since I have a fish memory, I've put enough details to remember quickly next time I will read it. It is not as exhaustive as the training (but I hope it's close enough). 

* **Diagrams** comes **from the training**. I only added some annotations or colors when needed. They are the work of _Stephen Grider_

# Docker training

## [Docker cli and core concepts](./1.Docker_core_concepts.md)

This section covers:
* Docker installation
* Docker main paradigms: to discover **WHAT** is Docker, **HOW** does is work underneath, **WHY** you should use it
* Understanding of the `docker cli` command line: `docker ps`, `docker exec`, `docker run`, `docker build`, `docker start`, etc.
* How to write a simple `Dockerfile` and understand its structure
* Docker in action: simple standalone web-application in a container

Go to [Docker cli and core concepts](./1.Docker_core_concepts.md)


## [Docker compose, work with multiple local containers](2.Docker_compose.md)

This section covers:
* Container **Architecture**: how to **design** a multi-containers applications with its dependencies + how to **implement** such design
* Limitations of single _Dockerfile_ and why we need _docker-compose_
* Understanding of the `docker-compose` command line + `docker-compose.yml` file
* Docker in action: multiple containers application

Go to [Docker compose, work with multiple local containers](2.Docker_compose.md)

