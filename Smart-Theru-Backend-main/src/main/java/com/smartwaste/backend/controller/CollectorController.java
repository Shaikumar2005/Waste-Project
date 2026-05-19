package com.smartwaste.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.smartwaste.backend.entity.Collector;
import com.smartwaste.backend.service.CollectorService;

@RestController
@RequestMapping("/api/collectors")
@CrossOrigin("*")
public class CollectorController {

    private final CollectorService service;

    public CollectorController(CollectorService service) {
        this.service = service;
    }

    /**
     * ADMIN: Create Collector
     */
    @PostMapping
    public Collector create(@RequestBody Collector collector) {
        return service.createCollector(collector);
    }

    /**
     * ADMIN: Get all collectors
     */
    @GetMapping
    public List<Collector> getAll() {
        return service.getAllCollectors();
    }

    /**
     * ADMIN: Update collector
     */
    @PutMapping("/{id}")
    public Collector update(@PathVariable Long id,
                            @RequestBody Collector collector) {
        return service.updateCollector(id, collector);
    }

    /**
     * ADMIN: Delete collector
     */

    // ✅ DELETE API (IMPORTANT)
       @DeleteMapping("/{id}")
       public void delete(@PathVariable Long id) {
           service.deleteCollector(id);
       }

}
