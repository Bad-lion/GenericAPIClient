package com.neobis.genericapiclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.FadingCircle
import com.neobis.genericapiclient.adapter.MyAdapter
import com.neobis.genericapiclient.repository.Repository
import com.neobis.genericapiclient.utils.LoadingBar
import com.neobis.genericapiclient.viewModel.MainViewModel
import com.neobis.genericapiclient.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.progressbar.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loading = LoadingBar(this)


        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomPosts()
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
        refreshBt.setOnClickListener {
            loading.startLoading()
            viewModel.getCustomPosts()

            viewModel.myCustomPosts.observe(this, Observer { response ->

                if(response.isSuccessful){

                    response.body()?.let { myAdapter.setData(it) }
                    loading.isDismiss()
                }else {
                    Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
                    loading.isDismiss()
                }
            })
            loading.startLoading()
        }



    }

    private fun setupRecyclerview() {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }






}