package br.com.zgsolucoes.task.scheduler

import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.InformarHorasTelegram
import br.com.zgsolucoes.task.scheduler.executaveis.implementacoes.InformarHorasWhatsapp
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

class ClasseExecutavelFactoryServiceSpec extends Specification
		implements ServiceUnitTest<ClasseExecutavelFactoryService>,
				DomainUnitTest<Executavel> {

	void "procurarClasseExecutavel retorna instancia correta de InformarHorasTelegram"() {
		given:
		final Executavel executavel = new Executavel(classeExecutavel: classe)
		final ApplicationContext applicationContext = Mock(ApplicationContext)
		applicationContext.getBean('InformarHorasWhatsapp', _) >> {
			new InformarHorasWhatsapp()
		}

		applicationContext.getBean('InformarHorasTelegram', _) >> {
			new InformarHorasTelegram()
		}

		service.applicationContext = applicationContext

		when:
		final ClasseExecutavel classeExecutavel = service.procurarClasseExecutavel(executavel)

		then:
		classeExecutavel.class.simpleName == classe

		where:
		classe                  | _
		'InformarHorasWhatsapp' | _
		'InformarHorasTelegram' | _
	}
}
