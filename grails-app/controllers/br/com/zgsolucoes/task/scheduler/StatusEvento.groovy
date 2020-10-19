package br.com.zgsolucoes.task.scheduler

import groovy.transform.CompileStatic

@CompileStatic
enum StatusEvento {
	SUCESSO('Sucesso'),
	ADVERTENCIA('Advertência'),
	ERRO('Erro')

	String descricao

	StatusEvento(final String descricao) {
		this.descricao = descricao
	}
}
