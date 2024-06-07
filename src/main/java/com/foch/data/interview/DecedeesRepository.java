package com.foch.data.interview;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecedeesRepository extends CrudRepository<Decedees, Integer> {

    @Query(value = "SELECT DISTINCT nom_de_famille, prenom, date_de_naissance, date_du_deces FROM t_decedees", nativeQuery = true)
    List<SummaryDataDao> findSummaryData();
}
