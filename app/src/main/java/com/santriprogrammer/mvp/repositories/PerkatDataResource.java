package com.santriprogrammer.mvp.repositories;

import android.support.annotation.NonNull;
import com.santriprogrammer.mvp.model.PojoPerkat;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public interface PerkatDataResource {

  interface PerkatDataCallback {
    void onSuccess(List<PojoPerkat.DataBean> data, String msg);
    void onError(String msg);
    void onDataEmpty(String msg);
  }

  void getPerkatList(String id,@NonNull PerkatDataCallback perkatDataCallback);

}
