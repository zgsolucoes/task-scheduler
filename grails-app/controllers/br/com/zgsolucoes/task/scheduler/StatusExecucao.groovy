package br.com.zgsolucoes.task.scheduler

import groovy.transform.CompileStatic

@CompileStatic
enum StatusExecucao {
	ERRO('Erro'),
	CONCLUIDO('Concluído'),
	EM_EXECUCAO('Em Execução')

	String descricao

	StatusExecucao(final String descricao) {
		this.descricao = descricao
	}
}
