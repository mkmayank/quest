=================================================

// A viewport always manages a Camera's viewportWidth and viewportHeight.
// Manages a Camera and determines how world coordinates are mapped to and from the screen.
// https://github.com/libgdx/libgdx/wiki/Viewports
// https://github.com/libgdx/libgdx/tree/master/gdx/src/com/badlogic/gdx/utils/viewport
=================================================

private Viewport viewport;
private Camera camera;

public void create() {
    camera = new PerspectiveCamera();
    viewport = new FitViewport(800, 480, camera);
}


public void resize(int width, int height) {
    viewport.update(width, height);
}
=================================================

mCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
mCamera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
mCamera.update();
mViewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, mCamera);

=================================================

// https://github.com/libgdx/libgdx/tree/master/gdx/src/com/badlogic/gdx/utils/viewport

StretchViewport
FitViewport
FillViewPort
ScreenViewPort
ExtendViewport
ScalingViewport
//

=================================================
