package com.example.proiectdam.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proiectdam.R;
import com.google.android.gms.common.util.Strings;

public class SearchCountriesAdapter extends ArrayAdapter<String> {

    String[] names;
    int[] flags;
    Context mContext;
    String[] capitals;

    public SearchCountriesAdapter(@NonNull Context context, String[] countries, int[] countryImages, String[] capital) {
        super(context, R.layout.search_countries_listview_item);
        this.names = countries;
        this.flags = countryImages;
        this.mContext = context;
        this.capitals = capital;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView ==null) {
            LayoutInflater inflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.search_countries_listview_item,
                    parent, false);
            mViewHolder.mFlag = convertView.findViewById(R.id.search_countries_listview_item_image_v);
            mViewHolder.mName =  convertView.findViewById(R.id.search_countries_listview_item_tv_country);
            mViewHolder.mCapital =  convertView.findViewById(R.id.search_countries_listview_item_tv_capital);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }
            mViewHolder.mFlag.setImageResource(flags[position]);
            mViewHolder.mName.setText(names[position]);
            mViewHolder.mCapital.setText(capitals[position]);

        return convertView;
    }

    static  class ViewHolder{
        ImageView mFlag;
        TextView mName;
        TextView mCapital;
    }
}
