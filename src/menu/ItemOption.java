package menu;

import items.Item;
import gfx.Screen;
import gfx.Text;

public class ItemOption extends Option{
	public Text name;
	public Text q;
	public Item item;
	public int itemID;
	public int itemPackID;
	public int quantity;
	public Menu menu;
	public ItemOption(Item i, int q){
		item = i;
		quantity = q;
		name = new Text(item.title);
		name.setPos(56, 9);
		itemID = i.ID;
		itemPackID = i.packID;
		updateQuantity();
	}
	public void updateQuantity(){
		q = new Text("x"+Integer.toString(quantity));
		q.setPos(136, 9);
	}
	public void addAmount(int x){
		quantity+=x;
		updateQuantity();
	}
	public void render(Screen screen) {
		screen.renderStaticImage(name);
		screen.renderStaticImage(q);
	}
	public Option setPos(int x, int y) {
		name.setPos(x, y);
		q.setPos(x+80, y);
		return this;
	}
	public Menu select() {
		return menu;
	}

}
