package com.santriprogrammer.mvp.ui.list;


import com.santriprogrammer.mvp.model.Pojo.KategoriBean;
import com.santriprogrammer.mvp.remote.MainActivityDataResource.MainActivityGetCallback;
import com.santriprogrammer.mvp.remote.MainActivityRepositories;
import java.util.List;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

  MainActivityContract.View view;
  private MainActivityRepositories mainActivityRepositories;

  public MainActivityPresenter(MainActivityRepositories mainActivityRepositories) {
    this.mainActivityRepositories = mainActivityRepositories;
  }


  @Override
  public void onAttachView(MainActivityContract.View view) {
    this.view = view;
  }

  @Override
  public void onDettachView() {
  }

  @Override
  public void getData() {
    mainActivityRepositories.getMainActivityList(new MainActivityGetCallback() {
      @Override
      public void onSucces(List<KategoriBean> data,String msg) {
        view.onSucces(data,msg);
      }

      @Override
      public void onError(String msg) {
        view.onError(msg);
      }

      @Override
      public void onDataEmpty(String msg) {
        view.onError(msg);
      }
    });
  }
}

