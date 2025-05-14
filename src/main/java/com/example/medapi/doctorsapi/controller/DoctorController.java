package com.example.medapi.doctorsapi.controller;


import org.springframework.web.bind.annotation.*;

import com.example.medapi.doctorsapi.domain.dto.AvailabilityDTO;
import com.example.medapi.doctorsapi.domain.dto.DoctorDTO;
import com.example.medapi.doctorsapi.domain.service.DoctorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public List<DoctorDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DoctorDTO> getDoctor(@PathVariable Long id) {
        return service.getDoctor(id);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<DoctorDTO> getDoctorsBySpecialty(@PathVariable String especialidad) {
        return service.getDoctorsBySpecialty(especialidad);
    }

    @GetMapping("/disponibles")
    public List<AvailabilityDTO> getAvailableDoctors(@RequestParam("fecha") String date) {
        return service.getAvailableDoctors(date);
    }

    @GetMapping("/disponibles/especialidad/{especialidad}")
    public List<AvailabilityDTO> getAvailableDoctorsBySpecialty(
            @RequestParam("fecha") String date,
            @PathVariable String especialidad) {
        return service.getAvailableDoctorsBySpecialty(date, especialidad);
    }

    @GetMapping("/disponibles/doctor/{id}")
    public List<AvailabilityDTO> getAvailableDoctorById(
            @RequestParam("fecha") String date,
            @PathVariable Long id) {
        return service.getAvailableDoctorById(date, id);
    }

    @PostMapping
    public DoctorDTO save(@RequestBody DoctorDTO doctor) {
        return service.save(doctor);
    }

    @PutMapping("/{id}")
    public DoctorDTO update(@PathVariable Long id, @RequestBody DoctorDTO doctor) {
        doctor.setId(id);
        return service.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
