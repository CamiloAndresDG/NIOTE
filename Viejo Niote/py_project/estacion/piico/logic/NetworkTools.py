'''
Created on 28/02/2020

@author: aasanchez
'''
import json

class Network():
    '''
    classdocs
    '''


    def __init__(self):
        '''
        Constructor
        '''
        self.__wifiIP=self.__readWifiIP()
        self.__blueMAC=self.__readBlueMAC()
        self.__blueDev=self.__readBlueDev()
        
class Protocols():
    def __init__(self):
        self.__protocols=[]
    
    def getProtocols(self,protocols):
        for s in protocols:   
            if s == 'all':
                self.__protocols=["wifi","blue","xbee"]                
                return self.__protocols   
        self.__protocols=protocols
        return self.__protocols