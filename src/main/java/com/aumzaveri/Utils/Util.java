package com.aumzaveri.Utils;

import com.aumzaveri.tictactoe.HelloApplication;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.*;

public class Util {
    public static int user_selection;

    public static void SwitchScene(AnchorPane currentAnchorPane, String fxml) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }

    public static void ShowWinner(int winner, AnchorPane currentAnchorPane, String fxml) throws IOException {
        if(winner != 2) {
            if (winner == 1){
                Util.ShowResult("X won this game of Tic-Tac-Toe");
                TwoPlayerGame.resetGame();
            }
            else if(winner == -1) {
                Util.ShowResult("O won this game of Tic-Tac-Toe");
                TwoPlayerGame.resetGame();
            }
            else {
                Util.ShowResult("It's a Draw well played you two.");
                TwoPlayerGame.resetGame();
            }
            Util.SwitchScene(currentAnchorPane, fxml);
        }
    }

    private static void ShowResult(String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(message);
        alert.setContentText("To start new game press ok or cancel");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.CANCEL) {
            alert.close();
        }
    }
}
