package dev.glitch.hunter.entities.statics;

import dev.glitch.hunter.Handler;
import dev.glitch.hunter.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
	}

}
