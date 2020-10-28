package br.com.zgsolucoes.task.scheduler

import groovy.transform.CompileStatic

import java.time.LocalDateTime

@CompileStatic
class ExecucaoFactoryService {

	Execucao criarExecucao(final Executavel executavel) {
		return new Execucao(
				executavel: executavel,
				data: LocalDateTime.now(),
				status: StatusExecucao.EM_EXECUCAO,
				progresso: BigDecimal.ZERO,
		)
	}

}
