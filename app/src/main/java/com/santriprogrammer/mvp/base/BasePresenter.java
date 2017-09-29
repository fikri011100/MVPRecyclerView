package com.santriprogrammer.mvp.base;

/**
 * Created by fikriimaduddin on 9/28/17.
 */

public interface BasePresenter<T> {
  void onAttachView(T view);
  void onDettachView();
}
