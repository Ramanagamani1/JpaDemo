package com.example.jpademo.repositories;

import com.example.jpademo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    /**
     * @Query -- To execute custom queries
     * 1. JPQL - Java persistence Query language (Keeping java objects in mind)
     * 2. Native Query - Writing queries keeping sql table in mind
     */

    @Query
    List<Employee> findByNameAndAgeAndCountry(String name, Integer age, String country);

     @Modifying
     @Transactional
     @Query("update Employee e set e.name=?1, e.age=?2, e.country=?3, e.yearsOfExp=?4, e.address=?5 where e.id=?6")
     public void update(String name, Integer age, String country, Integer yearsOfExp, String address, Integer id);

}
