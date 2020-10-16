grails {
	plugin {
		springsecurity {
			rest {
				token {
					storage {
						jwt {
							secret = 'zgsolucoesTaskSchedulerProgramaDeEstagio'
						}
					}
				}
			}
			securityConfigType = "InterceptUrlMap"
			filterChain {
				chainMap = [
						[pattern: '/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter']
				]
			}
			userLookup {
				userDomainClassName = 'br.com.zgsolucoes.task.scheduler.Usuario'
				authorityJoinClassName = 'br.com.zgsolucoes.task.scheduler.UsuarioPapel'
			}
			authority {
				className = 'br.com.zgsolucoes.task.scheduler.Papel'
			}
			interceptUrlMap = [
					[pattern: '/**', access: ['ROLE_USER']]
			]
		}
	}
}