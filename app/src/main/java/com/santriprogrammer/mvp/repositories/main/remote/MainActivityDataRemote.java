package com.santriprogrammer.mvp.repositories.main.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.santriprogrammer.mvp.R;
import com.santriprogrammer.mvp.model.Pojo;
import com.santriprogrammer.mvp.repositories.main.MainActivityDataResource;
import com.santriprogrammer.mvp.utils.Helper;

/**
 * Created by fikriimaduddin on 9/26/17.
 */

public class MainActivityDataRemote implements MainActivityDataResource {

  private Context context;
  private final static String URL = Helper.Movie.BASE_URL + "getkategori.php";

  public MainActivityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getMainActivityList(@NonNull final MainActivityGetCallback mainActivityGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            final Pojo pojoList = new Gson().fromJson(response, Pojo.class);
            if (pojoList == null) {
              mainActivityGetCallback.onDataEmpty(context.getString(R.string.empty_data));
            } else {
              mainActivityGetCallback
                  .onSucces(pojoList.getData(), context.getString(R.string.ada_data));
            }
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        mainActivityGetCallback.onError(String.valueOf(error));
      }
    });
    requestQueue.add(stringRequest);
  }
}