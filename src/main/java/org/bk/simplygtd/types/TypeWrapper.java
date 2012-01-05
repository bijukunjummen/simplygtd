package org.bk.simplygtd.types;

import java.util.List;

public class TypeWrapper<T> {
    private final List<T> data;
    private  final Boolean success;
    
    public TypeWrapper(List<T> data, Boolean success){
        this.data = data;
        this.success = success;
    }

    public List<T> getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }
        
}
