package com.ifs21014.dinopedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DinoAdapter(
    private val context: Context,
    private val dinosaur: List<Dinosaur>,
    val listener:(Dinosaur) -> Unit
) : RecyclerView.Adapter<DinoAdapter.DinosaurViewHolder>(){

    class DinosaurViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgDinosaur = view.findViewById<ImageView>(R.id.img_item_image_dino)
        val nameDinosaur = view.findViewById<TextView>(R.id.tv_item_name_dino)
        val famDinosaur = view.findViewById<TextView>(R.id.tv_item_family_dino)



        fun bindView(dinosaur: Dinosaur, listener: (Dinosaur) -> Unit) {
            imgDinosaur.setImageResource(dinosaur.img)
            nameDinosaur.text = dinosaur.name
            famDinosaur.text = dinosaur.family
            itemView.setOnClickListener {
                listener(dinosaur)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DinosaurViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dinosaur, parent, false)
        return DinosaurViewHolder(view)
    }

    override fun onBindViewHolder(holder: DinosaurViewHolder, position: Int) {
        val currentDinosaur = dinosaur[position]
        holder.bindView(currentDinosaur, listener)
    }

    override fun getItemCount(): Int {
        return dinosaur.size
    }
}

private fun ImageView.setImageResource(img: String) {

}
