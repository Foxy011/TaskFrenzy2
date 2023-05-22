package com.example.taskfrenzy.domain

data class TaskModel(
    val title: String,
    val description: String,
    val pictureUri: String? = null,
) : java.io.Serializable