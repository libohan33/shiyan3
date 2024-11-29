package com.example.shiyan3;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listView);

        List<Map<String, String>> data = new ArrayList<>();
        Map<String, String> item1 = new HashMap<>();
        item1.put("name", "Lion");
        item1.put("image", String.valueOf(R.drawable.lion));
        data.add(item1);

        Map<String, String> item2 = new HashMap<>();
        item2.put("name", "Tiger");
        item2.put("image", String.valueOf(R.drawable.tiger));
        data.add(item2);

        Map<String, String> item3 = new HashMap<>();
        item3.put("name", "Monkey");
        item3.put("image", String.valueOf(R.drawable.monkey));
        data.add(item3);

        Map<String, String> item4 = new HashMap<>();
        item4.put("name", "Dog");
        item4.put("image", String.valueOf(R.drawable.dog));
        data.add(item4);

        Map<String, String> item5 = new HashMap<>();
        item5.put("name", "Cat");
        item5.put("image", String.valueOf(R.drawable.cat));
        data.add(item5);

        Map<String, String> item6 = new HashMap<>();
        item6.put("name", "Elephant");
        item6.put("image", String.valueOf(R.drawable.elephant));
        data.add(item6);

        String[] from = {"name", "image"};
        int[] to = {R.id.item_name, R.id.item_image};

        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);
            String selectedItem = item.get("name").toString();
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
        });
    }
}