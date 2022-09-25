package com.addressbook.controller;
import java.awt.Choice;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterators.AbstractDoubleSpliterator;
import java.util.jar.Attributes.Name;

class Contacts{
	String firstName, lastName, address, city, state, eMail;
	long zip, phoneNumber;
	Scanner sc = new Scanner(System.in);
	public void addContact() {
		System.out.println("Enter First name");
		firstName = sc.next();
		System.out.println("Enter Last name");
		lastName = sc.next();
		System.out.println("Enter Address");
		address = sc.next();
		System.out.println("Enter City");
		city = sc.next();
		System.out.println("Enter State");
		state = sc.next();
		System.out.println("Enter Email");
		eMail = sc.next();
		System.out.println("Enter Zip code");
		zip = sc.nextLong();
		System.out.println("Enter Phone number");
		phoneNumber = sc.nextLong();
	}
	@Override
	public String toString() {
		return " firstName=" + firstName + ",\n lastName=" + lastName + ",\n address=" + address + ",\n city=" + city
				+ ", \n state=" + state + ",\n eMail=" + eMail + ", \n zip=" + zip + ",\n phoneNumber=" + phoneNumber + ",]";
	}
	}
public class AdressBookController {
	
	ArrayList<Contacts> list = new ArrayList<Contacts>(); 
	static Scanner sc = new Scanner(System.in);
	static int count;
	
	public static void main(String[] args) {
		AdressBookController add  = new AdressBookController(); 
	
		int options = 1;

		do {
			System.out.println("Menu: \n 1. Add \n 2. Show \n 3. Edit \n 4. Delete \n 5. Exit " );
			System.out.println("Enter the choice from menu");
			options = sc.nextInt();
		switch(options) {
		case 1:
			Contacts cn = new Contacts();
			cn.addContact();
			add.list.add(cn);
			System.out.println("Contact added");
			break;
		case 2:
			add.contactShow();
			break;
		case 3:
			add.contactEdit();
			break;
		case 4:
			add.deleteContact();
			break;
		case 5:
			System.out.println("Byee!!");
			break;
		default:
			System.out.println("Choose from menu");
		}
		}while(options != 5);
		
//		System.out.println(add.contacts[0]);
		}
	void contactShow() {
		for (int count = 0; count < list.size(); count++) {
			if(list.get(count) != null) 
		System.out.println(list.get(count).toString()+"\n");
	}
	}
	
	public int getIndex(String name) {
		for ( int i = 0; i < list.size(); i++) {
			if(list.get(i) != null && list.get(i).firstName.equals(name)) {
			return i;
			}
		}
		return -1;
	}
	
	public void contactEdit() {
		int choice = 0;
		
		if(list.get(0) == null) {
			System.out.println("Contact list is empty, first add any contact");
			return;
		}
		for ( int i = 0; i < list.size(); i++) {
			if(list.get(i) != null) {
			System.out.print(list.get(i).firstName+ ", ");
			}
			}
			System.out.println();
			System.out.println("\n Enter the name you want to edit");
			String name1 = sc.next();
			System.out.println(name1);
			
			int index = getIndex(name1);
			
			if(index == -1) {
				System.out.println("The entered name not found");
				return;
			}
			
		do {
			
			System.out.println("What you would like to edit");
			System.out.println("1. First Name \n2. Last Name \n3. Address \n4. City \n5. State \n6. Email \n7. Zip \n8. Phone Number \n9. Exit");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter the updated First name");
				String updatedFirstName = sc.next();
				list.get(index).firstName = updatedFirstName;
				break;
			case 2:
				System.out.println("Enter the updated Last name");
				String updatedLastName = sc.next();
				list.get(index).lastName = updatedLastName;
				break; 
			case 3:
				System.out.println("Enter the updated Address");
				String updatedAddress = sc.next();
				list.get(index).address = updatedAddress;
				break;
			case 4:
				System.out.println("Enter the updated City");
				String updatedCity = sc.next();
				list.get(index).city = updatedCity;
				break;
			case 5:
				System.out.println("Enter the updated State");
				String updatedState = sc.next();
				list.get(index).state = updatedState;
				break;
			case 6:
				System.out.println("Enter the updated Email");
				String updatedEmail = sc.next();
				list.get(index).eMail = updatedEmail;
				break;
			case 7: 
				System.out.println("Enter the updated Zip");
				Long updatedZip = sc.nextLong();
				list.get(index).zip = updatedZip;
				break;
			case 8:
				System.out.println("Enter the updated Phone Number");
				Long updatedPhoneNumber = sc.nextLong();
				list.get(index).phoneNumber = updatedPhoneNumber;
				break;
			case 9:
				System.out.println("Byee");
				break;
			}
			} while (choice != 9);
	}
	

	public void deleteContact() { 
		
		if(list.get(0) == null) {
			System.out.println("Contact list is empty, first add any contact");
			return;
		}
		for (int i = 0; i <list.size(); i++) {
//			if(list.get(i) != null) {
			System.out.print(list.get(i).firstName+ ", ");
//			}
			}
			System.out.println();
			System.out.println("\n Enter the name you want to delete");
			
			String name1 = sc.next();
			System.out.println(name1);
			
			int index = getIndex(name1);
			
			if(index == -1) {
				System.out.println("The entered name is not found");
				return;
			}
			
		int choice = 0;
		do {
			
			System.out.println("What you would like to delete");
			System.out.println("1. First Name \n2. Last Name \n3. Address \n4. City \n5. State \n6. Email \n7. Zip \n8. Phone Number \n9. Exit");
			choice = sc.nextInt();
			
			Contacts temp = list.get(index);
					
			switch (choice) {
			case 1:
				temp.firstName = "";
				list.set(index, temp);
				break;
			case 2:
				temp.lastName = "";
				list.set(index, temp);
				break; 
			case 3:
				temp.address = "";
				list.set(index, temp);
				break;
			case 4:
				temp.city = "";
				list.set(index, temp);
				break;
			case 5:
				temp.state = "";
				list.set(index, temp);
				break;
			case 6:
				temp.eMail = "";
				list.set(index, temp);
				break;
			case 7: 
				temp.zip = 0;
				list.set(index, temp);
				break;
			case 8:
				temp.phoneNumber = 0;
				list.set(index, temp);
				break;
			case 9:
				System.out.println("Byee");
				break;
			}
			} while (choice != 9);
	}
}
