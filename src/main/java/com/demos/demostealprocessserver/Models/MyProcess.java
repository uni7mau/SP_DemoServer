package com.demos.demostealprocessserver.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name="myprocess")
@Data
public class MyProcess {

    @Id
    private int id;
    private String name;
    private String status;
    public int parent_id;
    private OffsetDateTime start_time;

}
