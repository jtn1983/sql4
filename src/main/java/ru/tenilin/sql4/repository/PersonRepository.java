package ru.tenilin.sql4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.tenilin.sql4.entity.NameSurnameAge;
import ru.tenilin.sql4.entity.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Persons, NameSurnameAge> {
    List<Persons> findByCityOfLiving(String cityOfLiving);

    List<Persons> findByNameSurnameAge_AgeLessThanOrderByNameSurnameAge_AgeAsc(int age);

    @Query("SELECT c FROM Persons c WHERE " +
            "(:name is null or c.nameSurnameAge.name = :name) " +
            "and :surname is null or c.nameSurnameAge.surname = :surname")
    List<Persons> findByNameSurname(
            @Param("name") Optional<String> name,
            @Param("surname") Optional<String> surname);
}
