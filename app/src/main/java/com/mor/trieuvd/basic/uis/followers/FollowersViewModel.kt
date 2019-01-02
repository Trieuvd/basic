package com.mor.trieuvd.basic.uis.followers

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mor.trieuvd.basic.data.AppDb
import com.mor.trieuvd.basic.model.User
import com.mor.trieuvd.basic.rest.APIs
import com.mor.trieuvd.basic.rest.RestClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel : ViewModel() {
    val followers = MutableLiveData<MutableList<User>>()
    val TAG: String = "CHECK_DATA_FOLLOWERS"
    var checkInternet = MutableLiveData<Boolean>()

    private lateinit var context: Context
    fun setContext(context: Context) {
        this.context = context
        getFollower()
    }

    fun loadFollowers() {
        val call = RestClient.restClient.create(APIs::class.java).getFollowers
        call.enqueue(object : Callback<MutableList<User>> {
            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                Log.e(TAG, "That bai: " + t.cause + ":" + t.message)
                checkInternet.postValue(false)
            }

            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
                Log.e(TAG, "thanh cong")
                followers.postValue(response.body())
                saveFollowers()
                checkInternet.postValue(true)
            }
        })
    }

    fun saveFollowers() {
        Observable.fromCallable {
            val db = AppDb.getAppDb(context)
            val followerDao = db?.followerDao()
            followerDao?.delAllFollower()
            for (user in followers.value!!) {
                followerDao?.insertFollower(user)
            }
        }
            .doOnNext { }
            .doOnComplete { }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    private fun getFollower() {
        Observable.fromCallable {
            val db = AppDb.getAppDb(context)
            db?.followerDao()?.getFollowers()
        }
            .doOnNext { list ->
                if (list!!.isNotEmpty()) {
                    followers.postValue(list)
                    Log.d("AAAA", "had data: ${list.size}")
                } else {
                    Log.d("AAAA", "no data")
                    loadFollowers()
                }
            }
            .doOnComplete { }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}