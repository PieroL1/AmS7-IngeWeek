package com.example.ingeweek

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventoAdapter(private val eventos: List<Evento>) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvHora: TextView = itemView.findViewById(R.id.tvHora)
        val tvLugar: TextView = itemView.findViewById(R.id.tvLugar)
        val tvPonente: TextView = itemView.findViewById(R.id.tvPonente)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent, false)
        return EventoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = eventos[position]
        holder.tvTitulo.text = evento.titulo
        holder.tvHora.text = "Hora: ${evento.hora}"
        holder.tvLugar.text = "Lugar: ${evento.lugar}"
        if (evento.ponente != null) {
            holder.tvPonente.visibility = View.VISIBLE
            holder.tvPonente.text = "Ponente: ${evento.ponente}"
        } else {
            holder.tvPonente.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = eventos.size
}
