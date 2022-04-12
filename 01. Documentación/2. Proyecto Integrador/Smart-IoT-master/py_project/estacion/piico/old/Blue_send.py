from collections import OrderedDict
import json
import os
import argparse
import sys
import bluetooth


###########Help
parser= argparse.ArgumentParser()
parser.add_argument("-json",help="message to send")
args= parser.parse_args()


#bd_addr = "C0:97:27:56:B0:CB"
bd_addr = "94:53:30:3C:97:F2"
port    = 1
sock    = bluetooth.BluetoothSocket( bluetooth.RFCOMM )
sock.connect((bd_addr, port))
mensaje= args.json
sock.send(mensaje)
sock.close()


