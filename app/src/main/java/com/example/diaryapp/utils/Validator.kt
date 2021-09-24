package com.example.diaryapp.utils

import com.example.diaryapp.data.model.Task

object Validator {

    fun validate(task: Task): Boolean {
        return !(task.name.isEmpty() || task.description.isEmpty())

    }
}
