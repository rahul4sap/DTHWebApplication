# DTHWebApplication Demo

DTHWebApplication Spring Boot Application for DEVOPS Training
mvn install -Dmaven.test.skip=true
mvn test -DskipITs
mvn verify -Dmaven.test.skip=true
mvn install -Dskip.surefire.tests -DskipITs
