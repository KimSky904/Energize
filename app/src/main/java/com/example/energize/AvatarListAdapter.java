package com.example.energize;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AvatarListAdapter extends BaseAdapter {

    //avatar icon resource file
    private ImageView imageView;
    //avatar price
    private TextView price;

    private ArrayList<AvatarListItem> listViewItemList  = new ArrayList<AvatarListItem>();


    AvatarListAdapter(){}

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.avatar_listview_item,parent,false);
        }

        imageView = (ImageView) convertView.findViewById(R.id.img_avatar);
        price = (TextView) convertView.findViewById(R.id.avatar_price);

        AvatarListItem listItem = listViewItemList.get(position);

        imageView.setImageResource(listItem.getAvatar());
        price.setText(listItem.getPrice());

        return convertView;
    }

    public void addItem(int image, int price){
        AvatarListItem item = new AvatarListItem();

        item.setPrice(price);
        item.setAvatar(image);

        listViewItemList.add(item);
    }
}
