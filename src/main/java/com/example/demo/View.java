package com.example.demo;

import java.io.File;
import java.io.PrintWriter;
/**
 * <h2>View</h2>
 * This class handles all view related methods
 * @author ianmhenriquez
 *
 */
public class View {
	/**
	 * This method creates the view file for the student 
	 * @param obj this is the student who needs the file
	 */
	public void createViewFile(Student obj) {
		File borrowedList = new File(obj.getStud_Name()+"BorrowedList.txt");
		Library_Item[] item = obj.getBorrowedItems();
		 try(PrintWriter pwBl = new PrintWriter(borrowedList)){
			 pwBl.flush();
	        	for (int i = 0; i < item.length; i++) {
	        		pwBl.write(item[i].getLibitem_author() + "," + item[i].getLibitem_cat() + "," + item[i].getLibitem_date()+ "," + item[i].getLibitem_ID() + "," + item[i].getLibitem_name() + "\n");
	        	}
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	}
}
