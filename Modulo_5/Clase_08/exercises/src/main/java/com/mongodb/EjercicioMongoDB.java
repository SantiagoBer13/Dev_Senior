package com.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.List;

public class EjercicioMongoDB {
    public static void main(String[] args) {
        String uri = "mongodb+srv://bernaltinjacasantiago113:12345@sistemagestioneventos.azwqs.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sistemagestioneventos");
            MongoCollection<Document> collection = database.getCollection("libros");

            System.out.println("✅ Conexión exitosa a MongoDB Atlas.");

            // Elimina la colección si existe
            if (database.listCollectionNames().into(new java.util.ArrayList<>()).contains("libros")) {
                collection.drop();
                System.out.println("🗑️ Colección 'libros' eliminada.");
            }

            // Reasignar la colección después de borrarla
            collection = database.getCollection("libros");

            // Ejecutar ejercicios
            ejercicio1_Insertar(collection);
            ejercicio2_Consultar(collection);
            ejercicio3_Actualizar(collection);
            ejercicio4_Eliminar(collection);

            // Mostrar contenido final
            System.out.println("📚 Contenido final en la colección 'libros':");
            for (Document doc : collection.find()) {
                System.out.println("📄 " + doc.toJson());
            }

        } catch (Exception e) {
            System.err.println("❌ Error al conectar o procesar:");
            e.printStackTrace();
        }
    }

    // Ejercicio 1: Insertar documentos
    public static void ejercicio1_Insertar(MongoCollection<Document> collection) {
        System.out.println("📝 Insertando registros del ejercicio 1...");
        List<Document> documents = List.of(
                new Document("titulo", "El Señor de los Anillos")
                        .append("autor", "J.R.R. Tolkien")
                        .append("anio", 1954)
                        .append("genero", "Fantasía"),
                new Document("titulo", "Cien años de soledad")
                        .append("autor", "Gabriel García Márquez")
                        .append("anio", 1967)
                        .append("genero", "Realismo Mágico"),
                new Document("titulo", "1984")
                        .append("autor", "George Orwell")
                        .append("anio", 1949)
                        .append("genero", "Ciencia Ficción"),
                new Document("titulo", "Orgullo y prejuicio")
                        .append("autor", "Jane Austen")
                        .append("anio", 1813)
                        .append("genero", "Romance")
        );
        collection.insertMany(documents);
        System.out.println("Registros insertados.");
    }

    // Ejercicio 2: Consultar documentos
    public static void ejercicio2_Consultar(MongoCollection<Document> collection) {
        System.out.println("\nConsultas:");

        System.out.println("Todos los libros:");
        collection.find().forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("\nLibros del género 'Fantasía':");
        collection.find(Filters.eq("genero", "Fantasía")).forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("\nLibros publicados después de 1950:");
        collection.find(Filters.gt("anio", 1950)).forEach(doc -> System.out.println(doc.toJson()));

        System.out.println("\nLibro con título 'Cien años de soledad':");
        collection.find(Filters.eq("titulo", "Cien años de soledad")).forEach(doc -> System.out.println(doc.toJson()));
    }

    // Ejercicio 3: Actualizar documentos
    public static void ejercicio3_Actualizar(MongoCollection<Document> collection) {
        System.out.println("\nActualizando documentos...");

        UpdateResult result1 = collection.updateOne(
                Filters.eq("titulo", "El Señor de los Anillos"),
                Updates.set("anio", 1955)
        );
        System.out.printf("Documentos modificados (año actualizado): %d%n", result1.getModifiedCount());

        UpdateResult result2 = collection.updateMany(
                Filters.eq("autor", "Jane Austen"),
                Updates.set("idioma", "Inglés")
        );
        System.out.printf("🌐 Documentos modificados (idioma añadido): %d%n", result2.getModifiedCount());
        System.out.println("Todos los libros:");
        collection.find().forEach(doc -> System.out.println(doc.toJson()));

    }

    // Ejercicio 4: Eliminar documentos
    public static void ejercicio4_Eliminar(MongoCollection<Document> collection) {
        System.out.println("\nEliminando documentos...");

        DeleteResult delete1 = collection.deleteOne(Filters.eq("titulo", "1984"));
        System.out.printf("Eliminados con título '1984': %d%n", delete1.getDeletedCount());

        DeleteResult delete2 = collection.deleteMany(Filters.lt("anio", 1900));
        System.out.printf("Eliminados con año < 1900: %d%n", delete2.getDeletedCount());
    }
}
