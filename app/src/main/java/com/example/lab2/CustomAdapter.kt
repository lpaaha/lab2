package com.example.animal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab2.R
import com.example.lab2.firstfragment

class CustomAdapter(val fragment:firstfragment,private val lisOfAnimals:ArrayList<Animal_DataClass>,private val listener:Listener):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView


        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detal)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        val animal = lisOfAnimals[i]
        viewHolder.itemView.setOnClickListener {
            listener.onClick(i)
        }
        Glide.with(fragment)
            .load(lisOfAnimals.get(i).URL).fitCenter().into(viewHolder.itemImage)
        viewHolder.itemDetail.text = animal.titles
        viewHolder.itemTitle.text = animal.details

    }


    override fun getItemCount(): Int {
        return lisOfAnimals.size
    }

    interface Listener {
        fun onClick(itemView: Int)
    }

}