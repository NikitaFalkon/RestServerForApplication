package com;

import com.model.Patient;
import com.repository.PatientRepository;
import com.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
@SpringBootApplication
@RestController
public class MyController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ReportService reportService;
    @GetMapping("/all")
    public List<Patient> patients(){
        return patientRepository.findAll();
    }
 /*   @GetMapping("/report/{format}")
    public RedirectView GenerateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return reportService.exportReport(format);
    }*/
    @GetMapping(value = "/report", produces = { MediaType.APPLICATION_PDF_VALUE})
    public byte[] getHTML(@RequestParam(name = "format", required = false) String format
                         /*@RequestParam(name = "sex", required = false) String sex,
                         @RequestParam(name = "age", required = false) String age*/
    ) throws IOException, JRException {
        reportService.exportReport(format);
        return Files.readAllBytes(new File("patients.pdf").toPath());
    }

    public static void main(String[] args) {
        SpringApplication.run(MyController.class);
    }
}
