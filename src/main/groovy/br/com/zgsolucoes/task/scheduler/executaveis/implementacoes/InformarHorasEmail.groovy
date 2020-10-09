package br.com.zgsolucoes.task.scheduler.executaveis.implementacoes

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import groovy.transform.CompileStatic

@CompileStatic
class InformarHorasEmail implements ClasseExecutavel {
	@Override
	boolean execute() {
		return false
	}
}
