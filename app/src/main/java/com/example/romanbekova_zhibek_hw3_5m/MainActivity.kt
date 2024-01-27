package com.example.romanbekova_zhibek_hw3_5m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.romanbekova_zhibek_hw3_5m.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var page = 1
    var adapter = PixiAdapter(arrayListOf())
    private var newWord = ""
    private var oldWord = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            nextBtn.setOnClickListener {
                newWord = searchEd.text.toString()
                if (newWord != oldWord) {
                    Toast.makeText(
                        this@MainActivity,
                        "Чтобы найти новое нажмите 'Search' ",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    page++
                    getImages()
                }
            }
            searchBtn.setOnClickListener {
                adapter.list.clear()
                page = 1
                getImages()
            }
        }
    }


    private fun ActivityMainBinding.getImages() {
        oldWord = searchEd.text.toString()
        RetrofitService().api.getImages(
            keyWordForSearch = oldWord,
            page = page
        )
            .enqueue(object : Callback<PixabayModel> {
                override fun onResponse(
                    call: Call<PixabayModel>,
                    response: Response<PixabayModel>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            adapter.list.addAll(it.hits)
                            binding.pixaRw.adapter = adapter
                        }
                    }
                }

                override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }

}