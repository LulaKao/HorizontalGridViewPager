package com.shiaopin.horizontalgridviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.van.gplibrary.adapter.GridViewAdapter;
import java.util.List;

public class ProductAdapter extends GridViewAdapter<ProductModel> {
    private Context context;

    //========= ProductListAdapter START =========//
    public ProductAdapter(Context context, List<ProductModel> productList, int resId) {
        super(context, productList, resId);
        this.context = context;
    }
    //========= HomeProductAdapter END =========//

    //========= getView START =========//
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) { // if View didn't create
            // inflate Layout
            convertView = LayoutInflater.from(mContext).inflate(resId, null);

            // initial View
            viewHolder.item_img = convertView.findViewById(R.id.item_img);
            viewHolder.item_title = convertView.findViewById(R.id.item_title);
            viewHolder.item_container = convertView.findViewById(R.id.item_container);

            // set view
            convertView.setTag(viewHolder);

        } else { // if View is exist

            // get view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // set data
        viewHolder.item_title.setText(mData.get(position).getItem_title()); // set title
        viewHolder.item_img.setImageResource(mData.get(position).getItem_img()); // set image

        // setOnClickListener
        viewHolder.item_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "position = " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
    //========= getView END =========//

    //========= ViewHolder START =========//
    class ViewHolder {
        ImageView item_img;
        TextView item_title;
        LinearLayout item_container;
    }
    //========= ViewHolder END =========//
}
