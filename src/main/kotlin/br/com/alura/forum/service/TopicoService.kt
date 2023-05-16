package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
        private var topicos: List<Topico> = ArrayList(),
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoFormMapper: TopicoFormMapper,
        private val notFoundMessage: String = "Tópico não encontrado!"
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { topico -> topicoViewMapper.map(topico) }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }

        return TopicoView(
                id = topico.id,
                titulo = topico.titulo,
                mensagem = topico.mensagem,
                status = topico.status,
                dataCriacao = topico.dataCriacao,
                dataAtualizacao = topico.dataAtualizacao
        )
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter { topico ->
            topico.id == form.id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }

        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            respostas = topico.respostas,
            status = topico.status,
            dataCriacao = topico.dataCriacao,
            dataAtualizacao = LocalDateTime.now()
        )

        topicos = topicos.minus(topico).plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { topico ->
            topico.id == id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }

        topicos = topicos.minus(topico)
    }
}