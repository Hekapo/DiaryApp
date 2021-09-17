package com.example.diaryapp.data.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.diaryapp.data.model.Task

class TaskDiffUtil(private val oldList: List<Task>, private val newList: List<Task>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldHabit = oldList[oldItemPosition]
        val newHabit = newList[newItemPosition]
        return oldHabit == newHabit

    }
}
