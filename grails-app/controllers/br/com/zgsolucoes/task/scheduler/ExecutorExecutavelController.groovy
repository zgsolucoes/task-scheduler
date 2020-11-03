package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic
import org.springframework.http.HttpStatus

@GrailsCompileStatic
class ExecutorExecutavelController {

	ExecutorExecutavelService executorExecutavelService

	def executar(final Executavel executavel) {
		if (!executavel) {
			render(status: HttpStatus.NOT_FOUND)
			return
		}

		executorExecutavelService.executar(executavel)
		respond([status: HttpStatus.OK])
	}
}
