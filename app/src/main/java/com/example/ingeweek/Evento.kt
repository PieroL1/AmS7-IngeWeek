// Evento.kt
package com.example.ingeweek

data class Evento(
    val fecha: String,       // ej: "Lunes 2 de Junio"
    val hora: String,        // ej: "10:00 AM"
    val titulo: String,      // ej: "Inauguración"
    val ponente: String?,    // opcional, para seminarios
    val lugar: String,       // ej: "Biblioteca Central"
    val tipo: String         // "AGENDA", "COMPETENCIA", "SEMINARIO"
)
