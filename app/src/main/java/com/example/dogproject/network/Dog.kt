package com.example.dogproject.network

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Dog (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Transient
    val id: Int? = null,

    @Json(name = "message")
    @ColumnInfo(name = "image_url")
    val message: String,

    @Json(name = "status")
    @ColumnInfo(name = "status")
    val status: String
)