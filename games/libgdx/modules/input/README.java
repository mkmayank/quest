// https://github.com/libgdx/libgdx/blob/master/gdx/src/com/badlogic/gdx/Input.java

===================================================

// The origin (0, 0) is in the upper left corner of the screen, the x-axis points to the right, the y-axis points downwards.

===================================================

// disable Accelerometer & Compass
AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
config.useAccelerometer = false;
config.useCompass = false;
initialize(new MyGame(), config);

// Accelerometer & Compass are enabled by default

===================================================

// gyroscope is disabled by default
config.useGyroscope = true;

===================================================

boolean hardwareKeyboard = Gdx.input.isPeripheralAvailable(Peripheral.HardwareKeyboard);
boolean multiTouch = Gdx.input.isPeripheralAvailable(Peripheral.MultitouchScreen);

// https://github.com/libgdx/libgdx/blob/master/gdx/src/com/badlogic/gdx/Input.java#L560
public enum Peripheral {
    HardwareKeyboard, OnscreenKeyboard, MultitouchScreen, Accelerometer, Compass, Vibrator, Gyroscope
}

===================================================

// unproject touch point ot mouse cursor
Vector3 tp = new Vector3();
camera.unproject(tp.set(Gdx.input.getX(), Gdx.input.getY(), 0));

===================================================

// Polling
// not reliable , it can miss events
boolean isTouched = Gdx.input.isTouched();

//muti touch
boolean firstFingerTouching = Gdx.input.isTouched(0);
boolean secondFingerTouching = Gdx.input.isTouched(1);
boolean thirdFingerTouching = Gdx.input.isTouched(2);

// If a finger is lifted off the screen and touched down again, while other fingers are still on the screen, the finger will get the first free index.

// not reliable
boolean justTouched = Gdx.input.justTouched();

boolean leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
boolean rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);
boolean isAPressed = Gdx.input.isKeyPressed(Keys.A);

===================================================

int firstX = Gdx.input.getX();
int firstY = Gdx.input.getY();
int secondX = Gdx.input.getX(1);
int secondY = Gdx.input.getY(1);

===================================================

// https://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/InputProcessor.html
// Event handling

interface InputProcessor{}

InputAdapter - implements all the InputProcessor, returning false from each

public class test implements InputProcessor {

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}

test inputProcessor = new test();
Gdx.input.setInputProcessor(inputProcessor);
===================================================

InputMultiplexer multiplexer = new InputMultiplexer();
multiplexer.addProcessor(new MyUiInputProcessor());
multiplexer.addProcessor(new MyGameInputProcessor());
Gdx.input.setInputProcessor(multiplexer);

// The InputMultiplexer will hand any new events to the first InputProcessor that was added to it.
// If that processor returns false from the method invoked to handle the event,
// this indicates the event was not handled and the multiplexer will hand the event to the next processor in the chain.
===================================================

// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/input/GestureDetector.html
// https://github.com/libgdx/libgdx/blob/master/gdx/src/com/badlogic/gdx/input/GestureDetector.java

GestureDetector

public class MyGestureListener implements GestureListener{

   	@Override
   	public boolean touchDown(float x, float y, int pointer, int button) {

	   	return false;
   	}

	@Override
	public boolean tap(float x, float y, int count, int button) {

		return false;
	}

	@Override
	public boolean longPress(float x, float y) {

		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {

		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {

		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {

		return false;
	}

   	@Override
   	public boolean zoom (float originalDistance, float currentDistance){

	   return false;
   	}

   	@Override
   	public boolean pinch (Vector2 initialFirstPointer, Vector2 initialSecondPointer, Vector2 firstPointer, Vector2 secondPointer){

	   return false;
   	}
   	@Override
	public void pinchStop () {
	}
}


// one has to implement the GestureListener interface and pass it to the constructor of the GestureDetector
Gdx.input.setInputProcessor(new GestureDetector(new MyGestureListener()));

===================================================

// Text input
TextInputListener - interface

public class MyTextInputListener implements TextInputListener {
   @Override
   public void input (String text) {
   }

   @Override
   public void canceled () {
   }
}

// to bring up the dialog
MyTextInputListener listener = new MyTextInputListener();
Gdx.input.getTextInput(listener, "Dialog Title", "Initial Textfield Value", "Hint Value");

===================================================

// Accelerometer
int orientation = Gdx.input.getRotation(); // 0, 90, 180 or 270

Orientation nativeOrientation = Gdx.input.getNativeOrientation(); // Orientation.Landscape or Orientation.Portrait

// Polling
float accelX = Gdx.input.getAccelerometerX();
float accelY = Gdx.input.getAccelerometerY();
float accelZ = Gdx.input.getAccelerometerZ();

===================================================

//Gyroscope
// Polling
float gyroX = Gdx.input.getGyroscopeX();
float gyroY = Gdx.input.getGyroscopeY();
float gyroZ = Gdx.input.getGyroscopeZ();

===================================================

// Vibration

Gdx.input.vibrate(2000); // vibrate the phone for 2 seconds ( milliseconds )

Gdx.input.vibrate(new long[] { 0, 200, 200, 200}, -1); // pattern

===================================================

// Back and menu key catching
Gdx.input.setCatchBackKey(true);
Gdx.input.setCatchMenuKey(true);

===================================================

Gdx.input.setOnscreenKeyboardVisible(true); // buggy

===================================================
