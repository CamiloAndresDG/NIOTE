import pandas as pd
from datetime import datetime



abierto=pd.read_csv(r"C:\Users\acer\Documents\GitHub\NIOTE\02. Desarrollo\4. Ante Proyecto\Data\Datos_Hidrometeorol_gicos_Crudos_-_Red_de_Estaciones_IDEAM___Temperatura\Datos_Hidrometeorol_gicos_Crudos_-_Red_de_Estaciones_IDEAM___Temperatura.csv")
#abierto['FechaObservacion2'] = abierto['FechaObservacion'].replace('/','')
abierto.head()
abierto.info()
abierto.describe()
abierto