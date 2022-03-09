package com.example.demo;
/**
 * <h2> Data Creation</h2>
 * this class creates all the data needed for the program
 * @author ianmhenriquez
 *
 */

public class DataCreate {
    Librarian[] createLibData() {
        Librarian lib1 = new Librarian();
        lib1.setLib_id(1);
        lib1.setLib_name("Maxa");
        lib1.setLib_password("123");
        lib1.setLib_userName("abc");

        Librarian lib2 = new Librarian();
        lib2.setLib_id(2);
        lib2.setLib_name("Vas");
        lib2.setLib_password("456");
        lib2.setLib_userName("xyz");

        Librarian[] lib_arr = {lib1, lib2};
        return lib_arr;
    }
	
	/**
	 * This method creates all the data needed for student class
	 * @return an student array object
	 */
    Student[] createStudData() {
    	Library_Item[] items = createLibItemData();
    	Student stud1 = new Student();
    	stud1.setStud_id(1);
    	stud1.setStud_Name("James may");
    	stud1.setStud_Password("789");
    	stud1.setStud_UserName("Jmay");
    	stud1.setStud_type('u');
    	Library_Item[] testItems = addTestItems(items[0], items[2]);
    	stud1.setBorrowedItems(testItems);
    	
    	Student stud2 = new Student();
    	stud2.setStud_id(2);
    	stud2.setStud_Name("Bruce wayne");
    	stud2.setStud_Password("batman");
    	stud2.setStud_UserName("asd");
    	stud2.setStud_type('g');
    	Library_Item[] testItems2 = addTestItems(items[1], items[3]);
    	stud2.setBorrowedItems(testItems2);
    	
    	Student[] stud_arr = {stud1, stud2};
    	return stud_arr;
    }
    /**
     * This method creates all the data needed for the lib_item class
     * @return a lib_item array object
     */
    
    Library_Item[] createLibItemData() {
    	Library_Item item1 = new Library_Item();
		item1.setLibitem_cat('b');
    	item1.setLibitem_author("Bill Bob");
    	item1.setLibitem_date("01/12/2004");
    	item1.setLibitem_ID(1);
    	item1.setLibitem_name("A book");
    	item1.setLibitem_qnt(10);
    	//item1.setLibitem_quePosition(0);
    	
    	Library_Item item2 = new Library_Item();
		item2.setLibitem_cat('v');
    	item2.setLibitem_author("Jimmy Jones");
    	item2.setLibitem_date("03/25/1986");
    	item2.setLibitem_ID(2);
    	item2.setLibitem_name("How to spoon");
    	item2.setLibitem_qnt(5);
    	//item2.setLibitem_quePosition(0);
    	
    	Library_Item item3 = new Library_Item();
    	item3.setLibitem_author("John Jones");
    	item3.setLibitem_cat('m');
    	item3.setLibitem_date("12/22/2021");
    	item3.setLibitem_ID(3);
    	item3.setLibitem_name("Noir book");
    	item3.setLibitem_qnt(2);
    	//item3.setLibitem_quePosition(0);
    	
    	Library_Item item4 = new Library_Item();
    	item4.setLibitem_author("Dante");
    	item4.setLibitem_cat('b');
    	item4.setLibitem_date("03/25/1320");
    	item4.setLibitem_ID(4);
    	item4.setLibitem_name("Inferno");
    	item4.setLibitem_qnt(1);
    	//item4.setLibitem_quePosition(0);
    	
    	Library_Item[] item_arr = {item1, item2, item3, item4};
    	return item_arr;
    }
    
    /**
     * This method adds the data from lib_item into the student class
     * @param item1 adds one library item
     * @param item2 adds one library item
     * @return a lib_item array object
     */
    
    Library_Item[] addTestItems(Library_Item item1, Library_Item item2) {
    	Library_Item[] testData = {item1, item2};
    	return testData;
    }

}
