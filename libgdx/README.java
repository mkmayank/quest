./gradlew desktop:run

=============================================================
https://github.com/libgdx/libgdx/tree/master/gdx/src/com/badlogic/gdx
=============================================================
https://github.com/libgdx/libgdx/wiki/Starter-classes-%26-configuration#live-wallpapers

https://github.com/libgdx/libgdx/wiki/Starter-classes-%26-configuration#daydreams
=============================================================

https://github.com/libgdx/libgdx/wiki/Querying#getting-the-application-type

Getting the Application Type
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


number of bytes currently in use ihn the respective heap
long javaHeap = Gdx.app.getJavaHeap();
long nativeHeap = Gdx.app.getNativeHeap();

=============================================================
ANdroid studio
Desktop:
Run -> Edit Configurations..., click the plus (+) button and select Application.
Set the Name to Desktop.
Set the field Use classpath of module to desktop,
then click on the button of the Main class field and select the DesktopLauncher class.
Set the Working directory to your android/assets/ (or your_project_path/core/assets/) folder!
click Apply and then OK.

=============================================================
it is very, very bad to instantiate a new object all the time, such as the Vector3 instance.
The reason for this is the garbage collector has to kick in frequently to collect these short-lived objects.

=============================================================

ApplicationListener -   interface
ApplicationAdapter  -   abstract class implemets ApplicationListener
Game                -   abstract class implemets ApplicationListener
