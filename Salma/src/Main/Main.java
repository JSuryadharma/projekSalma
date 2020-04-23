package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Menu.MainMenu;
import Payment.Booking;
import User.Stylist;
import User.*;

public class Main {
	
	public static ArrayList<User> userdata = new ArrayList<User>();
	public static ArrayList<User> stylistdata = new ArrayList<User>();
	
	public static void loadPrevData(){
		BufferedReader br = null;
		File userFile = new File("userdata.file");
		
		if(!userFile.exists()){
			try {
				userFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try{
			br = new BufferedReader(new FileReader("userdata.file"));
			String tempLine;
			
			while((tempLine = br.readLine()) != null){
				String[] inputData = tempLine.split("#");
				String UUID = inputData[0];
				String Name = inputData[1];
				String Email = inputData[2];
				String Password = inputData[3];
				Double Saldo = Double.parseDouble(inputData[4]);
				String Type = inputData[5];
				Integer Point = Integer.parseInt(inputData[6]);
				Integer nTransaksi = Integer.parseInt(inputData[7]);
				
				User tempUser = null;
				if(Type.equals("Customer")){
//					System.out.print("Regular Customer");
					tempUser = new Customer(UUID, Name, Email, Password, Saldo, nTransaksi);
				} else if(Type.equals("Silver")){
//					System.out.print("Silver Customer");
					tempUser = new Silver(UUID, Name, Email, Password, Saldo, Point, nTransaksi);
				} else if(Type.equals("Gold")){
//					System.out.print("Gold Customer");
					tempUser = new Gold(UUID, Name, Email, Password, Saldo, Point, nTransaksi);
				} else if(Type.equals("Platinum")){
//					System.out.print("Platinum Customer");
					tempUser = new Platinum(UUID, Name, Email, Password, Saldo, Point, nTransaksi);
				}
				
				userdata.add(tempUser);
//				System.out.println(" datas:");
//				System.out.println(UUID + " " + Name + " " + Email + " " + Password + " " + Saldo + " " + Point + " " + nTransaksi);
				if(inputData.length >= 8){
//					System.out.println("Bookings:");
					for(int i=8; i<inputData.length; i = i+6){
						String CustID = inputData[i];
						String StylistID = inputData[i+1];
						String StylistName = inputData[i+2];
						String serviceOrder = inputData[i+3];
						String dateSchedule = inputData[i+4];
						String dateBook = inputData[i+5];
//						System.out.println(CustID + " " + StylistID + " " + StylistName + " " + serviceOrder + " " + dateSchedule + " " + dateBook);
//						System.out.println("[Debug]: " + i);
						SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE ,dd-MM-YYYY");
						
						Date dataDate = dateFormat.parse(dateSchedule);
						Date thisdate = new Date();
						
						if(thisdate.compareTo(dataDate) >= 0){
							Booking tempBook = new Booking(CustID, StylistID, StylistName, serviceOrder, dateSchedule, dateBook);
							((Customer)tempUser).booklist.add(tempBook);
						} else {
//							System.out.println("Expired Date! Bookings on : " + dateFormat.format(dataDate));
						}
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void loadStylist()
	{
		BufferedReader br = null;
		
		File userFile = new File("stylistdata.file");
		if(!userFile.exists()){
			try {
				userFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
				Double Pricing = Double.parseDouble(inputData[5]);

//				System.out.println("Stylist datas:");
//				System.out.println(UUID + " " + Name + " " + Email+ " " + Password + " " + Specialization + " " + Pricing);
				Stylist tempStylist = new Stylist(UUID, Name, Email, Password, Specialization, Pricing);
				stylistdata.add(tempStylist);	
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		System.out.println("Debug Logs:");
		loadPrevData();
		loadStylist();
		new MainMenu();
	}
	

}
