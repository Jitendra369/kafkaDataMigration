package com.kafka.producer.repo;

import com.kafka.producer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

     List<User> findTop10ByIsReadOrderById(boolean isActive);
}
