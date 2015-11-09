package io.kimo.base.v4.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.kimo.base.mvp.example.model.CustomerModel;
import io.kimo.base.v4.example.R;



public class CustomerListAdapter extends BaseAdapter {

    private Context context;
    private List<CustomerModel> data = new ArrayList<>();

    public CustomerListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<CustomerModel> newData) {
        data = newData;
        notifyDataSetChanged();
    }

    public void clearData() {
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CustomerModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomerModel model = getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_example_list, parent, false);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView subtitle = (TextView) convertView.findViewById(R.id.subtitle);

        title.setText(model.getName());
        subtitle.setText(model.getProfession());

        return convertView;
    }
}
