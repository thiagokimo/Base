package io.kimo.base.v7.example.presentation.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.kimo.base.v7.example.R;
import io.kimo.base.v7.example.presentation.mvp.model.ExampleModel;

public class ExampleListAdapter extends BaseAdapter {

    private Context context;
    private List<ExampleModel> data = new ArrayList<>();

    public ExampleListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ExampleModel> newData) {
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
    public ExampleModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ExampleModel model = getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_example_list, parent, false);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView subtitle = (TextView) convertView.findViewById(R.id.subtitle);

        title.setText(model.getName());
        subtitle.setText(model.getModelId()+"");

        return convertView;
    }
}
