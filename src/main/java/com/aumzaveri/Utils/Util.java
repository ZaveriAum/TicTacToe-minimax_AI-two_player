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

    public static int[][] matrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    public static int number_of_turns = 1;

    public static boolean cross_turn = true;

    public static int winner = 2; // if winner status is 2 - nothing has happened
                                  // if winner status is 0 - it's a draw
                                  // if winner status is 1 - X won
                                  // if winner status is -1 - O won

    public static void SwitchScene(AnchorPane currentAnchorPane, String fxml) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }

    public static void ShowWinner(int winner, AnchorPane currentAnchorPane, String fxml) throws IOException {
        if(winner != 2) {
            if (winner == 1){
                Util.ShowResult("X won this game of Tic-Tac-Toe");
            }
            else if(winner == -1) {
                Util.ShowResult("O won this game of Tic-Tac-Toe");
            }
            else {
                Util.ShowResult("It's a Draw well played you two.");
            }
            Util.SwitchScene(currentAnchorPane, fxml);
        }
    }

    private static void ShowResult(String message){
        Util.ResetBoard();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(message);
        alert.setContentText("To start new game press ok or cancel");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.CANCEL) {
            alert.close();
        }
    }

    public static void ConfirmExit(AnchorPane anchorPane, String screen) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Are you sure");
        alert.setHeaderText("The game will not be stored");
        alert.setContentText("To exit press ok");

        ButtonType okButton = new ButtonType("OK");
        ButtonType cancelButton = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(okButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == okButton) {
            Util.ResetBoard();
            Util.SwitchScene(anchorPane, screen);
            alert.close();
        }

    }


    public static void ResetBoard(){
        matrix = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        number_of_turns = 1;
        cross_turn = true;
        winner = 2;
    }
}
