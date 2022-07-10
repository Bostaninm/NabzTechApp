package com.example.marathonapp.selection

interface ISelectionRepository {
    suspend fun getRoot(): Category
    suspend fun getChildes(parent : Category) : List<Category>
    suspend fun getParent(child: Category): Category
    suspend fun getByPath(path: String): Category
}