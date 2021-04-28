package com.example.bk_form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ShowActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Dao dao;
    private C_adapter c_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        init();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        dao = new Dao(this);
        List<Bean> bean = dao.load();

        if (bean.size() > 0) {
            c_adapter = new C_adapter(bean, ShowActivity.this);
            recyclerView.setAdapter(c_adapter);
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void init() {
        recyclerView = findViewById(R.id.recyclerView);
    }
}