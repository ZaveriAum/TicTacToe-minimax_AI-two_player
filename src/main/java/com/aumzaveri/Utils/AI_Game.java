package com.aumzaveri.Utils;

import java.util.ArrayList;

public class AI_Game {
    private int number_of_moves;

    private int[][][] position_not_visited = {{{0,0}, {0,1}, {0, 2}},{{1,0}, {1,1}, {0, 2}}, {{2,0}, {2,1}, {2, 2}}};

    private boolean ai_playing_cross;

    private int[][] matrix;

    // How will the program travels
    // If user is cross then it select the first spot
    // After that ai wil analyse the position and will send the index where it wants to put the circle
    // and this goes on and on until there is a winner, or it's a draw.

//    private int[] minimax(int[][] matrix,int depth,int checker, int[] last_input_index){
//
//    }
}
