package br.com.alura.forum.model

import br.com.alura.forum.enum.StatusTopico
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topico(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        var titulo: String,

        var mensagem: String,

        val dataCriacao: LocalDateTime = LocalDateTime.now(),

        val dataAtualizacao: LocalDateTime?,

        @ManyToOne
        val curso: Curso,

        @ManyToOne
        val autor: Usuario,

        @Enumerated(value = EnumType.STRING)
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

        @OneToMany(mappedBy = "topico")
        val respostas: List<Resposta> = ArrayList()
)