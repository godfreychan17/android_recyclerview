package com.godfery.recyclerviewsample.views.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.godfery.recyclerviewsample.R
import com.godfery.recyclerviewsample.adapter.MainAdapter
import com.godfery.recyclerviewsample.databinding.ActivityMainBinding
import com.godfery.recyclerviewsample.model.BeerResponse

import com.godfery.recyclerviewsample.util.Status
import com.godfery.recyclerviewsample.viewmodelfactory.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var adapter : MainAdapter
    private lateinit var mainViewModel : MainViewModel

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupModelView()
        setupObserver()
    }

    fun setupUI(){
        adapter = MainAdapter(arrayListOf())

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.adapter = adapter
        //TODO recyvlerView add item click listener
    }

    fun setupModelView(){
        mainViewModel = ViewModelProvider(this, MainViewModelFactory()).get(MainViewModel::class.java)
    }

    fun setupObserver(){
        mainViewModel.getItems().observe(this,
            {
                when(it.status){
                    Status.Loading ->{

                    }

                    Status.Success ->{
                        it.data?.let { items -> updateList(items) }
                    }

                    Status.Error ->{
                        Log.d("MainAcitivty", it.msg!!)
                    }


                }
            })
    }

    private fun updateList ( items : List<BeerResponse>){
        adapter.addData(items)
        adapter.notifyDataSetChanged();
    }


}