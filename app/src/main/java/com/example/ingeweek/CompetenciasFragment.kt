package com.example.ingeweek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CompetenciasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompetenciasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_competencias, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        toolbar.title = "Competencias"

        // Reutiliza la lista de eventos o crea una nueva
        val competencias = listOf(
            Evento("Martes 4 de Junio", "15:00", "Concurso de puentes de palitos", null, "Plaza Principal", "COMPETENCIA"),
            Evento("Martes 4 de Junio", "16:00", "Hackathon IngeWeek", null, "Laboratorio de Cómputo", "COMPETENCIA"),
            Evento("Miércoles 5 de Junio", "15:00", "Concurso de robots seguidores de línea", null, "Patio de Ingeniería", "COMPETENCIA"),
            Evento("Jueves 6 de Junio", "15:00", "Competencia de estructuras de espagueti", null, "Patio de Ingeniería", "COMPETENCIA"),
            Evento("Jueves 6 de Junio", "16:00", "Expo de proyectos de estudiantes", null, "Patio de Ingeniería", "COMPETENCIA"),
            Evento("Viernes 7 de Junio", "10:00", "Juegos deportivos interescuelas", null, "Campo Deportivo", "COMPETENCIA"),
        )

        val rvCompetencias = view.findViewById<RecyclerView>(R.id.rvCompetencias)
        rvCompetencias.layoutManager = LinearLayoutManager(requireContext())
        rvCompetencias.adapter = EventoAdapter(competencias)
    }
}
