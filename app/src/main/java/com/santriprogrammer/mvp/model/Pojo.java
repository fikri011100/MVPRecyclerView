package com.santriprogrammer.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 9/28/17.
 */

public class  Pojo {

  /**
   * data : [{"id_cat":"1","nama_cat":"Makanan","image_cat":"food.jpg"},{"id_cat":"2","nama_cat":"Minuman","image_cat":"drink.png"},{"id_cat":"3","nama_cat":"Sambal","image_cat":"chili.jpg"},{"id_cat":"4","nama_cat":"Makanan Ringan","image_cat":"snack.png"}]
   * result : 1
   * msg : semua data kategori
   */

  private int result;
  private String msg;
  private List<DataBean> data;

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<DataBean> getData() {
    return data;
  }

  public void setData(List<DataBean> data) {
    this.data = data;
  }

  public static class DataBean implements Parcelable{

    /**
     * id_cat : 1
     * nama_cat : Makanan
     * image_cat : food.jpg
     */

    private String id_cat;
    private String nama_cat;
    private String image_cat;

    protected DataBean(Parcel in) {
      id_cat = in.readString();
      nama_cat = in.readString();
      image_cat = in.readString();
    }

    public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
      @Override
      public DataBean createFromParcel(Parcel in) {
        return new DataBean(in);
      }

      @Override
      public DataBean[] newArray(int size) {
        return new DataBean[size];
      }
    };

    public String getId_cat() {
      return id_cat;
    }

    public void setId_cat(String id_cat) {
      this.id_cat = id_cat;
    }

    public String getNama_cat() {
      return nama_cat;
    }

    public void setNama_cat(String nama_cat) {
      this.nama_cat = nama_cat;
    }

    public String getImage_cat() {
      return image_cat;
    }

    public void setImage_cat(String image_cat) {
      this.image_cat = image_cat;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
      parcel.writeString(id_cat);
      parcel.writeString(nama_cat);
      parcel.writeString(image_cat);
    }
  }
}
