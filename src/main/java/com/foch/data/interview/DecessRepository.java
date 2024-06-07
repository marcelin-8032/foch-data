package com.foch.data.interview;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecessRepository extends CrudRepository<Decesses, Integer> {


    @Query(value = "SELECT nom, prénoms, date_de_naissance, date_de_décès FROM T_Decesses",  nativeQuery = true)
     SpecialDataDao findSomeData();




}
