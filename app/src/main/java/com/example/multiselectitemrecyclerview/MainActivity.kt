package com.example.multiselectitemrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var mAdapter: MainAdapter
    lateinit var rv: RecyclerView
    lateinit var tvSelectAll: Button
    lateinit var tvUnselectAll: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = MainAdapter()
        for (i in 0 until 30) {
            mAdapter.listItem.add(Model("text view $i"))
        }
        rv = findViewById(R.id.rv)
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

        tvSelectAll = findViewById(R.id.tv_select_all)
        tvSelectAll.setOnClickListener {
            mAdapter.selectAllItems(true)
        }
        tvUnselectAll = findViewById(R.id.tv_unselect_all)
        tvUnselectAll.setOnClickListener {
            mAdapter.selectAllItems(false)
        }

    }
}