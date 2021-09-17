package com.example.diaryapp.views.fragments.task_details_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.diaryapp.databinding.FragmentTaskDetailsBinding

class TaskDetailsFragment : Fragment() {

    private var _bindingTaskList: FragmentTaskDetailsBinding? = null
    private val binding get() = _bindingTaskList!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _bindingTaskList = FragmentTaskDetailsBinding.inflate(inflater)

        return binding.root
    }
}
