package com.CarSelling.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarSelling.project.model.StatistiqueCommission;
import com.CarSelling.project.model.StatistiqueVoitureVendu;
import com.CarSelling.project.service.StatistiqueService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/statistiquecontroller")
public class StatistiqueController {
    @Autowired
    private StatistiqueService statistiqueService;

    @GetMapping(path = "/commission")
    public List<StatistiqueCommission> getCommissionParMois(HttpServletRequest request) {
        return statistiqueService.getCommissionParMois(Integer.valueOf(request.getParameter("annee")));

    }

    @GetMapping(path = "/vendu")
    public List<StatistiqueVoitureVendu> getVoitureVenduParMois(HttpServletRequest request) {
        return statistiqueService.getVoitureVenduParMois(Integer.valueOf(request.getParameter("annee")));

    }
}