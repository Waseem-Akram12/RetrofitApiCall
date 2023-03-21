package com.example.retrofitapicall

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapicall.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//https://dummyjson.com/products/1
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var binding:ActivityMainBinding
    lateinit var adapter:AdapterClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.button.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setMessage("here it comes")
        progressDialog.show()
        Retrofitissistance.Apiinterface.getData().enqueue(object : Callback<nextnewone?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<nextnewone?>, response: Response<nextnewone?>) {
                progressDialog.dismiss()
                val imageUrls = response.body()?.images ?: emptyList()
                Log.e("image", imageUrls.toString())
                adapter = AdapterClass(imageUrls)
                recyclerView.adapter=adapter
                adapter.notifyDataSetChanged()
                progressDialog.dismiss()

            }

            override fun onFailure(call: Call<nextnewone?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "onFail Call", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        })
    }
}