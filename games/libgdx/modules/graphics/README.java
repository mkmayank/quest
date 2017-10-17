=================================================
// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Graphics.html
=================================================

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

Gdx.gl.glClearColor(0, 0, 0.2f, 1); // r,g,b,alpha , set the clear color to color given
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clear the screen with the color

=================================================

import com.badlogic.gdx.Gdx;

Gdx.graphics.getDeltaTime() //returns the time passed between the last and the current frame in seconds

=================================================
LWJGL 2

DisplayMode[] modes = LwjglApplicationConfiguration.getDisplayModes();

DisplayMode desktopMode = LwjglApplicationConfiguration.getDesktopDisplayMode();

// full-screen mode

DisplayMode displayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
config.setFromDisplayMode(displayMode);
new LwjglApplication(new MyAppListener(), config);

// windows mode
LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
config.width = 800;
config.height = 600;
new LwjglApplication(new MyAppListener(), config);

// position the window on the primary monitor by specifying its top-left corner coordinate relative to the monitors current display mode
config.x = 100;
config.y = 100;

// To center your window, use -1 for the coordinates (the default)
config.x = -1;
config.y = -1;

// enable vsync
config.vSyncEnabled = true;

=================================================

LWJGL 3 // it supports multi-monitor setups

Monitor[] monitors = Lwjgl3ApplicationConfiguration.getMonitors();

Monitor primary = Lwjgl3ApplicationConfiguration.getPrimaryMonitor();

DisplayMode[] displayModes = Lwjgl3ApplicationConfiguration.getDisplayModes(monitor);

DisplayMode desktopMode = Lwjgl3ApplicationConfiguration.getDisplayMode(monitor);

// for primary monitor
DisplayMode[] primaryDisplayModes = Lwjgl3ApplicationConfiguration.getDisplayModes();
DisplayMode primaryDesktopMode = Lwjgl3ApplicationConfiguration.getDisplayMode();

// full screen mode
DisplayMode primaryMode = LWjgl3ApplicationConfiguration.getDisplayMode();
Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
config.setFullscreenMode(primaryMode);
new Lwjgl3ApplicationConfiguration(new MyAppListener(), config);

// windowed mode
Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
config.setWindowedMode(800, 600);

// to position of the window
config.setWindowPosition(100, 100);

// if your window should be resizable and whether it has decoration (window title bar, borders):
config.setResizable(false);
config.setDecorated(false);

if(Gdx.graphics.supportsDisplayModeChange()) {
   // change display mode if necessary
}

=================================================

// disabling the continuous rendering, and calling it only when really need it.
// in ApplicationListener's create() method
Gdx.graphics.setContinuousRendering(false); // stop calling the render() method automatically
Gdx.graphics.requestRendering();    // triggers the render() method once

// If continuous rendering is set to false, the render() method will be called only when the following things happen.
//
//  An input event is triggered
//  Gdx.graphics.requestRendering() is called
//  Gdx.app.postRunnable() is called

=================================================

// take a screenshot

byte[] pixels = ScreenUtils.getFrameBufferPixels(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), true);

Pixmap pixmap = new Pixmap(Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), Pixmap.Format.RGBA8888);
BufferUtils.copy(pixels, 0, pixmap.getPixels(), pixels.length);
PixmapIO.writePNG(Gdx.files.external("mypixmap.png"), pixmap);
pixmap.dispose();


=================================================

// FPSLogger
log();

//PerformanceCounter
// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/utils/PerformanceCounter.html
start();
stop();

// GLProfiler
// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/graphics/profiling/GLProfiler.html
// https://github.com/libgdx/libgdx/wiki/Profiling#profiling

//Currently the following informations are provided by the profiler:
//  Amount of total OpenGL calls
//  Amount of draw calls
//  Amount of texture bindings
//  Amount of shader switches
//  Amount of used vertices

GLProfiler.enable()
GLProfiler.reset()
GLProfiler.disable()

apitrace
// https://github.com/libgdx/libgdx/wiki/Profiling#apitrace
// https://github.com/apitrace/apitrace

=================================================
