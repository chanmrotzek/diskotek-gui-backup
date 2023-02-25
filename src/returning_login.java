import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class returning_login extends Application {

    @Override
    public void start(Stage window) throws Exception {



        // 1. Creating the view for asking a password

        Label page_title = new Label("DISKOTEK  |  Sign-in Demo");

        Label page_divider = new Label("-------------------------");
        Label page_divider_2 = new Label("-------------------------");
        page_divider.setAlignment(Pos.CENTER);

        Label user_email_text = new Label("Email Address");
        TextField user_email_field = new TextField();

        Label user_username_text = new Label("Username");
        TextField user_username_field = new TextField();

        Label user_password_text = new Label("Password");
        PasswordField user_password_field = new PasswordField();
        Button startButton = new Button("Log in");

        Label errorMessage = new Label("                                                        ");

        // 1.2 creating layout and adding components to it
        GridPane layout = new GridPane();

        layout.add(page_title, 0, 1);

        layout.add(page_divider, 0, 3);

        layout.add(user_email_text, 0, 5);
        layout.add(user_email_field, 0, 6);

        layout.add(user_password_text, 0, 7);
        layout.add(user_password_field, 0, 8);

        layout.add(page_divider_2, 0, 11);

        layout.add(startButton, 0, 14);
        layout.add(errorMessage, 0, 16);

        // 1.3 styling the layout
        layout.setPrefSize(500, 500);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(5);
        layout.setHgap(5);
        layout.setPadding(new Insets(10, 10, 10, 0));

        // 1.4 creating the view itself and setting it to use the layout
        Scene passwordView = new Scene(layout);

        // 2. Creating a view for showing the welcome message
        Label welcomeText = new Label("Welcome, ");

        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(500, 500);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene welcomeView = new Scene(welcomeLayout);

        // 3. Adding an event handler to the login button.
        // The view is changed if the password is right.
        startButton.setOnAction((event) -> {

            String returned_email = user_email_field.getText().trim();
            String returned_password = user_password_field.getText().trim();

            System.out.println(returned_email);
            System.out.println(returned_password);



            window.setScene(welcomeView);


        });

        window.setScene(passwordView);
        window.show();
    }
}