package com.src.assignapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.src.assignapplication.R
import com.src.assignapplication.ui.adapter.BasicAdapter
import com.src.assignapplication.ui.adapter.BasicBAdapter
import com.src.assignapplication.ui.adapter.BasicCAdapter
import com.src.assignapplication.ui.model.IntObj
import com.src.assignapplication.ui.utils.OnItemSelectedListener
import com.src.assignapplication.ui.utils.OnListCSelectedListener
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_b.*


class Fragment__C : Fragment(), OnItemSelectedListener,OnListCSelectedListener {

    override fun onItemCSelected(i: Int, b: Boolean) {
        callback.onItemCSelected(i, b)
    }

    override fun onItemBSelected(i: Int, b: Boolean) {

    }


    override fun onItemSelected(i: Int, b: Boolean) {
        Log.i("i error B",""+ i)
    }
    internal lateinit var callback: OnItemSelectedListener

    fun setOnItemSelectedListener(callback: OnItemSelectedListener) {
        this.callback = callback
    }
    private var mAdapter: BasicCAdapter? = null

    private var mList: ArrayList<IntObj> = ArrayList()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
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
        mAdapter?.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        source.setHasFixedSize(true)
        source.layoutManager = LinearLayoutManager(requireContext())
        mAdapter =
            BasicCAdapter(this,mList, this)
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
            if(mList.contains(vals[i])){
                mList.remove(vals[i])
            }
        }
        mAdapter =
            BasicCAdapter(this, mList, this)
        source.adapter = mAdapter
    }

}