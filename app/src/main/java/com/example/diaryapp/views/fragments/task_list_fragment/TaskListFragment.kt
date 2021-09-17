package com.example.diaryapp.views.fragments.task_list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.diaryapp.databinding.FragmentTaskListBinding

class TaskListFragment : Fragment() {

    private var _bindingTaskList: FragmentTaskListBinding? = null
    private val binding get() = _bindingTaskList!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingTaskList = FragmentTaskListBinding.inflate(inflater)

        return binding.root

    }
}
