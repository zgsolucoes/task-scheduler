package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class ExecutorExecutavelService {

	ClasseExecutavelFactoryService classeExecutavelFactoryService

	ExecucaoFactoryService execucaoFactoryService

	boolean executar(final Executavel executavel) {
		final Execucao execucao = execucaoFactoryService.criarExecucao(executavel)
		final ClasseExecutavel classeExecutavel = classeExecutavelFactoryService.procurarClasseExecutavel(executavel)
		return classeExecutavel.execute(execucao)
	}

}
