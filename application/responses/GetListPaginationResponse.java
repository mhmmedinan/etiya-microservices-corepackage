package com.etiya.corepackage.application.responses;

import com.etiya.corepackage.persistence.paging.BasePageableModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class GetListPaginationResponse<T> extends BasePageableModel {

    private List<T> items;

    public List<T> getItems(){
        if (items==null)
            items= new ArrayList<>();
        return items;
    }

    public void setItems(List<T> items){
        this.items=items;
    }
}
