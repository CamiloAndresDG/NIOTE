

import json
import sys
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("-data", help=":datos")
args= parser.parse_args()
print "recepcion"

if args.data:
	print args.data
	matriz=json.loads(args.data)
	matriz["MAC-B"]= "ABCD15"
	dataa= json.dumps(matriz, indent=4, separators=(',',':'),sort_keys= True)
	print dataa



