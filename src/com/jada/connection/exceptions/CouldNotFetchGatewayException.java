package com.jada.connection.exceptions;

public class CouldNotFetchGatewayException extends Exception {

    public void handle(){
        System.out.println("There was a Problem fetching the gateway"
                        + "\n"
                        + "Check internet connection or Discord Status");
    }
}
