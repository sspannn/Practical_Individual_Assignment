package my.edu.utar.practical_individual_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class readMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_me);
    }

    public void backHome(View view){
        Intent intent=new Intent(this,startGameActivity.class);
        startActivity(intent);
        finish();
    }
}