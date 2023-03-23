package my.edu.utar.practical_individual_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import my.edu.utar.practical_individual_assignment.object.frame;

public class EndGameActivity extends AppCompatActivity {

    TextView textLevel;
    int level=0;
    frame Frame = new frame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        init();
        anhXa();
        setUp();
        setClick();
    }

    private void init(){

        level=getIntent().getIntExtra("level",0);

        if(level>=25){
//            new executeDialog(this,Frame.level).show();
            Dialog dialog=new Dialog(this, R.style.DialogStyle);
            dialog.setContentView(R.layout.game_dialog);

            TextView dontSaveBtn = dialog.findViewById(R.id.dontSaveBtn);
            dontSaveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();

            TextView saveNameBtn = findViewById(R.id.saveNameBtn);
            saveNameBtn.setVisibility(View.VISIBLE);
        }
    }

    private void anhXa(){

        textLevel = findViewById(R.id.textLevel);
    }

    private void setUp(){

        textLevel.setText(""+level);
    }

    private void setClick(){

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

    public void goHome(View view){
        Intent intent = new Intent(this, startGameActivity.class);
        intent.putExtra("level", Frame.level);
        startActivity(intent);
        finish();
    }

    public void exitGame(View view){
        finish();
    }

    public void saveName(View view){
        Intent intent = new Intent(this, saveScore.class);
        startActivity(intent);

    }





}