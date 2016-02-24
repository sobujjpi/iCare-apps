package com.brittolab.icare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.brittolab.icare.Database.UserProfileTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mamun on 1/17/16.
 */
public class ArrayAdapterForUserList extends ArrayAdapter<UserProfileTable> {



    public ArrayAdapterForUserList(Context context, ArrayList<UserProfileTable> objects) {
        super(context, android.R.layout.simple_list_item_activated_1, objects);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder = null;
        UserProfileTable userProfileTable = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_activated_1, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvUserName = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.tvUserName.setText(userProfileTable.getUserName());



        return convertView;

    }

    private static class ViewHolder{
        TextView tvUserName;
    }
}
