package com.amaressantana.minhaslojasdigitais.model.entitysenus;

public enum OrderStatos {
    NUll(0),
    WAITING_PAYMENTM(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;
    private OrderStatos(int code){
        this.code=code;
    }

    public int getCode(){
       return code;
    }
    public static OrderStatos valueOf(int code){
        for (OrderStatos value : OrderStatos.values()){
             if (value.getCode() == code){
                 return value;
             }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code" );
    }


}
