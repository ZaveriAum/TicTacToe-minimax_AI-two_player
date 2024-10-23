package com.aumzaveri.Controller;

import com.aumzaveri.Utils.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TurnSelection {
    @FXML
    private AnchorPane selection_anchor_pane;

    @FXML
    private void onExit() throws IOException {
        Util.SwitchScene(selection_anchor_pane, "hello-view.fxml");
    }

    @FXML
    private void onCrossSelect() throws IOException {
        Util.user_selection = 1;
        Util.SwitchScene(selection_anchor_pane, "AI-view.fxml");
    }

    @FXML
    private void onCircleSelect() throws IOException {
        Util.user_selection = 0;
        Util.SwitchScene(selection_anchor_pane, "AI-view.fxml");
    }
}
