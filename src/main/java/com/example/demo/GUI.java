package com.example.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static com.example.demo.Main.stud_arr;


/**
 * <h2> GUI control</h2>
 * This class controls all the G.U.I related methods
 * @author ianmhenriquez, Suhail Sameer
 *
 */

public class GUI extends Application {
	public Stage stage;
	
	private Scene mainScene;
	private Scene studentLogin;
	private Scene librarianLogin;
	private Scene adminLogin;

	private Scene librarianMainScene;
	private Scene librarianAddItem;
	private Scene librarianViewAll;
	private Scene librarianIssue;
	private Scene librarianReturn;

	private Scene studentMainScene;
	private Scene studentSearchScene;
	private Scene studentViewScene;
	
	private Student student_obj;
	private Librarian lib_obj;
	/**
	 * This method starts the stage for the GUI
	 */
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			stage.setTitle("Student Home");
			
			mainScene = createMainScene();
			
			studentLogin = createStudentLogin();
			librarianLogin = createLibrarianLogin();


			studentSearchScene = createSearchScene();
			studentViewScene = createViewScene();
			stage.setScene(mainScene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author iamhenriquez
	 * This methods allows the GUI to be launched in the main.java
	 * @param args
	 */
	public static void launchApplication(String... args)
	{
	    launch(args);
	}
	
	/**
	 * @author iamhenriquez
	 * This method switches the GUI scene 
	 * @param scene this is the scene that the GUI will be switched to
	 */
	public void switchScenes(Scene scene) {
		stage.setScene(scene);
	}
	
	/**
	 * @author iamhenriquez
	 * This method creates the main scene for the GUI
	 * @return Scene, this returns a Scene object
	 */
	public Scene createMainScene() {
		Button student = new Button("Student Login");
		student.setMaxSize(300, 100);
		student.setOnAction(e -> switchScenes(studentLogin));
		
		Button librarian = new Button("Librarian Login");
		librarian.setMaxSize(300, 100);
		librarian.setOnAction(e -> switchScenes(librarianLogin));
		
		Button admin = new Button("Admin Login");
		admin.setMaxSize(300, 100);
		admin.setOnAction(e -> switchScenes(adminLogin));
		
		HBox mainHbox = new HBox(20);
		mainHbox.setAlignment(Pos.CENTER);
		mainHbox.getChildren().addAll(admin, librarian, student);
		
		mainScene = new Scene(mainHbox, 800, 400);
		return mainScene;
	}
	
	/**
	 * @author iamhenriquez
	 * This method creates the studentLogin scene 
	 * @return Scene, this returns a Scene object
	 */
	public Scene createStudentLogin() {
		Label user_id = new Label("UserName");
		Label passWord = new Label("Password");
		final Label error = new Label();
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		Button submit = new Button("Submit");
		Button back = new Button("Back");
		back.setOnAction(
				/**
				 * This event handler clears the input and switches the scene back to the previous scene
				 */
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						tf1.clear();
						tf2.clear();
						switchScenes(mainScene);
					}
				});
		submit.setOnAction(
				/**
				 * This eventHandler calls the studentLogin method and on successful login clears the screen and switches the scene 
				 */
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Student student = new Student();
						Login login = new Login();
						student = login.LoginStudent(tf1.getText(), tf2.getText());
						if(!Objects.isNull(student)) {
							student_obj = student;
							studentMainScene = createMainStudentScene();
							switchScenes(studentMainScene);
							tf1.clear();
							tf2.clear();
						}
						else {
							error.setText("UserName and or Password is incorrect");
							tf1.clear();
							tf2.clear();
						}
					}
				});
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.addRow(0, user_id, tf1);
		root.addRow(1, passWord, tf2);
		root.addRow(2, submit, back);
		root.addRow(3, error);
		studentLogin = new Scene(root, 800, 400);
		return studentLogin;
	}

	/**
	 * @author Suhail Sameer
	 * This method creates the librarianLogin scene
	 * @return Scene, this returns a Scene object
	 */
	public Scene createLibrarianLogin() {
		Label user_id = new Label("UserName");
		Label passWord = new Label("Password");
		final Label error = new Label();
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		Button submit = new Button("Submit");
		Button back = new Button("Back");
		back.setOnAction(
				/**
				 * This event handler clears the input and switches the scene back to the previous scene
				 */
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						tf1.clear();
						tf2.clear();
						switchScenes(mainScene);
					}
				});
		submit.setOnAction(
				/**
				 * This eventHandler calls the studentLogin method and on successful login clears the screen and switches the scene
				 */
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						//Student student = new Student();
						Librarian librarian = new Librarian();
						Login login = new Login();
						//librarian = login.LoginStudent(tf1.getText(), tf2.getText());
						librarian = login.LoginLibrarian(tf1.getText(),tf2.getText());
						if(!Objects.isNull(librarian)) {
							//lib_obj = new Librarian();
							lib_obj = librarian;
							try {
								librarianMainScene = createMainLibrarianScene();
							}
							catch (IOException e){
								e.printStackTrace();
							}
							switchScenes(librarianMainScene);
							tf1.clear();
							tf2.clear();
						}
						else {
							error.setText("UserName and or Password is incorrect");
							tf1.clear();
							tf2.clear();
						}
					}
				});

		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.addRow(0, user_id, tf1);
		root.addRow(1, passWord, tf2);
		root.addRow(2, submit, back);
		root.addRow(3, error);
		librarianLogin = new Scene(root, 800, 400);
		return librarianLogin;
	}

	/**
	 * @author iamhenriquez
	 * This method creates the mainStudent scene 
	 * @return Scene, this returns a Scene object
	 */
	public Scene createMainStudentScene() {
		GridPane pane = new GridPane();
			Label lbl1 = new Label();
			Label lbl2 = new Label();
			String studentType;
			if(student_obj.getStud_type() == 'a') {
				studentType = "alumni";
			}
			else if(student_obj.getStud_type() == 'c') {
				studentType = "current";
			}
			else if(student_obj.getStud_type() == 'u') {
				studentType = "undergrad";
			}
			else {
				studentType = "grad";
			}
			lbl1.setText(student_obj.getStud_Name());
			lbl2.setText(studentType);
			pane.setAlignment(Pos.CENTER);
			pane.addRow(0, lbl1);
			pane.addRow(1, lbl2);
		Button SrchBtn = new Button("Search");
		 
		 SrchBtn.setMaxSize(200, 100);
		 SrchBtn.setOnAction(e -> switchScenes(studentSearchScene));

		Button ViewBtn = new Button("View");
		 ViewBtn.setMaxSize(200, 100);
		 ViewBtn.setOnAction(e -> switchScenes(studentViewScene));
		 
		 Button back = new Button("Back");
		 back.setMaxSize(200, 100);
		 back.setOnAction(e -> switchScenes(mainScene));
		 
		VBox studentMainVboxBox = new VBox(20);
		 studentMainVboxBox.setAlignment(Pos.CENTER);
		 studentMainVboxBox.getChildren().addAll(pane,SrchBtn,ViewBtn, back);
		 
		 studentMainScene = new Scene(studentMainVboxBox, 800, 400);
		 
		 return studentMainScene;
	}

	/**
	 * @author Suhail Sameer
	 * This method creates the mainLibrarian scene
	 * @return Scene, this returns a Scene object
	 */
	public Scene createMainLibrarianScene() throws IOException {
		lib_obj.getLibItem();
		GridPane pane = new GridPane();
		Label lbl1 = new Label();
		lbl1.setText("Welcome " + lib_obj.getLib_name());
		pane.setAlignment(Pos.CENTER);
		pane.addRow(0, lbl1);

		librarianAddItem = createLibrarianAdd();
		Button SrchBtn = new Button("Add a New Book");
		SrchBtn.setMaxSize(200, 100);
		SrchBtn.setOnAction(e -> switchScenes(librarianAddItem));

		//librarianViewAll = createLibrarianView();
		Button ViewBtn = new Button("View All Books");
		ViewBtn.setMaxSize(200, 100);
		ViewBtn.setOnAction(
				actionEvent -> {
					librarianViewAll = createLibrarianView();
					switchScenes(librarianViewAll);
				}
		);

		Button issueBtn = new Button("Issue Book to Student");
		issueBtn.setMaxSize(200, 100);
		issueBtn.setOnAction(
				actionEvent -> {
					librarianIssue = createLibrarianIssue();
					switchScenes(librarianIssue);
				}
		);

		Button returnBtn = new Button("Return a Book");
		returnBtn.setMaxSize(200, 100);
		returnBtn.setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						librarianReturn = createLibrarianReturn();
						switchScenes(librarianReturn);
					}
				}
		);

		Button back = new Button("Back");
		back.setMaxSize(200, 100);
		back.setOnAction(e -> switchScenes(mainScene));

		VBox studentMainVboxBox = new VBox(20);
		studentMainVboxBox.setAlignment(Pos.CENTER);
		studentMainVboxBox.getChildren().addAll(pane,SrchBtn,ViewBtn,issueBtn,returnBtn,back);

		studentMainScene = new Scene(studentMainVboxBox, 800, 400);

		return studentMainScene;
	}

	/**
	 * @author Suhail Sameer
	 * This method create the LibrarianAdd Scene
	 * @return Scene, this returns a Scene object
	 */
	public Scene createLibrarianAdd(){
		Label item_cat = new Label("Category of Item (book,video,magazine):");
		Label item_name = new Label("Name of Item:");
		Label item_author = new Label("Name of Author:");
		Label item_issueDate = new Label("Date of Issue (MM/DD/YYYY):");
		Label item_qnt = new Label("Quantity of Item");

		final Label error = new Label();

		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		TextField tf5 = new TextField();

		Button submit = new Button("Submit");
		Button back = new Button("Back");

		back.setOnAction(
				/**
				 * This event handler clears the input and switches the scene back to the previous scene
				 */
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						tf1.clear();
						tf2.clear();
						tf3.clear();
						tf4.clear();
						tf5.clear();
						switchScenes(librarianMainScene);
					}
				});

		submit.setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						String result = lib_obj.addItem(tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(), tf5.getText());
						if(result == null){
							error.setText("Item has been successfully added");
						}
						else{
							error.setText(result);
						}
					}
				}
		);

		GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.addRow(0, item_cat, tf1);
			root.addRow(1, item_name, tf2);
			root.addRow(2, item_author, tf3);
			root.addRow(3, item_issueDate, tf4);
			root.addRow(4, item_qnt, tf5);
			root.addRow(5, submit, back);
			root.addRow(6, error);

		librarianAddItem = new Scene(root, 800, 400);
		return librarianAddItem;
	}

	/**
	 * @author Suhail Sameer
	 * This method create the LibrarianView Scene
	 * @return Scene, this returns a Scene object
	 */
	public Scene createLibrarianView(){
		//TableView table = new TableView();
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		Label viewText = new Label("All Items in Library");
		Button displayData = new Button("Display Data");
		pane.addRow(0,viewText,displayData);

		displayData.setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						displayData.setVisible(false);
						String hdr = String.format("%-10s%-4s%-20s%-15s%-10s%-8s","Category","ID","Name","Author","Issue","Quantity");
						String header = "Category	ID		Name	Author	Issue Date		Quantity";
						Label lblheader = new Label(hdr);

						lblheader.setPadding(new Insets(10));
						pane.addRow(1,lblheader);

						for(int i = 0; i < lib_obj.getCount(); ++i){
							Label label = new Label(lib_obj.libitem_arr[i].displayItem());
							pane.addRow(i+2,label);
						}
					}
				}
		);


		/*TableColumn CatColumn = new TableColumn("Category");
		TableColumn NameColumn = new TableColumn("Name");
		TableColumn AuthorColumn = new TableColumn("Author");
		TableColumn DateColumn = new TableColumn("Date");
		TableColumn QntColumn = new TableColumn("Quantity");*/

		//table.getColumns().addAll(CatColumn,NameColumn,AuthorColumn,DateColumn,QntColumn);

		//Label tableText = new Label("")

		Button back = new Button("Back");
		back.setMaxSize(200, 100);
		back.setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						pane.getChildren().clear();
						switchScenes(librarianMainScene);
					}
				}
		);

		VBox librarianViewVBox = new VBox(20);
		librarianViewVBox.setAlignment((Pos.CENTER));
		librarianViewVBox.getChildren().addAll(pane,back);

		librarianViewAll = new Scene(librarianViewVBox, 800, 400);

		return librarianViewAll;
	}

	/**
	 * @author Suhail Sameer
	 * This method create the LibrarianIssue Scene
	 * @return Scene, this returns a Scene object
	 */
	public Scene createLibrarianIssue() {
		GridPane pane = new GridPane();
		Label label = new Label("Enter the ID of the Student");
		TextField tf1 = new TextField();
		Button srchButton = new Button("Search");
		Label result = new Label();
		Label result2 = new Label();
		Button issueBtn = new Button("Issue");
		Button back = new Button("Back");

		issueBtn.setVisible(false);

		srchButton.setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						Student stud = new Student();
						Search srch = new Search();
						String nameOfItem = "";
						String nameOfStudent = "";
						try {
							stud = srch.findStudent(tf1.getText());
						}
						catch (IOException e){
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
						if(stud != null){
							issueBtn.setVisible(true);
							nameOfItem = stud.displayToBeBorrowedItem();
							nameOfStudent = stud.getStud_Name();
							result.setText("Student Found!\nName: " + nameOfStudent + " , ID: " + stud.getStud_id() +
									"\nItem to be Issued: " + nameOfItem);
						}
						else{
							result.setText("No Student Found with ID");
						}

						issueBtn.setOnAction(
								new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent actionEvent) {
										lib_obj.issueItem(tf1.getText());
										result2.setText("Added Library Item to borrowed list");
									}
								}
						);

					}

				}
		);

		back.setOnAction(
				actionEvent -> {
					pane.getChildren().clear();
					switchScenes(librarianMainScene);
				}
		);


		pane.setAlignment(Pos.CENTER);
		pane.addRow(0,label);
		pane.addRow(1,tf1);
		pane.addRow(2,srchButton,back);
		pane.addRow(3,result);
		pane.addRow(4,issueBtn,result2);

		VBox librarianIssueVBox = new VBox(20);
		librarianIssueVBox.setAlignment(Pos.CENTER);
		librarianIssueVBox.getChildren().addAll(pane);
		librarianIssue = new Scene(librarianIssueVBox,800,400);
		return librarianIssue;
	}

	/**
	 * @author Suhail Sameer
	 * This method create the LibrarianReturn Scene
	 * @return Scene, this returns a Scene object
	 */
	public Scene createLibrarianReturn() {
		GridPane pane = new GridPane();
		Label label = new Label("Enter the ID of the Student");
		TextField tf1 = new TextField();
		Button srchButton = new Button("Search");
		Label result = new Label();
		Label result2 = new Label();
		Button returnBtn = new Button("Return");
		Button back = new Button("Back");

		srchButton.setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						Student stud = new Student();
						Search srch = new Search();
						String nameOfItem = "";
						String nameOfStudent = "";
						try {
							stud = srch.findStudent(tf1.getText());
						}
						catch (IOException e){
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
						if(stud != null){
							returnBtn.setVisible(true);
							nameOfItem = stud.displayToBeBorrowedItem();
							nameOfStudent = stud.getStud_Name();
							result.setText("Student Found!\nName: " + nameOfStudent + " , ID: " + stud.getStud_id());
						}
						else{
							result.setText("No Student Found with ID");
						}

						returnBtn.setOnAction(
								new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent actionEvent) {
										String result = lib_obj.returnItem(tf1.getText());
										if(result != null){
											result2.setText(result);
										}
										else{
											result2.setText("Student has not borrowed books");
										}
									}
								}
						);
					}
				}
		);

		back.setOnAction(
				actionEvent -> {
					pane.getChildren().clear();
					switchScenes(librarianMainScene);
				}
		);

		pane.setAlignment(Pos.CENTER);
		pane.addRow(0,label);
		pane.addRow(1,tf1);
		pane.addRow(2,srchButton,back);
		pane.addRow(3,result);
		pane.addRow(4,returnBtn,result2);

		VBox librarianreturnVBox = new VBox(20);
		librarianreturnVBox.setAlignment(Pos.CENTER);
		librarianreturnVBox.getChildren().addAll(pane);
		librarianIssue = new Scene(librarianreturnVBox,800,400);
		return librarianIssue;
	}

	/**
	 * @author iamhenriquez
	 * this method creates the search Scene
	 * @return Scene, this returns a Scene object
	 */
	 public Scene createSearchScene() {
			Search srch = new Search();
			TextField tf1 = new TextField();
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			final Label lbl = new Label();
			final Button issueConf = new Button("Issue waiting ticket");
			final Button borrowItem = new Button("Borrow Item?");
			issueConf.setVisible(false);
			borrowItem.setVisible(false);
			tf1.setMaxSize(400, 100);
			Button submit = new Button("Search");
			submit.setMaxSize(200, 100);
			submit.setOnAction(
					/**
					 * This eventHandler handles all search related events
					 */
				new EventHandler<ActionEvent>() {
					@Override
				    public void handle(ActionEvent event) {
				        String find;
				        String issuedString;
				        Library_Item item = new Library_Item();
				        item  = srch.find(tf1.getText());
						 if(!Objects.isNull(item)) {
							 if(item.getLibitem_qnt() == 0) {
								 issuedString = "This book has already been issued, submit ticket?";
								 issueConf.setVisible(true);
							 }
							 else {
								issuedString = "This book has not been issued yet!";
								borrowItem.setVisible(true);
							}
							 find = item.getLibitem_name()+" By "+item.getLibitem_author()+" Published in "+item.getLibitem_date()+" Found! \n" + issuedString;
							 lbl.setText(find);
							 final Library_Item finalItem = item;
							 //final boolean status;
							 issueConf.setOnAction(
									 /**
									  * This event handler handles all issue related events
									  */
									 new EventHandler<ActionEvent>() {
											@Override
										    public void handle(ActionEvent event) {
												Label label = new Label();
												Issue issue = new Issue();
												issue.IssueTicket(student_obj, finalItem);
												label.setText("Waiting ticket succesfully issued!");
												pane.addRow(0, label);
											}
									 });
							 borrowItem.setOnAction(
									 new EventHandler<ActionEvent>() {
										 @Override
										 public void handle(ActionEvent actionEvent) {
											 int id = student_obj.getStud_id();
											 final boolean status = stud_arr[id-1].setToBeBorrowedItem(finalItem);
											 Label label = new Label();
											 if(status == true){
												 label.setText("Book added to Cart");
											 }
											 else{
												 label.setText(	"Student has already borrowed a book");
											 }
											 pane.addRow(0,label);
										 }
									 }
							 );
						 }
						 else {
							 find = "No book found";
							 lbl.setText(find);
						 }
				      }
				});
			Button searchReturnbtn = new Button("Back");
			searchReturnbtn.setMaxSize(200, 100);
			searchReturnbtn.setOnAction( 
					/**
					 * This event handler clears the input and switches the scene back to the previous scene
					 */
					new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					tf1.clear();
					pane.getChildren().clear();
					lbl.setText(" ");
					switchScenes(studentMainScene);
				}
			});

			
			VBox studentSearchVBox = new VBox(20);
			studentSearchVBox.setAlignment(Pos.CENTER);
			studentSearchVBox.getChildren().addAll(tf1, submit,searchReturnbtn, lbl, issueConf,borrowItem,pane);
			Scene studentSearchScene = new Scene(studentSearchVBox, 800, 400);
			
			return studentSearchScene;
		}
	 
	 /**
	  * @author iamhenriquez
	  * This method creates the view Scene
	  * @return Scene, this returns a Scene object
	  */
	 private Scene createViewScene() {
			Button viewReturnBtn = new Button("Back");
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			Button viewAll = new Button("View all borrowed books");
			viewAll.setMaxSize(200, 100);
			viewAll.setOnAction( 
					/**
					 * This eventHandler handles all view related events
					 */
					new EventHandler<ActionEvent>() {
				@Override
			    public void handle(ActionEvent event) {
					View view = new View();
					view.createViewFile(student_obj);
					Library_Item[] items = student_obj.getBorrowedItems();
					for (int i = 0; i < items.length; i++) {
						Label label = new Label(items[i].getLibitem_name());
						pane.addRow(i, label);
					}
				}
		 });
			viewReturnBtn.setMaxSize(200, 100);
			viewReturnBtn.setOnAction( 
					/**
					 * This event handler clears the input and switches the scene back to the previous scene
					 */
					new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							pane.getChildren().clear();
							switchScenes(studentMainScene);
						}
					});
			
			VBox studentViewVboxBox = new VBox(20);
			studentViewVboxBox.setAlignment(Pos.CENTER);
			studentViewVboxBox.getChildren().addAll(viewAll, viewReturnBtn, pane);
			studentViewScene = new Scene(studentViewVboxBox, 800, 400);
			
			return studentViewScene;
		}
}
