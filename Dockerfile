# Use an official centos as a parent image
FROM centos:latest

# Set the working directory to /app
WORKDIR /app

# Copy the contents into the container at /app
COPY target/dth-web-application-0.0.1-SNAPSHOT.war /app

# Install any needed packages specified in requirements.txt
RUN yum install -y java

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define environment variable
ENV NAME World

# Run app.py when the container launches
CMD ["java", "-jar","dth-web-application-0.0.1-SNAPSHOT.war"]
