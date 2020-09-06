package com.example.geedha.placement_with_android;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Getnames extends AsyncTask<String, String, Placement[]> {

    @Override
    protected Placement[] doInBackground(String... params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<Placement> allplacement = new ArrayList<>();
        Placement[] plaObjects = new Placement[0];
        HttpGet httpGet = new HttpGet("https://geedhaapp.herokuapp.com/getplacement");
        String data = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity repEntity = response.getEntity();
            data = EntityUtils.toString(repEntity,"UTF-8");
            Gson gson = new Gson();
            plaObjects = gson.fromJson(data,Placement[].class);



        } catch (IOException e) {
            e.printStackTrace();
        }
        return plaObjects;
    }
}