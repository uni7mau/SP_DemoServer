package com.demos.demostealprocessserver.Controllers;

import com.demos.demostealprocessserver.Models.MyProcess;
import com.demos.demostealprocessserver.Services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WProcessController {

    private ProcessService service;

    @Autowired
    public void setService(ProcessService service) { this.service = service; }

    @MessageMapping("/process") // client vào "/app/process"
    @SendTo("/topic/process/") // server ra "/topic/processes"
    public MyProcess handleProcess(MyProcess process)
    {
        return service.saveOrUpdateProcess(process);
    }

}
