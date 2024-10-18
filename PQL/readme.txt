This PQL depends on a custom build of javaparser (including the symbol solver).

We should not disrupt the dependency the DAS has on its javaparser (for now).

This project has a lib folder with a fat jar that contains the custom javaparser and its dependencies.

This is built on the mac laptop by adding a shader plugin to the root maven pom.xml file in the javaparser project (Documents/JavaParser)

Then at the root of the project, type:

mvn package -DskipTests

Take the javaparser-symbol-solver-core-3.6.13-SNAPSHOT.jar file in the target folder of the 

/Users/psamouel/Documents/JavaParser/javaparser/javaparser-symbol-solver-core/target folder

and copy it to this project's lib folder. The build.gradle file has been modified to include a reference to this as follows:

in the repositories section, add:

    flatDir {
    	dirs 'lib'
    }

Then in the dependencies section add:

compile name: 'javaparser-symbol-solver-core-3.6.13-SNAPSHOT'

Part of the reason for all this complexity is that the javaparser project is not a gradle project (it's maven).