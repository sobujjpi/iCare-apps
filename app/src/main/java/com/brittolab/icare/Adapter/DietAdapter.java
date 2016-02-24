package com.brittolab.icare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brittolab.icare.Database.DietInfoTable;
import com.brittolab.icare.R;

import java.util.List;
import java.util.Objects;


public class DietAdapter extends BaseAdapter {

    private List<DietInfoTable> mItems;
    private LayoutInflater mInflater;

    public DietAdapter(Context context, List<DietInfoTable> listDietInfoTable) {
        this.setItems(listDietInfoTable);
        this.mInflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return (getItems() != null && !getItems().isEmpty()) ? getItems().size() : 0 ;
    }

    @Override
    public DietInfoTable getItem(int position) {
        return (getItems() != null && !getItems().isEmpty()) ? getItems().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return (getItems() != null && !getItems().isEmpty()) ? getItems().get(position).getDietId() : position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if(v == null) {
            v = mInflater.inflate(R.layout.diet_chart, parent, false);
            holder = new ViewHolder();
            holder.breakfastTV=(TextView)v.findViewById(R.id.breakfastTV);
            holder.txtMenu=(TextView)v.findViewById(R.id.txtMenu);
            holder.txtTime=(TextView)v.findViewById(R.id.txtTime);
            holder.txDate = (TextView)v.findViewById(R.id.txtDate);

            v.setTag(holder);
        }
        else {
            holder = (ViewHolder) v.getTag();
        }

        // fill row data
        DietInfoTable currentItem = getItem(position);
        if(currentItem != null) {
            holder.breakfastTV.setText(currentItem.getDietType());
            holder.txtMenu.setText(currentItem.getFoodMenu());
            holder.txtTime.setText(currentItem.getAlermTime());
            holder.txDate.setText(currentItem.getAlermDate());
        }

        return v;
    }

    public List<DietInfoTable> getItems() {
        return mItems;
    }

    public void setItems(List<DietInfoTable> mItems) {
        this.mItems = mItems;
    }

    class ViewHolder {
        TextView breakfastTV,txtMenu,txtTime,txDate;

    }

}
