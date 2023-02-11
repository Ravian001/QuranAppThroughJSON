package com.example.qappjason;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetaDataParser {
    private Map<String, List<String>> poemToVolumeMap;
    private List<String> volumeNames;

    public MetaDataParser(InputStream inputStream) {
        poemToVolumeMap = new HashMap<>();
        volumeNames = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(readStream(inputStream));
            JSONArray volumes = jsonObject.getJSONArray("volumes");

            for (int i = 0; i < volumes.length(); i++) {
                JSONObject volume = volumes.getJSONObject(i);
                String volumeName = volume.getString("volumeName");
                volumeNames.add(volumeName);

                JSONArray poems = volume.getJSONArray("poems");
                for (int j = 0; j < poems.length(); j++) {
                    JSONObject poem = poems.getJSONObject(j);
                    String poemName = poem.getString("poemName");

                    List<String> volumesForPoem = poemToVolumeMap.get(poemName);
                    if (volumesForPoem == null) {
                        volumesForPoem = new ArrayList<>();
                        poemToVolumeMap.put(poemName, volumesForPoem);
                    }
                    volumesForPoem.add(volumeName);
                }
            }
        } catch (Exception e) {
            // Handle exceptions
        }
    }

    private String readStream(InputStream inputStream) {
        // Code to read the inputStream and return the contents as a String
    return "abc";
    }

    public List<String> getVolumeNames() {
        return volumeNames;
    }

    public Map<String, List<String>> getPoemToVolumeMap() {
        return poemToVolumeMap;
    }
}
