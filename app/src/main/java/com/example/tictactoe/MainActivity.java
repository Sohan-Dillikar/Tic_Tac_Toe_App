package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView gameStatusTextView;
    ImageView token1ImageView;
    ImageView token2ImageView;
    ImageView token3ImageView;
    ImageView token4ImageView;
    ImageView token5ImageView;
    ImageView token6ImageView;
    ImageView token7ImageView;
    ImageView token8ImageView;
    ImageView token9ImageView;
    Button clearBoardButton;
    String turn;
    String[] board = {
            "", "", "",
            "", "", "",
            "", "", ""
    };

    public List<ImageView> tokenImageViewArray() {
        List<ImageView> tokenImageViewArray = new ArrayList<ImageView>();
        tokenImageViewArray.add(token1ImageView);
        tokenImageViewArray.add(token2ImageView);
        tokenImageViewArray.add(token3ImageView);
        tokenImageViewArray.add(token4ImageView);
        tokenImageViewArray.add(token5ImageView);
        tokenImageViewArray.add(token6ImageView);
        tokenImageViewArray.add(token7ImageView);
        tokenImageViewArray.add(token8ImageView);
        tokenImageViewArray.add(token9ImageView);
        return tokenImageViewArray;
    }

    public void clearBoard() {
        List<ImageView> tokenImageViewArray = tokenImageViewArray();
        for (ImageView tokenImageView : tokenImageViewArray) {
            tokenImageView.setAlpha(0f);
            tokenImageView.setEnabled(true);
        }
        turn = "x";
        gameStatusTextView.setText("Player X's turn to make a move");
        clearBoardButton.setText("Clear Board");
        clearBoardButton.setEnabled(false);
        for (int i = 0; i < board.length; i++) {
            board[i] = "";
        }
    }

    public boolean boardIsFilled() {
        for (String spot : board) {
            if (spot.equals("")) {
                return false;
            }
        }
        return true;
    }

    public String isWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(board[i + 3]) && board[i].equals(board[i + 6]) && ! board[i].isEmpty()) {
                return board[i];
            }
        }
        for (int i = 0; i < 9; i += 3) {
            if (board[i].equals(board[i + 1]) && board[i].equals(board[i + 2]) && ! board[i].isEmpty()) {
                return board[i];
            }
        }
        if (board[0].equals(board[4]) && board[0].equals(board[8]) && ! board[0].isEmpty()) {
            return board[0];
        }
        if (board[2].equals(board[4]) && board[2].equals(board[6]) && ! board[2].isEmpty()) {
            return board[2];
        }
        return "n";
    }

    public void gameOver() {
        List<ImageView> tokenImageViewArray = tokenImageViewArray();
        for (ImageView tokenImageViewEdit : tokenImageViewArray) {
            tokenImageViewEdit.setEnabled(false);
        }
        clearBoardButton.setText("Play Again");
    }

    public void dropToken(ImageView tokenImageView) {
        List<ImageView> tokenImageViewArray = tokenImageViewArray();
        if (turn.equals("x")) {
            board[tokenImageViewArray.indexOf(tokenImageView)] = "x";
            tokenImageView.setImageResource(R.drawable.x_counter);
            turn = "o";
            gameStatusTextView.setText("Player O's turn to make a move");
        } else {
            board[tokenImageViewArray.indexOf(tokenImageView)] = "o";
            tokenImageView.setImageResource(R.drawable.o_counter);
            turn = "x";
            gameStatusTextView.setText("Player X's turn to make a move");
        }
        clearBoardButton.setEnabled(true);
        tokenImageView.setTranslationY(-200f);
        tokenImageView.animate().alpha(1).translationYBy(200f).setDuration(250);
        tokenImageView.setEnabled(false);
        if (isWinner().equals("x")) {
            gameStatusTextView.setText("The winner is Player X!");
            gameOver();
        } else if (isWinner().equals("o")) {
            gameStatusTextView.setText("The winner is Player O!");
            gameOver();
        } else if (isWinner().equals("n") && boardIsFilled()) {
            gameStatusTextView.setText("It is a TIE!  No one is the winner!");
            gameOver();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameStatusTextView = (TextView) findViewById(R.id.gameStatusTextView);
        turn = "x";

        token1ImageView = (ImageView) findViewById(R.id.token1ImageView);
        token1ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token1ImageView);
            }
        });

        token2ImageView = (ImageView) findViewById(R.id.token2ImageView);
        token2ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token2ImageView);
            }
        });

        token3ImageView = (ImageView) findViewById(R.id.token3ImageView);
        token3ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token3ImageView);
            }
        });

        token4ImageView = (ImageView) findViewById(R.id.token4ImageView);
        token4ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token4ImageView);
            }
        });

        token5ImageView = (ImageView) findViewById(R.id.token5ImageView);
        token5ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token5ImageView);
            }
        });

        token6ImageView = (ImageView) findViewById(R.id.token6ImageView);
        token6ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token6ImageView);
            }
        });

        token7ImageView = (ImageView) findViewById(R.id.token7ImageView);
        token7ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token7ImageView);
            }
        });

        token8ImageView = (ImageView) findViewById(R.id.token8ImageView);
        token8ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token8ImageView);
            }
        });

        token9ImageView = (ImageView) findViewById(R.id.token9ImageView);
        token9ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropToken(token9ImageView);
            }
        });

        clearBoardButton = (Button) findViewById(R.id.clearBoardButton);
        clearBoardButton.setEnabled(false);
        clearBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearBoard();
            }
        });
    }
}