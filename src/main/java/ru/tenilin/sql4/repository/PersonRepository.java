package ru.tenilin.sql4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.tenilin.sql4.entity.NameSurnameAge;
import ru.tenilin.sql4.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, NameSurnameAge> {
    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findByNameSurnameAge_AgeLessThanOrderByNameSurnameAge_AgeAsc(int age);

    @Query("SELECT c FROM Person c WHERE " +
            "(:name is null or c.nameSurnameAge.name = :name) " +
            "and :surname is null or c.nameSurnameAge.surname = :surname")
    List<Person> findByNameSurname(
            @Param("name") Optional<String> name,
            @Param("surname") Optional<String> surname);
}
