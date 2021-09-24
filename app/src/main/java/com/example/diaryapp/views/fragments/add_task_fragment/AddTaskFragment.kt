package com.example.diaryapp.views.fragments.add_task_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.diaryapp.data.model.Task
import com.example.diaryapp.databinding.FragmentAddTaskBinding
import com.example.diaryapp.views.fragments.add_task_fragment.presenter.AddTaskView

class AddTaskFragment : Fragment(), AddTaskView {
    private var _bindingTaskList: FragmentAddTaskBinding? = null
    private val binding get() = _bindingTaskList!!

    private var timeStart = ""
    private var timeFinish = ""
    private var tempDay = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _bindingTaskList = FragmentAddTaskBinding.inflate(inflater)

        return binding.root
    }

    override fun getTask(): Task {
        val id = tempDay
        val name = binding.edtName.text.toString()
        val desc = binding.edtDescription.text.toString()
        return Task(id, timeStart, timeFinish, name, desc)
    }

    override fun showInputIsRequired() {
        showMsg("Something missing")
    }

    override fun showMsg(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    override fun navigateTo(destination: Int) {
        binding.root.findNavController().navigate(destination)
    }

    override fun showTimePicker() {
        TODO("Not yet implemented")
    }

    override fun showDatePicker() {
        TODO("Not yet implemented")
    }
}
