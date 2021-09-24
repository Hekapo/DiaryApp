package com.example.diaryapp.views.fragments.task_list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.diaryapp.data.model.Task
import com.example.diaryapp.data.recycler.TaskAdapter
import com.example.diaryapp.databinding.FragmentTaskListBinding
import io.realm.Realm
import io.realm.RealmResults

class TaskListFragment : Fragment() {

    private var _bindingTaskList: FragmentTaskListBinding? = null
    private val binding get() = _bindingTaskList!!

    private var allTask: RealmResults<Task>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Realm.init(requireContext())


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingTaskList = FragmentTaskListBinding.inflate(inflater)
        setUpRecyclerView(allTask)

        return binding.root

    }

    private fun setUpRecyclerView(task: RealmResults<Task>?) {
        if (task == null) {
//            binding.recyclerView.visibility = View.GONE
        } else {
            val todoAdapter = TaskAdapter(task)
            binding.recyclerView.setHasFixedSize(true)
            binding.recyclerView.adapter = todoAdapter
            binding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                    this.requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            todoAdapter.setData(task)


        }
    }
}
