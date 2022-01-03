DOCKER training

- [Training notes](#training-notes)
  - [Finished Code](#finished-code)
  - [Diagrams](#diagrams)
- [Docker installation](#docker-installation)
  - [Tools](#tools)
  - [Adjust storage path for images and containers=](#adjust-storage-path-for-images-and-containers)
- [Docker principle](#docker-principle)
  - [Hello-world: get image and spawn container](#hello-world-get-image-and-spawn-container)
  - [What is a container ?](#what-is-a-container-)
    - [Core concepts](#core-concepts)
    - [Container definition](#container-definition)
    - [Image definition](#image-definition)
    - [Docker application principle](#docker-application-principle)


# Training notes

* Course: https://www.udemy.com/course/docker-and-kubernetes-the-complete-guide/
* Training period: 2022-01-03
* Docker setup: Windows 11 with WSL2, docker desktop v4.3.2 (72729) | docker cli v20.10.11


## Finished Code
Finished code is attached to each applicable lecture throughout the course. 

If you get stuck at any point you can download the code and compare it against yours with a diff tool like Diffchecker or VSCode's built-in comparison tool.


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


## Adjust storage path for images and containers=

!! **This is for Windows WSL 2 only** !!

* Source: [StackOverflow thread](https://stackoverflow.com/questions/62441307/how-can-i-change-the-location-of-docker-images-when-using-docker-desktop-on-wsl2)


The WSL 2 `docker-desktop-data` vm disk image would normally reside in: `%USERPROFILE%\AppData\Local\Docker\wsl\data\ext4.vhdx`

To relocate it to other drive/directory, with all existing docker data preserved:
* First, **shut down your docker desktop** by right click on the Docker Desktop icon and select Quit Docker Desktop
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

![core concepts behing Docker](images/03_core_concepts_behind_docker.png "core concepts behing Docker")

!! These particular concepts are Linux specific features. Therefore each container will run on Linux. 

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

## Docker run

This command will spawn a new *container* for a particular *image*. `docker run` command is based on: 

![docker run basis](images/07_docker_run_basis.png "docker run basis")

To showcase the `docker run` command, we rely on ***[BusyBox](https://hub.docker.com/_/busybox/)*** a very small linux distro (between 1 to 5 Mb) with only core utilities.

* execute simple `echo`:
  ```docker run busybox echo this is test```
* execute simple `ls`: 
   ```docker run busybox ls```
* execute long process `ping`: 
   ```docker run busybox ping google.com```

## Docker ps

This is one of the key command for Docker. By default, it will list all **running** containers that are currently available on the machine. But it can do so much more! 

* View **running** containers: ```docker ps```
* View all containers: ```docker ps --all```

# Container lifecycle

1. To **create** a new container from a specific _docker image_: `docker create {imageName}
  ![docker create](images/08_docker_create_command.png "docker create")
  - example: `docker create busybox`
  - This will:
    - Download / retrieve the corresponding _image_  
    - Assign _resources_ to that particular "instance" (memory, hard-drive, etc.). This will apply _namespacing_ and _control group_ paradigms
    - Unpack the image content (files and folders) into this new space
    - Assign a particular _container ID_


2. To **start** an existing container, use its _container ID_: `docker start`
  ![docker start](images/09_docker_start.png "docker start")
  - example: `docker start -a 5327241a353256083f18a90383acc2b7bd856e45a7490ae553375e6fc9a5af6e`
  - Key points:
    - Everytime you *start* a container, the corresponding _startup command_ will be executed. :fire: **you cannot override the default startup command** :fire:
    - You can restart a stopped container
    - Don't forget to use the `-a` argument to redirect container's console (System.Out) to your local terminal!

> Docker **run** is just a shortcut: `docker run` = `docker create`+ `docker start`
> 
> :fire: Careful :fire:
> 
> * `docker run` 
>   * **redirect** all container's **output** to the current terminal. You can see logs and errors.
>   * you can **override** the default **_startup command_** with something else
> 
> * `docker start`
>   * **does NOT print anything by default**, unless you use `-a` argument
>   * you **cannot change default startup** command

3. To **stop** a container, use its _container ID_: `docker stop` 

## Cleanup containers

To clean containers that are STOPPED and delete all their content: `docker system prune`
* remove stopped _containers_
* remove all _virtual networks interfaces_ that are not used anymore by at least 1 container
* clear out docker _build cache_ (this might remove also the not used local images)

