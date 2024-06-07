package com.foch.data.interview;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DecedeesController {

    public final DecedeesService decedeesService;

    @PostMapping(value = "/uploadFile", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void saveData(@RequestParam("file") MultipartFile file) throws SQLException, IOException, ClassNotFoundException {
        decedeesService.txtToTable(file);
    }

    @GetMapping
    public List<SummaryDataDao> getSummaryData() {
        return decedeesService.getSomeData();
    }

}
