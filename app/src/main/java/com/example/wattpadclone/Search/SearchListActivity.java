package com.example.wattpadclone.Search;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.Detalts.ActivityBookDetails;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class SearchListActivity extends AppCompatActivity {
    ListView lv;
    Adapter.ListViewBaseAdapter adapter;
    ArrayList<Book> arr_bean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        Toolbar toolbar = findViewById(R.id.toolbar_search_list);
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lv = findViewById(R.id.listview);
        arr_bean = new ArrayList<>();
        adapter=new Adapter.ListViewBaseAdapter(arr_bean,this);
        lv.setAdapter(adapter);

        WebServices webServices = new WebServices(this);
        webServices.GetDataList("http://tranquangdang.000webhostapp.com/index.php", arr_bean,adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SearchListActivity.this, ActivityBookDetails.class);
                startActivity(intent);
            }
        });
    }

}