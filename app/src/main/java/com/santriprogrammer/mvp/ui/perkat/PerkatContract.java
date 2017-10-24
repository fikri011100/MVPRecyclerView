package com.santriprogrammer.mvp.ui.perkat;

import com.santriprogrammer.mvp.base.BasePresenter;
import com.santriprogrammer.mvp.model.PojoPerkat;
import com.santriprogrammer.mvp.ui.list.MainActivityContract.View;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public class PerkatContract {

  public interface PerkatView {
    void perkatSuccess(List<PojoPerkat.IsiBean> data, String msg);
    void perkatError(String msg);
  }
  public interface PerkatPresenter extends BasePresenter<PerkatView>{
    void getPerkat(String id);
  }

}
