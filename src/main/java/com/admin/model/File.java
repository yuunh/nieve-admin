package com.admin.model;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class File {

    private int fileNo;
    private String originName;
    private String changeName;
    private String filePath;
    private LocalDateTime uploadDate;
    private String status;
}
