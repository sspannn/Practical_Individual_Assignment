package my.edu.utar.practical_individual_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import my.edu.utar.practical_individual_assignment.Databases.UserTable;
import my.edu.utar.practical_individual_assignment.Helper.DatabasesHelper;
import my.edu.utar.practical_individual_assignment.adapter.userAdapter;

public class scoreActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    userAdapter UAdapter;
    DatabasesHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        helper=DatabasesHelper.getInstance(this);

        recycler_view=findViewById(R.id.recycler_view);

        helper.getAllUserData();
    }

    public void setRecycler_view(List<UserTable> userTableList){
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        UAdapter = new userAdapter(this, userTableList);
        recycler_view.setAdapter(UAdapter);
    }

    public void backHome(View view){
        Intent intent=new Intent(this,startGameActivity.class);
        startActivity(intent);
        finish();
    }
}