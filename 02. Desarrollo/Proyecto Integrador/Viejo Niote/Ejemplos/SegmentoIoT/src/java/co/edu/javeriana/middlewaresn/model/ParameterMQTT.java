/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.middlewaresn.model;

/**
 *
 * @author Oscar
 */
public class ParameterMQTT {
    
    public static String MQTTServer = "tcp://192.168.0.103:1883";
    public static String ClientIdListener = "MiddlewareSN";
    public static String ClientIdSendMessage = "MiddlewareSN_Send";
    public static String defaultTopic = "mqtt/temp";
    public static int qos = 2;
    
}
