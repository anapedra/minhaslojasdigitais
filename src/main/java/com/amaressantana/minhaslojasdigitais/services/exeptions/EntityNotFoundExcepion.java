package com.amaressantana.minhaslojasdigitais.services.exeptions;

public class EntityNotFoundExcepion extends RuntimeException{
    private static final long serialVersionUID=1L;
    public EntityNotFoundExcepion(String msg){
        super(msg);
    }
}
