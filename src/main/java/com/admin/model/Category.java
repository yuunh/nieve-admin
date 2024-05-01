package com.admin.model;

import lombok.*;

import java.lang.classfile.instruction.StackInstruction;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {

    private int categoryNo;
    private String categoryName;
}
