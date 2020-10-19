package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Agendamento {

	Executavel executavel
	List<ParametroAgendamento> parametros

	static constraints = {
	}
}
