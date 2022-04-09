from gpiozero import Button
import time
import math



wind_count      = 0
radius_cm       = 9.0
wind_interval   = 2
CM_IN_A_KM      = 100000.0
SECS_IN_AN_HOUR = 3600
ADJUSTMENT      = 1.18

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



def reset_rainfall():
        global rain_count
        rain_count   = 0


wind_speed_sensor=Button(5)
wind_speed_sensor.when_pressed = spin

while True:
    wind_count = 0
    time.sleep(wind_interval)
  
#  hoy= datetime.today()
 #   formatdate= "%x-%X"
#    now = hoy.strftime(formatdate)
#    conditions()
#    print now
#    print Datos[str(valoradc1)]
    print (calculate_speed(wind_interval), "km/h")
#    print (water_amount, "mm3")
#    print (temperature ,"celcius")
#    print (humidity    ,"percent")
