package shop;

import com.github.saacsos.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXRouter.bind(this, primaryStage, "Student ID", 1280, 1024);

        configRoute();

        FXRouter.goTo("home");
    }

    private static void configRoute() {
        FXRouter.when("home", "home.fxml");
        FXRouter.when("member_card_detail", "member_card_detail.fxml");
        FXRouter.when("member_card_list", "member_card_list.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
