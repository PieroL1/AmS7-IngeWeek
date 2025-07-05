package com.example.ingeweek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UbicacionesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UbicacionesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ubicaciones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        toolbar.title = "Ubicaciones"

        val ubicaciones = listOf(
            Ubicacion("Auditorio Central", "Primer piso, edificio principal"),
            Ubicacion("Patio de Ingeniería", "Zona central entre pabellones"),
            Ubicacion("Laboratorio de Cómputo", "Segundo piso, Pabellón B"),
            Ubicacion("Campo Deportivo", "A espaldas de la facultad"),
            Ubicacion("Plaza Principal", "Frente al comedor universitario"),
            Ubicacion("Comedor Universitario", "A la derecha de la entrada principal")
        )

        val rvUbicaciones = view.findViewById<RecyclerView>(R.id.rvUbicaciones)
        rvUbicaciones.layoutManager = LinearLayoutManager(requireContext())
        rvUbicaciones.adapter = UbicacionAdapter(ubicaciones)
    }
}
