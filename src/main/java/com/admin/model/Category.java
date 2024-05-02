package com.admin.model;

import lombok.*;

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
