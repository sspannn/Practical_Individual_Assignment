package my.edu.utar.practical_individual_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import my.edu.utar.practical_individual_assignment.object.frame;

public class startGameActivity extends AppCompatActivity {

    frame Frame = new frame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
    }

    public void newGame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void viewScore(View view){
        Intent intent = new Intent(this, scoreActivity.class);
        intent.putExtra("level", Frame.level);
        startActivity(intent);
        finish();
    }

    public void readMe(View view){
        Intent intent = new Intent(this, readMe.class);
        startActivity(intent);
        finish();
    }

    public void exitGame(View view){
        finish();
    }
}