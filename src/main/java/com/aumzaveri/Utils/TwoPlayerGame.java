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
        int[] index = get_index(cell);
        matrix[index[0]][index[1]] = 1;

        Image image;

        if(cross_turn){
            image = new Image(getClass().getResource("/com/images/cross.png").toExternalForm());
            ImageView imageView = new ImageView(image);

            imageView.setFitWidth(30);
            imageView.setFitHeight(30);

            cell.setGraphic(imageView);

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

            if(number_of_turns >= 5){
                winner = analyze_game(index, 0);
            }
            cross_turn = true;
        }
        number_of_turns++;
        //print_matrix();
        System.out.println(winner);
        return winner;
    }

    private int[] get_index(Button cell){
        int[] index = {-1, -1};
        index[0] = GridPane.getRowIndex(cell);
        index[1] = GridPane.getColumnIndex(cell);
        return index;
    }

    private int analyze_game(int[] last_input_index, int checker){
        if (Arrays.equals(last_input_index, new int[]{1, 1})) {
            if((matrix[0][1] == checker && checker== matrix[1][2])
                    ||
                (matrix[0][0] == checker && checker== matrix[2][2])
                    ||
                (matrix[1][0] == checker && checker== matrix[1][2])
                    ||
                (matrix[2][0] == checker && checker== matrix[0][2])
            )
                return checker;
        }
        return -1;
    }

    private void print_matrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " index ->" + "( " + i + ", " + j + " )");
            }
            System.out.println();
            System.out.print("--------------------");
            System.out.println();
        }
    }
}
