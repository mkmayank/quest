=================================================

// https://github.com/libgdx/libgdx/wiki/Texture-Compression

=================================================
// LibGDX provides 2 options for textures in memory :
// 1.  ETC1 (Ericsson Texture Compression)
// 2.  KTX/ZKTX textures

// ETC1 :
//     -   allows to decrease the size of any RGB8 image by a 6x factor
//     -   lossy compression format
//     -   doesn't support alpha, though there are workaround
//
//     -   ETC1 compressed images will only work with OpenGL ES 2.0.
//     -   In case OpenGL ES 1.0 application they will get converted to normal RGB565 images on the fly!

Pixmap pixmap = new Pixmap(Gdx.files.absolute("image.png"));
ETC1.encodeImagePKM(pixmap).write(Gdx.files.absolute("image.etc1"));

Texture texture = new Texture(Gdx.files.internal("image.etc1"));

// KTX/ZKTX :
//     -   ZKTX format is just a zipped KTX to limit the size of the file on disk.
//     -   https://www.khronos.org/opengles/sdk/tools/KTX/

Texture texture = new Texture(Gdx.files.internal("image.zktx"));

=================================================
