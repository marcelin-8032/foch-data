package com.foch.data.interview;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class DecessService {


    public final DecessRepository decessRepository;

    public DecessService(DecessRepository decessRepository) {
        this.decessRepository = decessRepository;
    }

    public void saveData() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql:test", "postgres", "123456");
        File file = new File("/deces-2023-m10.txt");
        FileInputStream fis = new FileInputStream(file);
        PreparedStatement pstmt = conn
                .prepareStatement("insert into T_Decesses (" +
                        " le_nom_de_famille," +
                                "prénom,  " +
                                "sexe," +
                                "date_de_naissance," +
                                "code_du_lieu_de_naissance,"+
                                "la_localité_de_naissance,"+
                                "le_libellé_de_pays_de_naissance,"+
                        "la_date_du_décès,"+
                        "le_code_du_lieu_de_décès,"+
                        "le_numéro_dacte_de_décès,"+
                        " ) values (?,?,?,?,?,?,?,?,?)");
        pstmt.setInt(1, 1);
        pstmt.setBinaryStream(2, fis, (int) file.length());
        int check = pstmt.executeUpdate();
        System.out.println(check);
    }

    public SpecialDataDao getSomeData() {
       return decessRepository.findSomeData();
    }
}
