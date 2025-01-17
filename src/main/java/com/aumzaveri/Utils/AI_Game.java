package com.aumzaveri.Utils;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class AI_Game {

    public static boolean ai_playing_cross;

    public int play(Button cell, Label turn_label, GridPane game_board) {
        userMove(cell, turn_label);
        if (Util.winner != 2)
            return Util.winner;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(Util.matrix[i][j]);
            }
            System.out.println("----------------");
        }
        aiMove(turn_label, game_board);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(Util.matrix[i][j]);
            }
            System.out.println("----------------");
        }
        return Util.winner;
    }

    private void userMove(Button cell, Label turn_label) {
        cell.setDisable(true);
        setImage(cell, !ai_playing_cross ? "cross" : "circle");
        int[] index = get_index(cell);
        Util.matrix[index[0]][index[1]] = !ai_playing_cross ? 1 : -1;

        Util.number_of_turns++;
        Util.winner = TwoPlayerGame.analyze_game(Util.matrix, Util.number_of_turns);
        turn_label.setText(ai_playing_cross ? "X's turn" : "O's turn");
    }

    private void aiMove(Label turn_label, GridPane game_board) {
        int aiMark = ai_playing_cross ? 1 : -1; // AI's mark (1 for X, -1 for O)
        int[] bestMove = findBestMove(Util.matrix, aiMark);

        if (bestMove != null) {
            int row = bestMove[0];
            int col = bestMove[1];
            Button cell = getButton(row, col, game_board);

            cell.setDisable(true);
            setImage(cell, ai_playing_cross ? "cross" : "circle");
            Util.matrix[row][col] = aiMark;

            Util.number_of_turns++;
            Util.winner = TwoPlayerGame.analyze_game(Util.matrix, Util.number_of_turns);

            if (Util.winner == 2) {
                turn_label.setText(!ai_playing_cross ? "X's turn" : "O's turn");
            } else {
                turn_label.setText(Util.winner == aiMark ? "AI wins!" : "You win!");
            }
        }
    }

    private int[] findBestMove(int[][] board, int aiMark) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = null;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 0) {
                    board[row][col] = aiMark;
                    int score = minimax(board, 0, false, aiMark);
                    board[row][col] = 0;

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{row, col};
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(int[][] board, int depth, boolean isMaximizing, int aiMark) {
        int result = TwoPlayerGame.analyze_game(board, Util.number_of_turns);

        if (result != 2) {
            if (result == aiMark) {
                return 10 - depth;
            } else if (result == 0) {
                return 0;
            } else {
                return depth - 10;
            }
        }

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentMark = isMaximizing ? aiMark : -aiMark;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 0) {
                    board[row][col] = currentMark;
                    int score = minimax(board, depth + 1, !isMaximizing, aiMark);
                    board[row][col] = 0;

                    bestScore = isMaximizing
                            ? Math.max(bestScore, score)
                            : Math.min(bestScore, score);
                }
            }
        }
        return bestScore;
    }

    private void setImage(Button cell, String type) {
        String imagePath = "/com/images/" + type + ".png";
        Image image = new Image(getClass().getResource(imagePath).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        cell.setGraphic(imageView);
    }

    private int[] get_index(Button cell) {
        return new int[]{GridPane.getRowIndex(cell), GridPane.getColumnIndex(cell)};
    }

    private Button getButton(int row, int col, GridPane game_board) {
        for (Node node : game_board.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col && node instanceof Button) {
                return (Button) node;
            }
        }
        return null;
    }

}
