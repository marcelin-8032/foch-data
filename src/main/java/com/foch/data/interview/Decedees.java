package com.foch.data.interview;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "T_DECEDEES")
public class Decedees {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer decedeesId;

    @Column
    private String nom_de_famille;

    @Column
    private String prenom;

    @Column
    private String sexe;

    @Column
    private String date_de_naissance;

    @Column
    private String code_du_lieu_de_naissance;

    @Column
    private String localite_de_naissance;

    @Column
    private String libelle_de_pays_de_naissance;

    @Column
    private String date_du_deces;

    @Column
    private String code_du_lieu_de_deces;

    @Column
    private String numero_dacte_de_deces;
}
