package com.example.diaryapp.data.realm

import com.example.diaryapp.data.model.Task
import io.realm.Realm
import io.realm.RealmResults

class RealmControllerImplementation : RealmController {
    private val realm = Realm.getDefaultInstance()

    override fun getSortedTasksByDayAndTime(day: Int): RealmResults<Task> {
        return realm.where(Task::class.java).equalTo("id", day).sort("dateStart").findAll()

    }

    override fun saveTask(task: Task) {
        realm.beginTransaction()
        realm.copyToRealm(task)
        realm.commitTransaction()

    }

    override fun getAllTasks(): RealmResults<Task> {
        return realm.where(Task::class.java).findAll()

    }

    override fun deleteTask() {
        realm.beginTransaction()
        realm.delete(Task::class.java)
        realm.commitTransaction()
    }

    override fun deleteSingleTask(id: Int) {
        val todoToDelete = realm.where(Task::class.java).equalTo("id", id).findFirst()
        if (!realm.isInTransaction) {
            realm.beginTransaction()
            todoToDelete?.deleteFromRealm()
            realm.commitTransaction()
        }
    }

    override fun deleteOldTasks() {
        TODO("Not yet implemented")
    }
}
