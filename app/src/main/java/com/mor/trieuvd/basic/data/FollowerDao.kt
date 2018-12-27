package com.mor.trieuvd.basic.data

import androidx.room.*

@Dao
interface FollowerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFollower(follower: Follower)

    @Update
    fun updateFollower(follower: Follower)

    @Delete
    fun deleteFollower(follower: Follower)

    @Query("SELECT * FROM followers")
    fun getFollowers(): List<Follower>
}
