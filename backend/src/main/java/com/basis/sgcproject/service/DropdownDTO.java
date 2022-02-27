package com.basis.sgcproject.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DropdownDTO {

    private String label;

    private Integer value;

    public DropdownDTO(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

}
