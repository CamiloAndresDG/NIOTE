'''
Created on 28/02/2020

@author: aasanchez
'''
import json 

class Sensor():
    def __init__(self,typ,ide,mag,val):
        self.__ide=ide
        self.__typ=typ
        self.__mag=mag
        self.__val=val
    
    def getIde(self):
        return self.__ide
    
    def setIde(self,ide):
        self.__ide=ide    
    
    def getTyp(self):
        return self.__typ
    
    def setTyp(self,typ):
        self.__typ=typ      
    
    def getMag(self):
        return self.__mag
    
    def setMag(self,mag):
        self.__mag=mag
    
    def getVal(self):
        return self.__val
    
    def setVal(self,val):
        self.__val=val
        
    def toJason(self):
        self.__attributes = {"type" : "-","sensor-id" : "-","value" : "-", "magnitude" : "-"}
        self.__attributes["type"]=self.getTyp()
        self.__attributes["sensor-id"]=self.getIde()
        self.__attributes["value"]=self.getVal()
        self.__attributes["magnitude"]=self.getMag()
        self.__datajson = json.dumps(self.__attributes, indent=4,separators=(',',':'),sort_keys=False)
        return self.__datajson
    
    def __str__(self):           
        return self.toJason()


class ReadSensor():
    def __init__(self):
        self.__sensors=[]
    
    def getSensors(self,sensors):
        for s in sensors:   
            if s == 'all':
                self.createListAllSensor()                
                return self.__sensors   
        self.__sensors=[]
        for i in range(len(sensors)):   
            self.__sensors.append(json.loads(self.createSensor(sensors[i])))
        return self.__sensors 
    
    def createListAllSensor(self):
        self.__sensors=[
            json.loads(self.createSensor('tem')),
            json.loads(self.createSensor('hum')),
            json.loads(self.createSensor('vel')),
            json.loads(self.createSensor('dir')),
            json.loads(self.createSensor('plu')),
            json.loads(self.createSensor('rad'))]
        
    def createSensor(self,sensorType):
        if sensorType == 'tem':
            return Sensor('tem', 'Temperature', 'Celsius', '0.0').toJason()         
        elif sensorType == 'hum':
            return Sensor('hum', 'Humidity', 'percent', '0.0').toJason()  
        elif sensorType == 'vel':
            return Sensor('vel', 'Velocity', 'Km/h', '0.0').toJason()  
        elif sensorType == 'dir':
            return Sensor('dir', 'Direction', 'Cardinal_point', 'North').toJason() 
        elif sensorType == 'plu':
            return Sensor('plu', 'Pluviometer', 'mm3', '0.0').toJason()  
        elif sensorType == 'rad':
            return Sensor('rad', 'Radiation', 'W/m2', '0.0').toJason()  
        else:
            return Sensor('null', 'null', 'null', 'null').toJason()  
        