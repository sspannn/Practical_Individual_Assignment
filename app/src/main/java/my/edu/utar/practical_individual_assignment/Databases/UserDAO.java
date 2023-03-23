package my.edu.utar.practical_individual_assignment.Databases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    //For inserting Data
    @Insert
    void insertData(UserTable userTable);

    //For getting all Data
    @Query("SELECT * FROM userTable")
    List<UserTable> selectAll();
}
