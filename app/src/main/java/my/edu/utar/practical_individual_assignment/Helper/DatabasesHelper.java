package my.edu.utar.practical_individual_assignment.Helper;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import my.edu.utar.practical_individual_assignment.Databases.DatabaseClient;
import my.edu.utar.practical_individual_assignment.Databases.UserTable;
import my.edu.utar.practical_individual_assignment.scoreActivity;

public class DatabasesHelper {

    Context context;

    public DatabasesHelper(Context context){
        this.context=context;
    }

    public static DatabasesHelper getInstance(Context context){
        return new DatabasesHelper(context);
    }

    //Insert Data
    public void addNewUser(String user_name, String user_level){
        class NewUser extends AsyncTask<Void,Void, UserTable>{

            @Override
            protected UserTable doInBackground(Void... voids) {
                UserTable userTable = new UserTable();
                userTable.setUser_name(user_name);
                userTable.setUser_level(user_level);

                DatabaseClient.getInstance(context)
                        .getUserDatabase()
                        .userDAO()
                        .insertData(userTable);
                return userTable;
            }

            @Override
            protected void onPostExecute(UserTable userTable) {
                super.onPostExecute(userTable);
                if(userTable!=null){
                    Toast.makeText(context, userTable.getUser_name() + "\n" + userTable.getUser_level(), Toast.LENGTH_SHORT).show();
                }
            }
        }

        NewUser newUser = new NewUser();
        newUser.execute();
    }

    //Show all data from UserTable
    public void getAllUserData(){
        class AllUser extends AsyncTask<Void,Void,List<UserTable>>{

            @Override
            protected List<UserTable> doInBackground(Void... voids) {
                List<UserTable> list=DatabaseClient.getInstance(context)
                        .getUserDatabase()
                        .userDAO()
                        .selectAll();
                return list;
            }

            @Override
            protected void onPostExecute(List<UserTable> userTables) {
                super.onPostExecute(userTables);
                if(userTables!=null && userTables.size()>0){
                    ((scoreActivity)context).setRecycler_view(userTables);
                }
            }
        }

        AllUser allUser = new AllUser();
        allUser.execute();
    }
}
