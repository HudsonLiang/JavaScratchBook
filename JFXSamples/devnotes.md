###Build JavaFX application with Gradle
####1 Directly run fx ant tasks in Gradle
#####Namespace
JDK comes with Ant tasks to package JavaFX application into native self-contained runnable package and corresponding installer.These tasks can be imported into Gradle.

```java
task importJavaFXTasks << {
	ant.taskdef(resource:"com/sun/javafx/tools/ant/antlib.xml", 
		uri:"javafx:com.sun.javafx.tools.ant",
		classpath: "${javahome}/lib/ant-javafx.jar")
}
```

JDK assigns default **namespace** to these tasks. Groovy allows special symbols in method names so namespace prefix can be put in method name. However, code can be cleaner by using 'NameSpaceBuilder' 
```java

import groovy.xml.NamespaceBuilder
def fx = NamespaceBuilder.newInstance(ant, 'javafx:com.sun.javafx.tools.ant')
fx.jar(....)

```
Reference: [Using Ant Libraries with AntBuilder](http://groovy.jmiguel.eu/groovy.codehaus.org/Using+Ant+Libraries+with+AntBuilder.html)

#####issue with `fx:deploy task`
Although `javapackager` in JDK supports options `srcdir` `srcfiles`, but the Ant `fx:deploy` task **DOES NOT** support them at all. If these options are used, not output will be generated.

In fact, in `DeployFXTask`, only these attributes are defined:
```java
     private String width = null;
     private String height = null;
     private String embeddedWidth = null;
     private String embeddedHeight = null;
     private String outfile = null;
     private String outdir = null;
     private boolean embedJNLP;
     private boolean isExtension = false;

```
So, to make `fx:deploy` task work, `resources` must be used
```java

 	fx.deploy(outdir:packageFolder, outfile:"jfx", nativeBundles:"exe",verbose:true){
 		application(name:"fxml example", mainClass:"fxmlexample.FXMLExample")
 		resources{
 			fileset(dir:"libs", includes:"JFXSamples.jar")
 		}

 	}
``` 