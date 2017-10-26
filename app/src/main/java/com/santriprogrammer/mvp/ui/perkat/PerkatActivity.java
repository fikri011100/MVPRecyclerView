package com.santriprogrammer.mvp.ui.perkat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.santriprogrammer.mvp.R;
import com.santriprogrammer.mvp.model.PojoPerkat;
import com.santriprogrammer.mvp.repositories.perkat.PerkatRepoInject;
import com.santriprogrammer.mvp.ui.perkat.PerkatContract.PerkatView;
import java.util.ArrayList;
import java.util.List;

public class PerkatActivity extends AppCompatActivity implements PerkatView {


  @BindView(R.id.rv_perkat)
  RecyclerView rvPerkat;
  PerkatPresenter perkatPresenter;
  AdapterPerkat adapter;
  ArrayList<PojoPerkat.DataBean> resultItem;
  String id, nama;
  private static final String simpan = "simpan";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_perkat);
    ButterKnife.bind(this);
    perkatPresenter = new PerkatPresenter(PerkatRepoInject.provideToPerkatRepo(getApplicationContext()));
    perkatPresenter.onAttachView(this);
    id = getIntent().getStringExtra("id");
    nama = getIntent().getStringExtra("judul");
    setTitle(nama);
    resultItem = new ArrayList<>();
    rvPerkat.setLayoutManager(new LinearLayoutManager(this));
    adapter = new AdapterPerkat(PerkatActivity.this, resultItem);
    rvPerkat.setAdapter(adapter);
    if (savedInstanceState != null){
      ArrayList<PojoPerkat.DataBean> resultArray = savedInstanceState.getParcelableArrayList(simpan);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      adapter.notifyDataSetChanged();
    }else{
      perkatPresenter.getPerkat(id);
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(simpan, resultItem);
  }

  @Override
  public void perkatSuccess(List<PojoPerkat.DataBean> data, String msg) {
    resultItem.clear();
    resultItem.addAll(data);
    adapter.notifyDataSetChanged();
  }

  @Override
  public void perkatError(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }
}
