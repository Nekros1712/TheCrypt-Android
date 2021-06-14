package com.example.thecrypt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity() : AppCompatActivity() {

    lateinit var cryptsRecycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        getData()

        cryptsRecycler = findViewById(R.id.cryptsRecycler)
        cryptsRecycler.layoutManager = LinearLayoutManager(this)
    }

    private fun getData() {
        val data = CryptoService.cryptoInstance.getCrypts()
        data.enqueue(object: Callback<List<Coins>>{
            override fun onFailure(call: Call<List<Coins>>, t: Throwable) {
                Log.d("Failure", "Error while fetching API", t)
            }

            override fun onResponse(call: Call<List<Coins>>, response: Response<List<Coins>>) {
                if(response.isSuccessful) {
                    val resultData : List<Coins>? = response.body()
                    cryptsRecycler.adapter = CryptsAdapter(this@MainActivity, resultData)
                }
            }
        })
    }
}