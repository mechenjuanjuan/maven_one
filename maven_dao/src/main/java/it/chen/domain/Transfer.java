package it.chen.domain;

import lombok.Data;

@Data
public class Transfer {
    private String sourceName;
    private String tragetName;
    private Float money;
}
