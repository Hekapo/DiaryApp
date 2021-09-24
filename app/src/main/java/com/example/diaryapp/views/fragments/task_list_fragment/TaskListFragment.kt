package com.example.diaryapp.views.fragments.task_list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.diaryapp.R
import com.example.diaryapp.data.model.Task
import com.example.diaryapp.data.recycler.TaskAdapter
import com.example.diaryapp.databinding.FragmentTaskListBinding
import com.example.diaryapp.views.fragments.task_list_fragment.presenter.TaskListPresenter
import com.example.diaryapp.views.fragments.task_list_fragment.presenter.TaskListView
import io.realm.Realm
import io.realm.RealmResults
import java.util.*

class TaskListFragment : Fragment(), TaskListView {

    private var _bindingTaskList: FragmentTaskListBinding? = null
    private val binding get() = _bindingTaskList!!

    private var allTask: RealmResults<Task>? = null

    private lateinit var presenter: TaskListPresenter

    private var date = Calendar.getInstance().get(Calendar.DATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Realm.init(requireContext())
        presenter = TaskListPresenter(this)

        presenter.getAllTasks(date)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingTaskList = FragmentTaskListBinding.inflate(inflater)

        binding.imgCalendar.setOnClickListener {

        }

        binding.navigateToAddFragmentButton.setOnClickListener {
            navigateToAddTaskFragment()
        }

        binding.day.text = date.toString()
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

    private fun navigateToAddTaskFragment() {
        presenter.navigate(R.id.action_taskListFragment_to_addTaskFragment, null)
    }

    override fun navigate(destination: Int, arg: Bundle?) {
        binding.root.findNavController().navigate(id, arg)
    }

    override fun setTask(task: RealmResults<Task>) {
        allTask = task
    }
}
