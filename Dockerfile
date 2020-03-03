FROM tomcat:9.0-alpine

ADD api/target/api.war /usr/local/tomcat/webapps/api

EXPOSE 8080
CMD ["catalina.sh", "run"]
