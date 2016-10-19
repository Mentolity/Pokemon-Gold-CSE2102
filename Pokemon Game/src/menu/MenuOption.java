package menu;

public class MenuOption extends Option {
	public Menu menu;
	public MenuOption(String title, Menu menu){
		text = new Text(title);
		this.menu = menu;
	}
	public Menu select(){
		if(menu==null) return null;
		menu.open();
		return menu;
	}
}
