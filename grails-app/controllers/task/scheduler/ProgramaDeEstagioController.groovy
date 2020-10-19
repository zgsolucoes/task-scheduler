package task.scheduler

import org.springframework.http.HttpStatus

class ProgramaDeEstagioController {

	def obtenhaNomeProjeto() {
		render([contentType: 'application/json', status: HttpStatus.OK], 'Task-scheduler') as Object
	}

}