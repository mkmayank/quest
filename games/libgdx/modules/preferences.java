// application can have multiple preferences, just give them different names

// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Preferences.html
===================================================

Preferences prefs = Gdx.app.getPreferences("My Preferences");

===================================================

prefs.putString("name", "Donald Duck");
String name = prefs.getString("name", "No name stored"); // with default value

prefs.putBoolean("soundOn", true);
prefs.putInteger("highscore", 10);

===================================================

// bulk update your preferences
prefs.flush();

// changes to a preferences instance will only get persisted if we explicitly call the flush() method

===================================================
