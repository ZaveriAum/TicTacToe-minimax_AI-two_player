package com.aumzaveri.Utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.Objects;

public class TwoPlayerGame {

    private static boolean cross_turn = true;

    private static int winner = 2;

    private static int[][] matrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    private static int number_of_turns = 1;

    public int play(Button cell, Label turn_label){

        cell.setDisable(true);

        Image image;

        if(cross_turn){
            turn_label.setText("O's turn");

            image = new Image(getClass().getResource("/com/images/cross.png").toExternalForm());
            ImageView imageView = new ImageView(image);

            imageView.setFitWidth(30);
            imageView.setFitHeight(30);

            cell.setGraphic(imageView);

            int[] index = get_index(cell);
            matrix[index[0]][index[1]] = 1;

            if(number_of_turns >= 5){
                winner = analyze_game();
            }

            cross_turn = false;
        }
        else{
            turn_label.setText("X's turn");

            image = new Image(getClass().getResource("/com/images/circle.png").toExternalForm());
            ImageView imageView = new ImageView(image);

            // Setting image size (optional)
            imageView.setFitWidth(30);
            imageView.setFitHeight(30);

            // Setting the image on the button
            cell.setGraphic(imageView);

            int[] index = get_index(cell);
            matrix[index[0]][index[1]] = -1;

            if(number_of_turns >= 5){
                winner = analyze_game();
            }
            cross_turn = true;
        }
        number_of_turns++;
        return winner;
    }

    private int[] get_index(Button cell){
        int[] index = {0, 0};
        index[0] = GridPane.getRowIndex(cell);
        index[1] = GridPane.getColumnIndex(cell);
        return index;
    }

    public static int analyze_game(){
        // Check for column matches
        for (int i = 0; i < 3; i++) {
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i])
                return matrix[0][i];
        }

        // Check for row matches
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2])
                return matrix[i][0];
        }

        // Check for positive diagonal
        if(matrix[2][0] == matrix[1][1] && matrix[1][1] == matrix[0][2])
            return matrix[1][1];

        // Check for negative diagonal
        if(matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2])
            return matrix[1][1];
        if(number_of_turns == 9)
            return 0;
        return 2;
    }

    public static void resetGame(){
        TwoPlayerGame.winner = 2;

        TwoPlayerGame.matrix = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        TwoPlayerGame.number_of_turns = 1;

        TwoPlayerGame.cross_turn = true;
    }
}
