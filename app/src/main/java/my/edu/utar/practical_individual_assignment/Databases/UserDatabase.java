package my.edu.utar.practical_individual_assignment.Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={UserTable.class},version=1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
}
