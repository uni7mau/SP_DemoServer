package com.demos.demostealprocessserver.Controllers;

import com.demos.demostealprocessserver.Models.MyProcess;
import com.demos.demostealprocessserver.Services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HProcessController {

    private ProcessService service;

    @Autowired
    public void setService(ProcessService service) { this.service = service; }

    @GetMapping("/processes/")
    public List<MyProcess> getProcesses() { return service.getProcesses(); }

    @GetMapping("/processes/{id}")
    public MyProcess getProcessById(@PathVariable int id) { return service.getProcessById(id); }

    @PostMapping("/processes/")
    public void addProcess(@RequestBody MyProcess process) {
        service.addProcess(process);
    }

    @PutMapping("/processes/")
    public void updateProcess(@RequestBody MyProcess process) {
        service.updateProcess(process);
    }

    @DeleteMapping("/processes/{id}")
    public void deleteProcess(@PathVariable int id) { service.deleteProcess(id); }

}
