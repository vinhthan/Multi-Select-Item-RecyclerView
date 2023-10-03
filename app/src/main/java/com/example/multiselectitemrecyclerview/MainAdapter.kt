package com.example.multiselectitemrecyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var listItem = mutableListOf<Model>()

    private var selectAllItems: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listItem[position])

        listItem[position].isSelected = selectAllItems

        if (listItem[position].isSelected == true) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.color_E85A5A))
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
        }

        holder.itemView.setOnClickListener {
            listItem[position].isSelected = listItem[position].isSelected == false
            if (listItem[position].isSelected == true) {
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.color_E85A5A))
            } else {
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            }
        }


    }

    class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tv = itemView.findViewById<TextView>(R.id.text_view)
        fun bind(model: Model) {
            tv.text = model.name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun selectAllItems(selectAll: Boolean){
        selectAllItems = selectAll
        notifyDataSetChanged()
    }
}