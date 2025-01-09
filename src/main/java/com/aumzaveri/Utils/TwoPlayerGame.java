package com.aumzaveri.Utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class TwoPlayerGame {

    public int play(Button cell, Label turn_label){

        System.out.println(Util.winner);
        cell.setDisable(true);

        Image image;

        if(Util.cross_turn){
            turn_label.setText("O's turn");

            image = new Image(getClass().getResource("/com/images/cross.png").toExternalForm());
            ImageView imageView = new ImageView(image);

            imageView.setFitWidth(30);
            imageView.setFitHeight(30);

            cell.setGraphic(imageView);

            int[] index = get_index(cell);
            Util.matrix[index[0]][index[1]] = 1;

            if(Util.number_of_turns >= 5){
                Util.winner = analyze_game(Util.matrix, Util.number_of_turns);
            }

            Util.cross_turn = false;
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
            Util.matrix[index[0]][index[1]] = -1;

            if(Util.number_of_turns >= 5){
                Util.winner = analyze_game(Util.matrix, Util.number_of_turns);
            }
            Util.cross_turn = true;
        }
        Util.number_of_turns++;
        return Util.winner;
    }

    private static int[] get_index(Button cell){
        int[] index = {0, 0};
        index[0] = GridPane.getRowIndex(cell);
        index[1] = GridPane.getColumnIndex(cell);
        return index;
    }

    public static int analyze_game(int [][] matrix, int number_of_turns){
        // Check for column matches
        for (int i = 0; i < 3; i++) {
            if ((matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) && matrix[0][i] != 0)
                return matrix[0][i];
        }

        // Check for row matches
        for (int i = 0; i < 3; i++) {
            if ((matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) && matrix[i][0] != 0)
                return matrix[i][0];
        }

        // Check for positive diagonal
        if((matrix[2][0] == matrix[1][1] && matrix[1][1] == matrix[0][2]) && matrix[2][0] != 0)
            return matrix[1][1];

        // Check for negative diagonal
        if((matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) && matrix[2][2] != 0)
            return matrix[1][1];
        if(number_of_turns == 9)
            return 0;
        return 2;
    }

}
