package com.example.qappjason;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.List;

public class OpenByVolumeActivity extends AppCompatActivity {
    private ListView volumeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_by_volume);

        volumeListView = findViewById(R.id.volume_list_view);

        InputStream inputStream = getResources().openRawResource(R.raw.metadata);
        MetaDataParser metaDataParser = new MetaDataParser(inputStream);
        List<String> volumeNames = metaDataParser.getVolumeNames();

        ArrayAdapter<String> volumeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, volumeNames);
        volumeListView.setAdapter(volumeAdapter);
    }
}
