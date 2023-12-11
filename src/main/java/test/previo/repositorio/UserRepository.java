package test.previo.repositorio;

import org.springframework.stereotype.Repository;

import test.previo.entidades.User;

@Repository
public class UserRepository {

	public User findUserByEmail(String email){
        User user = new User(email,"123456");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        return user;
    }
}
