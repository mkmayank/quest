Files type

Claspath
Internal    -   assets folder
Local       -   internal storage
External    -   external storage
Absolute

===================================================

// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/files/FileHandle.html

===================================================

boolean isExtAvailable = Gdx.files.isExternalStorageAvailable();
boolean isLocAvailable = Gdx.files.isLocalStorageAvailable();

String extRoot = Gdx.files.getExternalStoragePath();
String locRoot = Gdx.files.getLocalStoragePath();

===================================================

FileHandle handle = Gdx.files.internal("myfile.txt");
FileHandle handle = Gdx.files.classpath("myfile.txt");
FileHandle handle = Gdx.files.external("myfile.txt");
FileHandle handle = Gdx.files.absolute("/some_dir/subdir/myfile.txt");

===================================================

boolean exists = Gdx.files.external("doitexist.txt").exists();
boolean isDirectory = Gdx.files.external("test/").isDirectory();

FileHandle[] files = Gdx.files.local("mylocaldir/").list();
for(FileHandle file: files) {
   // do something interesting here
}

===================================================

FileHandle parent = Gdx.files.internal("data/graphics/myimage.png").parent();
FileHandle child = Gdx.files.internal("data/sounds/").child("myaudiofile.mp3");

//parent would point to "data/graphics/"
//child would point to data/sounds/myaudiofile.mp3"

===================================================

FileHandle file = Gdx.files.internal("myfile.txt");
String text = file.readString();

FileHandle file = Gdx.files.internal("myblob.bin");
byte[] bytes = file.readBytes();

===================================================

FileHandle file = Gdx.files.local("myfile.txt");
file.writeString("My god, it's full of stars", false);

//false - the current content of the file will be overwritten

===================================================

FileHandle from = Gdx.files.internal("myresource.txt");
from.copyTo(Gdx.files.external("myexternalcopy.txt"));

Gdx.files.external("myexternalcopy.txt").rename("mycopy.txt");
Gdx.files.external("mycopy.txt").moveTo(Gdx.files.local("mylocalcopy.txt"));

Gdx.files.local("mylocalcopy.txt").delete();

===================================================
