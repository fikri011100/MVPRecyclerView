package com.santriprogrammer.mvp.ui.list;

import com.santriprogrammer.mvp.base.BasePresenter;
import com.santriprogrammer.mvp.model.Pojo;
import java.util.List;

/**
 * Created by fikriimaduddin on 9/25/17.
 */

public class MainActivityContract {

  public interface View {
    void onSucces(List<Pojo.KategoriBean> data,String msg);
    void onError(String msg);
  }

  public interface Presenter extends BasePresenter<View>{
    void getData();
  }

}
