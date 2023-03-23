package my.edu.utar.practical_individual_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;
import my.edu.utar.practical_individual_assignment.adapter.colorPanelAdapter;
import my.edu.utar.practical_individual_assignment.object.colorPanel;
import my.edu.utar.practical_individual_assignment.object.frame;

public class MainActivity extends AppCompatActivity {

    frame Frame = new frame();

    ArrayList<colorPanel> arrcolorPanel = new ArrayList<>();

    GridView gdvLisColorPanel;
    colorPanelAdapter adapter;

    TextView textLevel;
    TextView textTime;
    CountDownTimer cdTimer;

    ImageView imgIconCenter;
    int iconAnimation=R.drawable.icon1;
    boolean conIcon = true;
    boolean isPaused=false;

    ImageButton pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
    }

    private void init(){
        keepLoading();
        adapter=new colorPanelAdapter(this,0,arrcolorPanel);
    }

    private void anhXa(){
        gdvLisColorPanel=findViewById(R.id.gdvLisColorPanel);
        textLevel=findViewById(R.id.textLevel);
        textTime=findViewById(R.id.textTime);
        imgIconCenter=findViewById(R.id.imgIconCenter);
        pauseButton = findViewById(R.id.pauseButton);
    }

    private void setUp(){
        gdvLisColorPanel.setNumColumns(Frame.column);
        gdvLisColorPanel.setAdapter(adapter);
        textLevel.setText(""+Frame.level);
        upDateTime();

        new CountDownTimer(3000,200){

            @Override
            public void onTick(long millisUntilFinished) {
                if(conIcon==true) {
                    if (iconAnimation==R.drawable.icon1) {
                        iconAnimation=R.drawable.icon1;
                    } else {
                        iconAnimation=R.drawable.icon1;
                    }
                    imgIconCenter.setImageResource(iconAnimation);
                }
            }

            @Override
            public void onFinish() {
                conIcon=false;
                //layoutFrame.setBackground(null);
                if(Frame.tapShape==false){
                    start();
                }
                start();
            }
        }.start();
    }

    private void setClick(){
        gdvLisColorPanel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                checkColor(arrcolorPanel.get(position));
            }
        });
    }

    private void checkColor(colorPanel cp){
        if(cp.color.equals(Frame.colorHighlighted)){
            Frame.level++;
            keepLoading();
            upDate();
            Frame.timeCountdown=Frame.timeCountdown+Frame.timeEnd;
            cdTimer.cancel();
            upDateTime();
            conIcon=true;
        }
        else{
            Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
        }
    }

    private void keepLoading(){
        Frame.setLevel();
        Frame.colorLay();
        arrcolorPanel.clear();
        while(arrcolorPanel.size() < Frame.all){
            arrcolorPanel.add(new colorPanel(Frame.colorChange));
        }

        Random r = new Random();
        arrcolorPanel.get(r.nextInt(arrcolorPanel.size())).color=Frame.colorHighlighted;
    }

    private void upDate(){
        adapter.upDate(arrcolorPanel);
        gdvLisColorPanel.setNumColumns(Frame.column);
        textLevel.setText(""+Frame.level);
    }

    private void upDateTime(){
        cdTimer=new CountDownTimer(5000,10){

            @Override
            public void onTick(long millisUntilFinished) {
                Frame.timeCountdown= (int) millisUntilFinished;
                if(Frame.timeCountdown>=0) {
                    int second = Frame.timeCountdown/1000;
//                    int miliSecond = Frame.timeCountdown%1000/10;
                    String times = second+" "+"second";
                    textTime.setText(times);
                }
                else{
                    textTime.setText("TIME OUT");
                }
            }

            @Override
            public void onFinish() {
                textTime.setText("TIME OUT");
                stopTouch();
            }
        }.start();
    }

    private void stopTouch(){
        Frame.tapShape=true;
        gdvLisColorPanel.setOnItemClickListener(null);
            Intent intent = new Intent(this, EndGameActivity.class);
            intent.putExtra("level", Frame.level);
            startActivity(intent);
            finish();
    }

    public void pausableGame(View view) {
        if(!isPaused) {
            isPaused = true;
            pauseButton.setImageDrawable(getResources().getDrawable(
                    R.drawable.resume_button
            ));
            cdTimer.cancel();
            imgIconCenter.clearAnimation();
            gdvLisColorPanel.setOnItemClickListener(null);
        }
        else{
            isPaused=false;
            pauseButton.setImageDrawable(getResources().getDrawable(
                    R.drawable.pause
            ));
            upDateTime();
            gdvLisColorPanel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    checkColor(arrcolorPanel.get(position));
                }
            });
        }
    }

    public void stopPlaying(View view) {
            Intent intent=new Intent(this,EndGameActivity.class);
            intent.putExtra("level", Frame.level);
            startActivity(intent);
            finish();
    }
}