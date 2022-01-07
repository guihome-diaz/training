DOCKER training

- [Training notes](#training-notes)
  - [Diagrams](#diagrams)
- [Docker installation](#docker-installation)
  - [Tools](#tools)
  - [Adjust storage path for images and containers](#adjust-storage-path-for-images-and-containers)
- [Docker principles](#docker-principles)
  - [Hello-world: get image and spawn container](#hello-world-get-image-and-spawn-container)
  - [What is a container ?](#what-is-a-container-)
    - [Core concepts](#core-concepts)
    - [Container definition](#container-definition)
    - [Image definition](#image-definition)
    - [Docker application principle](#docker-application-principle)
- [Docker basics commands (lifecycle)](#docker-basics-commands-lifecycle)
  - [Docker run](#docker-run)
    - [Definition](#definition)
    - [Examples](#examples)
  - [Docker create](#docker-create)
  - [Docker start](#docker-start)
  - [Docker run VS docker start](#docker-run-vs-docker-start)
  - [Docker log](#docker-log)
  - [Docker stop](#docker-stop)
  - [Docker exec](#docker-exec)
    - [Key points](#key-points)
    - [Access container's command prompt (SH / BASH)](#access-containers-command-prompt-sh--bash)
    - [Docker exec example: redis server + redis-cli](#docker-exec-example-redis-server--redis-cli)
  - [Docker kill](#docker-kill)
  - [Docker ps](#docker-ps)
  - [Cleanup containers](#cleanup-containers)
- [Create custom docker image](#create-custom-docker-image)
  - [Introduction to Dockerfile](#introduction-to-dockerfile)
  - [ALPINE as base image](#alpine-as-base-image)
  - [Docker build command](#docker-build-command)
    - [Principle](#principle)
    - [Build lifecycle](#build-lifecycle)
    - [How to tag an image (naming conventions)](#how-to-tag-an-image-naming-conventions)
    - [Example: create a redis-server image](#example-create-a-redis-server-image)
    - [Docker build cache](#docker-build-cache)
  - [Create new image from container's snapshot (docker commit)](#create-new-image-from-containers-snapshot-docker-commit)
  - [Add files inside the image (docker copy)](#add-files-inside-the-image-docker-copy)
- [Docker port mapping](#docker-port-mapping)
  - [Principle](#principle-1)
  - [How to forward a local port to the container?](#how-to-forward-a-local-port-to-the-container)
- [Simple application example](#simple-application-example)
  - [Objectives](#objectives)
  - [Requirements](#requirements)
  - [Execution steps](#execution-steps)
- [Resources](#resources)


# Training notes

* Course: https://www.udemy.com/course/docker-and-kubernetes-the-complete-guide/
* Trainer: Stephen Grider
* Training period: 2022-01-03
* Docker setup: Windows 11 with WSL2, docker desktop v4.3.2 (72729) | docker cli v20.10.11


## Diagrams
The [diagrams](./diagrams.zip) shown in the course are attached as a zip file.
* Download the file and extract it somewhere on your computer.
* Visit diagrams.net (formerly draw.io).
* Select Open Existing Diagram 
* Use the file explorer to select the diagram file from your computer.

or

* Install and execute draw.io viewer locally
* Click on File menu, Select Open From Device
* use the file explorer to select the diagram file from your computer.


(i) Note - Please understand, if a diagram or group of diagrams is missing, this means that we no longer have them to share. You'll need to use a good screenshot tool to make a copy from the video lecture.



# Docker installation

## Tools

Make sure Virtualization is enabled in your Bios! This is one of the requirements for Windows 11.

* [Docker desktop](https://hub.docker.com/)
* Microsoft Windows WSL 2
* [Git (with gitBash)](https://git-scm.com/downloads)


## Adjust storage path for images and containers

!! **This is for Windows WSL 2 only** !!

* Source: [StackOverflow thread](https://stackoverflow.com/questions/62441307/how-can-i-change-the-location-of-docker-images-when-using-docker-desktop-on-wsl2)


The WSL 2 `docker-desktop-data` vm disk image would normally reside in: `%USERPROFILE%\AppData\Local\Docker\wsl\data\ext4.vhdx`

To relocate it to other drive/directory, with all existing docker data preserved:
* First, **shut down your docker desktop** by right-click on the Docker Desktop icon and select Quit Docker Desktop
* Then, open your command prompt (GitBash)
  `wsl --list -v`

You should be able to see, make sure the STATE for both is Stopped.(wsl  --shutdown)
```bash
  NAME                   STATE           VERSION
* docker-desktop         Stopped         2
  docker-desktop-data    Stopped         2
```

Export docker-desktop-data into a file
```bash
wsl --export docker-desktop-data "D:\Dev\docker\wsl\docker-desktop-data.tar"
```

Unregister docker-desktop-data from wsl, note that after this, your ext4.vhdx file would automatically be removed (so back it up first if you have important existing image/container):
```bash
wsl --unregister docker-desktop-data
```

Import the docker-desktop-data back to wsl, but now the ext4.vhdx would reside in different drive/directory:
```bash
wsl --import docker-desktop-data "D:\Dev\docker\wsl" "D:\Dev\docker\wsl\docker-desktop-data.tar" --version 2
```

Start the Docker Desktop again and it should work

(i) You may delete the `D:\Dev\docker\wsl\docker-desktop-data.tar` file (NOT the ext4.vhdx file) if everything looks good for you after verifying


# Docker principles

## Hello-world: get image and spawn container

```bash
docker run hello-world
```

First, docker need the `hello-world` **image**.

![get docker](images/01_docker_get_image_process.png "get docker")

Then, docker create a **container** (~ instance) of that particular image

![generate container](images/02_docker_image_and_containers.png "generate container")

Last, it executes that image.
In present case it generates a small text.


## What is a container ?

### Core concepts

A container relies on 2 concepts: 
* **Namespacing**: to isolate resources per process or group processes. A "resource" can be physical (hard-drive, network card, etc.) or logic (communication between processes, users, files rights, etc.)
* **Control group**: to limit the amount of resources used by process. To ensure a particular process stays within its limits. A "resource" can be CPU, memory, hard-drive size, etc.

![core concepts behind Docker](images/03_core_concepts_behind_docker.png "core concepts behind Docker")

!! These particular concepts are Linux specific features. Therefore, **each container will run on Linux**. 

Each container, like any Linux machine, has the following input/output:
- STDIN: keyboard + mouse
- STDOUT: console output
- STDERR: error messages

You can access some or all input/output with Docker, depending on the command you are going to execute and its arguments.


> :fire: !! Important 
> 
> As a result of previous paradigms, _container are **completely isolated** and **separated** from each other_.


### Container definition

> *A **container** is a process or set of processes that have a grouping of resources specifically assign to it.*

![docker container definition](images/04_container_definition.png "docker container definition")

### Image definition

> An **image** is composed of:
>   * *file-system* snapshot, that contains required files and folders
>   * a *startup command*

![docker image definition](images/05_image_definition.png "docker image definition")

### Docker application principle

A *container* can only work on a Linux kernel. Therefore, Docker is kind of a **Linux Virtual Machine** that allows us to isolate resources through *namespacing* and *control groups*.

![docker architecture overview](images/06_docker_architecture_overview.png "docker architecture overview")


# Docker basics commands (lifecycle)

## Docker run

### Definition

This command will spawn a new *container* for a particular *image*. `docker run` command is based on: 

![docker run basis](images/07_docker_run_basis.png "docker run basis")

Use the `-p` argument to forward incoming request _FROM_ local workstation's port number _TO_ a container's port.

![docker run port mapping](images/16_docker_port_mapping_run_argument.png "docker run port mapping")

### Examples

To showcase the `docker run` command, we rely on ***[BusyBox](https://hub.docker.com/_/busybox/)*** a very small linux distro (between 1 and 5 Mb) with only core utilities.

* Run busybox image with default command
  ```docker run busybox```
* execute simple `echo`:
  ```docker run busybox echo this is test```
* execute simple `ls`: 
   ```docker run busybox ls```
* execute long process `ping`: 
   ```docker run busybox ping google.com```
* start simple linux and access the prompt directly
   ```docker run -it busybox sh```
* use a particular version of an image (default version is _latest_)
   ```docker run -it busybox:1.34.1 sh```
* redirect _local_ port 5000 to _container_ port 8080
   ```docker run -it -p 5000:8080 node:17-alpine sh```


## Docker create

To **create** a new container from a specific _docker image_: `docker create {imageName}`
![docker create](images/08_docker_create_command.png "docker create")

* example: `docker create busybox echo hi there`
* This will:
    - Download / retrieve the corresponding _image_
    - Assign _resources_ to that particular "instance" (memory, hard-drive, etc.). This will apply _namespacing_ and _control group_ paradigms
    - Unpack the image content (files and folders) into this new space
    - Assign a particular _container ID_

## Docker start

To **start** an existing container, use its _container ID_: `docker start {containerId}`
![docker start](images/09_docker_start.png "docker start")

* example: `docker start -a 5327241a353256083f18a90383acc2b7bd856e45a7490ae553375e6fc9a5af6e`
* Key points:
  - Everytime you *start* a container, the corresponding _startup command_ will be executed. 
  - :fire: you **cannot override** the default startup command
  - You can restart a stopped container
  - Don't forget to use the `-a` argument to redirect container's outputs (STDOUT, STDERR) to your local terminal!

## Docker run VS docker start

Docker **run** is just a shortcut: `docker run` = `docker create`+ `docker start`

:fire: Careful :fire:
* `docker run`
  * **redirect** all container's **output** to the current terminal automatically.
  * you can **override** the default **_startup command_** with something else
* `docker start`
  * **does NOT print anything by default**, unless you use `-a` argument. Do view the STDOUT or STDERR you must use `docker logs`
  * you **cannot change default startup** command


## Docker log

To **view** what happen inside a specific container that you did not start with `-a`, you can use `docker log {containerId}` to access the logs and all outputs (STDOUT, STDERR).
![docker logs](images/10_docker_logs.png "docker logs")


* example: `docker logs 5327241a353256083f18a90383acc2b7bd856e45a7490ae553375e6fc9a5af6e`
* Key points:
  - You can view logs from an active or stopped container 
  - `docker logs` does NOT trigger any process. It just displays the system outputs
  


## Docker stop

To gracefully **stop** a container, use its _container ID_: `docker stop {containerId}`

This will send a _SIGTERM_ message to the process and shut the container down in a clean way - cleaning temporary values, saving state, etc.

> :fire: if the container does NOT stop 10 seconds max after `docker stop`, then a `docker kill` is automatically trigger by Docker Cli


## Docker exec

To **execute** an _additional_ command/process inside an existing container.
![docker exec](images/11_docker_exec.png "docker exec")

### Key points

* You can forward computer's inputs to the new process
  * `-i` to attach the current terminal to the new process, and use STDIN
  * `-t` make sure that all input text is nicely formatted (including encoding, keyboard layout, shortcuts, auto-completion, etc.)

> Don't forget to add the `-it` to forward the STDIN to the new process (= to attach local mouse and keyboard)

* `-u` to specify a particular Linux UserId to connect with.
  * root _(id = 0)_ is the default user within a container. 
  * The image developer can create additional users. Those users are accessible by name. 
  * When passing a numeric ID, the user does not have to exist in the container.
  > to use the root account, set `-u 0` 

### Access container's command prompt (SH / BASH)

With _docker exec_ you can access the container's command prompt. 

```bash
# SH default shell. It is always present.
docker exec -it {container_id} sh

# BASH, depends on the image content (default user)
docker exec -it {container_id} bash

# Access BASH with root account
docker exec -u 0 -it {container_id} bash
``` 


### Docker exec example: redis server + redis-cli

[Redis](https://redis.io/) is an open source, in-memory data storage used as database, cache and message broker. The purpose of this training is NOT to learn Redis, but this is a very good example of a docker application.

Process to showcase _docker exec_:
* Get Redis server
* By default, the Redis server does NOT include the `redis-cli` command
* Manually execute a new process inside the Redis server

```bash
# Start Redis server
docker run redis

# Get Redis server container ID
docker ps

# Exec new command "redis-cli" in container
docker exec -it efb6f31109ac redis-cli
```


## Docker kill

To **kill** a container, use its _container ID_: `docker kill {containerId}`

This will send a _SIGKILL_ message to the process and trigger a brute-force stop.



## Docker ps

This is one of the key command for Docker. By default, it will list all **running** containers that are currently available on the machine. But it can do so much more! 

* View **running** containers: ```docker ps```
* View **all** containers: ```docker ps --all```


## Cleanup containers

To clean containers that are STOPPED and delete all their content: `docker system prune`
* remove stopped _containers_
* remove all _virtual networks interfaces_ that are not used any more by at least 1 container
* clear out docker _build cache_ (this might remove also the not used local images)


# Create custom docker image

## Introduction to Dockerfile

To create a custom docker image we have to generate a `Dockerfile`. 
> This **configuration file** defines how our container should behave. 

![docker image principle](images/11_docker_image_principle.png "docker image principle")

More specifically, this configuration file describes: 
* what different programs it is going to contain
* what it does when a container starts up

Every _Dockerfile_ contains, at least:
| | item | docker instruction |Addition info|
|-|--------------------|---------------------|----------|
|1| Base image | **FROM** | For simple stuff use the _Alpine_ base image |
|2| Add additional commands and programs | **RUN** | There shall be only 1 RUN with `\` to chain operations |
|3| Specify a startup command to be executed after boot | **CMD** | It must be unique!! Only 1 CMD will be executed, and it is always the last one. syntax: `CMD["command", "arg1", "arg2"]` |


![docker file overview](images/12_docker_file_principle.png "docker file overview")


## ALPINE as base image

[Alpine](https://hub.docker.com/_/alpine/) Linux is a security-oriented, lightweight Linux distribution based on [musl libc](https://www.musl-libc.org/) and [busybox](https://www.busybox.net/). It contains all utilities to interact with other systems, resources and repositories + core programs. **This is the smallest and most efficient Linux kernel**. Since it is small, it is go-to choice for small containers, and it can be used in production.

Key points:
* It uses its own package manager called *`apk`*
* Crystal-clear Linux environment without all the noise. Only the bare minimum (8 Mb). It keeps your environment *as small and efficient as possible*
* Alpine Linux was designed with security in mind

> `Alpine` is often use with Docker containers because of its small footprint and security.


## Docker build command

### Principle
Use `docker build` to generate the new image.
* This will parse the `Dockerfile` and apply its configuration. 
* All files and folders located in the `Dockerfile` directory will be included in the image.
* At the end of the process you shall see the container ID.
* You can name an image with the `-t {imageName}` attribute. 
  .. Later on you can spawn a new instance with `docker run {imageName}`

Usage examples:
* Create a new image: `docker build {path-to-Dockerfile}`
* Create a new image with a particular name: `docker build -t {imageName} {path-to-Dockerfile}`


### Build lifecycle

:fire: :fire: !! IMPORTANT !! :fire: :fire:

When `docker build` parse the content of the `Dockerfile`, it performs the following actions: 

* FROM
  1. Retrieve from local cache/Download from docker-hub the **base image**
* RUN
  1. **Spawn a new temporary _container_** with the base image
  2. **Start** the temporary container
  3. **Execute all RUN instructions** _inside_ that temporary container.
  4. **Stop** the temporary container
  5. Take a **file system snapshot** of this temporary container
  6. **Save** snapshot as a **temporary image**
  7. **Drop** temporary _container_
* CMD
  1. Create a **new temporary _container_ based on temporary _image_**
  2. Set the **primary command** to execute + its arguments (= content of the `CMD` instruction)
  3. **Stop** the temporary container
  4. Take a **file system + startup command snapshot** of this temporary container
  5. **Save** the snapshot as **new image**
  6. **Drop** temporary _container_

----------
> Build principle: every docker instruction relies on the previous one. 
> 
> * Each Docker instruction will spawn a **temporary container** based on last Docker instruction's result
> * It will **apply its own configuration and commands**
> * The result of these operations (filesystem + startup command) will be **saved in a temporary image** for the next Docker instruction
> * Temporary container is dropped
>
> Final image is created when there is no more docker instructions to follow.

That's why, it is VERY IMPORTANT to avoid many docker operations. 

![docker build optimisation](images/12_docker_build_single_instruction.png "docker build optimisation")

Many `RUN` will result in: 
- Bigger image filesize
- Longer builds
- Harder maintenance

> Always prefer a single RUN operation
> 
>  ... even though it might reduce a little the usage of the local cache.

Source: [Google Cloud Architecture, best-practices-for-building-containers](https://cloud.google.com/architecture/best-practices-for-building-containers)

### How to tag an image (naming conventions)

If you want to name (_tag_) an image you must use the `-t {imageName}` flag. You should follow some conventions: 

```
imageName = {dockerId} / {projectName} : {version}
```


- **dockerId**: name of your docker user (ex: _guihomediaz_)
- **projectName** : name of the current project
- **version**: either a version number or `latest`

:information_source: Only the Open Source projects (such as _busybox, Alpine, Redis, etc._) have a simple name without dockerId.



### Example: create a redis-server image

1. create a new folder on your local machine to host the configuration (ex: `exercices/section3`)
2. create a new configuration file inside that folder: `Dockerfile` (no file extension). 
   ```bash 
   mkdir -p ./exercices/section3
   vim ./exercices/section3/Dockerfile
   ```

   It must contain the following structure:
   ```docker
   # Use an existing image as a base
   FROM alpine

   # Download and install a dependencies
   RUN ........

   # Tell the image what to do when it starts as a container
   CMD ["........"]
   ```
3. Build the image
   ```bash
   docker build -t guihomediaz/redis:latest .
   ```
   :information_source: All files and folder located in the build directory will be included in the image.

   At the end of the process you shall see the container ID.
   ```bash 
   writing image sha256:61f0bf35e165cbef3dc696b08d777c860aa036f40599cc429f1c75c94c67334f
   ```
4. Create and start a new container for that particular image
   ```bash
   docker run 61f0bf35e165cbef3dc696b08d777c860aa036f40599cc429f1c75c94c67334f
   ```

Diagram to represent what occurred: 
![docker build process overview](images/13_docker_build_simple_sequence.png "docker build process overview")

### Docker build cache

Docker has a local cache. It means that when you run the same `Dockerfile` multiple times it will be much faster! The local cache is one of the key to Docker's performances.

The cache is based on **ordered operations**. So, if something changed in the _RUN_ instruction(s) then a new build will be triggered.


## Create new image from container's snapshot (docker commit)

You can create an image from an existing running container (Snapshot). Use `docker commit` with `-c` to set the startup command. 

Ex: ```docker commit -c "CMD ['bash']" {containerId}```

> !!!! :fire::fire::fire: !!!
> 
> In real life, do **not** use `docker commit`, it is _much_ better to use a Dockerfile !
> 
> !!!! :fire::fire::fire: !!!


```bash
#################################################
# (example) create a simple container with data #
##################################################
# New container with just alpine on it
docker run -it alpine sh
# Add application
apk add --update vim
apk add --update bash
apk add --update redis


##################################################
# Create snapshot                                #
##################################################
# Get the containerId of the running container you'd like to save as an image
docker ps

# Create a Snapshot
#### Linux
docker commit -c 'CMD ["redis-server"]' {containerId}
#### Windows
docker commit -c "CMD ['redis-server']" {containerId}
```

## Add files inside the image (docker copy)

To add specific files inside the image, such as application's files | images | etc., you must use `docker copy {workstation_hdd_path} {docker_image_target_path}`
* `workstation_hdd_path` : path where the **sources files** are located on the workstation hard drive at the moment of the build. 
    This is relative to the build context - where you execute _docker build_ command!
* `docker_image_target_path` : **target** path where to copy these files inside the image

![docker copy](images/14_docker_copy.png "docker copy")


# Docker port mapping

## Principle

**The container has its own isolated set of ports that can receive traffic**.

> By default no trafic that is coming from your local network or computer is routed to the container. 
>
> You cannot reach any endpoint without **explicit port mapping**
> 

## How to forward a local port to the container?

**Port mapping definition**: 
* To forward all incoming requests on a particular workstation/server port number to a particular container's port number. 
* Port mapping only applies to **incoming requests**. By default a container can contact any remote web-site: there is no output filtering
* The **local port number is NOT necessary the as the container**. For instance, you can redirect workstation's `localhost:5000` to `container:8080`

![docker port mapping principle](images/15_docker_port_mapping_principle.png "docker port mapping principle")

:fire::fire: !! port forwarding is strictly a **runtime constraint** !!
> Port forwarding is set with `docker run` command, not in the `Dockerfile`!!


# Simple application example 

## Objectives

Create a simple NodeJS application to demonstrate how to encapsulate a real application in Docker. This is:
* Expose a web-service that will return a String (~ like hello-world) on HTTP GET `/`
* Do a `server-side console log` at each web-service call
* `Listen` for incoming queries on `port 8080`


## Requirements

1. `Dockerfile` specifications
  To fufill the objects, the new `Dockerfile` shall include: 
  * FROM 
    * Use base image: official node image, _alpine_ based
  * COPY 
    * to copy application's files into the new image, to a specific location (`/usr/app`)
  * WORKDIR
    * To set the working directory for our application in runtime, when the container start. In other words: 
      * At build, it affects _all following `Dockerfile` commands_ will be executed relative to this folder
      * In runtime, _all `docker exec` commands_ will be executed from that folder too
    * If the folder does not already exists inside the container it will be created for us
  * RUN 
    * Add missing dependencies 
    * Sources compilation
  * CMD
    * Application start: `npm start`
2. `docker build` : the new image shall have a tag that follows the convention: `dockerID/appName` (ex: _guihomediaz/simplewebapp_)
3. `docker run` : when you create the container, don't forget to forward a local port to container's `8080` with the `-p` argument


## Execution steps

See application's files + `Dockerfile` in [section 4 files](./exercices/section_4/simple-app)

```bash
# Build the image base on the Dockerfile
docker build -t guihomediaz/simplewebapp .

# Spawn new container
# !! Don't forget the port mapping !!
docker run -p 5000:8080 guihomediaz/simplewebapp

# Check-out the browser from local workstation
curl http://localhost:5000
```  



# Resources

* [Google cloud best practices with Docker](https://cloud.google.com/architecture/best-practices-for-building-containers#build-the-smallest-image-possible)


