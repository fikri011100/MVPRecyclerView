package com.santriprogrammer.mvp.ui.list;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.santriprogrammer.mvp.R;
import com.santriprogrammer.mvp.model.Pojo;
import com.santriprogrammer.mvp.ui.list.Adapter.ViewHolder;
import com.santriprogrammer.mvp.ui.perkat.PerkatActivity;
import com.santriprogrammer.mvp.utils.Helper.Movie;
import java.util.List;

/**
 * Created by fikriimaduddin on 9/27/17.
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

  Context context;
  List<Pojo.DataBean> data;
  private int lastPosition = -1;

  public Adapter(Context context, List<Pojo.DataBean> data) {
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
    final Pojo.DataBean listitem = data.get(position);
    Glide.with(context)
        .load(Movie.GAMBAR + listitem.getImage_cat())
        .placeholder(R.mipmap.ic_launcher)
        .into(holder.image);
    holder.txtJudul.setText(listitem.getNama_cat());
    holder.constraint.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i = new Intent(view.getContext(), PerkatActivity.class);
        i.putExtra("id",listitem.getId_cat());
        i.putExtra("judul",listitem.getNama_cat());
        view.getContext().startActivity(i);
      }
    });
    setAnimation(holder.itemView, position);
  }
  private void setAnimation(View viewToAnimate, int position)
  {
    // If the bound view wasn't previously displayed on screen, it's animated
    if (position > lastPosition)
    {
      Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
      viewToAnimate.startAnimation(animation);
      lastPosition = position;
    }
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
    ImageView image;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      image = itemView.findViewById(R.id.imgMain);
    }
  }
}
