package com.example.usermanagment.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathChecker {
    public static boolean checkURLPath(String path , String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(path);
        return matcher.find();
    }
}
