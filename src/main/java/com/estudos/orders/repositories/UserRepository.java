package com.estudos.orders.repositories;

import com.estudos.orders.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
