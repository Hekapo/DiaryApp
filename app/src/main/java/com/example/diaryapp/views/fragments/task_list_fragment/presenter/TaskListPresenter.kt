package com.example.diaryapp.views.fragments.task_list_fragment.presenter

import android.os.Bundle
import com.example.diaryapp.data.realm.RealmControllerImplementation

class TaskListPresenter(private val taskListView: TaskListView) {

    private val realmControllerImplementation = RealmControllerImplementation()

    fun getAllTasks(day: Int) {
        val tasks = realmControllerImplementation.getSortedTasksByDayAndTime(day)

        taskListView.setTask(tasks)

    }

    fun navigate(dest: Int, arg: Bundle?) {
        taskListView.navigate(dest, arg)

    }
}
