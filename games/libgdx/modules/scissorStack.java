=================================================

// https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/scenes/scene2d/utils/ScissorStack.html

=================================================

// https://github.com/libgdx/libgdx/wiki/Clipping%2C-with-the-use-of-scissorstack

Rectangle scissors = new Rectangle();
Rectangle clipBounds = new Rectangle(x,y,w,h);
ScissorStack.calculateScissors(camera, spriteBatch.getTransformMatrix(), clipBounds, scissors);
ScissorStack.pushScissors(scissors);
spriteBatch.draw(...);
spriteBatch.flush();
ScissorStack.popScissors();

=================================================
