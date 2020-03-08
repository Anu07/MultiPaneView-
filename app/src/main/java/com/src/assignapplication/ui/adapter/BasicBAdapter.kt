package com.src.assignapplication.ui.adapter


import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.src.assignapplication.R
import com.src.assignapplication.ui.fragment.Fragment__A
import com.src.assignapplication.ui.fragment.Fragment__B
import com.src.assignapplication.ui.fragment.Fragment__C
import com.src.assignapplication.ui.model.IntObj
import com.src.assignapplication.ui.utils.OnItemSelectedListener
import kotlinx.android.synthetic.main.item_list.view.*


class BasicBAdapter(
    var ctx: Fragment,
    private var listdata: ArrayList<IntObj>,
    var mListenerAdapter: OnItemSelectedListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(listItem)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.i("item", "seection B" + listdata[position].iscChecked)
        holder.itemView.selectionView.isChecked = false
        holder.itemView.item.text = listdata[position].value.toString()
        holder.itemView.selectionView.setOnCheckedChangeListener { _, b ->
            mListenerAdapter.onItemBSelected(listdata[position].value, b)
            listdata[position].iscChecked = b
        }
    }

    fun swap(nList: ArrayList<IntObj>) {
        listdata = ArrayList()
        listdata.addAll(nList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}