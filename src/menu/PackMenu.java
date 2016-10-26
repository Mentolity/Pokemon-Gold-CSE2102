package menu;

import pokemon.Item;
import game.InputHandler;
import gfx.Textbox;

public abstract class PackMenu extends Menu {
	public int size;
	public int id;
	public PackMenu(Menu ref){
		size=-1;
		last = ref;
		template = new PackMenuTemplate();
		boxes = new Textbox[]{
				new Textbox(0, 96, 20, 6)
				};
		options = new ItemOption[25];
	}
	public void addItem(Item i, int q){
		size++;
		for(int y=0;y<25;y++){
			if(options[y]==null){
				options[y] = new ItemOption(i,q).setPos(56, (y*9)+9);
				break;
			}
		}
	}
	public Item takeItem(){
		ItemOption i = (ItemOption) options[loc];
		if(i.quantity>1){
			i.quantity--;
			options[loc] = i;
			return i.item;
		}
		else{
			options[loc] = null;
			for(int x=loc;x<24-loc;x++){
				if(options[x+1]!=null) options[x] = options[x+1];
			}
			return i.item;
		}
	}
	public void navigate(InputHandler input) {
		if(input.right.isPressed()){
			if(input.right.ticksPressed()<=1){
				this.close();
				if(id==3) next = last.PackMenus[0].open();
				else next = last.PackMenus[id+1].open();
			}
		}
		else if(input.left.isPressed()){
			if(input.left.ticksPressed()<=1){
				this.close();
				if(id==0) next = last.PackMenus[3].open();
				else next = last.PackMenus[id-1].open();
			}
		}
		else if(input.up.isPressed()){
			if(input.up.ticksPressed()<=1){
				if(loc==0) loc = size;
				else loc--;
				cursor.setPos(48,(loc*8)+9);
			}
		}	
		else if(input.down.isPressed()){
			if(input.down.ticksPressed()<=1){
				if(loc==size) loc = 0;
				else loc++;
				cursor.setPos(48,(loc*8)+9);
			}	
		}		
	}
	public void updateCursor() {
		loc=0;
		cursor.setPos(48, 9);
	}

}
