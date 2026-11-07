/**
 * @author Darryn
 * @since 11/06/2026
 */

package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
    	
    	//===========================================
        // Create the main BorderPane
    	//===========================================
        BorderPane borderPane = new BorderPane();
        
        
        
        //===========================================
        // Customizing Top Section
    	//===========================================
        HBox topHeader = new HBox();
        
        // Top Header Elements
        Label headerText = new Label("Welcome to Java College! Please Complete the Student Registration Form Below.");
        
        // Add Elements
        topHeader.getChildren().add(headerText);
        
        // Top Header Styling
        headerText.setStyle("-fx-text-fill: white");
        topHeader.setStyle("-fx-background-color: #6699cc;");
        topHeader.setPadding(new Insets(30, 0, 30, 30));
        
        
        
        //===========================================
        // Customizing Left Section
    	//===========================================
        VBox navBar = new VBox();
       
        // Navigation Bar Elements
        Label navTitle = new Label("MENU");
        Button dashboardButton = new Button("Dashboard");
        Button registrationButton = new Button("Registration"); 
        Button coursesButton = new Button("Courses");
        Button helpButton = new Button("Help");
        
        // Add Elements
        navBar.getChildren().addAll(navTitle, dashboardButton, registrationButton, coursesButton, helpButton);
        
        // Navigation Bar Styling
        navBar.setSpacing(10);
        navBar.setPadding(new Insets(10, 40, 10, 10));
        navBar.setStyle("-fx-background-color: #c2d6ea;");
        navTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
        
        
        //===========================================
        // Customizing Right Section
    	//===========================================
        VBox rightBanner = new VBox();
        rightBanner.getChildren().add(new Label("      "));
        rightBanner.setStyle("-fx-background-color: #c2d6ea;");
        
        
        
        //===========================================
        // Customizing Bottom Section
    	//===========================================
        HBox footer = new HBox();
        Label footerText = new Label("Copyright: Darryn Long");
        footer.getChildren().add(footerText);
        
        // Styling
        footerText.setStyle("-fx-text-fill: white");
        footer.setStyle("-fx-background-color: #6699cc;");
        footerText.setPadding(new Insets(5, 0, 5, 30));
        
        
        
        //===========================================
        // Customizing Center Section
    	//===========================================
        VBox centrePane = new VBox();
        
        // Center Pane Elements
        Label title = new Label("Resgistration Form");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
        title.setPadding(new Insets(10, 40, 10, 10));
        
        // Create the GridPane for the center
        GridPane gridPane = new GridPane();
        
        // Text Fields
        TextField studentIdField = new TextField();
        TextField fullNameField = new TextField();
        TextField emailField = new TextField();
        TextField programField = new TextField();
        
        // Place nodes in the GridPane
        gridPane.add(new Label("Student ID:"), 0, 0);
        gridPane.add(studentIdField, 1, 0);
        
        gridPane.add(new Label("Full Name:"), 0, 1);
        gridPane.add(fullNameField, 1, 1);
        
        gridPane.add(new Label("Email:"), 0, 2);
        gridPane.add(emailField, 1, 2);
        
        gridPane.add(new Label("Program:"), 0, 3);
        gridPane.add(programField, 1, 3);
        
        // Courses Section
        Label courseTitle = new Label("Courses");
        gridPane.add(courseTitle, 0, 4);
        GridPane.setMargin(courseTitle, new Insets(15, 0, 0, 0));
        courseTitle.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
        
        // Separator Line
        Separator separator = new Separator();
        gridPane.add(separator, 0, 5, 2, 1);
        GridPane.setMargin(separator, new Insets(0, 0, 15, 0)); 
        
        // Place course nodes in the grid
        int courseCount = 6;
        TextField[] courseFields = new TextField[courseCount];
        
        for (var i = 0; i < courseCount; i++)
        {
        	gridPane.add(new Label("Course " + (i + 1) + ":"), 0, i + 6);
        	
        	courseFields[i] = new TextField();
            gridPane.add(courseFields[i], 1, i + 6);
        }
        
        // Grid Styling
        gridPane.setPadding(new Insets(10, 10, 10, 15));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);
        
        // Button Horizontal Box
        HBox buttonBox = new HBox(10);
        
        // Buttons
        Button registerButton = new Button("Register");
        Button clearButton = new Button("Clear");
        
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(0, 190, 10, 0));
        
        // Add Elements
        buttonBox.getChildren().addAll(registerButton, clearButton);
        
        // Adding Elements to Center Pane
        centrePane.getChildren().addAll(title, gridPane, buttonBox);
        
        
        
        //===========================================
        // Completed Panel
        //===========================================
        VBox completedForm = new VBox();
        completedForm.getChildren().add(new Label("Thanks for completing the form!"));
        completedForm.setPadding(new Insets(30, 0, 30, 30));
        completedForm.setStyle("-fx-font-weight: bold; -fx-font-size: 18px;");
        
        
        
        //===========================================
        // Setting the sections
        //===========================================
        
        borderPane.setTop(topHeader);
        borderPane.setRight(rightBanner);
        borderPane.setBottom(footer);
        borderPane.setLeft(navBar);
        borderPane.setCenter(centrePane);
        
        borderPane.setStyle("-fx-background-color: #edf0f2;");
        
        
        
        //===========================================
        // Button Actions
        //===========================================
        
        clearButton.setOnAction(e -> {
            studentIdField.clear();
            fullNameField.clear();
            emailField.clear();
            programField.clear();
            
            // Loop through the standard array to clear each field
            for (TextField field : courseFields) 
            {
                field.clear();
            }
        });
        
        registerButton.setOnAction(e -> {
            if (studentIdField.getText().isBlank()) 
            {
                System.out.println("Student ID cannot be empty.");
                studentIdField.requestFocus(); // Focuses cursor on the empty field
            }
            else if (fullNameField.getText().isBlank()) 
            {
                System.out.println("Full name cannot be empty.");
                fullNameField.requestFocus();
            }
            else if (emailField.getText().isBlank()) 
            {
                System.out.println("Email cannot be empty.");
                emailField.requestFocus();
            }
            else if (programField.getText().isBlank()) 
            {
                System.out.println("Program cannot be empty.");
                programField.requestFocus();
            }
            else 
            {
                // Check if at least one course text field is filled
                boolean hasCourse = false;
                for (TextField field : courseFields) 
                {
                    if (!field.getText().isBlank())
                    {
                        hasCourse = true;
                        break;
                    }
                }
                
                if (!hasCourse) 
                {
                    System.out.println("Please enter at least one course.");
                } 
                else 
                {
                    System.out.println("Registration successful!");
                    System.out.println("Student ID: " + studentIdField.getText());
                    System.out.println("Full name: " + fullNameField.getText());
                    System.out.println("Email: " + emailField.getText());
                    System.out.println("Program: " + programField.getText());
                    borderPane.setCenter(completedForm);
                }
            }
        });
        
        
        
        
        //===========================================
        // Creating the Scene and setting the stage
        //===========================================
        Scene scene = new Scene(borderPane, 700, 600);
        primaryStage.setTitle("Student Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}