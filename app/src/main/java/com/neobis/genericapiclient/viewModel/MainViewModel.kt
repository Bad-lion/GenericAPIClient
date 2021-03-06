package com.neobis.genericapiclient.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neobis.genericapiclient.model.Post
import com.neobis.genericapiclient.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()


    fun getCustomPosts() {
        viewModelScope.launch {
            val response = repository.getCustomPosts()
            myCustomPosts.value = response
        }
    }


}