package com.example.nasaxml.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaxml.R

class AnimalsAdapter(private val animals: List<Animal>) : RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.animal_image)
        val nameTextView: TextView = itemView.findViewById(R.id.animal_name)
        val descriptionTextView: TextView = itemView.findViewById(R.id.animal_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animals[position]
        holder.imageView.setImageResource(animal.picture) // assuming picture is a drawable resource id
        holder.nameTextView.text = holder.itemView.context.getString(animal.name) // assuming name is a string resource id
        holder.descriptionTextView.text = holder.itemView.context.getString(animal.description) // use actual description resource
    }

    override fun getItemCount(): Int = animals.size
}
