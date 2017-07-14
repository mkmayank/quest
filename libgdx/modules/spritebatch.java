===========================================

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

private SpriteBatch batch;
batch = new SpriteBatch();

// https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/g2d/SpriteBatch.html
===========================================

batch.setProjectionMatrix(camera.combined);
batch.begin();
batch.draw(bucketImage, bucket.x, bucket.y);
batch.end();

===========================================

SpriteBatch

// OpenGL hates nothing more than telling it about individual images.
// It wants to be told about as many images to render as possible at once.
//
// The SpriteBatch class helps making OpenGL happy.
// It will record all drawing commands in between SpriteBatch.begin() and SpriteBatch.end().
// Once we call SpriteBatch.end() it will submit all drawing requests we made at once, speeding up rendering quite a bit.

// To draw a texture, geometry is described and the texture is applied by specifying where each vertex in the geometry corresponds on the texture.
// A rectangle that is a subset of a texture is called a texture region.
// To do the actual drawing, first the texture is bound (i.e., made the current texture), then the geometry is given to OpenGL to draw

private SpriteBatch batch;
batch = new SpriteBatch();

batch.begin();
		// Drawing goes here!
batch.end();

===========================================

Texture

// The Texture class decodes an image file and loads it into GPU memory.
// The image file should be placed in the "assets" folder.
// The image's dimensions should be powers of two (16x16, 64x256, etc) for compatibility and performance reasons.

private Texture texture;
texture = new Texture(Gdx.files.internal("image.png"));

batch.draw(texture, 10, 10);

===========================================

TextureRegion

// Describes a rectangle inside a texture and is useful for drawing only a portion of the texture.
// The coordinate system used has its origin in the upper left corner with the x-axis pointing to the right and the y axis pointing downwards.

private TextureRegion region;
...
texture = new Texture(Gdx.files.internal("image.png"));
region = new TextureRegion(texture, 20, 20, 50, 50);
...
batch.begin();
batch.draw(region, 10, 10);
batch.end();

===========================================

Sprite

// describes both a texture region, the geometry where it will be drawn, and the color it will be drawn

private Sprite sprite;
...
texture = new Texture(Gdx.files.internal("image.png"));
sprite = new Sprite(texture, 20, 20, 50, 50);
sprite.setPosition(10, 10);
sprite.setRotation(45);
...
batch.begin();
sprite.draw(batch);
batch.end();

===========================================

Tinting

private Texture texture;
private TextureRegion region;
private Sprite sprite;
...
texture = new Texture(Gdx.files.internal("image.png"));
region = new TextureRegion(texture, 20, 20, 50, 50);
sprite = new Sprite(texture, 20, 20, 50, 50);
sprite.setPosition(100, 10);
sprite.setColor(0, 0, 1, 1);
...
batch.begin();
batch.setColor(1, 0, 0, 1);
batch.draw(texture, 10, 10);
batch.setColor(0, 1, 0, 1);
batch.draw(region, 50, 10);
sprite.draw(batch);
batch.end();

===========================================

Blending

// Blending is enabled by default
// When blending is disabled, anything already on the screen at that location is replaced by the texture.
// This is more efficient, so blending should always be disabled unless it is needed.

Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
batch.begin();
batch.disableBlending();
backgroundSprite.draw(batch);
batch.enableBlending();
// Other drawing here.
batch.end();

===========================================

// https://github.com/libgdx/libgdx/wiki/Spritebatch%2C-Textureregions%2C-and-Sprites#performance-tuning

===========================================
