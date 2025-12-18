package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.service.DiversityTargetService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/targets")
public class DiversityTargetController {

    @Autowired
    DiversityTargetService service;

    @PostMapping("/")
    public DiversityTarget create(@RequestBody DiversityTarget target) {
        return service.createTarget(target);
    }

    @PutMapping("/{id}")
    public DiversityTarget update(@PathVariable Long id,
                                  @RequestBody DiversityTarget target) {
        return service.updateTarget(id, target);
    }

    @GetMapping("/")
    public List<DiversityTarget> getAll() {
        return service.getAllTargets();
    }

    @GetMapping("/year/{year}")
    public List<DiversityTarget> getByYear(@PathVariable Integer year) {
        return service.getTargetsByYear(year);
    }

    @PutMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        service.deactivateTarget(id);
        return "Target deactivated";
    }
}
