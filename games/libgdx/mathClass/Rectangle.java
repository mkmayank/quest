import com.badlogic.gdx.math.Rectangle;

==========================================

private Rectangle bucket;

bucket = new Rectangle();
bucket.x = 800 / 2 - 64 / 2;
bucket.y = 20;
bucket.width = 64;
bucket.height = 64;

==========================================

raindrop.overlaps(bucket) //checks if this rectangle overlaps with another rectangle

==========================================
