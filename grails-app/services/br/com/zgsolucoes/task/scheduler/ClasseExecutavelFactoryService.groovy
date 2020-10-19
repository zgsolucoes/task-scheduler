package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import org.springframework.context.ApplicationContext

@Transactional
@CompileStatic
class ClasseExecutavelFactoryService {

	ApplicationContext applicationContext

	ClasseExecutavel procurarClasseExecutavel(final Executavel executavel) {
		final Class clazz = Class.forName("br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.${executavel.classeExecutavel}")
		final ClasseExecutavel classeExecutavel = (ClasseExecutavel) applicationContext.getBean(executavel.classeExecutavel, clazz)
		return classeExecutavel
	}
}
