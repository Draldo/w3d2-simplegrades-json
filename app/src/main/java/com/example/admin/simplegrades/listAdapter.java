package com.example.admin.simplegrades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 8/3/2016.
 */
public class listAdapter extends ArrayAdapter<String> {

    private TextView mTextview;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View myView = inflater.inflate(R.layout.list_item, parent, false);

        mTextview = (TextView) myView.findViewById(R.id.texview_item);
        String str = getItem(position);
        String[] arrStr = str.split("-");

        if(Double.parseDouble(arrStr[1])< 7.0)
            mTextview.setBackgroundResource(R.color.red);

        mTextview.setText(arrStr[0]);

        return  myView;
    }

    public listAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
