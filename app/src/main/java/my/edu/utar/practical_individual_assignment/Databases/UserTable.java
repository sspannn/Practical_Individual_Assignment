package my.edu.utar.practical_individual_assignment.Databases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserTable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="user_name")
    private String user_name;

    @ColumnInfo(name="user_level")
    private String user_level;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_name(String user_name){
        this.user_name=user_name;
    }

    public String getUser_level(){
        return user_level;
    }

    public void setUser_level(String user_level){
        this.user_level=user_level;
    }

    @Override
    public String toString(){
        return "UserTable{" +
                ", user_name='" + user_name + '\'' +
                ", user_level='" + user_level + '\'' +
                '}';
    }
}
