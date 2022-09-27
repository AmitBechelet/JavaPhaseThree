package com.lockedme;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainMenu { 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BusinessMenu busObj = new BusinessMenu();
		mainMenu();
	}

	
	public static void mainMenu() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("\t Main Menu");
		System.out.println("1. Retrieve List of Files");
		System.out.println("2. Business Level Operations");
		System.out.println("3. Close Application");
		int mainoption=0;
		try {
			if (sc.hasNextInt()) {
			do {
			mainoption = sc.nextInt();
			switch(mainoption) {
				case 1:
					System.out.println("Here are the available files: ");
					fileList();
					break;
				case 2:
					BusinessMenu.businessMenu();
					break;
				case 3:
					System.out.println("Thank you for using LockedMe!");
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid input, please enter a valid option. Main default ");
				}
		}
			while(mainoption!=3);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid input"+e); //, please enter a valid option from Main Menu. ");

		}
		
	}
	

	public static void fileList() {
		// TODO Auto-generated method stub
		File maindir = new File("C:\\Users\\amit_\\eclipse-workspace\\LockedMe\\UserFiles\\");
		File[] userfiles = maindir.listFiles();
		List<String> showfiles = new ArrayList<String>();
		Collections.sort(showfiles);
	    for(File file : userfiles) {
			if(file.isFile()) {
				showfiles.add(file.getName());
	                }
        }
		showfiles.forEach(System.out::println);

	}

}

	


