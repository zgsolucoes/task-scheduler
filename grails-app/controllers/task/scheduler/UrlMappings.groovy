package task.scheduler

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}

		'/execucao/adicionar'(controller: 'executorExecutavel', action: 'executar')

		"/"(view: "/index")
		"500"(view: '/error')
		"404"(view: '/notFound')
	}
}
