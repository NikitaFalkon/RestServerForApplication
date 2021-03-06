package com.service;

import com.model.Analys;
import com.model.Patient;
import com.repository.AnalysisRepository;
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
    @Autowired
    AnalysisRepository analysisRepository;
    public void exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Analys> analyses = analysisRepository.findAll();
        /*analyses.forEach(analys -> {analys.ForGraph();
            System.out.println(analys);});*/
        File file = null;
        if(reportFormat.equals("table"))
        {
            file = ResourceUtils.getFile("classpath:AnalTabl.jrxml");
        }
        else
        {
            file = ResourceUtils.getFile("classpath:Analysis.jrxml");
        }
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(analyses);
        Map<String, Object> map = new HashMap<>();
        map.put("My Name", "is Nikita");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);
//        if (reportFormat.equalsIgnoreCase("html")) {
            //JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\FilesForJava" + "\\patients.pdf");
        JasperExportManager.exportReportToPdfFile(jasperPrint, "patients.pdf");
//        }
  /*      if (reportFormat.equalsIgnoreCase("jpg")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "C:\\FilesForJava" + "\\patients.jpg");
        }*/
    }
}
