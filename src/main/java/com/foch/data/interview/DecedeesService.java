package com.foch.data.interview;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DecedeesService {

    public final DecedeesRepository decedeesRepository;

    @Transactional
    public void txtToTable(@Valid MultipartFile file) throws IOException {

        val listDevice = txtFileReadAndSave(file.getInputStream());
        decedeesRepository.saveAll(listDevice);
    }


    private List<Decedees> txtFileReadAndSave(InputStream is) throws IOException {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            List<Decedees> lines = new ArrayList<>();

            String line = fileReader.readLine();

            while (line != null) {
                String[] split = StringUtils.split(line.substring(0, 80), "*");
                Decedees decedees = new Decedees();
                decedees.setNom_de_famille(split[0]);
                decedees.setPrenom(split[1].replaceAll("/",""));
                decedees.setSexe(line.substring(80, 81)); //Longueur : 1
                decedees.setDate_de_naissance(line.substring(81, 89)); //Longueur : 8
                decedees.setCode_du_lieu_de_naissance(line.substring(89, 94));  //Longueur : 5
                decedees.setLocalite_de_naissance(line.substring(94, 124));//Longueur : 30
                decedees.setLibelle_de_pays_de_naissance(line.substring(124, 154)); //Longueur : 30
                decedees.setDate_du_deces(line.substring(154, 162)); //Longueur : 8
                decedees.setCode_du_lieu_de_deces(line.substring(162, 167)); //Longueur : 5
                decedees.setNumero_dacte_de_deces(line.substring(167, 173)); //Longueur : 9

                lines.add(decedees);
                line = fileReader.readLine();
            }

            decedeesRepository.saveAll(lines);

            fileReader.close();

            return lines;
        }
    }

    public List<SummaryDataDao> getSomeData() {
        return decedeesRepository.findSummaryData();
    }
}
