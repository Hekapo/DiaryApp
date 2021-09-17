package com.example.diaryapp.data.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.diaryapp.data.model.Task
import com.example.diaryapp.databinding.OneHourItemBinding
import io.realm.RealmRecyclerViewAdapter
import io.realm.RealmResults

class TaskAdapter(task: RealmResults<Task>) :
    RealmRecyclerViewAdapter<Task, TaskAdapter.TaskViewHolder>(task, false) {

    private lateinit var onCLickListener: OnTodoClickListener

    private var oldTaskList = listOf<Task>()

    private val colors = listOf("#6D74FF", "#4361EE", "#25A18E", "#FF5D8F")

    interface OnTodoClickListener {
        fun onTodoClicked(task: Task)
    }

    fun setOnItemClickListener(aClickListener: OnTodoClickListener) {
        onCLickListener = aClickListener
    }

    inner class TaskViewHolder(var binding: OneHourItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun clickItem(task: Task) {
            binding.root.setOnClickListener {
                onCLickListener.onTodoClicked(task)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            OneHourItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding.taskName.text = (oldTaskList[position].name)
        holder.binding.dateStart.text = oldTaskList[position].dateStart
        holder.binding.dateFinish.text = oldTaskList[position].dateFinish
        holder.binding.taskDesc.text = (oldTaskList[position].description)
        holder.clickItem(oldTaskList[position])

        holder.binding.root.background.colorFilter =
            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                Color.parseColor(colors[(position + 1) % colors.size]),
                BlendModeCompat.SRC_ATOP
            )
    }

    override fun getItemCount(): Int {
        return oldTaskList.size
    }

}
