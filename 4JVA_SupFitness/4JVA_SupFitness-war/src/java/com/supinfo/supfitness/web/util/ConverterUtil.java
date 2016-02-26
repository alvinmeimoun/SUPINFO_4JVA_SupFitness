/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supfitness.web.util;

/**
 * Utilitaires de conversions
 */
public abstract class ConverterUtil {
    
    /**
     * Récupère d'un attribut d'une requête un object Long
     * @param requestAttribute Valeur de l'attribut de requête
     * @return Valeur Long de l'object
     */
    public static Long ConvertRequestParameterToLong(Object requestAttribute)
    {
        return Long.valueOf(String.valueOf(requestAttribute));
    }
    
    /**
     * Récupère d'un attribut d'une requête un object String
     * @param requestAttribute Valeur de l'attribut de requête
     * @return Valeur String de l'object
     */
    public static String ConvertRequestParameterToString(Object requestAttribute)
    {
        return String.valueOf(requestAttribute); 
    }
}
