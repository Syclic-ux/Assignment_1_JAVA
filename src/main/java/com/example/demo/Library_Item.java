package com.example.demo;


/**
 * <h2>Library Item</h2>
 * This class contains all the Librarian information
 * @author ianmhenriquez, Suhail Sameer
 *
 */
public class Library_Item {

    //Category of item
    private char libitem_cat;
    //Name of Library Item
    private String libitem_name;
    //ID of Library Item
    private int libitem_ID;
    //Release Date
    private String libitem_date;
    //Author of item
    private String libitem_author;
    //Quantity of item
    private int libitem_qnt;



    public Library_Item() {
        this.libitem_cat = '0';
        this.libitem_name = "";
        this.libitem_ID = 0;
        this.libitem_date = "";
        this.libitem_author = "";
        this.libitem_qnt = 0;
        
    }


	/**
	 * Getter which returns libitem_cat
	 * @return char
	 */
	public char getLibitem_cat() {
		return libitem_cat;
	}

	/**
	 * Setter which sets libitem_cat
	 * @param libitem_cat
	 */
	public void setLibitem_cat(char libitem_cat) {
		this.libitem_cat = libitem_cat;
	}

	/**
	 * Getter which returns libitem_name
	 * @return String
	 */
	public String getLibitem_name() {
		return libitem_name;
	}

	/**
	 * Getter which returns libitem_cat
	 * @param libitem_name
	 */
	public void setLibitem_name(String libitem_name) {
		this.libitem_name = libitem_name;
	}

	/**
	 * Getter which returns libitem_id
	 * @return Integer
	 */
	public int getLibitem_ID() {
		return libitem_ID;
	}

	/**
	 * Setter which sets libitem_id
	 * @param libitem_ID Integer
	 */
	public void setLibitem_ID(int libitem_ID) {
		this.libitem_ID = libitem_ID;
	}

	/**
	 * Getter which returns libitem_date
	 * @return String
	 */
	public String getLibitem_date() {
		return libitem_date;
	}

	/**
	 * Setter which sets libitem_date
	 * @param libitem_date String
	 */
	public void setLibitem_date(String libitem_date) {
		this.libitem_date = libitem_date;
	}

	/**
	 * Getter which returns libitem_author
	 * @return String
	 */
	public String getLibitem_author() {
		return libitem_author;
	}

	/**
	 * Setter which sets libitem_author
	 * @param libitem_author String
	 */
	public void setLibitem_author(String libitem_author) {
		this.libitem_author = libitem_author;
	}

	/**
	 * Getter which returns libitem_qnt
	 * @return Integer
	 */
	public int getLibitem_qnt() {
		return libitem_qnt;
	}

	/**
	 * Setter which returns libitem_qnt
	 * @param libitem_qnt Integer
	 */
	public void setLibitem_qnt(int libitem_qnt) {
		this.libitem_qnt = libitem_qnt;
	}

	/**
	 * Method used to set data in the Object
	 * @param temp A String which contains the information to be parsed
	 */
	public void setData(String temp){
		String[] token = temp.split(",");
		try {
			this.libitem_cat = token[0].charAt(0);
			this.libitem_ID = Integer.parseInt(token[1]);
			this.libitem_name = token[2];
			this.libitem_author = token[3];
			this.libitem_date = token[4];
			this.libitem_qnt = Integer.parseInt(token[5]);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 *Method to return the string with display information
	 * @return
	 */
	public String displayItem(){

		String temp_cat = "";

		if(libitem_cat == 'b') temp_cat = "Book";
		else if(libitem_cat == 'v') temp_cat = "Video";
		else if(libitem_cat == 'm') temp_cat = "Magazine";

		String retVal = String.format("%-10s%-4d%-15s%-20s%-15s%8d%n",temp_cat,libitem_ID,libitem_name,libitem_author,libitem_date,libitem_qnt);

		System.out.printf("%-10s%-4d%-15s%-20s%-15s%8d%n",temp_cat,libitem_ID,libitem_name,libitem_author,libitem_date,libitem_qnt);

		return retVal;
	}


}
