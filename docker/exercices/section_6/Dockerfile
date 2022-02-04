#####################################
# Section 6: simple REACT application
#
# @author Stephen Grider (trainer)
# @author Guillaume Diaz (trainee)
# @version 1.0, 2022/02
#####################################
#
# This container will start the application on the port 3000 (`npm run start`)
#
# Port forwaring rules, This application listens on:
# TCP 3000        |     NodeJS REACT application
#
# Build with: 
# docker build . -f .\Dockerfile.dev -t guihomediaz/section_6_frontend
#
# Run with: 
# docker run --name section6_react -p 4000:3000 -v /opt/app/node_modules -v ${pwd}:/opt/app guihomediaz/section_6_frontend
#
#####################################

###### BUILD phase ########
# Build the application using the same image and configuration as 'dev' environment

FROM node:17-alpine as react-app-builder
WORKDIR '/app/section6'
COPY package*.json .
RUN npm install
# Copy all projects files inside the container
# !! do NOT use volumes for production when you serve code !!
# COPY ensure that everyone gets the same content, always.
COPY . .
# Build project
RUN npm run build

###### RUN phase ########
FROM nginx
# Retrieve and copy output files from previous phase (from /app/section6/build) to NGINX default folder
COPY --from=react-app-builder /app/section6/build /usr/share/nginx/html 

