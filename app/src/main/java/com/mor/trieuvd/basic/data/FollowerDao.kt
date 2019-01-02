package com.mor.trieuvd.basic.data

import androidx.room.*
import com.mor.trieuvd.basic.model.User

@Dao
interface FollowerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFollower(user: User)

    @Update
    fun updateFollower(user: User)

    @Query("DELETE FROM followers")
    fun delAllFollower()

    @Query("SELECT * FROM followers")
    fun getFollowers(): MutableList<User>
}
