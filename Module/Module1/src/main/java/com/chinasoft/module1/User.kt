package com.chinasoft.module1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "loginUser")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "name")
    var aliasName: String = "",
    var age: Int = 0,
    var ads: String = "",
    @Ignore
    var avatar: String = "") {
    constructor(aliasName: String, age: Int, ads: String, avatar: String) : this() {
        this.aliasName = aliasName
        this.age = age
        this.ads = ads
        this.avatar = avatar
    }

    override fun toString(): String {
        return "User(id=$id, aliasName='$aliasName', age=$age, ads='$ads', avatar='$avatar')"
    }
}
