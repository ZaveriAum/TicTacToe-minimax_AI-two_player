package com.aumzaveri.Controller;

import com.aumzaveri.Utils.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HelloController {

    @FXML
    private AnchorPane welcomeAnchorPane;

    @FXML
    private void openPlayerVsAI() throws IOException {
        Util.SwitchScene(welcomeAnchorPane, "AI-view.fxml");
    }

    @FXML
    private void openTwoPlayer(ActionEvent event) throws IOException {
        Util.SwitchScene(welcomeAnchorPane, "two-player-view.fxml");
    }
}