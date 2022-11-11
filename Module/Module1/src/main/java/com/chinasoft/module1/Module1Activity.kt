package com.chinasoft.module1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chinasoft.base.util.RouterActivityPath
import kotlinx.coroutines.runBlocking
import java.util.*

@Route(path = RouterActivityPath.PAGER_MODULE1)
class Module1Activity : AppCompatActivity() {
    private lateinit var  queryBtn: Button
    private lateinit var  insertBtn: Button
    private lateinit var  updateBtn: Button
    private lateinit var  deleteBtn: Button
    private lateinit var  resultRecycle: RecyclerView
    private var list = mutableListOf<User>()
    var userDao: UserDao = DbManager.db.userDao()

    private val userAdapter by lazy {
        UserAdapter(R.layout.user_item_layout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module1)
//        findViewById<TextView>(R.id.tv_test).setOnClickListener {
//            ARouter.getInstance().build(RouterActivityPath.PAGER_MODULE2).navigation()
//        }
        findVbId()
    }

    private fun findVbId() {
        queryBtn = findViewById(R.id.query)
        insertBtn = findViewById(R.id.insert)
        updateBtn = findViewById(R.id.update)
        deleteBtn = findViewById(R.id.delete)
        resultRecycle = findViewById(R.id.result_recycle)
        resultRecycle.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        resultRecycle.adapter = userAdapter
        userAdapter.addChildClickViewIds(R.id.item_delete, R.id.item_modify)
        queryBtn.setOnClickListener { query() }
        insertBtn.setOnClickListener { insertSingle() }
        deleteBtn.setOnClickListener { delete() }
        updateBtn.setOnClickListener { update() }
        userAdapter.setOnItemChildClickListener { _, view, position ->
            when (view.id) {
                R.id.item_delete -> singleDel(list[position])
                R.id.item_modify -> singleModify(list[position])
            }
        }
        insertAll()
    }

    private fun query() {
        list = userDao.queryAllUser()
        userAdapter.setList(list)
    }

    private fun insertAll() {
        runBlocking {
            if (userDao.queryAllUser().size == 0) {
                val mutableList: MutableList<User> = mutableListOf()
                for (a in 1..3) {
                    val user = User("张三$a", 20 + a, "贵阳市观山湖区$a", "")
                    mutableList.add(user)
                }
                userDao.addBatchUser(mutableList)
                Toast.makeText(this@Module1Activity,"批量新增数据成功",Toast.LENGTH_LONG).show()
            }
            query()
        }
    }

    private fun insertSingle() {
        val age = kotlin.random.Random.nextInt(20,40)
        val user = User("小二", age, "贵阳市观山湖区", "")
        userDao.addUser(user)
        Toast.makeText(this@Module1Activity,"新增一条数据成功",Toast.LENGTH_LONG).show()
        query()
    }

    private fun delete() {
        userDao.deleteAllUser()
        Toast.makeText(this@Module1Activity,"删除所有数据成功",Toast.LENGTH_LONG).show()
        query()
    }

    private fun update() {
        userDao.updateAll()
        Toast.makeText(this@Module1Activity,"更新表里所有年龄数据成功",Toast.LENGTH_LONG).show()
        query()
    }

    private fun singleDel(singleUser: User) {
        userDao.deleteSingle(singleUser)
        Toast.makeText(this@Module1Activity,"删除单条数据成功",Toast.LENGTH_LONG).show()
        query()
    }

    private fun singleModify(user: User) {
        user.aliasName = "修改的" + user.aliasName
        user.age = 100
        user.ads = "修改的地址白云区"
        userDao.updateUser(user)
        Toast.makeText(this@Module1Activity,"更新单条数据成功",Toast.LENGTH_LONG).show()
        list.clear()
        query()
    }

}