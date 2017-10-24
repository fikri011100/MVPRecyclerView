package com.santriprogrammer.mvp.ui.list;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.santriprogrammer.mvp.model.PojoBaru;
import com.santriprogrammer.mvp.repositories.MainRepoInject;
import com.santriprogrammer.mvp.ui.list.MainActivityContract.View;
import com.santriprogrammer.mvp.R;
import com.santriprogrammer.mvp.model.Pojo;
import com.santriprogrammer.mvp.model.Pojo.KategoriBean;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View {

  @BindView(R.id.recMain)
  RecyclerView rvMVP;
  MainActivityPresenter mainActivityPresenter;
  Adapter adapter;
  ArrayList<PojoBaru.DataBean> resultItem;
  private static final String simpan = "simpan";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mainActivityPresenter = new MainActivityPresenter(
        MainRepoInject.provideToMainRepo(getApplicationContext()));
    mainActivityPresenter.onAttachView(this);

    resultItem = new ArrayList<>();
    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
      rvMVP.setLayoutManager(new LinearLayoutManager(this));
    }else {
      rvMVP.setLayoutManager(new GridLayoutManager(this, 5));
    }
//    rvMVP.setLayoutManager(new LinearLayoutManager(this));
    adapter = new Adapter(MainActivity.this, resultItem);
    rvMVP.setAdapter(adapter);
    if (savedInstanceState != null){
      ArrayList<PojoBaru.DataBean> resultArray = savedInstanceState.getParcelableArrayList(simpan);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      adapter.notifyDataSetChanged();
    }else{
      mainActivityPresenter.getData();
    }

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(simpan, resultItem);
  }

  @Override
  public void onSucces(List<PojoBaru.DataBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
  }

  @Override
  public void onError(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }
}
