from collections import OrderedDict
import json
import os
import sys
import argparse
from datetime import date, datetime, time, timedelta
import calendar 
from gpiozero import MCP3008
from gpiozero import Button
import time
import math
import AM2315
import traceback

hoy= datetime.today()
formatdate= "%x-%X"
now = hoy.strftime(formatdate)
print str(now)


parser = argparse.ArgumentParser()
parser.add_argument("-tem"   , help=":Protocol to send")
parser.add_argument("-hum"   , help=":Protocol to send")
parser.add_argument("-dir"   , help=":Protocol to send")
parser.add_argument("-vel"   , help=":Protocol to send")
parser.add_argument("-rad"   , help=":Protocol to send")
parser.add_argument("-plu"   , help=":Protocol to send")
args= parser.parse_args()

def conditions():
        if args.tem:
                temperature =thsen.read_temperature()
                env='python jsonPython.py -p '+ args.tem +' -n '+ nodeid +' -s Temperature -v '+ str(temperature) +' -m Celsius -d '+ str(now) 
                os.system(env)


        if args.hum:
                humidity        =thsen.read_humidity()
                env='python jsonPython.py -p '+ args.hum +' -n '+ nodeid +' -s Humidity -v '+ str(humidity) +' -m percent -d '+ str(now) 
                os.system(env)

        if args.dir:
                valoradc1=("{0:.1f}".format(adc1.value*3.3))
                env='python jsonPython.py -p '+ args.dir +' -n '+ nodeid +' -s Direction -v '+ Datos[str(valoradc1)] +' -m Cardinal_point -d '+ str(now) 
                os.system(env)

        if args.vel:
                air_speed=calculate_speed(wind_interval)
                env='python jsonPython.py -p '+ args.vel +' -n '+ nodeid +' -s Velocity -v '+ str(air_speed) +' -m Km/h -d '+ str(now) 
                os.system(env)

        if args.rad:
                valoradc0=(adc0.value*1800.0)
                env='python jsonPython.py -p '+ args.rad +' -n '+ nodeid +' -s Radiation -v '+ str(valoradc0) +' -m W/m2 -d '+ str(now) 
                os.system(env)

        if args.plu:
                env='python jsonPython.py -p '+ args.plu +' -n '+ nodeid +' -s pluviometer -v '+ str(water_amount) +' -m mm3 -d '+ str(now) 
                os.system(env)




####### Datos
nodeid = 'nodo1'
####### variables direccion del viento-velocidad
wind_count      = 0
radius_cm       = 9.0
wind_interval   = 0.5
CM_IN_A_KM      = 100000.0
SECS_IN_AN_HOUR = 3600
ADJUSTMENT      = 1.18
####### variable cantidad de agua
BUCKET_SIZE     = 0.2794
rain_count      = 0
water_amount    = 0
#sensor de direccion de viento
proceso		= 0

Datos= {
        "0.0":"ESTE",
        "0.1":"ESTE",
        "0.2":"SUR-ESTE",
        "0.3":"SUR-ESTE",
        "0.4":"SUR",
        "0.5":"SUR",
        "0.6":"SUR",
        "0.7":"NOR-ESTE",
        "0.8":"NOR-ESTE",
        "0.9":"NOR-ESTE",
        "1.0":"NOR-ESTE",
        "1.1":"NOR-ESTE",
        "1.2":"SUR-ESTE",
        "1.3":"SUR-ESTE",
        "1.4":"SUR-ESTE",
        "1.5":"SUR-ESTE",
        "1.6":"SUR-ESTE",
        "1.7":"SUR-ESTE",
        "1.8":"NORTE",
        "1.9":"NORTE",
        "2.0":"NORTE",
        "2.1":"NORTE",
        "2.2":"NORTE",
        "2.3":"NOR-OESTE",
        "2.4":"NOR-OESTE",
        "2.5":"NOR-OESTE",
        "2.6":"NOR-OESTE",
        "2.7":"OESTE",
        "2.8":"OESTE",
        "2.9":"OESTE",
        "3.0":"OESTE",
        "3.1":"OESTE",
        "3.2":"OESTE",
        "3.3":"OESTE"
     }
adc1 = MCP3008 (channel=1)
adc0 = MCP3008 (channel=0)
print ("iniciando")

def spin():
        global wind_count
        wind_count = wind_count + 1
#       print ("spin" + str(wind_count))

def calculate_speed(time_sec):
        global wind_count
        circumference_cm = (2*math.pi)*radius_cm
        rotations        = wind_count / 2.0
        dist_km          =(circumference_cm * rotations)/CM_IN_A_KM
        km_por_sec       = dist_km / time_sec
        km_por_hour      = km_por_sec * SECS_IN_AN_HOUR
        return km_por_hour * ADJUSTMENT

def bucket_tipped():
        global rain_count
        global water_amount
        rain_count   = rain_count + 1
        water_amount = rain_count * BUCKET_SIZE
#       print (water_amount)

def reset_rainfall():
        global rain_count
        rain_count   = 0




rain_sensor = Button(6)
rain_sensor.when_pressed = bucket_tipped

wind_speed_sensor=Button(5)
wind_speed_sensor.when_pressed = spin


thsen = AM2315.AM2315(powerpin=6)


while True:
    wind_count = 0

    time.sleep(wind_interval)
    hoy= datetime.today()
    formatdate= "%x-%X"
    now = hoy.strftime(formatdate)
    conditions()
    proceso= proceso +1
    if proceso == 95:
        wind_interval = wind_interval + 10
    if proceso == 142:
        wind_interval = wind_interval + 10
    if proceso == 175:
        wind_interval = wind_interval - 20
    print str(proceso)

