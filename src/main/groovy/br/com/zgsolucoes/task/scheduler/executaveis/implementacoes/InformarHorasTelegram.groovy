package br.com.zgsolucoes.task.scheduler.executaveis.implementacoes

import br.com.zgsolucoes.task.scheduler.Evento
import br.com.zgsolucoes.task.scheduler.Execucao
import br.com.zgsolucoes.task.scheduler.StatusEvento
import br.com.zgsolucoes.task.scheduler.execucao.CriadorEventos
import br.com.zgsolucoes.task.scheduler.execucao.RegistradorEventoExecucao
import br.com.zgsolucoes.task.scheduler.executaveis.ClasseExecutavel
import br.com.zgsolucoes.task.scheduler.executaveis.ObterDadosDoPonto
import groovy.transform.CompileStatic
import groovyx.net.http.HttpBuilder
import groovyx.net.http.UriBuilder
import io.micronaut.context.annotation.Prototype
import org.springframework.beans.factory.annotation.Autowired

@Prototype
@CompileStatic
class InformarHorasTelegram implements ClasseExecutavel {

	@Autowired
	RegistradorEventoExecucao registradorEventoExecucao

	@Autowired
	ObterDadosDoPonto obterDadosDoPonto

	@Override
	boolean execute(final Execucao execucao) {
		registradorEventoExecucao.registrarEvento(execucao, 'Iniciando execução', StatusEvento.SUCESSO, 1.0)
		final Map env = System.getenv()
		final String TELEGRAM_BOT_ID = env['TELEGRAM_BOT_ID']
		final String TELEGRAM_BOT_KEY = env['TELEGRAM_BOT_KEY']
		final String TELEGRAM_CHAT_ID = env['TELEGRAM_CHAT_ID']

		registradorEventoExecucao.registrarEvento(execucao, 'Obtendo dados do ponto', StatusEvento.SUCESSO, 30.0)

		final String encodedMessage = obterDadosDoPonto.obterDadosPonto()

		registradorEventoExecucao.registrarEvento(execucao, 'Enviando mensagem para o telegram', StatusEvento.SUCESSO, 50.0)
		final String basePath = 'https://api.telegram.org/'
		final String uriPath = "/${TELEGRAM_BOT_ID}:${TELEGRAM_BOT_KEY}/sendMessage"

		final HttpBuilder httpBin = HttpBuilder.configure {
			request.uri = basePath
		}

		final Map<String, ?> params = [
				chat_id: "@${TELEGRAM_CHAT_ID}".toString(),
				text   : encodedMessage,
		]

		final Map result = httpBin.get {
			final UriBuilder uriBuilder = request.uri
			uriBuilder.path = uriPath
			uriBuilder.query = params
		} as Map

		registradorEventoExecucao.registrarEvento(execucao, 'Execução finalizada', StatusEvento.SUCESSO, 100.0)
		return result.ok
	}
}
