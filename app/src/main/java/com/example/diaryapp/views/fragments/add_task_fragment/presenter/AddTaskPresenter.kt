package com.example.diaryapp.views.fragments.add_task_fragment.presenter

import androidx.lifecycle.ViewModel
import com.example.diaryapp.R
import com.example.diaryapp.data.realm.RealmControllerImplementation
import com.example.diaryapp.utils.Validator

class AddTaskPresenter(private val addTaskView: AddTaskView) : ViewModel() {

    private val realmController = RealmControllerImplementation()

    fun onSaveClicked() {
        val task = addTaskView.getTask()
        val isInputDataTrue = Validator.validate(task)
        if (!isInputDataTrue) {
            addTaskView.showInputIsRequired()
        } else {

            realmController.saveTask(task)
            addTaskView.navigateTo(R.id.action_addTaskFragment_to_taskListFragment)


        }

    }
}
