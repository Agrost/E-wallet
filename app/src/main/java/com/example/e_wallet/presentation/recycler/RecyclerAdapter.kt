package com.example.e_wallet.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.e_wallet.R
import com.example.e_wallet.domain.entity.PersonCard

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var items: MutableList<PersonCard> = mutableListOf()
        set(value) {
            val callback = DiffCallback(field, value)
            field = value
            DiffUtil.calculateDiff(callback).dispatchUpdatesTo(this)
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var postText: TextView = itemView.findViewById(R.id.person_name)
        var postImage: ImageView = itemView.findViewById(R.id.person_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.person_card, parent, false)
        )
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postText.text = items[position].avatarName
        holder.postImage.setImageResource(items[position].avatarImage)
    }
}

fun a(){
    RecyclerAdapter()
}