package dev.glitch.hunter.entities.statics;

import java.awt.Graphics;

import dev.glitch.hunter.Handler;
import dev.glitch.hunter.gfx.Assets;
import dev.glitch.hunter.items.Item;
import dev.glitch.hunter.tiles.Tile;

public class Rock extends StaticEntity {
	private int i;
	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 3;
		bounds.y = (int) (height / 2f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void tick() 
	{
		if(health == 4)
			i = 0;
		if(health == 3)
			i = 1;
		if(health == 2)
			i = 2;
		if(health == 1 )
			i = 3;
	}
	
	@Override
	public void die(){
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock[i], (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
