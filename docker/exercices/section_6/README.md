# Application with containers for DEV / TEST / PROD

This is an important chapter, it explains how to ship the application for DEV / TEST / PROD. 

## Objectives

Main objectives: 
* Create and start **development** image and container. 
  * It will run `npm run start`. 
  * Live coding is available on port `3000`
* Create and start **testing** image and container. 
  * It will run `npm run test`. 
  * This container does not expose anything. You can only access it with `docker exec -it <containerId> bash`
* Create and start **production** image and container. 
  * It will run `npm run build`. 
  * Produced files will be served by Nginx on port `80`

Other objectives:
* Development + test images and containers are managed together. **Whatever you code is tested**
  * Same `Dockerfile.dev` for the structure
  * Same `docker-compose.yml` for the management
* Production uses `Dockerfile`. You must `build` and `run` it manually


## Development image and container

* CAREFUL: the `package.json` file will be copied. Any change to it requires a new image build
* Source code: the container will listen for any code changes and apply it immediately. 

* You can use the `Dockerfile.dev`
```bash
#Build with: 
docker build . -f .\Dockerfile.dev -t guihomediaz/section_6/react-app-dev
#Run with: 
docker run --name s6-app-dev -p 4000:3000 -v /opt/app/node_modules -v ${pwd}:/opt/app guihomediaz/section_6/react-app-dev
```

Even better: use the `docker-compose.yml` file: 
```bash
docker-compose up --build
```

## Testing image and container



## Start Development and testing all together
## Production image and container