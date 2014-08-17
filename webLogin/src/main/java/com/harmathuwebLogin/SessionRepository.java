package com.harmathuwebLogin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface SessionRepository extends CrudRepository<Sessions, String> {

}
