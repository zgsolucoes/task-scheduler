package br.com.zgsolucoes.task.scheduler

import grails.gorm.services.Service

@Service(Agendamento)
interface AgendamentoService {

	Agendamento get(Serializable id)

	List<Agendamento> list(Map args)

	Long count()

	void delete(Serializable id)

	Agendamento save(Agendamento agendamento)

}
