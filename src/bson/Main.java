package bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {

    private static MongoClient cliente = new MongoClient("localhost", 27017);
    private static MongoDatabase conexion = cliente.getDatabase("universidad");
    private static MongoCollection coleccion = conexion.getCollection("Alumno");

    public static void main(String[] args) {
         insertarUnDocumento();
         mostrarTodosDocumentos1();
    }

    public static void insertarUnDocumento() {
        Alumno alumno = new Alumno(1, "Luis", 1.72);
        Document documento = new Document("idAlumno", alumno.getIdAlumno())
                .append("nombre", alumno.getNombre())
                .append("estatura", alumno.getEstatura())
                .append("edad",20);
        coleccion.insertOne(documento);
    }

    public static void mostrarTodosDocumentos1() {
        FindIterable<Document> iterable = coleccion.find();
        for (Document document : iterable) {
            //int idAlumno = document.getInteger("idAlumno");
            //String nombre = document.getString("nombre");
            //double estatura = document.getDouble("estatura");
            System.out.println(document);//Mostrar los documentos
            //System.out.println(idAlumno + "\t" + nombre + "\t" + estatura);
        }
    }

}
