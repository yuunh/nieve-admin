package com.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "attachment")
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileNo;
    private String originName;
    private String changeName;
    private String filePath;
    private LocalDateTime uploadDate;
    private String status;
}
