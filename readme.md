# Weather REST api

Toy springboot aplication that can store weather data

Link to data: https://query.data.world/s/3hfgm54so3aywtdc6wt2g2mgthaz75

App can be started with command `bash run_all.sh` that will spawn 3 docker containers:
 - 2 memory hungry cassandara clusters 
 - container with java application
 
Requirements:
 - docker

Java application is build inside container, so java is not nesseary to be present in host's OS
