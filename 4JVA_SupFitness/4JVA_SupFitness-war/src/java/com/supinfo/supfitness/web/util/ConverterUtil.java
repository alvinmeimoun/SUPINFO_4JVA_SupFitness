/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.util;

/**
 *
 * @author Antonin
 */
public abstract class ConverterUtil {
    
    public static Long ConvertRequestParameterToLong(Object requestAttribute)
    {
        return Long.valueOf(String.valueOf(requestAttribute));
    }
    public static String ConvertRequestParameterToString(Object requestAttribute)
    {
        return String.valueOf(requestAttribute); 
    }
}
