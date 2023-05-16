package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {
    override fun map(t: Topico): TopicoView {
        return TopicoView(
                id = t.id,
                titulo = t.titulo,
                mensagem = t.mensagem,
                status = t.status,
                dataCriacao = t.dataCriacao,
                dataAtualizacao = LocalDateTime.now()
        )
    }

}