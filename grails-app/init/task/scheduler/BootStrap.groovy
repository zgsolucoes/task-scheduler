package task.scheduler

import br.com.zgsolucoes.task.scheduler.Papel
import br.com.zgsolucoes.task.scheduler.Usuario
import grails.util.Environment

class BootStrap {

	def init = { servletContext ->
		if (Environment.current == Environment.TEST) {
			Papel.withNewTransaction {
				new Papel(authority: 'ROLE_USER').save()
			}
			Usuario.withNewTransaction {
				new Usuario(
						username: 'usuario',
						password: '12345678',
						email: 'user@email.com',
						authorities: [Papel.findByAuthority('ROLE_USER')].toSet()
				).save()
			}
		}
	}
	def destroy = {
	}
}
