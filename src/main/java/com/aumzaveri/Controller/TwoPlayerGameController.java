package com.aumzaveri.Controller;

import com.aumzaveri.Utils.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TwoPlayerGameController {
    @FXML
    private AnchorPane two_player_anchor_pane;

    @FXML
    private void exitTwoPlayerTicTacToe() throws IOException {
        new SceneSwitcher(two_player_anchor_pane, "hello-view.fxml");
    }
}
