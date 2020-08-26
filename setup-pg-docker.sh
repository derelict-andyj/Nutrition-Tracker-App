 #!/bin/bash
 echo 'Setting up docker container. This may take a minute...' 
 docker rm nutrition-tracker-db-dev 
 docker run -p 5432:5432 --name nutrition-tracker-db-dev -e POSTGRES_PASSWORD=secret -d postgres:11.7-alpine
 echo 'Stopping container...' 
 docker stop nutrition-tracker-db-dev
 echo 'Good to go!'