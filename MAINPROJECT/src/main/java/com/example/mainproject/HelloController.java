package com.example.mainproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class HelloController {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "#Aswin2005";

    @FXML
    private TextField name;


    @FXML
    private TextField duemailid;

    @FXML
    private CheckBox checkbox3;

    @FXML
    private TextField dupo;

    @FXML
    private TextArea addressid;

    @FXML
    private TextField usernameField;


    @FXML
    private DatePicker date1;

    @FXML
    private DatePicker date2;

    @FXML
    private CheckBox checkbox1;

    @FXML
    private Label watchtext3;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private Label booknowlabel1;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label Welcometext;

    @FXML
    private TextField emailid;

    @FXML
    private PasswordField passwordid;

    @FXML
    private TextField poid;

    @FXML
    private Label Watchtext2;

    @FXML
    private TextField feedname1;

    @FXML
    private TextField feedemail1;

    @FXML
    private TextField feed1;

    private  static int userId;

    private static int carId;

    private static int day;



    @FXML
    private void onHelloButtonClick() {
        if (usernameField != null && passwordField != null) {
            String providedUsername = usernameField.getText();
            String providedPassword = passwordField.getText();

            try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
                String sql = "SELECT * FROM information WHERE per_email = ? AND password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, providedUsername);
                    preparedStatement.setString(2, providedPassword);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            Welcometext.setText("Authentication successful!");
                            userId = resultSet.getInt("id");
                            openBrowsingScene();
                        } else {
                            Welcometext.setText("Invalid username or password.");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                Welcometext.setText("Error: " + e.getMessage());
            }
        } else {
            Welcometext.setText("usernameField or passwordField is null!");
        }
        System.out.println(userId);
    }


    @FXML
    private void onclicksignup() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Signup Page");
            stage.setScene(new Scene(root));

            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
            Welcometext.setText("Error loading browsing scene: " + e.getMessage());
        }
    }

    @FXML
    private void gotosigin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Login Page");
            stage.setScene(new Scene(root));

            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
            Welcometext.setText("Error loading browsing scene: " + e.getMessage());
        }
    }

    @FXML
    private void onclickcreate() {
        String newUsername = emailid.getText();
        String newPassword = passwordid.getText();
        String newNumber = poid.getText();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO information (per_email, password , per_number) VALUES (?, ? , ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newUsername);
                preparedStatement.setString(2, newPassword);
                preparedStatement.setString(3, newNumber);

                preparedStatement.executeUpdate();
                Watchtext2.setText("User registered successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Error!");
        }
    }


    @FXML
    private void openBrowsingScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Browsing.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Main Page");
            stage.setScene(new Scene(root));

            stage.show();


            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
            Welcometext.setText("Error loading browsing scene: " + e.getMessage());
        }
    }


    @FXML
    private void onclickfortuner(){
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "Update information SET dupcarid=? where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, userId);

                preparedStatement.executeUpdate();
                System.out.println("Car Added");
                carId = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Error!");
        }
        openBooknow();
    }

    @FXML
    private void onclicksantro(){

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "Update information SET dupcarid=? where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, 2);
                preparedStatement.setInt(2, userId);

                preparedStatement.executeUpdate();
                System.out.println("Car Added");
                carId = 2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Error!");
        }
        openBooknow();
    }

    @FXML
    private void onclickinnova(){

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "Update information SET dupcarid=? where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, 3);
                preparedStatement.setInt(2, userId);

                preparedStatement.executeUpdate();
                System.out.println("Car Added");
                carId = 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Error!");
        }
        openBooknow();
    }

    @FXML
    private void onclickthar(){

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "Update information SET dupcarid=? where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, 4);
                preparedStatement.setInt(2, userId);

                preparedStatement.executeUpdate();
                System.out.println("Car Added");
                carId = 4;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Error!");
        }
    }

    @FXML
    private void openBooknow(){
        LocalDate startDate = date1.getValue();
        LocalDate endDate = date2.getValue();

        if (startDate != null && endDate != null) {
            long daysDifference = endDate.toEpochDay() - startDate.toEpochDay();
            day = (int) daysDifference;
        }

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "Update information SET day = ? , start_date = ? , end_date = ? where id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, day);
                preparedStatement.setDate(2, Date.valueOf(date1.getValue()));
                preparedStatement.setDate(3, Date.valueOf(date2.getValue()));
                preparedStatement.setInt(4, userId);

                preparedStatement.executeUpdate();
                System.out.println("Car Added");
                carId = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Error!");
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Booknow.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Booknow Scene");
            stage.setScene(new Scene(root));

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Welcometext.setText("Error loading browsing scene: " + e.getMessage());
        }
    }



    @FXML
    private void addnew() {
        String  newname = name.getText();
        String newdupemaild = duemailid.getText();
        String newnumber = dupo.getText();
        String newaddress = addressid.getText();
        if(newname != null && newdupemaild != null && newaddress != null && newnumber != null){
            if(checkbox3.isSelected()){
                updatedatabase(newname , newdupemaild , newnumber , newaddress);
                gotopayment();
            }
        }
        else{
            if(newname == null || newdupemaild == null || newaddress == null || newnumber == null){
                booknowlabel1.setText("Kindly fill all the boxes;");
            }
            else{
                booknowlabel1.setText("Kindly agree terms and conditions");
            }
        }
    }

    @FXML
    private void updatedatabase(String newname , String newdupemaild , String newnumber , String newaddress){
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE information SET name = ? , dup_emailid=?, dup_number=? , address = ? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newname);
                preparedStatement.setString(2, newdupemaild);
                preparedStatement.setString(3, newnumber);
                preparedStatement.setString(4, newaddress);
                preparedStatement.setInt(5, userId);


                preparedStatement.executeUpdate();
                System.out.println("User details Updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }


    @FXML
    private void gotopayment() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {

            String updateSql = "UPDATE cardetails SET userid=?, status=? WHERE carid=?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                updateStatement.setInt(1, userId);
                updateStatement.setString(2, "notavailable");
                updateStatement.setInt(3, carId);
                updateStatement.executeUpdate();
                System.out.println("Status Updated");
            }

            System.out.println(day);


            FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));
            Parent root = loader.load();


            Stage stage = new Stage();
            stage.setTitle("Payment Page");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Error in gotopayment: " + e.getMessage());
        }
    }




    @FXML
    private void gotosuccess(){
        if(checkbox1.isSelected() || checkBox2.isSelected()){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Successful.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Final Page");
                stage.setScene(new Scene(root));



                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                Welcometext.setText("Error loading browsing scene: " + e.getMessage());
            }

        }
        else{
            watchtext3.setText("Select one Payment Option !");
        }
    }

    @FXML
    private void onclickfeed() {
        String newfeedname1 = feedname1.getText();
        String newfeedemail = feedemail1.getText();
        String newfeed = feed1.getText();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO feedback (feed_name , feed_email , feed , feeduserid) VALUES (?, ? , ? , ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newfeedname1);
                preparedStatement.setString(2, newfeedemail);
                preparedStatement.setString(3, newfeed);
                preparedStatement.setInt(4, userId);


                preparedStatement.executeUpdate();
                System.out.println("feedback updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Error!");
        }
    }

    @FXML
    private void gotofeedback(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("feedback page.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Feedback Page");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Welcometext.setText("Error loading browsing scene: " + e.getMessage());
        }
    }

    @FXML
    private void gottomainpage(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("browsing.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Main Page");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Welcometext.setText("Error loading browsing scene: " + e.getMessage());
        }
    }
}

