package my.edu.utar.practical_individual_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import my.edu.utar.practical_individual_assignment.Databases.UserTable;
import my.edu.utar.practical_individual_assignment.Helper.DatabasesHelper;

public class saveScore extends AppCompatActivity {

    EditText userName, userLevel;
    DatabasesHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_score);
        helper=DatabasesHelper.getInstance(this);

        userName=findViewById(R.id.userName);
        userLevel=findViewById(R.id.userLevel);
    }

    public void saveData(View view){
        if(!userName.getText().toString().isEmpty() && !userLevel.getText().toString().isEmpty()){
            helper.addNewUser(userName.getText().toString(),userLevel.getText().toString());
        }
    }

    public void showData(View view){
        startActivity(new Intent(this, scoreActivity.class));
    }

}