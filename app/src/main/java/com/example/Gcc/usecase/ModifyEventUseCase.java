package com.example.Gcc.usecase;

public class ModifyEventUseCase {

    private ModifyEventUseCase(){}

    private static class Holder {
        static ModifyEventUseCase instance = new ModifyEventUseCase();
    }

    public static ModifyEventUseCase getInstance(){
        return Holder.instance;
    }

}
