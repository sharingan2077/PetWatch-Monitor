package ru.android.petwatch.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.android.petwatch.R
import ru.android.petwatch.listeners.AnimalClickListener
import ru.android.petwatch.model.Animal

class AnimalAdapter(private val listener: AnimalClickListener): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var animals  = ArrayList<Animal>()

    fun setListData(data: ArrayList<Animal>) {
        this.animals = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(inflater, listener)
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            listener.onItemClickListener(animals[position])
        }
        holder.bind(animals[position])

    }



    class AnimalViewHolder(view: View, private val listener: AnimalClickListener): RecyclerView.ViewHolder(view) {

        private val tvName = view.findViewById<TextView>(R.id.tv_name)
        private val tvAge = view.findViewById<TextView>(R.id.tv_age)


        fun bind(data: Animal) {
            if (data.gender == "female") {
                tvName.text = "♀\uFE0F ${data.name}"
            }
            else if (data.gender == "male") {
                tvName.text = "♂\uFE0F ${data.name}"
            }
            tvAge.text = data.age

//            deleteUserID.setOnClickListener {
//                listener.onDeleteAnimalClickListener(data)
//            }
        }
    }

}