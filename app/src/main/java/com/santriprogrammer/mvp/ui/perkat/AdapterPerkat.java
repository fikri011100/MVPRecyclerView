package com.santriprogrammer.mvp.ui.perkat;


import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.santriprogrammer.mvp.R;
import com.santriprogrammer.mvp.model.PojoPerkat.IsiBean;
import com.santriprogrammer.mvp.utils.Helper.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public class AdapterPerkat extends RecyclerView.Adapter<AdapterPerkat.ViewHolder> {
  Context context;
  List<IsiBean> data;
  ImageView image;

  public AdapterPerkat(PerkatActivity perkatActivity, ArrayList<IsiBean> resultItem) {
    this.context = perkatActivity;
    this.data = resultItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final IsiBean listitem = data.get(position);
    Glide.with(context)
        .load(Movie.GAMBAR + listitem.getIsi_gambar())
        .placeholder(R.mipmap.ic_launcher)
        .into(image);
    holder.txtJudul.setText(listitem.getIsi_judul());
    Log.i("id", listitem.getId_kategori());
    holder.constraint.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(view.getContext(), PerkatActivity.class);
        i.putExtra("judul",listitem.getIsi_judul());
        i.putExtra("gambar",listitem.getIsi_gambar());
        i.putExtra("detail",listitem.getIsi_keterangan());
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