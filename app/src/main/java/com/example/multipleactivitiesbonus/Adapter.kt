package com.example.multipleactivitiesbonus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleactivitiesbonus.databinding.ItemRowBinding

class Adapter(private val info: ArrayList<String>?): RecyclerView.Adapter<Adapter.itemViewHolder>(){
    class itemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        return itemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val user = info!![position]

        holder.binding.apply {
            tv3.text = user
        }
    }

    override fun getItemCount() = info!!.size
}