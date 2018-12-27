package com.mor.trieuvd.basic.uis.followers

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mor.trieuvd.basic.data.AppDb
import com.mor.trieuvd.basic.data.Follower
import com.mor.trieuvd.basic.model.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FollowersViewModel : ViewModel() {
    val followers = MutableLiveData<List<User>>()
    private val TAG: String = "CHECK_DATA_FOLLOWERS"

    private lateinit var context: Context
    fun setContext(context: Context) {
        this.context = context
        //loadFollowers()
    }

    /*fun loadFollowers() {
        val call = RestClient.restClient.create(APIs::class.java).getFollowers
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.e(TAG, "That bai: " + t.cause + ":" + t.message)
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.e(TAG, "thanh cong")
                followers.postValue(response.body())
                saveFollowers()
            }
        })
    }*/

    fun saveUser() {
        Observable.fromCallable {
            val db = AppDb.getAppDb(context)
            val followerDao = db?.followerDao()

            val follower1 = Follower()
            follower1.name = "Hungnt"

            with(followerDao) {
                this?.insertFollower(follower1)
            }
        }
            .doOnNext {}
            .doOnComplete { getFollower() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun getFollower() {
        Observable.fromCallable {
            val db = AppDb.getAppDb(context)
            db?.followerDao()?.getFollowers()
        }
            .doOnNext { list ->
                Log.d("AAAAAAAA","Result get from DB: ${list!![0].name}")
            }
            .doOnComplete { }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}