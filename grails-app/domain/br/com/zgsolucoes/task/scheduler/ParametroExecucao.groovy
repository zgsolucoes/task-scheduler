package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ParametroExecucao {

	Execucao execucao
	Parametro parametro
	String valor

	static constraints = {
	}
}
