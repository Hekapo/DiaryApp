package com.example.diaryapp.views.fragments.task_list_fragment.presenter

import android.os.Bundle
import com.example.diaryapp.data.model.Task
import io.realm.RealmResults

interface TaskListView {

    fun navigate(destination: Int, arg: Bundle?)

    fun setTask(task:RealmResults<Task>)
}
