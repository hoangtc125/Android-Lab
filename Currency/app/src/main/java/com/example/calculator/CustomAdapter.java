package com.example.calculator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Activity context;
    private LayoutInflater layoutInflater;
    private List<Currency> list;
    private int listItemLayoutResource;

    public CustomAdapter(Activity context, List<Currency> list, int listItemLayoutResource) {
        this.context = context;
        this.layoutInflater = context.getLayoutInflater();
        this.list = list;
        this.listItemLayoutResource = listItemLayoutResource;
    }

    @Override
    public int getCount() {
        if(this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    @Override
    public Object getItem(int i) {
        if(this.list == null) {
            return null;
        }
        return this.list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Currency currency = this.list.get(i);
//        View rowView = this.layoutInflater.inflate(this.listItemLayoutResource, null, true);
//        TextView countryView = rowView.findViewById(R.id.textView_item_name);
//        TextView donviView = rowView.findViewById(R.id.textView_item_percent);
//        countryView.setText(currency.getCountry());
//        donviView.setText(currency.getDonvi());
        MyViewHolder myViewHolder;
        if(view == null) {
            view = layoutInflater.from(this.context).inflate(this.listItemLayoutResource, null);
            myViewHolder = new MyViewHolder();
            myViewHolder.country = view.findViewById(R.id.textView_item_name);
            myViewHolder.donvi = view.findViewById(R.id.textView_item_percent);
            myViewHolder.country.setText(currency.getCountry().toString());
            myViewHolder.donvi.setText(currency.getDonvi().toString());
            view.setTag(myViewHolder);
        } else {
            myViewHolder = (MyViewHolder) view.getTag();
        }
//        myViewHolder.country.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        return view;
    }

    class MyViewHolder {
        private TextView country;
        private TextView donvi;
    }
}
