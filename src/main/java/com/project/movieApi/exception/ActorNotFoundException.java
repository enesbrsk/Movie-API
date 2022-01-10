package com.project.movieApi.exception;

public class ActorNotFoundException extends RuntimeException{

    public ActorNotFoundException(String s){
        super(s);
    }
}
