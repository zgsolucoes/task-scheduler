package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic
import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

@GrailsCompileStatic
class AgendamentoController {

	AgendamentoService agendamentoService

	def list(final Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond agendamentoService.list(params)
	}

	def adicionar(final Agendamento agendamento) {
		if (agendamento == null) {
			respond([status: NOT_FOUND])
			return
		}

		try {
			agendamentoService.save(agendamento)
		} catch (ValidationException e) {
			respond([status: INTERNAL_SERVER_ERROR])
			return
		}

		respond([status: OK])
	}

	def remover(final Long id) {
		if (id == null) {
			respond([status: NOT_FOUND])
			return
		}

		try {
			agendamentoService.delete(id)
		} catch (ValidationException e) {
			respond([status: INTERNAL_SERVER_ERROR])
			return
		}

		respond([status: OK])
	}
}
