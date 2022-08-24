package com.anacarolcosta.apidorama.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "drama")
data class DramaModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var titulo: String,

    @Column
    var anoLancamento: Int,

    @Column
    var temporadas: Int,

    @Column
    var quantidadeEpisodios: Int,

    @ManyToOne
    @JoinColumn(name = "genero_id")
    var genero: GeneroModel? = null,

    @ManyToOne
    @JoinColumn(name = "plataforma_id")
    var plataforma: PlataformaModel? = null
)