package com.dharmik953.krishinetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    String urljson = "https://thekrishi.com/test/mandi?lat=28.44108136&lon=77.0526054&ver=89&lang=hi&crop_id=10";
    TextView textView;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Activity 2");
        Button fetch = findViewById(R.id.fetch);
        textView = findViewById(R.id.tv_data);


//        textView.setText("iaeurfhui");
//        final service dataservices = new service(MainActivity2.this);
        EditText cityId = findViewById(R.id.et_city_id);
//        ListView  listView = findViewById(R.id.listview);

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//******************************************************************************************************************************************************************************************************************************************************************************************************************************************


            }
        });

    }


    public class backGrounfTask extends AsyncTask<Void, Void, String>{

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(MainActivity2.this);
            pd.setTitle("Wait!");
            pd.setMessage("Fetching Data...");
            pd.show();

        }

        @Override
        protected String doInBackground(Void... voids) {
            StringBuilder builder = null;

            try {
                URL url = new URL(urljson);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStreamReader reader = new InputStreamReader( connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = " ";

                builder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null){
                    builder.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }



            return builder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();

            try {
                JSONObject obj = new JSONObject(s);
                for (int i = 0; i<obj.length(); i++){
                    JSONObject object = new JSONObject(String.valueOf(i));

                    String district_id = object.getString("district_id");

                    Log.e("district_id",district_id);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}