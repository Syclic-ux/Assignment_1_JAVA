package com.example.demo;

//import jdk.jfr.Category;

import java.io.*;

import static com.example.demo.Main.stud_arr;
import static com.example.demo.Main.stud_count;


//import java.util.*;


/**
 * <h2>Librarian</h2>
 * This class contains all the Librarian information
 * @author Suhail Sameer
 *
 */
@SuppressWarnings("serial")
public class Librarian implements Serializable{

    //Librarian Name
    private String lib_name;
    //Librarian ID
    private int lib_id;
    //Librarian UserName
    private String lib_userName;
    //Librarian PassWord
    private String lib_password;
    //Array to store LibItems
    static public Library_Item[] libitem_arr = new Library_Item[10];
    //Variable to keep track of number of Library Items
    static private int count;

    /**
     * Constructor for Librarian
     */
    public Librarian() {
        this.lib_name = "";
        this.lib_id = 0;
        this.lib_userName = "";
        this.lib_password = "";
        //this.libitem_arr = null;
        this.count = 0;
    }

    /**
     *Method which sets the data in the Librarian Object
     * @param data String which contains information to be parsed
     */
    public void setData(String data){
        String[] token = data.split(",");
        try{
            this.lib_id = Integer.parseInt(token[0]);
            this.lib_name = token[1];
            this.lib_userName = token[2];
            this.lib_password = token[3];
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Method which returns the no of items in the Library
     * @return count which is an integer
     */
    public int getCount(){return count;}

    /**
     * Method which issues a library item to the student
     * @param strid String which contains the ID of the student
     */
    public void issueItem(String strid){

        Student stud = new Student();
        int id = Integer.parseInt(strid);
        for(int i = 0; i < stud_count; ++i){
            if(stud_arr[i].getStud_id() == id){
                stud = stud_arr[i];
                break;
            }
        }
        if(stud.getBorrowedItems() == null){
            Library_Item[] new_arr = {stud.getToBeBorrowedItem()};
            stud.setBorrowedItems(new_arr);
            stud.setToBeBorrowedItem(null);
        }
        else {
            Library_Item issue = stud.getToBeBorrowedItem();
            Library_Item[] stud_borrow_arr = stud.getBorrowedItems();
            Library_Item[] lib_arr = new Library_Item[stud_borrow_arr.length + 1];
            for (int j = 0; j < stud.getBorrowedItems().length; ++j) {
                lib_arr[j] = stud_borrow_arr[j];
            }


            lib_arr[stud_borrow_arr.length] = issue;

            stud.setBorrowedItems(lib_arr);
            stud.setToBeBorrowedItem(null);
        }
    }

    /**
     * Method used to remove a library item from a student
     * @param strid String which contains the ID of the student
     * @return String, Returns the result whether an item has been added or not
     */
    public String returnItem(String strid){
        String retVal = "";
        Student stud = new Student();
        int id = Integer.parseInt(strid);
        for(int i = 0; i < stud_count; ++i){
            if(stud_arr[i].getStud_id() == id){
                stud = stud_arr[i];
                break;
            }
        }
        Library_Item[] temp_arr = stud.getBorrowedItems();
        if(temp_arr == null || temp_arr.length < 0){
            retVal = null;
        }
        else{
            if((temp_arr.length - 1 == 0)){
                stud.setBorrowedItems(null);
                retVal = "All Items has been removed from borrowed list";
            }
            Library_Item[] new_arr = new Library_Item[temp_arr.length - 1];
            for (int i = 0, k = 0; i < new_arr.length; i++) {

                // if the index is
                // the removal element index
                if (i == 0) {
                    continue;
                }

                // if the index is not
                // the removal element index
                new_arr[k++] = temp_arr[i];
            }
            retVal = "Item " + temp_arr[0].getLibitem_name() + " has been removed";
            stud.setBorrowedItems(temp_arr);
        }


        return retVal;
    }

    /**
     * Method which initializes the data in the libitem_arr static array by reading from file
     * @throws IOException Since FileReader throes IOException
     */
    public void getLibItem() throws IOException {
        //System.out.println("Function to read Librarian data");
        File readFile = new File("libraryItem.txt");
        //String[] str_arr = new String[10];
        FileReader fr = new FileReader(readFile);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            //libitem_arr[count] = line;
            libitem_arr[count] = new Library_Item();
            libitem_arr[count].setData(line);
            count++;
        }
    }

    /**
     * Getter which returns Name of librarian
     * @return String containing lib_name
     */
    public String getLib_name() {
        return lib_name;
    }

    /**
     * Setter which sets Name of Librarian
     * @param lib_name String containing name of Librarian
     */
    public void setLib_name(String lib_name) {
        this.lib_name = lib_name;
    }

    /**
     * Getter which returns ID of Librarian
     * @return integer which contains lib_id
     */
    public int getLib_id() {
        return lib_id;
    }

    /**
     * Setter which sets ID of Librarian
     * @param lib_id Integer containing ID of Librarian
     */
    public void setLib_id(int lib_id) {
        this.lib_id = lib_id;
    }

    /**
     * Getter which returns UserName of Librarian
     * @return String which contains lib_userName
     */
    public String getLib_userName() {
        return lib_userName;
    }

    /**
     * Setter which sets userName of Librarian
     * @param lib_userName String containing userName of Librarian
     */
    public void setLib_userName(String lib_userName) {
        this.lib_userName = lib_userName;
    }

    /**
     * Getter which returns PassWord of Librarian
     * @return String which contains lib_password
     */
    public String getLib_password() {
        return lib_password;
    }

    /**
     * Setter which sets PassWord of Librarian
     * @param lib_password String containing password of Librarian
     */
    public void setLib_password(String lib_password) {
        this.lib_password = lib_password;
    }

    public void displayItem() throws IOException{
        //System.out.println(String.format("%-10s%-4s%-15s%-10s%-10s%-8s","Category","ID","Name","Author","Issue","Quantity"));
        //this.getLibItem();
        for(int i = 0; i < count; ++i){
            //Library_Item temp = new Library_Item();
            //temp.displayItem();
            libitem_arr[i].displayItem();
        }

    }

    /**
     * Method which checks if the date is entered in the right format
     * @param str_date String containing the date to be validated
     * @return boolean value where true if correct or false if incorrect
     */
    private boolean validateDate(String str_date){

        return str_date.matches("(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}");
    }

    /**
     * Method to add the new Library Item into the array and append it to the Text File
     * @param input String containing information about the item to be parsed
     * @exception IOException Using FileWriter requires IOException to be thrown
     */
    private void addToFile(String input){
        libitem_arr[count] = new Library_Item();
        libitem_arr[count].setData(input);
        try
        {
            String filename= "libraryItem.txt";
            FileWriter fw = new FileWriter(filename,true);
            fw.write(input + "\n");
            fw.close();
            count++;
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    /**
     * Method used to validate if the information entered by the user is correct or diplay an error message if not
     * @param cat String which contains "category" of item (book,magazine,video)
     * @param name String which contains the "Name" of the item
     * @param author String which contains the "Author" of the item
     * @param date String which contains the "data of publication" of the item
     * @param quantity String which contains the "Quantity" of the Item
     * @return A String with null if no errors, or a message with the type of error encountered
     */
    public String addItem(String cat, String name, String author, String date, String quantity){
        String retVal = null;
        if(count >= 10){
            retVal = "The Library is Full!";
        }
        else{
            if(cat.equals("book") || cat.equals("video") || cat.equals("magazine")){
                if(validateDate(date)){
                    try {
                        int qnt = Integer.parseInt(quantity);
                        String str_cat = "";
                        if(cat.equals("book")) str_cat = "b";
                        else if(cat.equals("video")) str_cat = "v";
                        else if(cat.equals("magazine")) str_cat = "m";
                        String input = str_cat + "," + (count + 1) + "," + name + "," + author + "," + date + "," + quantity;
                        addToFile(input);
                    }
                    catch(NumberFormatException e){
                        File log_file = new File("logger.txt");
                            try (PrintWriter pwr = new PrintWriter(log_file)){
                                retVal = "Qunatity inputted is not an integer";
                                String err = e.getMessage();

                                pwr.flush();
                                pwr.write(err);

                                System.out.println("The error is " + err);
                                e.printStackTrace();
                            }
                            catch (IOException ex){
                                ex.printStackTrace();
                            }
                    }
                    //System.out.println("The Information is: \n" + cat + ", " + name + ", " + author + ", " + date + ", " + quantity);

                }
                else{
                    retVal = "Invalid Date Format";
                }
            }
            else {
                retVal = "Invalid Category";
            }

        }
        System.out.println("The Return value is " + retVal);
        return retVal;
    }
}
