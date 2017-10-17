// clear the screen each frame

// When blending is disabled, anything already on the screen at that location is replaced by the texture.
// This is more efficient, so blending should always be disabled unless it is needed.
// E.g., when drawing a large background image over the whole screen, a performance boost can be gained by first disabling blending:
