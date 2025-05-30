import paho.mqtt.client as mqtt
import sys
#import MySQLdb
import json
import os
inicio="clear"
os.system(inicio)
#Direccion de broker MQTT
broker_url = "localhost"
broker_port = 1883

#datos para base de datos 
#dir_local_sql  = "127.0.0.1"
#usr_local_sql  = "miusuario"
#psw_local_sql  = "piico"
#name_local_sql = "artik_demo"

#conexion con Base de Datos SQL
#try:
 #   	db = MySQLdb.connect( dir_local_sql , usr_local_sql , psw_local_sql , name_local_sql)
#
#except:
#       	print ("No se pudo conectar con la base de datos")
#        print ("Cerrando ...")
#        sys.exit()

#Preparar cursor para el manejo de la base de datos 

#cursor = db.cursor()


def on_connect(client, userdata, flags, rc):
   print("Connected With Result Code " (rc))

def on_message_from_node(client, userdata, message):
#   print("Message Recieved from nodo: "+message.payload.decode())
   datos= json.loads(message.payload.decode())
   datos["gate-id"]="(1)artik-1020"
   datos["network-id"]="red-1"
   datos["gps"]="usb"
#   texto=("echo '{};{};{};{}' >> datos.txt".format(datos["date"],datos["node-id"],datos["sensor-id"],datos["value"] ) )
#   print texto
   env= json.dumps(datos, indent=4, separators=( ',', ':'),sort_keys= True)
#   print env
#   os.system(texto)
   dato=str(env)
   bk_add = "test.mosquitto.org"
   cli = mqtt.Client("ArtikUSB")
   cli.connect(bk_add)
   cli.publish("piico_usb",dato)
#   d=dato.replaceAll('\n',' ')
   print dato
#   mensaje="mosquitto_pub -h 'test.mosquito.org' -t piico_usb -m '%s'" %dato
#   print mensaje
#   os.system(mensaje)


#  sql = """ INSERT INTO `tabla` (`id`, `usuario`, `topic`, `mensaje`, `fecha`) VALUES (NULL, 'WIFI', 'nodo 1', '"""+ message.payload.decode() +"""', CURRENT_TIMESTAMP);"""

 #  try:
        # Ejecutar comando SQL
  #      cursor.execute(sql)
   #     db.commit()
    #    print ("guardando en base de datos...OK")
   #except:
#	db.rollback()
 #       print ("Fallo en guardar informacion en base de datos")






#def on_message_from_nodo2(client, userdata, message):
 #  print("Message Recieved from Wifi nodo 2: "+message.payload.decode())
  # sql = """INSERT INTO `tabla` (`id`, `usuario`, `topic`, `mensaje`, `fecha`) VALUES (NULL, 'WIFI', 'nodo 2', '"""+ message.payload.decode() +"""', CURRENT_TIMESTAMP);"""

   #try:
        # Ejecutar comando SQL
    #    cursor.execute(sql)
     #   db.commit()
      #  print ("guardando en base de datos...OK")
   #except:
    #    db.rollback()
     #   print ("Fallo en guardar informacion en base de datos")




#def on_message_from_bluetooth_nodo1(client, userdata, message):
 #  print("Message Recieved from bluetooth nodo 1: "+message.payload.decode())
  # sql = """INSERT INTO `tabla` (`id`, `usuario`, `topic`, `mensaje`, `fecha`) VALUES (NULL, 'Bluetooth', 'nodo1', '"""+ message.payload.decode() +"""', CURRENT_TIMESTAMP);"""

   #try:
        # Ejecutar comando SQL
    #    cursor.execute(sql)
     #   db.commit()
      #  print ("guardando en base de datos...OK")
   #except:
    #    db.rollback()
     #   print ("Fallo en guardar informacion en base de datos")



#def on_message_from_bluetooth_nodo2(client, userdata, message):
 #  print("Message Recieved from bluetooth nodo 2: "+message.payload.decode())
  # sql = """INSERT INTO `tabla` (`id`, `usuario`, `topic`, `mensaje`, `fecha`) VALUES (NULL, 'Bluetooth', 'nodo2', '"""+ message.payload.decode() +"""', CURRENT_TIMESTAMP);"""

   #try:
        # Ejecutar comando SQL
    #    cursor.execute(sql)
     #   db.commit()
      #  print ("guardando en base de datos...OK")
   #except:
    #    db.rollback()
     #   print ("Fallo en guardar informacion en base de datos")

#def on_message_from_xbee1(client, userdata, message):

 #  print("Message Recieved from xbee nodo 1: "+message.payload.decode())
  # sql = """INSERT INTO `tabla` (`id`, `usuario`, `topic`, `mensaje`, `fecha`) VALUES (NULL, 'xbee', '1', '"""+ message.payload.decode() +"""', CURRENT_TIMESTAMP) ;"""

   #try:
        # Ejecutar comando SQL
    #   	cursor.execute(sql)
     #   db.commit()
      #  print ("guardando en base de datos...OK")
   #except:
    #    db.rollback()
     #   print ("Fallo en guardar informacion en base de datos")






#def on_message_from_xbee2(client, userdata, message):

 #  print("Message Recieved from xbee nodo 2: "+message.payload.decode())
  # sql = """INSERT INTO `tabla` (`id`, `usuario`, `topic`, `mensaje`, `fecha`) VALUES (NULL, 'xbee', '2', '"""+ message.payload.decode() +"""', CURRENT_TIMESTAMP) ;"""

   #try:
    #    # Ejecutar comando SQL
     #   cursor.execute(sql)
      #  db.commit()
       # print ("guardando en base de datos...OK")
   #except:
    #    db.rollback()
     #   print ("Fallo en guardar informacion en base de datos")


def on_message(client, userdata, message):
   print("Message Recieved from Others: "+message.payload.decode())


client = mqtt.Client()
client.on_connect = on_connect
#To Process Every Other Message
client.on_message = on_message

try:
	client.connect(broker_url, broker_port)
except:
	print ("Error de conexion con Broker")
	print ("cerrando")
#	db.close()
	sys.exit()


#lista de topicos

client.subscribe("wifi"     , qos=1)
client.subscribe("bluetooth", qos=1)
client.subscribe("zigbee"   , qos=1)



#recepcion de mensajes
client.message_callback_add("wifi"     , on_message_from_node)
client.message_callback_add("bluetooth", on_message_from_node)
client.message_callback_add("zigbee"   , on_message_from_node)


try:
	client.loop_forever()
except KeyboardInterrupt: #ctrl + c
	print ("Cerrando...")
#	db.close()
