package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico1 = Topico(
                id = 1,
                titulo = "Dúvidas Kotlin 1",
                mensagem = "Variáveis no Kotlin",
                curso = Curso(
                        id = 1,
                        nome =  "Kotlin",
                        categoria = "Programação"
                ),
                autor = Usuario(
                        id = 1,
                        nome = "Diogo Silva",
                        email = "diogosilvaoficial@gmail.com"
                )
        )

        val topico2 = Topico(
                id = 2,
                titulo = "Dúvidas Kotlin 2",
                mensagem = "Variáveis no Kotlin",
                curso = Curso(
                        id = 1,
                        nome =  "Kotlin",
                        categoria = "Programação"
                ),
                autor = Usuario(
                        id = 1,
                        nome = "Diogo Silva",
                        email = "diogosilvaoficial@gmail.com"
                )
        )

        val topico3 = Topico(
                id = 3,
                titulo = "Dúvidas Kotlin 3",
                mensagem = "Variáveis no Kotlin",
                curso = Curso(
                        id = 1,
                        nome =  "Kotlin",
                        categoria = "Programação"
                ),
                autor = Usuario(
                        id = 1,
                        nome = "Diogo Silva",
                        email = "diogosilvaoficial@gmail.com"
                )
        )

        topicos =  Arrays.asList(topico1, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({
            topico -> topico.id == id
        }).findFirst().get()
    }

}