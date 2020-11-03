package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

import java.time.LocalDateTime

@GrailsCompileStatic
class Agendamento {

	LocalDateTime horaExecucao
	Executavel executavel
	List<ParametroAgendamento> parametros

	static constraints = {
	}
}
