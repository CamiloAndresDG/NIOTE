import paho.mqtt.client as mqtt
import sys
import json
import os
inicio="clear"
os.system(inicio)
broker_url = "192.168.1.81"
broker_port = 1883

def on_connect(client, userdata, flags, rc):
   print("Connected With Result Code " (rc))

def on_message_from_node(client, userdata, message):
   print(message.payload.decode())
   os.system(message.payload.decode())

def on_message(client, userdata, message):
   print("Message Recieved from Others: "+message.payload.decode())


client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message

try:
	client.connect(broker_url, broker_port)
except:
	print ("Error de conexion con Broker")
	print ("cerrando")
	sys.exit()

client.subscribe("config-nodo1" , qos=1)


client.message_callback_add("config-nodo1", on_message_from_node)

try:
	client.loop_forever()
except KeyboardInterrupt: 
	print ("Cerrando...")

