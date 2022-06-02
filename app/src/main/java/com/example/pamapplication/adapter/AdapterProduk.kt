package com.example.pamapplication.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pamapplication.helper.Helper


import com.google.gson.Gson
import com.example.pamapplication.R
import com.example.pamapplication.activity.DetailProdukActivity
import com.example.pamapplication.model.Produk
import com.example.pamapplication.util.Config
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class AdapterProduk(var activity: Activity, var data:ArrayList<Produk>):RecyclerView.Adapter<AdapterProduk.Holder>() {
    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)
        val imgProduk = view.findViewById<ImageView>(R.id.img_produk)
        val layout = view.findViewById<CardView>(R.id.layout_utama)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].name
        holder.tvHarga.text = Helper().gantiRupiah(data[position].harga)
        val image = "http://192.168.100.7/web pam/toko/public/images/" + data[position].image
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.gbr_makanan)
            .error(R.drawable.gbr_makanan)
            .into(holder.imgProduk)

        holder.layout.setOnClickListener {
            val intentvity = Intent(activity, DetailProdukActivity::class.java)

            val str = Gson().toJson(data[position], Produk::class.java)
            intentvity.putExtra("extra", str)

            activity.startActivity(intentvity)
        }
    }
}






















