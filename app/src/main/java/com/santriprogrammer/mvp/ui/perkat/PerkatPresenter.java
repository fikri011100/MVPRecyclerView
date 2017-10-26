package com.santriprogrammer.mvp.ui.perkat;

import com.santriprogrammer.mvp.model.PojoPerkat;
import com.santriprogrammer.mvp.repositories.perkat.PerkatDataResource.PerkatDataCallback;
import com.santriprogrammer.mvp.repositories.perkat.PerkatRepositories;
import com.santriprogrammer.mvp.ui.perkat.PerkatContract.PerkatView;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public class PerkatPresenter implements PerkatContract.PerkatPresenter {

  PerkatContract.PerkatView view ;
  private PerkatRepositories repo;

  public PerkatPresenter(PerkatRepositories repo) {
    this.repo = repo;
  }

  @Override
  public void onAttachView(PerkatView view) {
    this.view = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getPerkat(String id) {
    repo.getPerkatList(id,new PerkatDataCallback() {
      @Override
      public void onSuccess(List<PojoPerkat.DataBean> data, String msg) {
        view.perkatSuccess(data,msg);
      }

      @Override
      public void onError(String msg) {

      }

      @Override
      public void onDataEmpty(String msg) {

      }
    });
  }
}
