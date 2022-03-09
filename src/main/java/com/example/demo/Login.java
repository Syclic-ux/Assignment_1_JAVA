package com.example.demo;

import java.util.Objects;

import static com.example.demo.Main.*;


/**
 * <h2> Login management</h2>
 * This class contains all methods that handle login management
 * @author ianmhenriquez, Suhail Sameer
 *
 */
public class Login {

	/**
	 * Method used to Login for Librarians
	 * @param userName String containing the inputted UserName
	 * @param password String containing the inputted PassWord
	 * @return An object of type librarian which either contains null or an element from lib_arr
	 */
    public Librarian LoginLibrarian(String userName, String password){
        Librarian lib_obj = new Librarian();
		for(int i = 0; i < lib_count; ++i){
			if(userName.equals(lib_arr[i].getLib_userName()) && password.equals(lib_arr[i].getLib_password())){
				lib_obj = lib_arr[i];
				break;
			}
			else {
				lib_obj = null;
			}
		}
		return lib_obj;

    }
    /**
     * This method handles student login
	 * @author iamhenriquez
     * @param userName this is the user name that is typed in by the student
     * @param password this is the password that is typed in by the student
     * @return Student, this is a student object that is associated with a userName and password
     */
    public Student LoginStudent(String userName, String password){
    	Student student = new Student();
    	for(int i = 0; i < stud_arr.length; i++) {
    		if(userName.equals(stud_arr[i].getStud_UserName()) && password.equals(stud_arr[i].getStud_Password())) {
    			student = stud_arr[i];
    			break;
    		}
    		else{
    			student = null;
    		}
    	}
    	
    	return student;
    }
    

    public void LoginAdmin(String userName, String password){

    }

}
