package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ExecutorExecutavelServiceSpec extends Specification
		implements ServiceUnitTest<ExecutorExecutavelService>,
				DomainUnitTest<Executavel> {


	void "Executar algum executavel com sucesso"() {
		given: 'eu tenho um executável'
		final String titulo = 'Informar horas completas no dia pelo telegram'
		final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'InformarHorasTelegram')
		executavel.save()

		and: 'instancio os mocks'
		final Execucao execucao = new Execucao()

		final ExecucaoFactoryService mockExecucaoFactory = Mock(ExecucaoFactoryService)
		mockExecucaoFactory.criarExecucao(executavel) >> { execucao }

		final ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)

		final ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
		classeExecutavelMock.execute(execucao) >> true

		mock.procurarClasseExecutavel(executavel) >> classeExecutavelMock

		service.classeExecutavelFactoryService = mock
		service.execucaoFactoryService = mockExecucaoFactory

		when: 'eu disparar a execução'
		boolean sucesso = service.executar(titulo)

		then: 'o retorno deve ser true'
		sucesso
	}

	void "Executar algum executavel sem sucesso"() {
		given: 'eu tenho um executável'
		final String titulo = 'Informar horas completas no dia pelo telegram'
		final Executavel executavel = new Executavel(titulo: titulo, classeExecutavel: 'InformarHorasTelegram')
		executavel.save()

		and: 'instancio os mocks'
		final Execucao execucao = new Execucao()

		final ExecucaoFactoryService mockExecucaoFactory = Mock(ExecucaoFactoryService)
		mockExecucaoFactory.criarExecucao(executavel) >> { execucao }

		final ClasseExecutavelFactoryService mock = Mock(ClasseExecutavelFactoryService)

		final ClasseExecutavel classeExecutavelMock = Mock(ClasseExecutavel)
		classeExecutavelMock.execute(execucao) >> false

		mock.procurarClasseExecutavel(executavel) >> classeExecutavelMock

		service.classeExecutavelFactoryService = mock
		service.execucaoFactoryService = mockExecucaoFactory

		when: 'eu disparar a execução'
		boolean sucesso = service.executar(titulo)

		then: 'o retorno deve ser false'
		!sucesso
	}

	//depois de cada teste
	def cleanup() {
	}
}
