package com.demos.demostealprocessserver.Services;

import com.demos.demostealprocessserver.Repos.ProcessRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demos.demostealprocessserver.Models.MyProcess;

import java.util.List;

@Setter
@Getter
@Service
public class ProcessService {

    private ProcessRepo processRepo;

    @Autowired
    public void setProcessRepo(ProcessRepo processRepo) { this.processRepo = processRepo; }

    public List<MyProcess> getProcesses() { return processRepo.findAll(); }

    public MyProcess getProcessById(int id) { return processRepo.findById(id).orElse(new MyProcess()); }

    public void addProcess(MyProcess process) { processRepo.save(process); }

    public void updateProcess(MyProcess process) { processRepo.save(process); }

    public void deleteProcess(int id) { processRepo.deleteById(id); }

    public MyProcess saveOrUpdateProcess(MyProcess process) {
        if (processRepo.existsById(process.getId())) {
            MyProcess existing = processRepo.findById(process.getId()).get();
            existing.setName(process.getName());
            existing.setStatus(process.getStatus());
            existing.setParent_id(process.getParent_id());
            existing.setStart_time(process.getStart_time());
            return processRepo.save(existing);
        } else {
            return processRepo.save(process);
        }
    }

}
