package com.chinasoft.module1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("SELECT * FROM loginUser")
    fun queryAllUser(): MutableList<User>

    @Query("SELECT * FROM loginUser WHERE name = :name")
    fun queryFindUser(name: String): User?

    @Insert
    fun addUser(vararg user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBatchUser(list: MutableList<User>)

    @Update
    fun updateUser(vararg user: User)

    @Query("UPDATE loginUser set age = '50'")
    fun updateAll()

    @Delete
    fun deleteSingle(vararg user: User)

    @Query("DELETE FROM loginUser")
    fun deleteAllUser()
}