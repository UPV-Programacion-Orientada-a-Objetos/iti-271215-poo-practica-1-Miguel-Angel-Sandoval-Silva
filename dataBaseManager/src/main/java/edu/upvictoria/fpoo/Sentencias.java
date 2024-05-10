package edu.upvictoria.fpoo;
import java.io.*;

public class Sentencias {
    //RUTA-> /Users/miguelangelsandovalsilva/Documents/6 Cuatrimestre/POO/1 UNIDAD/iti-271215-poo-practica-1-Miguel-Angel-Sandoval-Silva/dataBaseManager/src/main/$Path$
    //CREATE TABLE Alumnos ( id INT NOT NULL PRIMARY KEY, nombre VARCHAR(20) NOT NULL, app VARCHAR(20) NOT NULL, apm VARCHAR(20) NOT NULL, edad INT NULL );
    String entrada;
    String[] dividirNombre;
    String[] dividirCreate;
    public  void lectura() throws IOException{
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Ingresa el comando USE Nombre de la carpeta");
            entrada = bufer.readLine();
            dividirNombre = entrada.split(" ");
            if (!dividirNombre[0].equalsIgnoreCase("USE") || dividirNombre.length < 2) {
                System.out.println("ERROR!!!!. Introduce el comando USE y el nombre de la carpeta");
            }
        } while (!dividirNombre[0].equalsIgnoreCase("USE") || dividirNombre.length < 2);



        do {
            System.out.println("BASE DE DATOS:");
            entrada =  bufer.readLine();
            dividirCreate = entrada.split(" ");
            if (dividirCreate[0].equalsIgnoreCase("CREATE")&&dividirCreate[1].equalsIgnoreCase("TABLE")){
                String rutaArchivo = "/Users/miguelangelsandovalsilva/Documents/6 Cuatrimestre/POO/1 UNIDAD/iti-271215-poo-practica-1-Miguel-Angel-Sandoval-Silva/dataBaseManager/src/main/"+dividirNombre[1]+"/"+dividirCreate[2]+".csv";
                File archivo = new File(rutaArchivo);
                FileWriter writer = null;
                try {

                    if (archivo.createNewFile()) {
                        System.out.println("Archivo creado: " + archivo.getName());
                        writer = new FileWriter(archivo);
                        //System.out.println("Escribe lo que contendra el archivo :");
                        //entrada =  bufer.readLine();
                        String contenido=dividirCreate[4]+" "+dividirCreate[10]+" "+dividirCreate[14]+" "+dividirCreate[18]+" "+dividirCreate[22];
                        writer.write(contenido);
                        System.out.println("Se ha escrito correctamente en el archivo.");
                    } else {
                        System.out.println("El archivo ya existe.");
                    }


                } catch (IOException e) {
                    System.err.println("Ocurrió un error al crear o escribir en el archivo: " + e.getMessage());
                } finally {
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            System.err.println("Error al cerrar el archivo: " + e.getMessage());
                        }
                    }
                }
            } else{
                System.out.println("Sintaxis equivocada!!!");
            }
        }while (!(dividirCreate.length >= 25 && dividirCreate[0].equalsIgnoreCase("CREATE") && dividirCreate[1].equalsIgnoreCase("TABLE")));
    }
}

