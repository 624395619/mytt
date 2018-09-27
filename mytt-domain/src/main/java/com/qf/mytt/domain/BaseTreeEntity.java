package com.qf.mytt.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseTreeEntity extends BaseEntity implements Serializable {

    @JsonProperty(value="isParent")
    private boolean isParent;
}
