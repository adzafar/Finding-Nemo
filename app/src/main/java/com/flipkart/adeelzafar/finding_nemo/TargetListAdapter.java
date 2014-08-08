package com.flipkart.adeelzafar.finding_nemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by adeel.zafar on 08/08/14.
 */
public class TargetListAdapter extends ArrayAdapter<TargetModel> {
    private final ArrayList<TargetModel> values;
    private final Context context;
    private boolean isAvailableList;

    public TargetListAdapter(Context context, int resourceId, ArrayList<TargetModel> values) {
        super(context, resourceId, values);
        this.values = values;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.list_item_view, parent,false);
        TextView icon = (TextView)rowView.findViewById(R.id.list_icon);
        TextView text = (TextView)rowView.findViewById(R.id.list_text);

        if(isAvailableList())
            icon.setText("X");
        else
            icon.setText("+");

        text.setText(values.get(position).getPhoneName());

        if(values.get(position).isPermanent())
            text.setTextColor(context.getResources().getColor(R.color.Green));
        else
            text.setTextColor(context.getResources().getColor(R.color.Blue));

        return rowView;
    }

    public boolean isAvailableList() {
        return isAvailableList;
    }

    public void setAvailableList(boolean isAvailableList) {
        this.isAvailableList = isAvailableList;
    }

}
