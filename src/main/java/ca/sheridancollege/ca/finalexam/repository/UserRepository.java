package ca.sheridancollege.ca.finalexam.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.ca.finalexam.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	<Optional> User findByName(String name);
}
