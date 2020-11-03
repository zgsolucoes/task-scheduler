package br.com.zgsolucoes.task.scheduler

import grails.gorm.services.Service

@Service(Execucao)
interface ExecucaoService {

	Execucao get(Serializable id)

	List<Execucao> list(Map args)

	Long count()

	void delete(Serializable id)

	Execucao save(Execucao execucao)

}
