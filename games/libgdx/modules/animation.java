===========================================

// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/Animation.html
// https://github.com/libgdx/libgdx/blob/master/gdx/src/com/badlogic/gdx/graphics/g2d/Animation.java

===========================================
// Animation has a generic type parameter for the type of class that represents the image.
// The type would typically be a TextureRegion or PolygonRegion, but any renderable object can be used.





===========================================

TextureAtlas
// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/TextureAtlas.html
// https://github.com/libgdx/libgdx/blob/master/gdx/src/com/badlogic/gdx/graphics/g2d/TextureAtlas.java

// TexturePacker and TextureAtlas provide a convenient way to generate animations.
// All the source images of an animation should be named with an underscore and frame number at the end, such as running_0.png, running_1.png, running_2.png, etc.
// TexturePacker will automatically use these numbers as frame numbers (so long as the packing parameter useIndexes is left true).

public Animation<TextureRegion> runningAnimation;

runningAnimation = new Animation<TextureRegion>(0.033f, atlas.findRegions("running"), PlayMode.LOOP);

===========================================

// https://github.com/libgdx/libgdx/wiki/2D-Animation#sprite-sheet-example

===========================================
