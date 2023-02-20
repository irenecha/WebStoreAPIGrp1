package com.m2i.WebStore.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStore.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
