 package com.harmathuwebLogin;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends PagingAndSortingRepository<Users, Long>{
	List<Users> findByLastName (@Param("lastName") String lastName);
	
	
	Users findByUserNameAndPassWord(@Param("userName") String userName, @Param("passWord") String passWord);
}
