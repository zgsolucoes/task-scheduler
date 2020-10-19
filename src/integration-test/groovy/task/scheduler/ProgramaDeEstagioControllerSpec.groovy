package task.scheduler

import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientException
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@Integration
class ProgramaDeEstagioControllerSpec extends Specification {

	@Shared
	@AutoCleanup
	HttpClient client

	@OnceBefore
	void init() {
		client = HttpClient.create(new URL("http://localhost:$serverPort"))
	}

	def setup() {}

	def cleanup() {}

	def 'teste action /programaDeEstagio/obtenhaNomeProjeto está seguro'() {
		when:
		HttpRequest request = HttpRequest.GET('/programaDeEstagio/obtenhaNomeProjeto')
		client.toBlocking().exchange(request)

		then:
		HttpClientException e = thrown(HttpClientException)
		e.response.status == HttpStatus.UNAUTHORIZED
	}

	def 'teste action /programaDeEstagio/obtenhaNomeProjeto está acessivel com usuário logado'() {
		when:
		HttpRequest req = HttpRequest.POST('/api/login', [username: 'usuario', password: '12345678'])
		HttpResponse<Map> resp = client.toBlocking().exchange(req, Map)

		then:
		resp.status == HttpStatus.OK

		when:
		String accessToken = resp.body().access_token
		resp.body().roles.find { it == 'ROLE_USER' }

		then:
		accessToken

		when:
		HttpResponse<String> rsp = client.toBlocking().exchange(HttpRequest.GET('/programaDeEstagio/obtenhaNomeProjeto')
																		.header('Authorization', "Bearer ${accessToken}"), String)

		then:
		rsp.status == HttpStatus.OK
		rsp.body() == 'Task-scheduler'
	}

}