Shopping cart built in java servlets

make sure you have gradle installed, you can find it, here https://gradle.org/gradle-download/ or sudo apt-get install gradle for Ubuntu users
Download Tomcat
Pull the project
Run the gradle build (gradle build)
If all goes well, go into the now generated build/libs/classes folder
Copy the class into your tomcat{version}/webapps/ROOT/WEB-INF/classes/com/h3dg3wytch/
copy the web.xml into tomcat{version}/webapps/ROOT/WEB-INF
restart your tomcat
go to localhost:8080/
You should see, helloworld printed out
