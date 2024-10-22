package ru.flish1.atmsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.flish1.atmsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
