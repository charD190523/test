package com.example.myfirstapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapplication.model.Cat;
import com.example.myfirstapplication.model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CatAdapter adapter;
    private List<Cat> catList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        catList = new ArrayList<>();
        catList.add(new Cat("Cat 1", R.drawable.cat1));
        catList.add(new Cat("Cat 2", R.drawable.cat1));
        catList.add(new Cat("Cat 3", R.drawable.cat1));
        catList.add(new Cat("Cat 4", R.drawable.cat1));
        catList.add(new Cat("Cat 5", R.drawable.cat1));
        catList.add(new Cat("Cat 6", R.drawable.cat1));

        adapter = new CatAdapter(this, catList);
        recyclerView.setAdapter(adapter);
    }
}