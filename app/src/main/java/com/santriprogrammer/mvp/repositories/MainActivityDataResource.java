package com.santriprogrammer.mvp.repositories;

import android.support.annotation.NonNull;
import com.santriprogrammer.mvp.model.Pojo;
import com.santriprogrammer.mvp.model.PojoBaru;
import java.util.List;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public interface MainActivityDataResource {

interface MainActivityGetCallback{
  void onSucces(List<PojoBaru.DataBean> data, String msg);
  void onError(String msg);
  void onDataEmpty(String msg);
}

  void getMainActivityList(@NonNull MainActivityGetCallback mainActivityGetCallback);
}
