package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Evento {

	Execucao execucao
	String descricao
	StatusEvento status

	static constraints = {
	}
}
