#####################################
# Section 6: simple REACT application
#
# @author Stephen Grider (trainer)
# @author Guillaume Diaz (trainee)
# @version 1.0, 2022/02
#####################################
#
# !!!! PRODUCTION CONTAINER !!!!
#
# There are NO VOLUMES, all files are included inside the container
# You can only access the web-server through the NGINX port (container port 80)
# 
######################################
# Build with: 
# docker build . -f .\Dockerfile -t guihomediaz/section_6/react-app-prod
#
# Run with: 
# docker run --name s6-app-prod -p 8080:80 guihomediaz/section_6/react-app-prod
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
# Build project in BUILD phase, production version of the application
RUN npm run build

###### RUN phase ########
FROM nginx
# Retrieve and copy output files from previous phase (from /app/section6/build) to NGINX default folder
COPY --from=react-app-builder /app/section6/build /usr/share/nginx/html 
# Open port 80 (make it explicit)
EXPOSE 80
