package br.com.zgsolucoes.task.scheduler.executaveis.implementacoes

import br.com.zgsolucoes.task.scheduler.Execucao
import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import groovy.transform.CompileStatic
import io.micronaut.context.annotation.Prototype

@Prototype
@CompileStatic
class InformarHorasEmail implements ClasseExecutavel {
	@Override
	boolean execute(final Execucao execucao) {
		return false
	}
}
