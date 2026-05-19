package com.smartwaste.backend.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.*;

import com.smartwaste.backend.dto.AdminReportDTO;
import com.smartwaste.backend.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    // ✅ ADMIN REPORT
    @GetMapping("/admin")
    public AdminReportDTO getAdminReport() {
        return service.getAdminReport();
    }
    @GetMapping("/admin/date")
    public AdminReportDTO getByDate(
        @RequestParam LocalDate from,
        @RequestParam LocalDate to) {

        return service.getReportByDate(from, to);
    }
}