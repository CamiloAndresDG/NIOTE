
from collections import OrderedDict 
import json 
import os 
import argparse 
import sys 
from datetime import date 
from datetime import datetime


#today = date.today()
#now = datetime.now()
#print (today)
#print (now)
attributes ={
"sensor-id" : "-",
"node-id"   : "-",
"gate-id"   : "-",
"date"      : "-",
"value"     : "-",
"magnitude" : "-",
"gps"       : "-",
"network-id": "-",
"protocol"  : "-"
}


attributes2 ={
"2sensor-id" : "-",
"2node-id"   : "-",
"2gate-id"   : "-",
"2date"      : "-",
"2value"     : "-",
"2magnitude" : "-",
"2gps"       : "-",
"2network-id": "-",
"2protocol"  : "-"
}


#ayud
parser = argparse.ArgumentParser()
parser.add_argument("-p"   , help=":sending protocol")
parser.add_argument("-n"   , help=":node address")
parser.add_argument("-s"   , help=":sensor name")
parser.add_argument("-v"   , help=":value")
parser.add_argument("-m"   , help=":sensor magnitude")
parser.add_argument("-net" , help=":network name")
parser.add_argument("-g"   , help=":gateway address")
parser.add_argument("-gps" , help=":global positioning system")
parser.add_argument("-d"   , help=":date")
args= parser.parse_args()

if args.p:
       	print "sending protocol:",args.p
        attributes["protocol"]=args.p
if args.n:
	print "the node address is:",args.n
	attributes["node-id"]=args.n
if args.s:
       	print "the sensor name is:",args.s
       	attributes["sensor-id"]= args.s
if args.v:
        print "the value is:",args.v
       	attributes["value"]= args.v
if args.m:
       	print "the magnitude is:",args.m
       	attributes["magnitude"]=args.m
if args.net:
       	print "the network name is:",args.net
       	attributes["network-id"]=args.net
if args.g:
       	print "the gateway address is:",args.g
       	attributes["gate-id"]=args.g
if args.gps:
       	print "the global positioning system is:",args.gps
       	attributes["gps"]=args.gps
if args.d:
   	print "the date is:",args.d
        attributes["date"]=args.d



datajson = json.dumps(attributes, indent=4,separators=(',',':'),sort_keys=True)
datajson2 = json.dumps(attributes2, indent=4,separators=(',',':'),sort_keys=True)


if args.p == "bluetooth":
	send= "python Blue_send.py -json '%s'" % datajson
        os.system(send)

if args.p == "zigbee":
	send = "python Xbee_send.py -json '%s'" % datajson
        os.system(send)

if args.p == "wifi":
	send = "mosquitto_pub -h 192.168.43.144 -t wifi -m '%s'" % datajson
	os.system(send)



