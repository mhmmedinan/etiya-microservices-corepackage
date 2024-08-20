package com.etiya.corepackage.persistence.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasePageableModel {
    private int totalPages;
    private boolean hasNext;
    private boolean hasPrevious;
    private int size;
}
