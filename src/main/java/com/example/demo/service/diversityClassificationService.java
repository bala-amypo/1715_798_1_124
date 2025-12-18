package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.DiversityClassification;

public interface DiversityClassificationService {

    DiversityClassification createClassification(DiversityClassification c);

    DiversityClassification updateClassification(Long id, DiversityClassification c);

    List<DiversityClassification> getAllClassifications();

    DiversityClassification getById(Long id);

    void deactivateClassification(Long id);
}
