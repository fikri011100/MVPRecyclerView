package com.santriprogrammer.mvp.ui.list;


import com.santriprogrammer.mvp.model.Pojo;
import com.santriprogrammer.mvp.repositories.main.MainActivityDataResource.MainActivityGetCallback;
import com.santriprogrammer.mvp.repositories.main.MainActivityRepositories;
import com.santriprogrammer.mvp.ui.list.MainActivityContract.View;
import java.util.List;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

  MainActivityContract.View view;
  private MainActivityRepositories mainActivityRepositories;

  public MainActivityPresenter(
      MainActivityRepositories mainActivityRepositories) {
    this.mainActivityRepositories = mainActivityRepositories;
  }


  @Override
  public void onAttachView(View view) {
    this.view = view;
  }

  @Override
  public void onDettachView() {
  }

  @Override
  public void getData() {
    mainActivityRepositories.getMainActivityList(new MainActivityGetCallback() {
      @Override
      public void onSucces(List<Pojo.DataBean> data,String msg) {
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