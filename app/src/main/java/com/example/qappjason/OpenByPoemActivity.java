package com.example.qappjason;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OpenByPoemActivity extends AppCompatActivity {
    private ListView poemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_by_poem);

        poemListView = findViewById(R.id.poem_list_view);

        InputStream inputStream = getResources().openRawResource(R.raw.metadata);
        MetaDataParser metaDataParser = new MetaDataParser(inputStream);
        Map<String, List<String>> poemToVolumeMap = metaDataParser.getPoemToVolumeMap();

        List<String> poemNames = new ArrayList<>(poemToVolumeMap.keySet());

        ArrayAdapter<String> poemAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, poemNames);
        poemListView.setAdapter(poemAdapter);
    }
}
