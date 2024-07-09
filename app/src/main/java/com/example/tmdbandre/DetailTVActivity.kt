package com.example.tmdbandre

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.tmdbandre.databinding.ActivityDetailTvactivityBinding
import com.example.tmdbandre.model.Television

class DetailTVActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVS = "extra_tvs"
    }

    private lateinit var binding: ActivityDetailTvactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.imgItemPhoto.clipToOutline = true

        val detailTvs = intent.getParcelableExtra<Television>(EXTRA_TVS)

        if (detailTvs != null) {
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this).load(IMAGE_BASE + detailTvs.poster).into(binding.imgItemPhoto)
            binding.tvItemName.text = detailTvs.title
            binding.tvItemDescription.text = detailTvs.overview
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}