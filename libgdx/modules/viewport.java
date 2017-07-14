=================================================

// A viewport always manages a Camera's viewportWidth and viewportHeight.
// https://github.com/libgdx/libgdx/wiki/Viewports
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



=================================================
