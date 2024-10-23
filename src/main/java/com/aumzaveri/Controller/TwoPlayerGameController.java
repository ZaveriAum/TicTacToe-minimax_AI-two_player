package com.aumzaveri.Controller;

import com.aumzaveri.Utils.Util;
import com.aumzaveri.Utils.TwoPlayerGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class TwoPlayerGameController {

    @FXML
    private final TwoPlayerGame twoPlayerGame = new TwoPlayerGame();

    @FXML
    private Label turn_label;

    @FXML
    private AnchorPane two_player_anchor_pane;

    @FXML
    private void exitTwoPlayerTicTacToe() throws IOException {
        Util.SwitchScene(two_player_anchor_pane, "hello-view.fxml");
    }

    @FXML
    private void onButtonClick(ActionEvent event) throws IOException {
        Button cell = (Button)event.getSource();
        int winner = twoPlayerGame.play(cell, turn_label);
        cell.setDisable(true);
        Util.ShowWinner(winner, two_player_anchor_pane, "two-player-view.fxml");
    }
}
