package com.example.kotlin_study_pretask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_study_pretask.DTO.DataDTO
import com.example.kotlin_study_pretask.DTO.Item
import com.example.kotlin_study_pretask.Retrofit.RetrofitService
import com.example.kotlin_study_pretask.databinding.ActivityMainBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // MybookActivity로 이동
        viewBinding.imagebuttonGotoLike.setOnClickListener {
            val intent = Intent(this, MyBookActivity::class.java)
            startActivity(intent)
        }
        val retrofit = Retrofit.Builder().baseUrl("${BuildConfig.BASE_URL}")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(RetrofitService::class.java)

        service.getBookData("${BuildConfig.API_KEY}", "1", "1")
            .enqueue(object : Callback<DataDTO> {
                override fun onResponse(call: Call<DataDTO>, response: Response<DataDTO>) {
                    Log.d(" ************ Response check ************ reponse ",response.toString())
                    Log.d(" ************ Response check ************ reponse body",response.body().toString())
                    if (response.isSuccessful) {
                        //성공
                        var result: DataDTO? = response.body()
                        Log.d("RETROFIT2", "onResponse 성공: " + result?.toString());
                    } else {
                        //실패
                        Log.d("RETROFIT2", "onResponse 실패")
                    }
                }

                override fun onFailure(call: Call<DataDTO>, t: Throwable) {
                    // 통신 실패
                    Log.d("RETROFIT2", "onFailure 에러: " + t.message.toString());
                }

            })


        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapter(dataList)
        dataList.apply{
            add(Data("hello","1"))
        }
        viewBinding.recyclerviewMain.adapter = dataRVAdapter
        viewBinding.recyclerviewMain.layoutManager = LinearLayoutManager(this)

    }
}
