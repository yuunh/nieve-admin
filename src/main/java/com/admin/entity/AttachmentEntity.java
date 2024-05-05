package com.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.sql.Date;

@Entity(name = "attachment")
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileNo;
    private String originName;
    private String changeName;
    private String filePath;
    private Date uploadDate;
    private int fileLevel;
    private String status;
}
