package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ParametroAgendamento {

	Agendamento agendamento
	Parametro parametro
	String valor

	static constraints = {
	}
}
