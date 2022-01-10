#####################################
# Simple NodeJS application: hello-world web-service 
# New web-service is exposed on port 8080 (--> see index.js)
#
# @version: 1.0, 2022/01
# @author: Stephen Grider (trainer)
# @author: Guillaume Diaz (trainee)
#####################################

# IMPORTANT ##
# --BUILD-- ## Don't forget to build the image and tag it following the Docker convention:
#           ##                    imageTag = dockerId/applicationName
#           ## 
#           ## ex:  docker build -t guihomediaz/simplewebapp .
#           ##
#  --RUN--  ## Don't forget to add some port mapping
#           ## ex: docker run -p 5000:8080 guihomediaz/simplewebapp

#### Use an existing image as a base
# Instead of install manually every dependencies: rely on the official NODE image
# See https://hub.docker.com/_/node
FROM node:17-alpine

###### Metadata (ex: image maintainer, variables, etc.)
# Application working directory
WORKDIR /usr/app

###### STATIC resources (files) to include in the new image
## put here static resources or the ones that are required for later instructions. (ex: package.json)
COPY ./app/package.json /usr/app

# Download and install dependencies (not required)
RUN apk update \ 
    apk install bash

# Build the application
RUN npm install


###### Application content
COPY ./app/index.js /usr/app


##### Tell the image what to do when it starts as a container
CMD ["npm", "start"]
