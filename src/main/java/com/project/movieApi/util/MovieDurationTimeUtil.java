package com.project.movieApi.util;

public class MovieDurationTimeUtil {

    public static String getMovieDurationString(int duration){
        return (duration / 60) + "h "+ (duration % 60) + "m";
    }

}
