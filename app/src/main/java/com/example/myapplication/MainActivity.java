package com.example.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Api_Client api = new Api_Client("api_key",
            "api_secret");
    HashMap<String, String> rgParams = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgParams.put("order_currency", "BTC");
        rgParams.put("payment_currency", "KRW");
        test(api,rgParams);
    }
    private void test(Api_Client api, HashMap<String, String> rgParams ) {
        try {
            String result = api.callApi("/info/balance", rgParams);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
/*
class RetrieveFeedTask extends AsyncTask<String, String, String> {



    private void test(Api_Client api, HashMap<String, String> rgParams ) {
        try {
            String result = api.callApi("/info/balance", rgParams);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void onPostExecute(String feed) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}*/