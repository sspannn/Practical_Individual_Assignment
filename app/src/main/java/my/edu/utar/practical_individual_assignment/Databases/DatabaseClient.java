package my.edu.utar.practical_individual_assignment.Databases;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;

public class DatabaseClient {

    Context context;
    static DatabaseClient client;
    UserDatabase userDatabase;

    public DatabaseClient(Context context){
        this.context=context;

        userDatabase= Room.databaseBuilder(context,UserDatabase.class,"UserDatabase").build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if(client==null){
            client=new DatabaseClient(context);
        }
        return client;
    }

    public UserDatabase getUserDatabase(){
        return userDatabase;
    }
}
