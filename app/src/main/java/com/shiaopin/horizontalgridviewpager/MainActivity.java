package com.shiaopin.horizontalgridviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.van.gplibrary.weight.GridPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private GridPager gridPager;
    private TextView txt_page;
    private int total_page_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial view
        Button btn_previous = findViewById(R.id.btn_previous);
        Button btn_next = findViewById(R.id.btn_next);
        gridPager = findViewById(R.id.gridViewPager);
        txt_page = findViewById(R.id.txt_page);

        // set OnClickListener
        btn_previous.setOnClickListener(this);
        btn_next.setOnClickListener(this);

        // set data
        List<ProductModel> list = new ArrayList<>();
        for(int i = 0; i < 47; i++){
            list.add(new ProductModel(R.drawable.ic_android, "" + (i + 1)));
        }

        // calculate pages
        double total_page_double = list.size() / 12.0;
        total_page_int = (int) Math.ceil(total_page_double); // unconditional carry

        // page number (current page / total pages)
        txt_page.setText("1/" + total_page_int);

        // set GridPager
        gridPager.setmNumColumn(4); // 4 item / per column
        gridPager.setmPageSize(12); // 12 item / per page
        gridPager.setmVerticalSpacing(10); // set vertical spacing
        gridPager.setmHorizonticalSpacing(10); // set horizontal spacing
        gridPager.setPageMargin(40); // set page margin
        gridPager.setPadding(40,20,40,20); // set gridPager padding
        final ProductAdapter pro_adapter = new ProductAdapter(this, list, R.layout.item_view);
        gridPager.setAdapter(pro_adapter); // 綁定適配器

        // set OnPageChangeListener
        gridPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) { // change page
                // set page number (current page / total pages)
                txt_page.setText((position + 1) + "/" + total_page_int);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_previous){
            if((gridPager.getCurrentItem() + 1) > 1){ // still have previous page
                gridPager.setCurrentItem(gridPager.getCurrentItem() - 1,true); // switch to previous page
            } else { // no previous page
                Toast.makeText(this, "No previous page", Toast.LENGTH_SHORT).show();
            }
        } else { // R.id.btn_next
            if((gridPager.getCurrentItem() + 1) < total_page_int){ // still have next page
                gridPager.setCurrentItem((gridPager.getCurrentItem() + 1),true); // switch to next page
            } else { // no more page
                Toast.makeText(this, "No more page", Toast.LENGTH_SHORT).show();
            }
        }
    }
}