# DTHWebApplication - Added by Rahul for test -2

### DTHWebApplication Spring Boot Application for DEVOPS Training Demo

```
mvn install -Dmaven.test.skip=true
```
```
mvn test -DskipITs
```
```
mvn verify -Dmaven.test.skip=true
```

```
mvn install -Dskip.surefire.tests -DskipITs
```

```
Create directory /home/centos/DTHImage
```

```
Copy war to the directory [centos@ip-172-31-31-213 DTHImage]$ cp ../DTHWebApplication/target/dth-web-application-0.0.1-SNAPSHOT.war .
```

```
Create Dockerfile [centos@ip-172-31-31-213 DTHImage]$ vi Dockerfile
```

```
# Use an official centos as a parent image
FROM centos:latest

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages specified in requirements.txt
#RUN pip install --trusted-host pypi.python.org -r requirements.txt

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME World

# Run app.py when the container launches
CMD ["java", "-jar","dth-web-application-0.0.1-SNAPSHOT.war"]

```

```
[centos@ip-172-31-31-213 DTHImage]$ sudo docker build .
```
