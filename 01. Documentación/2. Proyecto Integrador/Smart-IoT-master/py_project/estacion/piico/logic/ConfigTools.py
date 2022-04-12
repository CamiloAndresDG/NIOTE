'''
Created on 28/02/2020

@author: aasanchez
'''
import json
from logic.SensorTools import ReadSensor
from logic.NetworkTools import Protocols

class Ubiety():
    def __init__(self,longitude,latitude):
        self.__longitude=float(longitude)
        self.__latitude=float(latitude)
    
    def getLongitude(self):
        return self.__longitude
    
    def setLongitude(self,longitude):
        self.__longitude=longitude
    
    def getLatitude(self):
        return self.__latitude
    
    def setLatitude(self,latitude):
        self.__latitude=latitude
    
    def toJason(self):
        self.__attributes = {"lon" : "-","lat" : "-"}
        self.__attributes["lon"]=self.getLongitude()
        self.__attributes["lat"]=self.getLatitude()
        self.__datajson = json.dumps(self.__attributes,indent=4,sort_keys=False)
        return self.__datajson
    
    def __str__(self):           
        return self.toJason()


class Station():  
    def __init__(self,nameId,ubiety,protocols,sensors,actuarors,gateway,broker):
        self.__nameId=self.__setNameId(nameId)
        self.__ubiety=self.__setUbiety(ubiety)
        self.__protocols=self.__loadProtocols(protocols)
        self.__sensors=self.__loadSensors(sensors)
        self.__actuators=self.__loadActuators(actuarors)
        self.__gateway=self.__setGateway(gateway)
        self.__broker=self.__setBroker(broker)        
        self.__network=self.__configNetwork()
    
    def getNameId(self):
        return self.__nameId
    
    def setNameId(self, nameId):
        self.__nameId=nameId
    
    def getUbiety(self):
        return self.__ubiety
    
    def setUbiety(self, ubiety):
        self.__ubiety=ubiety
        
    def getProtocols(self):
        return self.__protocols
    
    def setProtocols(self, protocols):
        self.__protocols=protocols   
    
    def getSensors(self):
        return self.__sensors
    
    def setSensors(self, sensors):
        self.__sensors=sensors
    
    def getActuators(self):
        return self.__actuators
    
    def setActuators(self, actuators):
        self.__actuators=actuators
    
    def getGateway(self):
        return self.__gateway
    
    def setGateway(self, gateway):
        self.__gateway=gateway
    
    def getBroker(self):
        return self.__broker
    
    def setBroker(self, broker):
        self.__broker=broker
    
    def getNetwork(self):
        return self.__network
    
    def setNetwork(self, network):
        self.__broker=network
        
    def toJason(self):
        self.__attributes = {"node-id" : "-","gps" : {},"protocols" : "-", "sensors" : "-", "actuators" : "-","gateway" : "-","broker" : "-","network" : "-",}
        self.__attributes["node-id"]=self.getNameId()
        self.__attributes["gps"]=json.loads(self.getUbiety().toJason())
        self.__attributes["protocols"]=self.getProtocols()
        self.__attributes["sensors"]=self.getSensors()
        self.__attributes["actuators"]=self.getActuators()
        self.__attributes["gateway"]=self.getGateway()
        self.__attributes["broker"]=self.getBroker()
        self.__attributes["network"]=self.getNetwork()       
        self.__datajson = json.dumps(self.__attributes, indent=4,separators=(',',':'),sort_keys=False)
        return self.__datajson
    
    def __str__(self):           
        return self.toJason()
        
    '''
    metodos de configuracion
    '''

    def __setNameId(self,nameId):
        return nameId[0]
    
    def __setUbiety(self,ubiety):
        ub = Ubiety(ubiety[0], ubiety[1])
        return ub
    
    def __loadSensors(self,sensors):
        return ReadSensor().getSensors(sensors)
    
    def __loadActuators(self,actuators):
        return actuators
    
    def __loadProtocols(self,protocols):
        return Protocols().getProtocols(protocols)
    
    def __setGateway(self,gateway):
        return gateway
    
    def __setBroker(self,broker):
        return broker

    def __configNetwork(self):
        return "net"
        