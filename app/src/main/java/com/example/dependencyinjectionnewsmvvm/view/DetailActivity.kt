package com.example.dependencyinjectionnewsmvvm.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dependencyinjectionnewsmvvm.R
import com.example.dependencyinjectionnewsmvvm.model.GetAllNewsResponseItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        val data = intent.extras!!.getSerializable("NEWS") as GetAllNewsResponseItem
        detail_deskripsi.text = "Deskripsi: \n${data.description}"
        detail_judul.text = "Judul: \n${data.title}"
        detail_penulis.text = "Penulis: \n${data.author}"
        detail_tanggal_rilis.text = "Tanggal rilis: \n${data.createdAt}"
        Glide.with(detail_image.context)
            .load(data.image)
            .error(R.drawable.ic_launcher_background)
            .into(detail_image)
    }
}