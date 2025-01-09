package com.aumzaveri.Controller;

import com.aumzaveri.Utils.Util;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HelloController {

    @FXML
    private AnchorPane welcomeAnchorPane;

    @FXML
    private void openPlayerVsAI() throws IOException {
        Util.SwitchScene(welcomeAnchorPane, "selection-view.fxml");
    }

    @FXML
    private void openTwoPlayer() throws IOException {
        Util.SwitchScene(welcomeAnchorPane, "two-player-view.fxml");
    }

    @FXML
    private void exit(){
        Util.ResetBoard();
        Platform.exit();
    }
}