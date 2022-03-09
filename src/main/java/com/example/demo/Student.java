package com.example.demo;

import java.io.Serializable;
/**
 * <h2>Student</h2>
 * This class contains all the student information
 * @author ianmhenriquez
 *
 */
@SuppressWarnings("serial")
public class Student  implements Serializable{
	private String stud_Name;
	private int stud_id;
	private String stud_UserName;
	private String stud_Password;
	private char stud_type;
	private int TicketNum;

	private Library_Item toBeBorrowedItem = null;

	private Library_Item[] borrowedItems;
	/**
	 * This is the constructor
	 */
	public Student() {
		super();
		this.stud_Name = "";
		this.stud_id = 0;
		this.stud_UserName = "";
		this.stud_Password = "";
		this.stud_type = ' ';
		this.TicketNum = 0;
	}
	/**
	 * This method return the BorrowedItem class variable
	 * @return BorrowedItems class variable
	 */
	/**
	 * Method to set data in the object
	 * @param theString contains the information to be parsed
	 */
	public void setData(String theString){
		String[] token = theString.split(",");
		try{
			this.stud_id = Integer.parseInt(token[0]);
			this.stud_Name = token[1];
			this.stud_UserName = token[2];
			this.stud_Password = token[3];
			this.stud_type = token[4].charAt(0);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public  Library_Item[] getBorrowedItems() {
		return borrowedItems;
	}
	
	/**
	 * This method return the TicketNum class variable
	 * @return TicketNum class variable
	 */
	public int getTicketNum() {
		return TicketNum;
	}

	/**
	 * This method sets the ticketNum class variable
	 * @param ticketNum what the class variable will be set to
	 */
	public void setTicketNum(int ticketNum) {
		TicketNum = ticketNum;
	}

	/**
	 * This method sets the borrowedItems class variable
	 * @param borrowedItems what the class variable will be set to
	 */
	public void setBorrowedItems(Library_Item[] borrowedItems) {
		this.borrowedItems = borrowedItems;
	}

	/**
	 * This method sets the toBeBorrowed class variable
	 * @param item The item, the student wants to borrow
	 * @return boolean if the student has already borrowed a item
	 */
	public boolean setToBeBorrowedItem(Library_Item item){
		boolean retVal = true;
		if(toBeBorrowedItem == null){
			retVal = true;
			toBeBorrowedItem = new Library_Item();
			toBeBorrowedItem = item;
		}
		else{
			retVal = false;
		}
		return retVal;
	}

	/**
	 * This method returns toBeBorrowed item
	 * @return the string containing the item to be borrowed
	 */
	public String displayToBeBorrowedItem(){
		return toBeBorrowedItem.displayItem();
	}
	/**
	 * This method returns toBeBorrowed item
	 * @return the string containing the item to be borrowed
	 */
	public Library_Item getToBeBorrowedItem(){
		return toBeBorrowedItem;
	}
	/**
	 * This method return the stud_Name class variable
	 * @return stud_Name class variable
	 */
	public String getStud_Name() {
		return stud_Name;
	}

	/**
	 * This method sets the stud_Name class variable
	 * @param stud_Name what the class variable will be set to
	 */
	public void setStud_Name(String stud_Name) {
		this.stud_Name = stud_Name;
	}

	/**
	 * This method return the stud_id class variable
	 * @return stud_id class variable
	 */
	public int getStud_id() {
		return stud_id;
	}

	/**
	 * This method sets the stud_id class variable
	 * @param stud_id what the class variable will be set to
	 */
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	/**
	 *This method return the stud_UserName class variable
	 * @return stud_UserName class variable
	 */
	public String getStud_UserName() {
		return stud_UserName;
	}

	/**
	 * This method sets the stud_UserName class variable
	 * @param stud_UserName what the class variable will be set to
	 */
	public void setStud_UserName(String stud_UserName) {
		this.stud_UserName = stud_UserName;
	}

	/**
	 * This method return the stud_Password class variable
	 * @return stud_Password class variable
	 */
	public String getStud_Password() {
		return stud_Password;
	}

	/**
	 * This method sets the stud_Password class variable
	 * @param stud_Password what the class variable will be set to
	 */
	public void setStud_Password(String stud_Password) {
		this.stud_Password = stud_Password;
	}

	/**
	 * This method return the stud_type class variable
	 * @return stud_type class variable
	 */
	public char getStud_type() {
		return stud_type;
	}

	/**
	 * This method sets the stud_type class variable
	 * @param stud_type what the class variable will be set to
	 */
	public void setStud_type(char stud_type) {
		this.stud_type = stud_type;
	}
	
	
	
	
}
