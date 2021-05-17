package com.helrin.pagingtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.helrin.pagingtest.model.Item
import com.helrin.pagingtest.model.ItemResponse
import com.helrin.pagingtest.remote.Repository
import com.helrin.pagingtest.vo.Resource
import com.helrin.tabling.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel() {

    private val _mDataList = MutableLiveData<Resource<ItemResponse>>()
    val mDataList = _mDataList.distinctUntilChanged()

    fun loadData(){
        viewModelScope.launch(Dispatchers.IO) {
            runDataLoading {
                _mDataList.postValue(Resource.loading(null))
                repository.list().let {
                    if (it.isSuccessful){
                        _mDataList.postValue(Resource.success(it.body()))
                    }
                }
            }
        }
    }
}