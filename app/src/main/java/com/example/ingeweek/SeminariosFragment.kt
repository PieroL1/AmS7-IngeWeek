package com.example.ingeweek

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout

class SeminariosFragment : Fragment() {

    // Simulación: puedes adaptar según tus datos reales
    val seminarios = listOf(
        // Civil
        Evento("Martes 4 de Junio", "12:00", "Impacto de la ingeniería civil en la sociedad", "Ing. Juan R. Paredes Aquino", "Auditorio Central", "SEMINARIO"),
        // Sistemas
        Evento("Lunes 3 de Junio", "15:00", "Innovación y desarrollo de software", "Ing. Marco A. Zevallos Tello", "Auditorio Central", "SEMINARIO"),
        Evento("Martes 4 de Junio", "16:00", "Hackathon IngeWeek", null, "Laboratorio de Cómputo", "SEMINARIO"),
        // Eléctrica
        Evento("Miércoles 5 de Junio", "09:00", "Tendencias de la ingeniería eléctrica", "Ing. David J. Quispe Huamán", "Auditorio Central", "SEMINARIO"),
        // Ambiental
        Evento("Miércoles 5 de Junio", "11:00", "Avances en ingeniería ambiental", "Ing. Deysi H. Vilchez Rosales", "Auditorio Central", "SEMINARIO"),
        // Energía
        Evento("Martes 4 de Junio", "10:00", "Ingeniería sostenible y energías renovables", "Ing. Giannina A. Espinoza Yzarra", "Auditorio Central", "SEMINARIO"),
        // Química
        Evento("Jueves 6 de Junio", "10:00", "Ingeniería química y bioprocesos", "Ing. José L. Huamán Alarcón", "Auditorio Central", "SEMINARIO"),
        // Automatización
        Evento("Miércoles 5 de Junio", "16:00", "Automatización y control", "Ing. Daniel G. Soto Paredes", "Auditorio Central", "SEMINARIO")
    )

    // Map de escuela a lista de seminarios
    val escuelas = listOf("Civil", "Sistemas", "Eléctrica", "Ambiental", "Energía", "Química", "Automatización")

    val seminariosPorEscuela = mapOf(
        "Civil" to seminarios.filter { it.titulo.contains("civil", ignoreCase = true) },
        "Sistemas" to seminarios.filter { it.titulo.contains("software", ignoreCase = true) || it.titulo.contains("Hackathon", ignoreCase = true) },
        "Eléctrica" to seminarios.filter { it.titulo.contains("eléctrica", ignoreCase = true) },
        "Ambiental" to seminarios.filter { it.titulo.contains("ambiental", ignoreCase = true) },
        "Energía" to seminarios.filter { it.titulo.contains("energía", ignoreCase = true) || it.titulo.contains("renovables", ignoreCase = true) },
        "Química" to seminarios.filter { it.titulo.contains("química", ignoreCase = true) || it.titulo.contains("bioprocesos", ignoreCase = true) },
        "Automatización" to seminarios.filter { it.titulo.contains("automatización", ignoreCase = true) || it.titulo.contains("control", ignoreCase = true) }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_seminarios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        toolbar.title = "Seminarios"

        val tabEscuelas = view.findViewById<TabLayout>(R.id.tabEscuelas)
        val rvSeminarios = view.findViewById<RecyclerView>(R.id.rvSeminarios)

        // Crea una pestaña por cada escuela
        for (escuela in escuelas) {
            tabEscuelas.addTab(tabEscuelas.newTab().setText(escuela))
        }

        rvSeminarios.layoutManager = LinearLayoutManager(requireContext())

        // Mostrar los seminarios de la primera escuela por defecto
        rvSeminarios.adapter = EventoAdapter(seminariosPorEscuela[escuelas[0]] ?: emptyList())

        // Cambia la lista según la pestaña seleccionada
        tabEscuelas.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val seleccion = tab?.text.toString()
                rvSeminarios.adapter = EventoAdapter(seminariosPorEscuela[seleccion] ?: emptyList())
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}
