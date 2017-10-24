package com.santriprogrammer.mvp.repositories;

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
import com.santriprogrammer.mvp.model.PojoPerkat;
import com.santriprogrammer.mvp.utils.Helper.Movie;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public class PerkatDataRemote implements PerkatDataResource {

  private Context c;
  private final static String URL = Movie.BASE_URL + "getTbIsiPerKategori.php";

  public PerkatDataRemote(Context c) {
    this.c = c;
  }

  @Override
  public void getPerkatList(final String id,@NonNull final PerkatDataCallback perkatDataCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(c);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL),
        new Listener<String>() {
          @Override
          public void onResponse(String response) {
            System.out.println(response);
            final PojoPerkat pojoList = new Gson().fromJson(response, PojoPerkat.class);
            if (pojoList == null) {
              perkatDataCallback.onDataEmpty(c.getString(R.string.empty_data));
            } else {
              perkatDataCallback
                  .onSuccess(pojoList.getIsi(), c.getString(R.string.ada_perkat));
            }
          }
        }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        perkatDataCallback.onError(String.valueOf(error));
      }
    }) {
      @Override
      protected Map<String, String> getParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_kategori", id);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
