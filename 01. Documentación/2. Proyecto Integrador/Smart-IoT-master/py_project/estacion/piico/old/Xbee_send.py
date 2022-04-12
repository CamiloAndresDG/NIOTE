import serial
import sys
import argparse
import json

parser= argparse.ArgumentParser()
parser.add_argument("-json",help="message to send")
args=parser.parse_args()
dat= args.json

#datos =json.loads(dat)
#datos1= str(datos)
#print datos

#datos1=json.dumps(datos, indent=4, separators=(",",":"), sort_keys=True)
ser = serial.Serial('/dev/ttyUSB0', 9600,timeout=1)
#datos2=str(datos1) 
#print datos2
#mensaje = args.json
ser.write( dat + '\r\n' )
#
#ser.write('\n') 
