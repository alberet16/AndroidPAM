package com.example.pamapplication.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "keranjang")
public class Produk implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int idTb;
    public int id;
    public String name;
    public String harga;
    public String deskripsi;
    public int category_id;
    public String image;
    public String created_at;
    public String updated_at;
    public int jumlah = 1;
    public boolean selected = true;
}

