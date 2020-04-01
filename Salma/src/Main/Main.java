package Main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Menu.MainMenu;
import User.User;

public class Main {
	
	public static ArrayList<User> userdata = new ArrayList<User>();

	public static Date date= Calendar.getInstance().getTime();
	
	public static void main(String[] args) {
		new MainMenu();
	}

}
