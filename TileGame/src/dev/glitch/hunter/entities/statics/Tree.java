package dev.glitch.hunter.entities.statics;

import java.awt.Graphics;

import dev.glitch.hunter.Handler;
import dev.glitch.hunter.gfx.Assets;
import dev.glitch.hunter.items.Item;
import dev.glitch.hunter.tiles.Tile;

public class Tree extends StaticEntity {
	private int i = 0;

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
		
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
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int) x, (int) y));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree[i], (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
