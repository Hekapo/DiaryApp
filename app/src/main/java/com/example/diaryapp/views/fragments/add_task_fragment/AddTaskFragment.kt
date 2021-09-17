package com.example.diaryapp.views.fragments.add_task_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.diaryapp.databinding.FragmentAddTaskBinding

class AddTaskFragment : Fragment() {
    private var _bindingTaskList: FragmentAddTaskBinding? = null
    private val binding get() = _bindingTaskList!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _bindingTaskList = FragmentAddTaskBinding.inflate(inflater)

        return binding.root
    }
}
