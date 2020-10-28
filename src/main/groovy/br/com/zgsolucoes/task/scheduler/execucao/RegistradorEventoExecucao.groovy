package br.com.zgsolucoes.task.scheduler.execucao

import br.com.zgsolucoes.task.scheduler.Evento
import br.com.zgsolucoes.task.scheduler.Execucao
import br.com.zgsolucoes.task.scheduler.StatusEvento
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

import javax.inject.Singleton

@Singleton
@CompileStatic
class RegistradorEventoExecucao {

	@Autowired
	CriadorEventos criadorEventos

	void registrarEvento(final Execucao execucao, final String descricao, final StatusEvento statusEvento, final BigDecimal progresso = null) {
		final Evento evento = criadorEventos.criarEvento(descricao, statusEvento)

		if (progresso) {
			execucao.progresso = progresso
		}

		execucao.addToEventos(evento)
		evento.save()
	}

}
