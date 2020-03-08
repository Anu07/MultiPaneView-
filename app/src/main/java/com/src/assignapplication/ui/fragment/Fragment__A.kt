package com.src.assignapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.src.assignapplication.R
import com.src.assignapplication.ui.adapter.BasicAdapter
import com.src.assignapplication.ui.model.IntObj
import kotlinx.android.synthetic.main.fragment_a.*
import com.src.assignapplication.ui.utils.OnItemSelectedListener

class Fragment__A : Fragment(), OnItemSelectedListener {
    override fun onItemBSelected(i: Int, b: Boolean) {
    }

    override fun onItemCSelected(i: Int, b: Boolean) {
    }

    override fun onItemSelected(i: Int, b: Boolean) {
        callback.onItemSelected(i, b)
    }


    private lateinit var callback: OnItemSelectedListener

    private var mAdapter: BasicAdapter? = null

    private var mList: ArrayList<IntObj> = ArrayList()


    fun setOnItemSelectedListener(callback: OnItemSelectedListener) {
        this.callback = callback
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        populateData()
    }

    /**
     * adding data in list and notifying view
     */
    private fun populateData() {
        for (i in 0..9) {
            mList.add(IntObj(i, false))
        }
        mAdapter?.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        source.setHasFixedSize(true)
        source.layoutManager = LinearLayoutManager(requireContext())
        mAdapter =
            BasicAdapter(this, mList, this as OnItemSelectedListener)
        source.adapter = mAdapter
    }


    fun onElementsAdded(values: ArrayList<IntObj>) {
        for (i in 0 until values.size) {
            values[i].iscChecked = false
            if (!mList.contains(values[i]))
                mList.add(values[i])
        }
        mAdapter?.swap(mList)
    }

    fun onElementsRemoved(vals: ArrayList<IntObj>) {
        for (i in 0 until vals.size) {
            vals[i].iscChecked = true
            if (mList.contains(vals[i])) {
                mList.remove(vals[i])
            }
        }
        mAdapter =
            BasicAdapter(this, mList, this as OnItemSelectedListener)
        source.adapter = mAdapter

    }
}