package com.harmathuwebLogin;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UsersRepository extends
		PagingAndSortingRepository<Users, Long> {
	public Users findByUserNameAndPassWord(String userName, String passWord);
}
