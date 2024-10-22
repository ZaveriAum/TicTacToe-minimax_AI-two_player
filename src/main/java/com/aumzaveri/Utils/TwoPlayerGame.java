package com.aumzaveri.Utils;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.Objects;

public class TwoPlayerGame {

    private boolean cross_turn = true;

    private int winner = -1;

    private int[][] matrix = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};

    private int number_of_turns = 1;

    public int play(Button cell){

        Image image;

        if(cross_turn){
            image = new Image(getClass().getResource("/com/images/cross.png").toExternalForm());
            ImageView imageView = new ImageView(image);

            imageView.setFitWidth(30);
            imageView.setFitHeight(30);

            cell.setGraphic(imageView);

            int[] index = get_index(cell);
            matrix[index[0]][index[1]] = 1;

            if(number_of_turns >= 5){
                winner = analyze_game(index, 1);
            }

            cross_turn = false;
        }
        else{
            image = new Image(getClass().getResource("/com/images/circle.png").toExternalForm());
            ImageView imageView = new ImageView(image);

            // Setting image size (optional)
            imageView.setFitWidth(30);
            imageView.setFitHeight(30);

            // Setting the image on the button
            cell.setGraphic(imageView);

            int[] index = get_index(cell);
            matrix[index[0]][index[1]] = 0;

            if(number_of_turns >= 5){
                winner = analyze_game(index, 0);
            }
            cross_turn = true;
        }
        number_of_turns++;
        return winner;
    }

    private int[] get_index(Button cell){
        int[] index = {-1, -1};
        index[0] = GridPane.getRowIndex(cell);
        index[1] = GridPane.getColumnIndex(cell);
        return index;
    }

    private int analyze_game(int[] last_input_index, int checker){
            // Check for column matches
            int matches = 1;
            int col = last_input_index[1];
            while(col + 1 <= 2 && checker == matrix[last_input_index[0]][col + 1]) {
                matches++;
                col++;
                if (matches == 3){
                    return checker;
                }
            }
            while(col >= 0 && checker == matrix[last_input_index[0]][col - 1]){
                matches++;
                col--;
                if (matches == 3){
                    return checker;
                }
            // Check for row matches
            matches = 1;
            int row = last_input_index[0];
            while(row + 1 <= 2 && checker == matrix[last_input_index[0]][row + 1]) {
                matches++;
                row++;
                if (matches == 3){
                    return checker;
                }
            }
            while(row >= 0 && checker == matrix[last_input_index[0]][row - 1]) {
                matches++;
                row--;
                if (matches == 3) {
                    return checker;
                }
            }
            // Check for diagonal matches
        }
        return -1;
    }

}
