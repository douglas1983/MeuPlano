package app.meuplano.usertest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.meuplano.usertest.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
