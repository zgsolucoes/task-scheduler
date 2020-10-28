package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

import java.time.LocalDateTime

@GrailsCompileStatic
class Execucao {

	List<ParametroExecucao> parametros
	BigDecimal progresso
	StatusExecucao status
	LocalDateTime data

	static hasMany = [eventos: Evento]

	static belongsTo = [executavel: Executavel]

	static constraints = {
	}
}
