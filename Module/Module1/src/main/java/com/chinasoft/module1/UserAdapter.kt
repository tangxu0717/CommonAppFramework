package com.chinasoft.module1

import android.graphics.Color
import android.widget.ImageView
import androidx.core.content.ContextCompat
import coil.load
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class UserAdapter(layoutResId: Int) : BaseQuickAdapter<User, BaseViewHolder>(layoutResId) {
    override fun convert(holder: BaseViewHolder, item: User) {
        val avatarView = holder.getView<ImageView>(R.id.avatar)
        avatarView.load(item.avatar)
        holder.setText(R.id.name, "姓名：${item.aliasName}")
            .setText(R.id.ads, "地址：${item.ads}")
        if (item.aliasName.contains("修改")) {
            holder.setTextColor(R.id.name, ContextCompat.getColor(context, R.color.red))
        }
        if (item.age == 100) {
            holder.setText(R.id.age, "年龄：修改的${item.age} 岁")
            holder.setTextColor(R.id.age, ContextCompat.getColor(context, R.color.red))
        } else {
            holder.setText(R.id.age, "年龄：${item.age} 岁")
        }
        if (item.ads.contains("修改")) {
            holder.setTextColor(R.id.ads, ContextCompat.getColor(context, R.color.red))
        }
    }
}