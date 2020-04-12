package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Menu.MainMenu;
import Payment.Booking;
import User.Stylist;
import User.User;

public class Main {
	
	public static ArrayList<User> userdata = new ArrayList<User>();
	public static ArrayList<User> stylistdata = new ArrayList<User>();
	
	public static Date date= Calendar.getInstance().getTime();
	
	public static void loadPrevData(){
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("userdata.file"));
			String tempLine;
			
			while((tempLine = br.readLine()) != null){
				String[] inputData = tempLine.split("#");
				String UUID = inputData[0];
				String Name = inputData[1];
				String Email = inputData[2];
				String Password = inputData[3];
				
				User tempUser = new User(UUID, Name, Email, Password);
				userdata.add(tempUser);
				
				for(int i=4; i<=inputData.length; i = i+4){
					String CustID = inputData[i];
					String StylistID = inputData[i+1];
					String serviceOrder = inputData[i+2];
					String dateSchedule = inputData[i+3];
					
					Booking tempBook = new Booking(CustID, StylistID, serviceOrder, dateSchedule);
					tempUser.booklist.add(tempBook);
				}
				
			}
		} catch (Exception e){
			
		}
	}
	
	public static void loadStylist()
	{
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader("stylistdata.file"));
			String tempLine;
			
			while((tempLine = br.readLine()) != null){
				String[] inputData = tempLine.split("#");
				String UUID = inputData[0];
				String Name = inputData[1];
				String Email = inputData[2];
				String Password = inputData[3];
				String Specialization = inputData[4];
				
				User tempStylist = new Stylist(UUID, Name, Email, Password, Specialization);
				stylistdata.add(tempStylist);
				
			}
		} catch (Exception e){
			
		}
	}
	
	public static void main(String[] args) {
		loadPrevData();
		new MainMenu();
	}
	

}
