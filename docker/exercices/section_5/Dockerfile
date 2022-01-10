#####################################
# Section 5: nodeJs application to count the number of visits
#
# You need to use a dedicate REDIS container with opened communications.
#
# @author Stephen Grider (trainer)
# @author Guillaume Diaz (trainee)
# @version 1.0, 2022/01
#
# NodeJS app is listening to port 8080
#####################################

# IMPORTANT ##
# --BUILD-- ## docker build -t guihomediaz/visits .
#           ##
#  --RUN--  ## Don't forget to add some port mapping
#           ## docker run -p 5000:8080 guihomediaz/visits

#### Use an existing image as a base
# Instead of install manually every dependencies: rely on the official NODE image
# See https://hub.docker.com/_/node
FROM node:alpine

###### Metadata (ex: image maintainer, variables, etc.)
# Application working directory
WORKDIR /usr/app

###### STATIC resources (files) to include in the new image
## put here static resources or the ones that are required for later instructions. (ex: package.json)
COPY ./visits/package.json /usr/app

# Download and install dependencies (not required)
RUN apk update \ 
    apk install bash

# Build the application
RUN npm install

###### Application content
COPY ./visits/index.js /usr/app

##### Tell the image what to do when it starts as a container
CMD ["npm", "start"]
