
import serial
import time
import sys
import os
import json
import string


attributes = {
'sensor-id' : '-',
'node-id'   : '-',
'gate-id'   : '-',
'date'      : '-',
'value'     : '-',
'magnitude' : '-',
'gps'       : '-',
'network-id': '-',
'protocol'  : '-'
}

attributes2 = {
'sensor-id' : '-',
'node-id'   : '-',
'gate-id'   : '-',
'date'      : '-',
'value'     : '-',
'magnitude' : '-',
'gps'       : '-',
'network-id': '-',
'protocol'  : '-'
}


attribute1 = "sensor-id"
attribute2 = "node-id"
attribute3 = "gate-id"
attribute4 = "date"
attribute5 = "value"
attribute6 = "magnitude"
attribute7 = "gps"
attribute8 = "network-id"
attribute9 = "protocol"


attribute12 = "2sensor-id"
attribute22 = "2node-id"
attribute32 = "2gate-id"
attribute42 = "2date"
attribute52 = "2value"
attribute62 = "2magnitude"
attribute72 = "2gps"
attribute82 = "2network-id"
attribute92 = "2protocol"




ser =serial.Serial('/dev/ttyUSB0', 9600, timeout=50)
count=0
count2=0
while True:

	incoming = ser.readline().strip()
	print incoming
#	a=string.find(incoming,attribute1)
#	print a
	if string.find(incoming,attribute1)==1:
		count = count +1
		longitud=len(incoming)
		texto=str(incoming[13:longitud-2]) 
		attributes[attribute1]=texto

	if string.find(incoming,attribute12)==1:
                count2 = count2 +1
                longitud=len(incoming)
                texto=str(incoming[14:longitud-2]) 
                attributes2[attribute1]=texto





	if string.find(incoming,attribute2)==1:
                count = count +1
                longitud=len(incoming)
                texto=str(incoming[11:longitud-2]) 
                attributes[attribute2]=texto

	if string.find(incoming,attribute22)==1:
                count2 = count2 +1
                longitud=len(incoming)
                texto=str(incoming[12:longitud-2]) 
                attributes2[attribute2]=texto






	if string.find(incoming,attribute3)==1:
		count=count+1
 		longitud=len(incoming)
                texto=str(incoming[11:longitud-2])
                attributes[attribute3]=texto

	if string.find(incoming,attribute32)==1:
                count=count+1
                longitud=len(incoming)
                texto=str(incoming[12:longitud-2])
                attributes2[attribute3]=texto






	if string.find(incoming,attribute4)==1:
		count = count+1
                longitud=len(incoming)
                texto=str(incoming[8:longitud-2])
                attributes[attribute4]=texto

	if string.find(incoming,attribute42)==1:
                count2 = count2+1
                longitud=len(incoming)
                texto=str(incoming[9:longitud-2])
                attributes2[attribute4]=texto





	if string.find(incoming,attribute5)==1:
		count = count+1
                longitud=len(incoming)
                texto=str(incoming[9:longitud-2])
                attributes[attribute5]=texto

	if string.find(incoming,attribute52)==1:
                count2 = count2 + 1
                longitud=len(incoming)
                texto=str(incoming[10:longitud-2])
                attributes2[attribute5]=texto




	if string.find(incoming,attribute6)==1:
		count = count+1
                longitud=len(incoming)
                texto=str(incoming[13:longitud-2])
                attributes[attribute6]=texto

	if string.find(incoming,attribute62)==1:
                count2 = count2+1
                longitud=len(incoming)
                texto=str(incoming[14:longitud-2])
                attributes2[attribute6]=texto







	if string.find(incoming,attribute7)==1:
		count = count+1
                longitud=len(incoming)
                texto=str(incoming[7:longitud-2])
                attributes2[attribute7]=texto

	if string.find(incoming,attribute72)==1:
                count2 = count2 + 1
                longitud=len(incoming)
                texto=str(incoming[8:longitud-2])
                attributes2[attribute7]=texto





	if string.find(incoming,attribute8)==1:
 		count = count+1
                longitud=len(incoming)
                texto=str(incoming[14:longitud-2])
                attributes2[attribute8]=texto

	if string.find(incoming,attribute82)==1:
                count2 = count2 + 1
                longitud=len(incoming)
                texto=str(incoming[15:longitud-2])
                attributes2[attribute8]=texto





	if string.find(incoming,attribute9)==1:
		count = count+1
                longitud=len(incoming)
                texto=str(incoming[12:longitud-2])
                attributes2[attribute9]=texto

	if string.find(incoming,attribute92)==1:
                count2 = count2 + 1
                longitud=len(incoming)
                texto=str(incoming[13:longitud-2])
                attributes2[attribute9]=texto




#	print count2
#	print count
#	print attributes


#	incoming1= str(incoming)
#        incoming2= " '%s' " % incoming1


#	print attributes


#	matriz=str(json.dumps(incoming))
#	print matriz

#	matriz1= json.loads(incoming2)
#	print matriz1

#	dataa=str(incoming)
#	dato5= " '%s' " % dataa
#	print dato5
#	datos= json.loads(dato5)
#	print datos
#	print incoming
#	message  = json.loads(incoming)
#	print message
#	dato     = json.loadsncoming, indent=4, separators=(',',':'), sort_keys= True)
#	dato2	 = json.loads(" '%s' " % dataa)
	dato6	 = json.dumps(attributes, indent=4, separators=(',',':'), sort_keys= True)
	dato8    = json.dumps(attributes2, indent=4, separators=(',',':'), sort_keys= True)

#	dato7 	 = json.loads(dato5)
#	dato7["gps"] = "usb"
#	print dato2
#	dato3= str(dato5)
#	dato6=json.loads(dataa)
	if count>8:
#		print dato6
		dato7= str(dato6)
		mensaje     = "mosquitto_pub -h 192.168.43.94 -t zigbee -m '%s' " % dato7
		os.system(mensaje)
		count=0
	if count2>8:
		dato9= str(dato8)
                mensaje     = "mosquitto_pub -h 192.168.43.94 -t zigbee -m '%s' " % dato9
                os.system(mensaje)
                count=0


#	print count

#	print dato3
#	mensaje     = 'mosquitto_pub -h 192.168.1.79 -t zigbee -m '+ dato3
#	print mensaje
#	os.system(mensaje)
