=================================================
//  https://github.com/libgdx/libgdx/wiki/Managing-your-assets
//  http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/assets/AssetManager.html
//  https://github.com/libgdx/libgdx/blob/master/gdx/src/com/badlogic/gdx/assets/AssetManager.java
=================================================

//  -   can show loading screen
//  -   assets are reference counted
//  -   single place to store all assets

// don't make it static
AssetManager manager = new AssetManager();

=================================================

// AssetsLoader

manager.load("data/mytexture.png", Texture.class);
manager.load("data/myfont.fnt", BitmapFont.class);
manager.load("data/mymusic.ogg", Music.class);

// with parameters

TextureParameter param = new TextureParameter();
param.minFilter = TextureFilter.Linear;
param.genMipMaps = true;
manager.load("data/mytexture.png", Texture.class, param);

// loading font

// First, let's define the params and then load our smaller font
FreeTypeFontLoaderParameter mySmallFont = new FreeTypeFontLoaderParameter();
mySmallFont.fontFileName = "arial.ttf";
mySmallFont.fontParameters.size = 10;
manager.load("arial.ttf", BitmapFont.class, mySmallFont);

// Next, let's define the params and then load our bigger font
FreeTypeFontLoaderParameter myBigFont = new FreeTypeFontLoaderParameter();
myBigFont.fontFileName = "georgia.ttf";
myBigFont.fontParameters.size = 20;
manager.load("georgia.ttf", BitmapFont.class, myBigFont);

BitmapFont mySmallFont = manager.get("arial.ttf", BitmapFont.class);
BitmapFont myBigFont = manager.get("georgia.ttf", BitmapFont.class);

=================================================

 // AssetManager does not yet load anything.
 // To kick this off we have to call AssetManager.update() continuously,

 public void render() {
     if(manager.update()) {
        // we are done loading, let's move to another screen!
     }

     // display loading information
     float progress = manager.getProgress()
     ... left to the reader ...
  }

//  returns a number between 0 and 1 indicating the percentage of assets loaded so far.
manager.getProgress()

// This will block until all the assets that have been queued are actually done loading
manager.finishLoading();

=================================================

// Getting Assets
// this assumes assets have been successfully loaded

Texture tex = manager.get("data/mytexture.png", Texture.class);
BitmapFont font = manager.get("data/myfont.fnt", BitmapFont.class);

if(manager.isLoaded("data/mytexture.png")) {
   Texture tex = manager.get("data/mytexture.png", Texture.class);
}

=================================================

// Disposing assets
// Assets managed via the AssetManager shouldn't be disposed manually, instead call AssetManager.unload()!
manager.unload("data/myfont.fnt");

// to get rid of all assets at once
manager.clear();
// or
manager.dispose();

=================================================

// to use our own fileHandlerResolver
AssetManager manager = new AssetManager(new ExternalFileHandleResolver());

=================================================

// Resuming with a loading screen

// after created assetmanger
Texture.setAssetManager(manager);

// and in resume method , show loading screen

=================================================
