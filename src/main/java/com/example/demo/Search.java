package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import static com.example.demo.Main.stud_arr;
import static com.example.demo.Main.stud_count;


/**
 * <h2>Search</h2>
 * This class handles all search related methods
 * @author ianmhenriquez, Suhail Sameer
 *
 */
public class Search{
    /**
	 * @author ianmhenriquez
     * This methods searches through lib_items till it find a match for the students request
     * @param source this is the student input
     * @return Lib_item this is the lib_item that the student searched for
     */
    public Library_Item find(String source) {
    	DataCreate data = new DataCreate();
    	Library_Item[] items = data.createLibItemData();
		Librarian lib = new Librarian();

    	Library_Item item_obj = new Library_Item();
    	for(int i = 0; i < items.length; i++ ) {
    		if(Objects.equals(items[i].getLibitem_name(), source)) {
    			item_obj = items[i];
    			break;
    		}
    		else {
    			item_obj = null;
    		}
    	}
    	
    	return item_obj;
    }

	/**
	 * @author Suhail Sameer
	 * Method to find the student based on the ID sent by the User
	 * @param source String containing the ID of the student
	 * @return An object of type Student is returned which has the same ID as "source"
	 * @throws IOException
	 */
	public static Student findStudent(String source)throws IOException {
		Student retVal = null;
		try {

			int id = Integer.parseInt(source);
			for(int i = 0; i < stud_count; ++i){
				if(stud_arr[i].getStud_id() == id){
					retVal = new Student();
					retVal = stud_arr[i];
				}
			}
		}
		catch(NumberFormatException e){
			try {
				String filename = "logger.txt";
				FileWriter fw = new FileWriter(filename);
				fw.write(e.getMessage());
				e.printStackTrace();
			}
			catch (IOException ex){
				ex.printStackTrace();
			}
		}
		return retVal;
	}
   
}