package com.aumzaveri.Controller;

import com.aumzaveri.tictactoe.HelloApplication;
import com.aumzaveri.Utils.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;

    @FXML
    private AnchorPane welcomeAnchorPane;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void openPlayerVsAI() throws IOException {
        new SceneSwitcher(welcomeAnchorPane, "AI-view.fxml");
    }

    @FXML
    private void openTwoPlayer(ActionEvent event) throws IOException {
        new SceneSwitcher(welcomeAnchorPane, "two-player-view.fxml");
    }
}