package com.example.diaryapp.data.realm

import com.example.diaryapp.data.model.Task
import io.realm.RealmResults

interface RealmController {

    fun getSortedTasksByDayAndTime(day: Int): RealmResults<Task>

    fun saveTask(task: Task)

    fun getAllTasks(): RealmResults<Task>

    fun deleteTask()

    fun deleteSingleTask(id: Int)

    fun deleteOldTasks()


}
