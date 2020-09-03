### Sample JavaFX application with jpackage to native executable



Edit paths in pom.xml for jpackage.path and javafx.mods.path to your local JDK and javafx.mods path or setup environment variables.
Execute maven goal to create native executable:

```mvn clean package -P jpackage``` 

the native image will be under:

 ```target\jpackage\hellofx```
 
to lunch the app run 'hellofx'
 
Tested with openJDK jdk-14.0.2 and javafx-jmods-14.0.2.1

For different options on jpackage edit the argument list in exec-maven-plugin. The list of options for use 'jpackage -h'