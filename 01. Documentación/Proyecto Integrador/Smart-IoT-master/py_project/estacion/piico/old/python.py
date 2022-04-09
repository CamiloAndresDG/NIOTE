import os 
import time

i=0
while True:
	numero=str(i)
	texto= str("echo 'numero es tal %s' >> datos.txt " % numero)
	os.system(texto)
	print (texto)
	time.sleep(2)
	i=i+1
