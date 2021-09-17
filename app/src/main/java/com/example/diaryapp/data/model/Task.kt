package com.example.diaryapp.data.model

import android.os.Parcelable
import io.realm.RealmObject
import kotlinx.parcelize.Parcelize


@Parcelize
open class Task(
    var id: Int,
    var dateStart: String,
    var dateFinish: String,
    var name: String,
    var description: String,
) : RealmObject(), Parcelable {
    constructor() : this(0, "", "", "", "")

}
