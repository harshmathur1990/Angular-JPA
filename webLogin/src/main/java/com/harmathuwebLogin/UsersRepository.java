 package com.harmathuwebLogin;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends PagingAndSortingRepository<Users, Long>{
	List<Users> findByLastName (String lastName);
	
	boolean findByUserNameAndPassWord(String userName, String passWord);
}
