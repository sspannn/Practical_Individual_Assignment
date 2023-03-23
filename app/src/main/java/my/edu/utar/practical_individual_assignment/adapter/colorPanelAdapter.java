package my.edu.utar.practical_individual_assignment.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import my.edu.utar.practical_individual_assignment.R;
import my.edu.utar.practical_individual_assignment.object.ImgCustom;
import my.edu.utar.practical_individual_assignment.object.colorPanel;


public class colorPanelAdapter extends ArrayAdapter<colorPanel> {
    private Context cont;
    private ArrayList<colorPanel> arrcolorPanel;

    public colorPanelAdapter(@NonNull Context context, int resource, @NonNull List<colorPanel> objects) {
        super(context, resource, objects);
        this.cont = context;
        this.arrcolorPanel = new ArrayList<>(objects);
    }

    public void upDate(ArrayList<colorPanel> arr){
        this.arrcolorPanel.clear();
        this.arrcolorPanel.addAll(arr);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrcolorPanel.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_colorpanel, null);
        }
        if(arrcolorPanel.size()>0){
            colorPanel cp = arrcolorPanel.get(position);
            ImgCustom imgCustom = convertView.findViewById(R.id.imgColorPanel);
            imgCustom.setColorFilter(Color.parseColor(cp.color));
        }

        return convertView;
    }
}
