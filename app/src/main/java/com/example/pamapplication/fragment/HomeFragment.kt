package com.example.pamapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.pamapplication.adapter.AdapterProduk
import com.example.pamapplication.model.ResponModel
import com.example.pamapplication.R
import com.example.pamapplication.adapter.AdapterSlider
import com.example.pamapplication.app.ApiConfig
import com.example.pamapplication.model.Produk
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    lateinit var rvProduk: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        initView(view)
        getProduk()

        return view
    }


    fun displayProduk(){
        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(requireActivity(), listProduk)
        rvProduk.layoutManager = layoutManager


    }

    private var listProduk:ArrayList<Produk> = ArrayList()

    fun getProduk() {

        ApiConfig.instanceRetrofit.getProduk().enqueue(object : Callback<ResponModel> {
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                if(res.success == 1){
                    listProduk = res.produks
                    displayProduk()
                }
            }
        })
    }


    fun initView(view: View){
        vpSlider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)

    }

//    val arrProduk: ArrayList<Produk>get(){
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "Hp Iphone 20"
//        p1.harga = "Rp. 29.000.000"
//        p1.gambar = R.drawable.hp_14_bs749tu
//
//        val p2 = Produk()
//        p2.nama = "Hp Samsung 20"
//        p2.harga = "Rp. 19.000.000"
//        p2.gambar = R.drawable.hp_envy_13_aq0019tx
//
//        val p3 = Produk()
//        p3.nama = "Hp Lenovo A33"
//        p3.harga = "Rp. 9.000.000"
//        p3.gambar = R.drawable.hp_notebook_14_bs709tu
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//
//        return arr
//    }

//    val arrElektronik: ArrayList<Produk>get(){
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "Hp Iphone 20"
//        p1.harga = "Rp. 29.000.000"
//        p1.gambar = R.drawable.hp_14_bs749tu
//
//        val p2 = Produk()
//        p2.nama = "Hp Samsung 20"
//        p2.harga = "Rp. 19.000.000"
//        p2.gambar = R.drawable.hp_envy_13_aq0019tx
//
//        val p3 = Produk()
//        p3.nama = "Hp Lenovo A33"
//        p3.harga = "Rp. 9.000.000"
//        p3.gambar = R.drawable.hp_notebook_14_bs709tu
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//
//        return arr
//    }
//
//    val arrProdukTerlaris: ArrayList<Produk>get(){
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "Hp Iphone 20"
//        p1.harga = "Rp. 29.000.000"
//        p1.gambar = R.drawable.hp_14_bs749tu
//
//        val p2 = Produk()
//        p2.nama = "Hp Samsung 20"
//        p2.harga = "Rp. 19.000.000"
//        p2.gambar = R.drawable.hp_envy_13_aq0019tx
//
//        val p3 = Produk()
//        p3.nama = "Hp Lenovo A33"
//        p3.harga = "Rp. 9.000.000"
//        p3.gambar = R.drawable.hp_notebook_14_bs709tu
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//
//        return arr
//    }

}






