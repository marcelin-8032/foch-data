package com.foch.data.interview;


import jakarta.persistence.*;

@Entity
@Table(name = "T_Decesses")
public class Decesses {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer decesseId;

    private String le_nom_de_famille;

    private String prénom;

    private String sexe;

    private String date_de_naissance;

    private String code_du_lieu_de_naissance;

    private String la_localité_de_naissance;

    private String le_libellé_de_pays_de_naissance;

    private String la_date_du_décès;

    private String le_code_du_lieu_de_décès;

    private String le_numéro_dacte_de_décès;

}
