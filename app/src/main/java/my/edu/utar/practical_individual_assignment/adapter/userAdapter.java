package my.edu.utar.practical_individual_assignment.adapter;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import my.edu.utar.practical_individual_assignment.Databases.UserTable;
import my.edu.utar.practical_individual_assignment.Helper.DatabasesHelper;
import my.edu.utar.practical_individual_assignment.R;

public class userAdapter extends RecyclerView.Adapter<userAdapter.ViewHolder> {
    Context context;
    List<UserTable> userTableList;
    View view;

    DatabasesHelper helper;

    public userAdapter(Context context){
        this.context=context;
    }

    public userAdapter(Context context, List<UserTable> userTableList){
        this.context = context;
        this.userTableList=userTableList;

        helper=DatabasesHelper.getInstance(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view=LayoutInflater.from(context).inflate(R.layout.rv_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(userTableList!=null&&userTableList.size()>0){
            UserTable userTable=userTableList.get(position);
//            holder.roll_no.setText(String.valueOf(userTable.getId()));
            holder.user_name.setText(userTable.getUser_name());
            holder.user_level.setText(userTable.getUser_level());
        }
    }

    @Override
    public int getItemCount() {
        return userTableList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView user_name,user_level;
        ImageView more_iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            roll_no=itemView.findViewById(R.id.roll_no);
            user_name=itemView.findViewById(R.id.user_name);
            user_level=itemView.findViewById(R.id.user_level);
        }
    }
}
