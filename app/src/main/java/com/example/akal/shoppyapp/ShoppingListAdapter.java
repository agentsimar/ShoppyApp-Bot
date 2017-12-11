package com.example.akal.shoppyapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akal on 10-11-2017.
 */

public class ShoppingListAdapter extends BaseAdapter implements Filterable {
    Context context;
    LayoutInflater inflater;
    ArrayList<ShoppingItem> items;
    CustomFilter filter;
    ArrayList<ShoppingItem> filteritems;
    public ShoppingListAdapter(Context context, List<ShoppingItem> items){
        super();
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.items = (ArrayList<ShoppingItem>) items;
        this.filteritems = (ArrayList<ShoppingItem>) items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.indexOf(getItem(i));
    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if (listItemView == null){
            listItemView = inflater.inflate(R.layout.list_item , null);
        }
        ShoppingItem currentItem = (ShoppingItem) getItem(i);
        ImageView img = listItemView.findViewById(R.id.itemIcon);
        Picasso.with(getContext())
                .load(context.getApplicationContext().getString(R.string.ip)
                        + String.valueOf(currentItem.getProductID())
                        + ".jpg")
                .fit().centerCrop()
                .into(img);

        TextView name = (TextView) listItemView.findViewById(R.id.itemName);
        name.setText(currentItem.getTitle());

        TextView description = (TextView) listItemView.findViewById(R.id.itemDescription);
        description.setText(currentItem.getDescription());

        TextView cost = (TextView) listItemView.findViewById(R.id.itemPrice);
        cost.setText(currentItem.getPrice());
        return listItemView;
    }


    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new CustomFilter();
        }
        return filter;
    }

    public Context getContext() {
        return context;
    }

    class CustomFilter extends Filter{


        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            if(constraint != null && constraint.length()>0){
                constraint = constraint.toString().toUpperCase();

                ArrayList<ShoppingItem> filters = new ArrayList<ShoppingItem>();

                for(int i=0; i<filteritems.size(); i++){
                    if(filteritems.get(i).getTitle().toUpperCase().contains(constraint)){
                        ShoppingItem item = new ShoppingItem(filteritems.get(i).getTitle());

                        filteritems.add(item);
                    }
                }
                results.count = filters.size();
                results.values = filters;

            }else {
                results.count = filteritems.size();
                results.values = filteritems;


            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            items = (ArrayList<ShoppingItem>) results.values;
            notifyDataSetChanged();

        }
    }
}
