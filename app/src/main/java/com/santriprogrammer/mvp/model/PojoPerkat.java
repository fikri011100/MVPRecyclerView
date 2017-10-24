package com.santriprogrammer.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/2/17.
 */

public class PojoPerkat {

  /**
   * isi : [{"id_isi":"8","id_admin":"1","id_kategori":"8","isi_judul":"1892jkansdk","admin_nama":"admin","kategori_nama":"vbjvjvjh","isi_keterangan":"exemple aja","isi_tgl_upload":"2017-09-11 14:02:17","isi_kunjungan":"0","isi_gambar":"example.png"},{"id_isi":"23","id_admin":"1","id_kategori":"8","isi_judul":"sdfqw","admin_nama":"admin","kategori_nama":"vbjvjvjh","isi_keterangan":"exemple aja","isi_tgl_upload":"2017-09-11 14:02:17","isi_kunjungan":"0","isi_gambar":"example.png"}]
   * status : 1
   * msg : Data Semua Isi
   */

  private String status;
  private String msg;
  private List<IsiBean> isi;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<IsiBean> getIsi() {
    return isi;
  }

  public void setIsi(List<IsiBean> isi) {
    this.isi = isi;
  }

  public static class IsiBean implements Parcelable{

    /**
     * id_isi : 8
     * id_admin : 1
     * id_kategori : 8
     * isi_judul : 1892jkansdk
     * admin_nama : admin
     * kategori_nama : vbjvjvjh
     * isi_keterangan : exemple aja
     * isi_tgl_upload : 2017-09-11 14:02:17
     * isi_kunjungan : 0
     * isi_gambar : example.png
     */

    private String id_isi;
    private String id_admin;
    private String id_kategori;
    private String isi_judul;
    private String admin_nama;
    private String kategori_nama;
    private String isi_keterangan;
    private String isi_tgl_upload;
    private String isi_kunjungan;
    private String isi_gambar;

    protected IsiBean(Parcel in) {
      id_isi = in.readString();
      id_admin = in.readString();
      id_kategori = in.readString();
      isi_judul = in.readString();
      admin_nama = in.readString();
      kategori_nama = in.readString();
      isi_keterangan = in.readString();
      isi_tgl_upload = in.readString();
      isi_kunjungan = in.readString();
      isi_gambar = in.readString();
    }

    public static final Creator<IsiBean> CREATOR = new Creator<IsiBean>() {
      @Override
      public IsiBean createFromParcel(Parcel in) {
        return new IsiBean(in);
      }

      @Override
      public IsiBean[] newArray(int size) {
        return new IsiBean[size];
      }
    };

    public String getId_isi() {
      return id_isi;
    }

    public void setId_isi(String id_isi) {
      this.id_isi = id_isi;
    }

    public String getId_admin() {
      return id_admin;
    }

    public void setId_admin(String id_admin) {
      this.id_admin = id_admin;
    }

    public String getId_kategori() {
      return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
      this.id_kategori = id_kategori;
    }

    public String getIsi_judul() {
      return isi_judul;
    }

    public void setIsi_judul(String isi_judul) {
      this.isi_judul = isi_judul;
    }

    public String getAdmin_nama() {
      return admin_nama;
    }

    public void setAdmin_nama(String admin_nama) {
      this.admin_nama = admin_nama;
    }

    public String getKategori_nama() {
      return kategori_nama;
    }

    public void setKategori_nama(String kategori_nama) {
      this.kategori_nama = kategori_nama;
    }

    public String getIsi_keterangan() {
      return isi_keterangan;
    }

    public void setIsi_keterangan(String isi_keterangan) {
      this.isi_keterangan = isi_keterangan;
    }

    public String getIsi_tgl_upload() {
      return isi_tgl_upload;
    }

    public void setIsi_tgl_upload(String isi_tgl_upload) {
      this.isi_tgl_upload = isi_tgl_upload;
    }

    public String getIsi_kunjungan() {
      return isi_kunjungan;
    }

    public void setIsi_kunjungan(String isi_kunjungan) {
      this.isi_kunjungan = isi_kunjungan;
    }

    public String getIsi_gambar() {
      return isi_gambar;
    }

    public void setIsi_gambar(String isi_gambar) {
      this.isi_gambar = isi_gambar;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
      parcel.writeString(id_isi);
      parcel.writeString(id_admin);
      parcel.writeString(id_kategori);
      parcel.writeString(isi_judul);
      parcel.writeString(admin_nama);
      parcel.writeString(kategori_nama);
      parcel.writeString(isi_keterangan);
      parcel.writeString(isi_tgl_upload);
      parcel.writeString(isi_kunjungan);
      parcel.writeString(isi_gambar);
    }
  }
}
