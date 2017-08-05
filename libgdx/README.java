=============================================================

// Creating the project
// https://github.com/libgdx/libgdx/wiki/Project-Setup-Gradle

java -jar ./gdx-setup.jar

//  will be asked :
//  Name: the name of the application, lower-case
//  Package: the Java package under which your code will live, e.g. com.badlogic.mygame
//  Game Class: the name of the main game java class of your app, e.g. MyGame
//  Destination: Folder where your app will be created
//  Android SDK: the location of your android sdk

=============================================================

// Running the project
./gradlew desktop:run


=============================================================

// Project Structure

settings.gradle            <- definition of sub-modules. By default core, desktop, android, html, ios
build.gradle               <- main Gradle build file, defines dependencies and plugins
gradlew                    <- script that will run Gradle on Unix systems
gradlew.bat                <- script that will run Gradle on Windows
gradle                     <- local gradle wrapper
local.properties           <- Intellij only file, defines android sdk location

core/
    build.gradle           <- Gradle build file for core project*
    src/                   <- Source folder for all your games code

desktop/
    build.gradle           <- Gradle build file for desktop project*
    src/                   <- Source folder for your desktop project, contains Lwjgl launcher class

android/
    build.gradle           <- Gradle build file for android project*
    AndroidManifest.xml    <- Android specific config
    assets/                <- contains for your graphics, audio, etc.  Shared with other projects.
    res/                   <- contains icons for your app and other resources
    src/                   <- Source folder for your Android project, contains android launcher class

html/
    build.gradle           <- Gradle build file for the html project*
    src/                   <- Source folder for your html project, contains launcher and html definition
    webapp/                <- War template, on generation the contents are copied to war. Contains startup url index page and web.xml


ios/
    build.gradle           <- Gradle build file for the ios project*
    src/                   <- Source folder for your ios project, contains launcher

=============================================================
// https://github.com/libgdx/libgdx/tree/master/gdx/src/com/badlogic/gdx
=============================================================
// https://github.com/libgdx/libgdx/wiki/Starter-classes-%26-configuration#live-wallpapers

// https://github.com/libgdx/libgdx/wiki/Starter-classes-%26-configuration#daydreams
=============================================================

// https://github.com/libgdx/libgdx/wiki/Querying#getting-the-application-type

// Getting the Application Type
Application.getType()

switch (Gdx.app.getType()) {
    case Android:
        // android specific code
        break;
    case Desktop:
        // desktop specific code
        break;
    case WebGl:
        // HTML5 specific code
        break;
    default:
        // Other platforms specific code
}

int androidVersion = Gdx.app.getVersion();


// number of bytes currently in use ihn the respective heap
long javaHeap = Gdx.app.getJavaHeap();
long nativeHeap = Gdx.app.getNativeHeap();

=============================================================
// ANdroid studio
// Desktop:
// Run -> Edit Configurations..., click the plus (+) button and select Application.
// Set the Name to Desktop.
// Set the field Use classpath of module to desktop,
// then click on the button of the Main class field and select the DesktopLauncher class.
// Set the Working directory to your android/assets/ (or your_project_path/core/assets/) folder!
// click Apply and then OK.

=============================================================
// it is very, very bad to instantiate a new object all the time, such as the Vector3 instance.
// The reason for this is the garbage collector has to kick in frequently to collect these short-lived objects.

=============================================================

ApplicationListener -   interface
ApplicationAdapter  -   abstract class implemets ApplicationListener
Game                -   abstract class implemets ApplicationListener, allow screen thing to implement easily
screen              -   interface
