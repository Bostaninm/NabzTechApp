package com.example.changeapp.selection

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey val id : Int,
    val path : String,
    val name : String,
    val parentId : Int,
    val isSubject: Boolean
)
