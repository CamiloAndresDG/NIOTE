import pymysql
import pandas
import csv


class ConexionODSDW:
    def __init__(self):
        
        # Conexion con la base de datos MySQL.
        self.connection = pymysql.connect(
            host="localhost",  # IP
            user="root",  # username
            password="root",  # password
            db="niote2"  # database
        )

        self.cursor = self.connection.cursor()
        print("Conexion establecida")

    # Limpieza de tabla a donde se realizara la inserción.
    def truncate_table(self):
        cursor = self.connection.cursor()
        sql = 'TRUNCATE `ods_project`.`modelos_datosobtenidos`;'
        cursor.execute(sql)
        result = cursor.rowcount
        self.connection.commit()
        cursor.close()
        return result

    # Funcioón para realizar la inserción a la base de datos desde el archivo csv.
    def insert_variable(self,path):
        cursor = self.connection.cursor()
        with open(path, 'r', encoding='utf8') as csvFile:
            reader = csv.reader(csvFile, delimiter=',')
            for row in reader:
                sql = 'INSERT INTO niote.modelos_datosobtenidos VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)'

                cursor.execute(sql, (str(row[0]), str(row[1]), str(row[2]), str(row[3]), str(row[4]), str(row[5]),
                    str(row[6]), str(row[7]), str(row[8]), str(row[9]), str(row[10]), str(row[11]), str(row[12]),
                    str(row[13]), str(row[14]), str(row[15]), str(row[16]), str(row[17]), str(row[18]), str(row[19]),
                    str(row[20]),str(row[21]),str(row[22]),str(row[23]),str(row[24]),str(row[25]),str(row[26]),
                    str(row[27]),str(row[28])))
                
        csvFile.close()
        result = cursor.rowcount
        self.connection.commit()
        cursor.close()
        return result

# Variables
# Path: ruta donde se encuentra el csv con los registros a insertar.

path='C:/Users/acer/Downloads/DataPrueba_Machine_Learning (1).csv'
databaseInsert = ConexionODSDW()
print("Iniciando proceso")
databaseInsert.truncate_table()
databaseInsert.insert_variable(path)
print("Insertado")
