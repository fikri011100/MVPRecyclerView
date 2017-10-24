package com.santriprogrammer.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/24/17.
 */

public class PojoBaru {

  /**
   * data : [{"id_fasilitas":"6","fasilitas":"Mouse Gaming","gambar":"Android-Volley.jpg","isi":"10"},{"id_fasilitas":"7","fasilitas":"Razer","gambar":"mathimage.jpg","isi":"9"}]
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
     * id_fasilitas : 6
     * fasilitas : Mouse Gaming
     * gambar : Android-Volley.jpg
     * isi : 10
     */

    private String id_fasilitas;
    private String fasilitas;
    private String gambar;
    private String isi;

    protected DataBean(Parcel in) {
      id_fasilitas = in.readString();
      fasilitas = in.readString();
      gambar = in.readString();
      isi = in.readString();
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

    public String getId_fasilitas() {
      return id_fasilitas;
    }

    public void setId_fasilitas(String id_fasilitas) {
      this.id_fasilitas = id_fasilitas;
    }

    public String getFasilitas() {
      return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
      this.fasilitas = fasilitas;
    }

    public String getGambar() {
      return gambar;
    }

    public void setGambar(String gambar) {
      this.gambar = gambar;
    }

    public String getIsi() {
      return isi;
    }

    public void setIsi(String isi) {
      this.isi = isi;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
      parcel.writeString(id_fasilitas);
      parcel.writeString(fasilitas);
      parcel.writeString(gambar);
      parcel.writeString(isi);
    }
  }
}
