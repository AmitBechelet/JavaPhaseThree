package com.lockedme;

import java.util.Scanner;

public class MainMenu implements FileApp {

	public MainMenu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fileDir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fileList() {
		// TODO Auto-generated method stub

	}

	
	public static void main(String[] args) {
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
//					fileList();
					break;
				case 2:
					//Business level ops menu
					System.out.println("This functionality will be implemented soon.");
					break;
				case 3:
					System.out.println("Thank you for using LockedMe.com");
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
			System.out.println("Invalid input"); //, please enter a valid option from Main Menu. ");

		}
	}

	@Override
	public void addFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mainMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void businessMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void businessMenu(int busoption) {
		// TODO Auto-generated method stub
		
	}

	}


