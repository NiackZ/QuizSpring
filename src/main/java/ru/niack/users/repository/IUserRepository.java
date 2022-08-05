package ru.niack.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.niack.users.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
