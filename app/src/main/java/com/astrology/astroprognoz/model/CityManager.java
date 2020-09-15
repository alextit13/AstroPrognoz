package com.astrology.astroprognoz.model;

import android.content.Context;

import com.astrology.astroprognoz.view.base.App;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class CityManager {
    public void getStateJson() throws JSONException {
        String json = null;
        try {
            Context context = Objects.requireNonNull(App.getInstance()).getApplicationContext();
            InputStream inputStream = context.getAssets().open("states.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

            System.out.println("dfsdfs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
