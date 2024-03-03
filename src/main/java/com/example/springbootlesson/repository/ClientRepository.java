package com.example.springbootlesson.repository;

import com.example.springbootlesson.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("select c from Client c where c.name = :name")
    List<Client> findAllByName(String name);

    @Query("select c from Client c where c.name = :name")
    Optional<Client> findByName(String name);

    @Modifying
    @Query("update Client c set c.name = :name where c.id = :id")
    int updateNameById(Integer id, String name);
}