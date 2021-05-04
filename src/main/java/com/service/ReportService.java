package com.service;

import com.model.Patient;
import com.repository.PatientRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    PatientRepository patientRepository;
    public void exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Patient> patientList = patientRepository.findAll();
        File file = ResourceUtils.getFile("classpath:diagram.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(patientList);
        Map<String, Object> map = new HashMap<>();
        map.put("My Name", "is Nikita");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\FilesForJava" + "\\patients.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\FilesForJava" + "\\patients.pdf");
        }
    }
}
