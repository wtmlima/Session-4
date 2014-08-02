package com.gdgwomen.session4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hansy on 02/08/2014.
 */
public class DepartmentAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mDepartments;

    public DepartmentAdapter(Context context, ArrayList<String> departments) {
        this.mContext = context;
        this.mDepartments = departments;
    }

    @Override
    public int getCount() {
        return this.mDepartments.size();
    }

    public void addItem(String department) {
        this.mDepartments.add(department);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                this.mContext.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            if (position % 2 == 0) {
                convertView =
                        inflater.inflate(
                                R.layout.list_dep_item_a, null, false);
            } else {
                convertView =
                        inflater.inflate(
                                R.layout.list_dep_item_b, null, false);
            }
        }
        TextView txtItem = (TextView) convertView.findViewById(R.id.txtItem);

        txtItem.setText(this.mDepartments.get(position));
        return convertView;
    }
}
