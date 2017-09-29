package com.santriprogrammer.mvp.remote;

import android.support.annotation.NonNull;
import com.santriprogrammer.mvp.model.Pojo;
import java.util.List;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public interface MainActivityDataResource {

interface MainActivityGetCallback{
  void onSucces(List<Pojo.KategoriBean> data, String msg);
  void onError(String msg);
  void onDataEmpty(String msg);
}

  void getMainActivityList(@NonNull MainActivityGetCallback mainActivityGetCallback);
}
