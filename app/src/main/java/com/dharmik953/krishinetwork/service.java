package com.dharmik953.krishinetwork;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class service {
    final private Context context;
    String cityId;
    private String URl = "https://thekrishi.com/test/mandi?lat=28.44108136&lon=77.0526054&ver=89&lang=hi&crop_id=10/";

    public service(Context context) {
        this.context = context;
    }

    public interface FetchById{

        void onError(String message);

        void onResponse(List<model> weatherReportModels);
    }

    public void GetDataById(String cityId, FetchById fetchById){
        final List<model> models = new ArrayList<>();

        String url = URl + cityId ;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray consolidated_weather_list = response.getJSONArray("other_mandi");

                        model one_day = new model();
                        JSONObject first_day_from_api = (JSONObject) consolidated_weather_list.get(1);
                        one_day.setId(first_day_from_api.getInt("id"));
                        one_day.setCrop_id(first_day_from_api.getInt("crop_id"));
                        one_day.setDistrict(first_day_from_api.getString("district"));
                        one_day.setHindi_name(first_day_from_api.getString("hindi_name"));
                        one_day.setDistrict_id(first_day_from_api.getInt("district_id"));
                        one_day.setImage(first_day_from_api.getString("image"));
                        one_day.setKm(first_day_from_api.getLong("km"));
                        one_day.setLast_date(first_day_from_api.getString("last_date"));
                        one_day.setLat(first_day_from_api.getLong("lat"));
                        one_day.setLng(first_day_from_api.getLong("lng"));
                        one_day.setLocation(first_day_from_api.getString("location"));
                        one_day.setMarket(first_day_from_api.getString("market"));
                        one_day.setMeters(first_day_from_api.getString("market"));
                        one_day.setState(first_day_from_api.getString("state"));
                        one_day.setLocaurl_strtion(first_day_from_api.getString("url_str"));
                        models.add(one_day);

                    fetchById.onResponse(models);
                } catch (JSONException e) {
                    Toast.makeText(context, "error in catch on response by id", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                fetchById.onError("Some thing went wrong");
            }
        });
                MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
