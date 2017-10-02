package com.santriprogrammer.mvp.ui.list;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.santriprogrammer.mvp.ui.detail.Detail;
import com.santriprogrammer.mvp.R;
import com.santriprogrammer.mvp.model.Pojo.KategoriBean;
import com.santriprogrammer.mvp.ui.list.Adapter.ViewHolder;
import com.santriprogrammer.mvp.utils.Helper.Movie;
import java.util.List;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

  Context context;
  List<KategoriBean> data;
  ImageView image;

  public Adapter(Context context, List<KategoriBean> data) {
    this.data = data;
    this.context = context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    final KategoriBean listitem = data.get(position);
    Glide.with(context)
        .load(Movie.GAMBAR + listitem.getKategori_gambar())
        .placeholder(R.mipmap.ic_launcher)
        .into(image);
    holder.txtJudul.setText(listitem.getKategori_nama());
    holder.constraint.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(view.getContext(), Detail.class);
        i.putExtra("id",listitem.getId_kategori());
        i.putExtra("nama",listitem.getKategori_nama());
        i.putExtra("gambar",listitem.getKategori_gambar());
        view.getContext().startActivity(i);
      }
    });
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txtRow)
    TextView txtJudul;
    @BindView(R.id.constraint)
    ConstraintLayout constraint;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      image = (ImageView) itemView.findViewById(R.id.imgMain);
    }
  }
}
