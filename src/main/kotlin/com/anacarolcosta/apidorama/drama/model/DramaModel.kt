package com.anacarolcosta.apidorama.drama.model

import com.anacarolcosta.apidorama.genero.model.GeneroModel
import com.anacarolcosta.apidorama.plataforma.model.DramaModel
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

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

    @OneToOne
    @JoinColumn(name = "genero_id")
    var genero: GeneroModel? = null,

    @OneToOne
    @JoinColumn(name = "plataforma_id")
    var plataforma: DramaModel? = null
)