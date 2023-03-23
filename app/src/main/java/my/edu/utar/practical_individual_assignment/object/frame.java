package my.edu.utar.practical_individual_assignment.object;

import java.util.Random;

public class frame {
    public int column=8;
    public int all=7;
    public String colorChange="#FF0000";
    public String colorHighlighted="#FA5858";

    private String arrColorChange[] = new String[]{
            "#1d3557",
            "#283618",
            "#9fa2b2",
            "#4a4e69",
            "#5e3023",
            "#495057",
            "#b56576",
            "#a4133c",
            "#735d78"

    };

    private String arrColorHighlighted[] = new String[]{
            "#457b9d",
            "#606c38",
            "#dbc2cf",
            "#9a8c98",
            "#c08552",
            "#6c757d",
            "#e56b6f",
            "#ff4d6d",
            "#b392ac"
    };

    public int level=1;
    public int timeTimer=5;
    public int timeCountdown=timeTimer*1000;
    public int timeEnd = 300;

    public boolean tapShape=false;

    public void colorLay(){
        Random r = new Random();
        int vt = r.nextInt(arrColorChange.length);
        colorChange=arrColorChange[vt];
        colorHighlighted=arrColorHighlighted[vt];
    }

    public void setLevel(){
        if(level<3){
            column=2;
        }
        else if(level<8){
            column=3;
        }
        else if(level<16){
            column=4;
        }
        else if(level<24){
            column=5;
        }
        else if(level<32){
            column=6;
        }
        else if(level<40){
            column=7;
        }
        else if(level<48){
            column=8;
        }
        else if(level<56){
            column=9;
        }
        else {
            column = 10;
        }
        all=column*column;
    }
}
