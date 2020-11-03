package br.com.zgsolucoes.task.scheduler

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

class ExecutavelController {

	ExecutavelService executavelService

	static allowedMethods = [
			list     : "GET",
			show     : "GET",
			adicionar: "POST",
			atualizar: "PUT",
			remover  : "DELETE"
	]

	def show(Long id) {
		respond executavelService.get(id)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond executavelService.list(params)
	}

	def adicionar(Executavel executavel) {
		if (executavel == null) {
			respond([status: NOT_FOUND])
			return
		}

		try {
			executavel.dataCriacao = new Date()
			executavelService.save(executavel)
		} catch (ValidationException e) {
			respond([status: INTERNAL_SERVER_ERROR])
			return
		}

		respond([status: OK])
	}

	def atualizar(Executavel executavel) {
		if (executavel == null) {
			respond([status: NOT_FOUND])
			return
		}

		try {
			executavelService.save(executavel)
		} catch (ValidationException e) {
			respond([status: INTERNAL_SERVER_ERROR])
			return
		}

		respond([status: OK])
	}

	def remover(Long id) {
		if (id == null) {
			respond([status: NOT_FOUND])
			return
		}

		executavelService.delete(id)

		respond([status: OK])
	}

}
