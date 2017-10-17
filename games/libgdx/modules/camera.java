=================================================
// https://github.com/libgdx/libgdx/wiki/Orthographic-camera
=================================================

import com.badlogic.gdx.graphics.OrthographicCamera;

private OrthographicCamera camera;

camera = new OrthographicCamera();
camera.setToOrtho(false, 800, 480);

=================================================
good practice to update the camera once per frame
camera.update();
