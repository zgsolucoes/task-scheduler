package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ExecutorExecutavelServiceSpec extends Specification
		implements ServiceUnitTest<ExecutorExecutavelService>,
				DomainUnitTest<Executavel> {


	void "Executar algum executavel com sucesso"() {
		given: 'instancio os mocks'
		final ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)
		final ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
		classeExecutavelMock.execute() >> true
		mock.procurarClasseExecutavel(_) >> classeExecutavelMock

		service.classeExecutavelFactoryService = mock

		and: 'eu tenho um executável'
		final String titulo = 'Informar horas completas no dia pelo telegram'
		final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'InformarHorasTelegram')
		executavel.save()

		when: 'eu disparar a execução'
		boolean sucesso = service.executar(titulo)

		then: 'o retorno deve ser true'
		sucesso
	}

	void "Executar algum executavel sem sucesso"() {
		given: 'instancio os mocks'
		final ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)
		final ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
		classeExecutavelMock.execute() >> false
		mock.procurarClasseExecutavel(_) >> classeExecutavelMock

		service.classeExecutavelFactoryService = mock

		and: 'eu tenho um executável'
		final String titulo = 'Informar horas completas no dia pelo telegram'
		final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'InformarHorasTelegram')
		executavel.save()

		when: 'eu disparar a execução'
		boolean sucesso = service.executar(titulo)

		then: 'o retorno deve ser false'
		!sucesso
	}

	//depois de cada teste
	def cleanup() {
	}
}
