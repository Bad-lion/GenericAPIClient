package com.neobis.genericapiclient.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neobis.genericapiclient.R
import com.neobis.genericapiclient.model.Post
import kotlinx.android.synthetic.main.row_layout.view.*


class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Post>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.jokeId_txt.text = myList[position].id.toString()
        holder.itemView.jokeType_txt.text = myList[position].type
        holder.itemView.jokeSetup_txt.text = myList[position].setup
        holder.itemView.jokePunchline_txt.text = myList[position].punchline

    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }
}