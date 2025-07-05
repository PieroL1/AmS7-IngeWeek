package com.example.ingeweek

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UbicacionAdapter(private val ubicaciones: List<Ubicacion>) :
    RecyclerView.Adapter<UbicacionAdapter.UbicacionViewHolder>() {

    class UbicacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvLugar: TextView = itemView.findViewById(R.id.tvLugar)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UbicacionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ubicacion, parent, false)
        return UbicacionViewHolder(view)
    }

    override fun onBindViewHolder(holder: UbicacionViewHolder, position: Int) {
        val ubicacion = ubicaciones[position]
        holder.tvLugar.text = ubicacion.lugar
        holder.tvDescripcion.text = ubicacion.descripcion
    }

    override fun getItemCount(): Int = ubicaciones.size
}
