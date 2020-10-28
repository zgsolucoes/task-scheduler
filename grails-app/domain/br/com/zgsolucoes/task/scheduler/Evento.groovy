package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Evento {

	String descricao
	StatusEvento status

	static belongsTo = [execucao: Execucao]

	static constraints = {
	}
}
