package com.src.assignapplication.ui.activity

import android.content.Context
import android.os.Handler
import androidx.fragment.app.Fragment
import com.src.assignapplication.R
import com.src.assignapplication.ui.fragment.Fragment__A
import com.src.assignapplication.ui.fragment.Fragment__B
import com.src.assignapplication.ui.fragment.Fragment__C
import com.src.assignapplication.ui.model.IntObj
import com.src.assignapplication.ui.utils.OnItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), OnItemSelectedListener {
    override fun onItemBSelected(i: Int, b: Boolean) {
        itemSelected = i
        mBList.add(IntObj(i, false))
    }

    override fun onItemCSelected(i: Int, b: Boolean) {
        itemSelected = i
        mCList.add(IntObj(i, false))
    }


    override fun onItemSelected(i: Int, b: Boolean) {
        itemSelected = i
        var obj = IntObj(i, true)
        if (b) {
            if (!mList.contains(obj)) {
                mList.add(obj)
            }
        }
    }

    private var tempList: ArrayList<IntObj> = ArrayList()
    private var itemSelected: Int = 0
    private var mList: ArrayList<IntObj> = ArrayList()
    private var mBList: ArrayList<IntObj> = ArrayList()
    private var mCList: ArrayList<IntObj> = ArrayList()

    override val layoutId: Int
        get() = R.layout.activity_main
    override val context: Context
        get() = this@MainActivity

    override fun onAttachFragment(fragment: Fragment) {
        when (fragment) {
            is Fragment__A -> fragment.setOnItemSelectedListener(this@MainActivity)
            is Fragment__B -> fragment.setOnItemSelectedListener(this@MainActivity)
            is Fragment__C -> fragment.setOnItemSelectedListener(this@MainActivity)
        }
    }

    override fun onCreate() {

    }


    override fun initListeners() {
        move.setOnClickListener {
            tempList.addAll(mList)
            mList.clear()
            (supportFragmentManager.findFragmentById(R.id.rightFrag) as Fragment__B?)?.onElementsAdded(
                tempList
            )
            (supportFragmentManager.findFragmentById(R.id.leftFrag) as Fragment__A?)?.onElementsRemoved(
                tempList
            )

        }
        back.setOnClickListener {
            tempList.clear()
            tempList.addAll(mBList)
            mBList.clear()
            (supportFragmentManager.findFragmentById(R.id.leftFrag) as Fragment__A?)?.onElementsAdded(
                tempList
            )
            (supportFragmentManager.findFragmentById(R.id.rightFrag) as Fragment__B?)?.onElementsRemoved(
                tempList
            )
        }


        upa.setOnClickListener {
            tempList.clear()
            tempList.addAll(mCList)
            mCList.clear()
            (supportFragmentManager.findFragmentById(R.id.leftFrag) as Fragment__A?)?.onElementsAdded(
                tempList
            )
            (supportFragmentManager.findFragmentById(R.id.bottomFrag) as Fragment__C?)?.onElementsRemoved(
                tempList
            )
        }


        downa.setOnClickListener {
            tempList.clear()
            tempList.addAll(mList)
            mList.clear()
            (supportFragmentManager.findFragmentById(R.id.bottomFrag) as Fragment__C?)?.onElementsAdded(
                tempList
            )
            (supportFragmentManager.findFragmentById(R.id.leftFrag) as Fragment__A?)?.onElementsRemoved(
                tempList
            )
        }
        upb.setOnClickListener {
            tempList.clear()
            tempList.addAll(mCList)
            mCList.clear()
            (supportFragmentManager.findFragmentById(R.id.rightFrag) as Fragment__B?)?.onElementsAdded(

                tempList
            )
            (supportFragmentManager.findFragmentById(R.id.bottomFrag) as Fragment__C?)?.onElementsRemoved(
                tempList
            )
        }
        downb.setOnClickListener {
            tempList.clear()
            tempList.addAll(mBList)
            mBList.clear()
            (supportFragmentManager.findFragmentById(R.id.bottomFrag) as Fragment__C?)?.onElementsAdded(
                tempList
            )
            (supportFragmentManager.findFragmentById(R.id.rightFrag) as Fragment__B?)?.onElementsRemoved(
                tempList
            )
        }
    }


}
