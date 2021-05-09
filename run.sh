mvn clean install
sudo docker build --build-arg JAR_FILE=target/*.jar -t com/sanjay .
sudo docker run -p 8080:8080 com/sanjay
