'''
Created on 27/02/2020

@author: aasanchez
'''

import argparse
from logic.ConfigTools import Station

parser = argparse.ArgumentParser(
    prog='Estacion PIICO USB',
    description='Comandos para el inicio de la estacion.',
    epilog="mas informacion en https://piico.ingusb.com",
    add_help=True
)
parser.add_argument(
    '-v','--version',
    dest='version',
    action='version',
    version='%(prog)s 1.0'
)
parser.add_argument(
    '-n','--name', '--nameid',
    dest='name',
    metavar='N',
    required=True,
    nargs=1,
    type=str,
    help='nombre identificador del nodo'
)
parser.add_argument(
    '-u','--ubi', '--ubiety',
    dest='ubiety',
    metavar='U',
    required=True,
    nargs=2,
    type=float,
    help='ubicacion gps Lon=xx.xxxxxx & Lat=xx.xxxxxx'
)
parser.add_argument(
    '-p','--prot', '--protocols',
    dest='protocols',
    metavar='P',
    required=False,
    nargs='*',
    type=str,
    choices=['all', 'wifi', 'blue', 'xbee'],
    default=['wifi'],
    help='[all | wifi blue xbee]'
)
parser.add_argument(
    '-s','--sen', '--sensors',
    dest='sensors',
    metavar='S',
    required=False,
    nargs='*',
    type=str,
    choices=['all', 'tem', 'hum', 'vel', 'dir', 'plu', 'rad'],
    default=['all'],
    help='[all | tem hum vel dir plu rad]'
)
parser.add_argument(
    '-a','--act', '--actuators',
    dest='actuators',
    metavar='A',
    required=False,
    nargs='*',
    type=str,
    choices=['all', 'asp', 'led'],
    default=['all'],
    help='[all | asp led]'
)
parser.add_argument(
    '-g','--gw', '--gateway',
    dest='gateway',
    metavar='G',
    required=False,
    nargs='*',
    type=str,
    default=['IP=192.168.1.2'],
    help='direccion IP del gateway [IP=], dirreccion bluetooth del gateway [BT=MAC-NAME-PIN]'
)
parser.add_argument(
    '-b','--bk', '--broker',
    dest='broker',
    metavar='B',
    required=False,
    nargs='*',
    type=str,
    default=['192.168.1.2'],
    help='direccion IP del broker [IP]'
)
    
def main():     
    args = parser.parse_args()
    estacion=Station(args.name, args.ubiety, args.protocols, args.sensors, args.actuators, args.gateway, args.broker)
    print('la estacion es: ', estacion)

if  __name__ ==  '__main__':
    main()
