package com.mor.trieuvd.basic.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "followers")
class Follower {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    lateinit var name: String
}