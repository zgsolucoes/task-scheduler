package br.com.zgsolucoes.task.scheduler.executaveis

import br.com.zgsolucoes.task.scheduler.Execucao
import groovy.transform.CompileStatic

@CompileStatic
interface ClasseExecutavel {

	boolean execute(final Execucao execucao)

}
