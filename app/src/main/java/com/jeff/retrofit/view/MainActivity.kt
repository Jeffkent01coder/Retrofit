package com.jeff.retrofit.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.jeff.retrofit.repository.Repository
import com.jeff.retrofit.viewModel.MainViewModel
import com.jeff.retrofit.databinding.ActivityMainBinding
import com.jeff.retrofit.viewModel.MainViewModelFactory
import java.lang.Exception
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var respository: Repository
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        respository = Repository()
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(respository)
        ).get(MainViewModel::class.java)

        getQuote()
        binding.btnGetQuote.setOnClickListener {
            getQuote()
        }

    }
        private fun getQuote(){
        try {
            viewModel.getQuote()
            viewModel.response.observe(this,{
                response ->
                if (response.isSuccessful){
                    Log.i("MainActivity","${response.body()?.quote}")
                }
            })
        }catch (e:Exception){
            Log.e("MainActivity",e.toString())
        }

    }
}