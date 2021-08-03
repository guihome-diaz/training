# Quarkus Project

Demonstration project to test Quarkus.

## Requirements

You need:
* [Apache maven 3.8.1](https://maven.apache.org/download.cgi)
* [Graal VM 21.2](https://www.graalvm.org/)

Environments variables:
* `JAVA_HOME` must point to GraalVM
* `GRAALVM_HOME` must point to GraalVM too


## Compilation

```shell script
# Built-in tool
./mvnw clean install 
# Old way
mvn clean install
```

Make sure the "mvnw" utility works. You'll need it for the rest of the operations.


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/

* Default landing page: http://localhost:8080
* Run the _Hello world_ web-service: http://localhost:8080/hello
* Development UI: http://localhost:8080/q/dev/


## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`. 
It will start a VertX server and listen on 8080 port automatically. 
You need to kill the process 



## Creating a native executable

(i) Before packaging, make sure to install the GraalVM "native-image" first.

### Native image (all platforms)

Install the native-image tool using gu install:
```shell script
${GRAALVM_HOME}/bin/gu install native-image
```
(i) _native-image_ is no longer included by default; it must be installed as a second step after GraalVM itself is installed.

### Windows libraries

You need some extra DLLs to work on Windows.
You must download and install [Visual Studio 2019 or later](https://visualstudio.microsoft.com/fr/downloads) to build the _native_ executable.
* Download the "Community" version

  ![MVSC step 1](/documentation/setup_msvc_1.PNG)

* Then execute the installation and choose:
    * Individual components (2nd tab headers)
    * Search for "**MSVC**" (Microsoft Visual Studio C++ compiler)
    * Install latest MSVC versions

  ![MVSC step 2](/documentation/setup_msvc_2.PNG)

* Add MVSC to the PATH

  `PATH: C:\Program Files (x86)\Microsoft Visual Studio\2019\Community\VC\Tools\MSVC\14.16.27023\bin\HostX64\x64`

### Build native image

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/eu.daxiongmao-training.quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)


## Documentation

* https://quarkus.io/guides/building-native-image
* [How to install and configure MVSC libraries](https://blog.csdn.net/xiaozei523/article/details/111885765) 