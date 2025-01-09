package com.aumzaveri.Controller;

import com.aumzaveri.Utils.AI_Game;
import com.aumzaveri.Utils.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AIController {

    @FXML
    Label turn_label;

    @FXML
    AnchorPane ai_anchor_pane;

    @FXML
    AI_Game ai = new AI_Game();

    @FXML
    private void returnToTurnSelection() throws IOException {
        Util.ResetBoard();
        Util.SwitchScene(ai_anchor_pane, "selection-view.fxml");
    }

    @FXML
    private void onButtonClick(ActionEvent event) throws IOException {
        Button cell = (Button)event.getSource();
        int winner = ai.play_game(cell, turn_label);
        Util.ShowWinner(winner, ai_anchor_pane, "AI-view.fxml");
    }
}
