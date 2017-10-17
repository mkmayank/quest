

=================================================
// http://libgdx.badlogicgames.com/nightlies/docs/api/com/badlogic/gdx/Audio.html
=================================================
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

Audio audio = Gdx.audio;

=================================================

// a Sound instance can not be over 1mb in size
// Libgdx supports MP3, OGG and WAV files.

Sound sound = Gdx.audio.newSound(Gdx.files.internal("data/mysound.mp3"));

sound.play(1.0f);

long id = sound.play(1.0f); // play new sound and keep handle for further manipulation
sound.stop(id);             // stops the sound instance immediately
sound.setPitch(id, 2);      // increases the pitch to 2x the original pitch

id = sound.play(1.0f);      // plays the sound a second time, this is treated as a different instance
sound.setPan(id, -1, 1);    // sets the pan of the sound to the left side at full volume
sound.setLooping(id, true); // keeps the sound looping
sound.stop(id);             // stops the looping sound

sound.dispose();

=================================================

// Music instances are heavy, you should usually not have more than one or two at most loaded.
Music music = Gdx.audio.newMusic(Gdx.files.internal("data/mymusic.mp3"));

music.play();

music.setVolume(0.5f);                 // sets the volume to half the maximum volume
music.setLooping(true);                // will repeat playback until music.stop() is called
music.stop();                          // stops the playback
music.pause();                         // pauses the playback
music.play();                          // resumes the playback
boolean isPlaying = music.isPlaying(); // obvious :)
boolean isLooping = music.isLooping(); // obvious as well :)
float position = music.getPosition();  // returns the playback position in seconds

music.dispose();
=================================================
