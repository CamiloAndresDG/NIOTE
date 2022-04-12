
import bluetooth
import os 


server_sock=bluetooth.BluetoothSocket( bluetooth.RFCOMM )
port = 1
server_sock.bind(("",port))
server_sock.listen(1)

while True:
	client_sock,address = server_sock.accept()
	print "Accepted connection from ",address
	data = client_sock.recv(1024)
	print data
	datos= str(data)
	print "received [%s]" % data
	mensaje = "mosquitto_pub -h 192.168.43.94 -t bluetooth -m '%s' " % datos
	os.system(mensaje)

#client_sock.close()
#server_sock.close()



