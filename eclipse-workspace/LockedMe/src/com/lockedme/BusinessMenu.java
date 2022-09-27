package com.lockedme;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusinessMenu {

	public BusinessMenu() {
		// TODO Auto-generated constructor stub
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		businessMenu();
		
	}


	public static void addFile() {
		// TODO Auto-generated method stub
	System.out.println("Please enter the name of the file to be added");
	Scanner scfile = new Scanner(System.in);
	String filename = scfile.nextLine();
	File maindir = new File("C:\\Users\\amit_\\eclipse-workspace\\LockedMe\\UserFiles\\");
	File myFile = new File(maindir+"\\"+filename);
	try {
		if(myFile.createNewFile()) {
			System.out.println(filename+" file is added to the directory");
			Desktop.getDesktop().edit(myFile);
		}
		else {
			System.out.println("This file already exists.");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}


	public static void deleteFile() {
		// TODO Auto-generated method stub
		File maindir = new File("C:\\Users\\amit_\\eclipse-workspace\\LockedMe\\UserFiles\\");
		File[] userfiles = maindir.listFiles();
		try {
			List<String> showfiles = new ArrayList<String>();
			try {
				for(File file : userfiles) {
					if(file.isFile()) {
						showfiles.add(file.getName());
				            }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Please enter the name of the file to be deleted: ");
			Scanner scfile = new Scanner(System.in);
			String fname = scfile.nextLine();
			File myFile  = new File(maindir+"\\"+fname);
			String uname = myFile.getName();
		
			if (showfiles.contains(uname)) {//check case-sensitivity of filename
				myFile.delete();
			}else System.out.println("File Not Found");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("File not found");
		}
		
	}
	
	public static void searchFile() {
		File maindir = new File("C:\\Users\\amit_\\eclipse-workspace\\LockedMe\\UserFiles\\");
		File[] userfiles = maindir.listFiles();
		System.out.println("Please enter the filename you are looking for. ");
		Scanner scfile = new Scanner(System.in);
		String filename = scfile.nextLine();
		boolean filex = false;
		for (File myfile :userfiles) {
			if(myfile.getName().equals(filename)) {
				System.out.println("File "+filename+" exists in the directory. ");
				filex = true;
			}
		}
		if(!filex) {
			System.out.println("The file "+filename+" is not in the directory.");
		}
	}


	public static void businessMenu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int busoption;
		do {
			System.out.println("\tBusiness Level Operations");
			System.out.println("1. Add a file");
			System.out.println("2. Delete a file");
			System.out.println("3. Search for a file");
			System.out.println("4. Return to Main Menu");
			try {
				busoption = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid input, please enter a valid option from Main Menu. ");
				break;
			}
			switch(busoption) {
				case 1:
					System.out.println("You have chosen to add a file");
					addFile();
					break;
				case 2:
					System.out.println("you have chosen to delete a file");
					deleteFile();
					break;
				case 3:
					System.out.println("You have chosen to search for a file");
					searchFile();
					break;
				case 4:
					System.out.println("Returning to Main Menu\n");
					MainMenu.mainMenu();
					break;
				default:
					System.out.println("Invalid input, please enter a valid option from the Business Menu");
				}
			}
			while(busoption!=4);
	}


}


