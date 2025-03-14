package com.pb.personajes_bakend.repository;

import com.pb.personajes_bakend.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findAllByOrderByNameAsc();

    List<Character> findAllByOrderByCreatedDateDesc();
}
