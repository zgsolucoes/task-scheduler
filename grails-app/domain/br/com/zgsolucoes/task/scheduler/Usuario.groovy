package br.com.zgsolucoes.task.scheduler

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	String username
	String password
	String email
	Date dataNascimento
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false

	static hasMany = [authorities: Papel]

	static constraints = {
		password nullable: false, blank: false, password: true
		username nullable: false, blank: false, unique: true
		email nullable: false
		dataNascimento nullable: true
	}

	static mapping = {
		password column: '`password`'
		authorities joinTable: [name: 'usuario_papel', key: 'usuario_id']
	}
}
