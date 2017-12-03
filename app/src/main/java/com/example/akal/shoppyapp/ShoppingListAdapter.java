package com.example.akal.shoppyapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

public class ShoppingListAdapter extends ArrayAdapter<ShoppingItem> implements Filterable {
    Context context;
    private List<ShoppingItem> mOriginalValues; // Original Values
    private List<ShoppingItem> mDisplayedValues;    // Values to be displayed
    LayoutInflater inflater;
    public ShoppingListAdapter(Context context, List<ShoppingItem> items){
        super(context, 0, items);
        this.context = context;
        this.mOriginalValues = items;
        this.mDisplayedValues = items;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        ShoppingItem currentItem = getItem(position);
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
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {

                mDisplayedValues = (List<ShoppingItem>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                List<ShoppingItem> FilteredArrList = new ArrayList<>();

                if (mOriginalValues == null) {
                    mOriginalValues = new ArrayList<ShoppingItem>(mDisplayedValues); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = mOriginalValues.size();
                    results.values = mOriginalValues;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < mOriginalValues.size(); i++) {
                        String data = mOriginalValues.get(i).name;
                        if (data.toLowerCase().startsWith(constraint.toString())) {
                            FilteredArrList.add(new ShoppingItem(mOriginalValues.get(i).name));
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }
}
