package com.example.diaryapp.views.fragments.add_task_fragment.presenter

import com.example.diaryapp.data.model.Task

interface AddTaskView {

    fun getTask(): Task

    fun showInputIsRequired()

    fun showMsg(msg: String)

    fun navigateTo(destination: Int)

    fun showTimePicker()

    fun showDatePicker()
}
