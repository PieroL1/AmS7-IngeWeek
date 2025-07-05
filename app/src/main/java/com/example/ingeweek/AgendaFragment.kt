package com.example.ingeweek

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AgendaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_agenda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        toolbar.title = "Agenda"

        val eventos = listOf(
            // LUNES 3 DE JUNIO
            Evento("Lunes 3 de Junio", "09:00", "Misa de inauguración", null, "Auditorio Central", "AGENDA"),
            Evento("Lunes 3 de Junio", "10:00", "Ceremonia de inauguración", null, "Auditorio Central", "AGENDA"),
            Evento("Lunes 3 de Junio", "12:00", "Conferencia: El ingeniero como agente de cambio", "Mg. Esp. Guido A. Vilcapoma Capcha", "Auditorio Central", "SEMINARIO"),
            Evento("Lunes 3 de Junio", "15:00", "Conferencia: Innovación y desarrollo de software", "Ing. Marco A. Zevallos Tello", "Auditorio Central", "SEMINARIO"),

            // MARTES 4 DE JUNIO
            Evento("Martes 4 de Junio", "10:00", "Conferencia: Ingeniería sostenible y energías renovables", "Ing. Giannina A. Espinoza Yzarra", "Auditorio Central", "SEMINARIO"),
            Evento("Martes 4 de Junio", "12:00", "Conferencia: Impacto de la ingeniería civil en la sociedad", "Ing. Juan R. Paredes Aquino", "Auditorio Central", "SEMINARIO"),
            Evento("Martes 4 de Junio", "15:00", "Concurso de puentes de palitos", null, "Plaza Principal", "COMPETENCIA"),
            Evento("Martes 4 de Junio", "16:00", "Hackathon IngeWeek", null, "Laboratorio de Cómputo", "COMPETENCIA"),

            // MIÉRCOLES 5 DE JUNIO
            Evento("Miércoles 5 de Junio", "09:00", "Seminario: Tendencias de la ingeniería eléctrica", "Ing. David J. Quispe Huamán", "Auditorio Central", "SEMINARIO"),
            Evento("Miércoles 5 de Junio", "11:00", "Seminario: Avances en ingeniería ambiental", "Ing. Deysi H. Vilchez Rosales", "Auditorio Central", "SEMINARIO"),
            Evento("Miércoles 5 de Junio", "15:00", "Concurso de robots seguidores de línea", null, "Patio de Ingeniería", "COMPETENCIA"),
            Evento("Miércoles 5 de Junio", "16:00", "Seminario: Automatización y control", "Ing. Daniel G. Soto Paredes", "Auditorio Central", "SEMINARIO"),

            // JUEVES 6 DE JUNIO
            Evento("Jueves 6 de Junio", "10:00", "Conferencia: Ingeniería química y bioprocesos", "Ing. José L. Huamán Alarcón", "Auditorio Central", "SEMINARIO"),
            Evento("Jueves 6 de Junio", "12:00", "Taller de creatividad e innovación", null, "Laboratorio de Innovación", "SEMINARIO"),
            Evento("Jueves 6 de Junio", "15:00", "Competencia de estructuras de espagueti", null, "Patio de Ingeniería", "COMPETENCIA"),
            Evento("Jueves 6 de Junio", "16:00", "Expo de proyectos de estudiantes", null, "Patio de Ingeniería", "COMPETENCIA"),

            // VIERNES 7 DE JUNIO
            Evento("Viernes 7 de Junio", "10:00", "Juegos deportivos interescuelas", null, "Campo Deportivo", "COMPETENCIA"),
            Evento("Viernes 7 de Junio", "13:00", "Almuerzo de confraternidad", null, "Comedor Universitario", "AGENDA"),
            Evento("Viernes 7 de Junio", "15:00", "Clausura y entrega de reconocimientos", null, "Auditorio Central", "AGENDA")
        )


        val rvAgenda = view.findViewById<RecyclerView>(R.id.rvAgenda)
        rvAgenda.layoutManager = LinearLayoutManager(requireContext())
        rvAgenda.adapter = EventoAdapter(eventos)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            Toast.makeText(requireContext(), "Función próximamente disponible", Toast.LENGTH_SHORT).show()
        }
    }
}
