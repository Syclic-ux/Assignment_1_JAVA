package com.example.demo;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	static public Librarian[] lib_arr = new Librarian[10];
	static public int lib_count = 0;

	static public Student[] stud_arr = new Student[10];
	static public int stud_count = 0;

	 static void createFiles(){
	        DataCreate dc = new DataCreate();
			//Creating Librarian File
	        Librarian[] lib_arr = dc.createLibData();
	        File inp_file = new File("librarian.txt");

	        try(PrintWriter pwr = new PrintWriter(inp_file)){
	            pwr.flush();
	            for (int i = 0; i < lib_arr.length; i++) {
	                pwr.write(lib_arr[i].getLib_id() + "," + lib_arr[i].getLib_name() + "," + lib_arr[i].getLib_userName() + "," + lib_arr[i].getLib_password() + "\n");
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
			// Creating Student File
	        Student[] stud_arr = dc.createStudData();
	        File stud_file = new File("Student.txt");
	        
	        try(PrintWriter pwSt = new PrintWriter(stud_file)){
	        	pwSt.flush();
	        	for (int i = 0; i < stud_arr.length; i++) {
	        		pwSt.write(stud_arr[i].getStud_id() + "," + stud_arr[i].getStud_Name() + "," + stud_arr[i].getStud_UserName() + "," + stud_arr[i].getStud_Password() + "," + stud_arr[i].getStud_type() + "\n");
	        	}
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }

		 Library_Item[] libitem_arr = dc.createLibItemData();
		 File libitem_file = new File("libraryItem.txt");

		 try(PrintWriter pwr = new PrintWriter(libitem_file)){
			 pwr.flush();
			 for (int i = 0; i < libitem_arr.length; i++) {
				 pwr.write(libitem_arr[i].getLibitem_cat() + "," + libitem_arr[i].getLibitem_ID() + "," +
						 libitem_arr[i].getLibitem_name() + "," + libitem_arr[i].getLibitem_author() + "," + libitem_arr[i].getLibitem_date()
						 + "," + libitem_arr[i].getLibitem_qnt()  + "\n");
			 }
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }

	    }
	 
	 static void readStudent(String fileName) throws IOException {
		 	DataCreate dc = new DataCreate();

			Student[] temp = dc.createStudData();

	        File readFile = new File(fileName);
	        String[] str_arr = new String[10];
	        FileReader fr = new FileReader(readFile);
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        while((line = br.readLine()) != null){
	            str_arr[stud_count] = line;
	            stud_count++;
	        }

	        String str = str_arr[0];
	        String[] token = str.split(",");
	        for(String split_str: token){
	            System.out.println(split_str + ", ");
	        }
			for(int i = 0; i < stud_count; ++i){
				stud_arr[i] = new Student();
				stud_arr[i].setData(str_arr[i]);
				stud_arr[i].setBorrowedItems(temp[i].getBorrowedItems());
			}


	    }

	static void readLibrarian() throws IOException {
		System.out.println("Function to read Librarian data");
		File readFile = new File("librarian.txt");
		String[] str_arr = new String[10];
		FileReader fr = new FileReader(readFile);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
			str_arr[lib_count] = line;
			lib_count++;
		}

		String str = str_arr[0];
		String[] token = str.split(",");
		for(String split_str: token){
			System.out.println(split_str + ", ");
		}
		for(int i = 0; i < lib_count; ++i){
			lib_arr[i] = new Librarian();
			lib_arr[i].setData(str_arr[i]);
		}

	}
	
	public static void main(String[] args) throws IOException {
		createFiles();
		readStudent("Student.txt");
		readLibrarian();
		GUI.launchApplication(args);
	}
}
