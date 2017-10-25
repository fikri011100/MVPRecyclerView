package com.santriprogrammer.mvp.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.santriprogrammer.mvp.R;
import com.santriprogrammer.mvp.utils.Helper.Movie;

public class Detail extends AppCompatActivity {

  String id, nama, gambar, detail;
  ImageView imgViw;
  TextView txtViw;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    txtViw = (TextView)findViewById(R.id.txtViw);
    imgViw = (ImageView)findViewById(R.id.imgViw);
    id = getIntent().getStringExtra("id");
    nama = getIntent().getStringExtra("nama");
    gambar = getIntent().getStringExtra("gambar");
    detail = getIntent().getStringExtra("isi");
    getSupportActionBar().setTitle(nama);
    txtViw.setText(detail);
    Glide.with(this)
        .load(Movie.GAMBAR + gambar)
        .placeholder(R.mipmap.ic_launcher)
        .into(imgViw);
  }
}
