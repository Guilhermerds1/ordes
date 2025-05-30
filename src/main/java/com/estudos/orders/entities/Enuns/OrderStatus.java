package com.estudos.orders.entities.Enuns;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCodee(){
        return code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus value: OrderStatus.values()){
            if(code == value.code){
                return value;
            }
        }

        throw  new IllegalArgumentException("Invalid OrderStatus code");
    }
}
