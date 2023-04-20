package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    //Ejercicio 1) recibe elos parametros: "patentes.txt" "(A[A-Z][0-9]{3}[d|t|c]?[A-Z]{2})|([A-Z]{3}[d|t|c]?[0-9]{3})"
    //Ejercicio 2) recibe a continuacion los parametros: "informacion.txt" ".*([0-9]{10}).* ([a-z0-9._-]+@[a-z]+\.[a-z]+).* ([0-9]+)$"

    public static void main(String[] args) throws IOException {
        //Ejercicio 1
        final String expresion1 = args[1];
        Path archivo1 = Paths.get(args[0]);
        for (String linea : Files.readAllLines(archivo1)){
            System.out.printf("%-10s %-7s", linea, "--->");
            if (linea.matches(expresion1)){
                System.out.println("Se corresponde con la expresion regular");
            } else System.out.println("No se corresponde con la expresion regular");
        }
        System.out.println("--------------------------------------------------------------------");

        //Ejercicio 2

        final String expresion2 = args[3];
        Path archivo2 = Paths.get(args[2]);
        final Pattern pattern = Pattern.compile(expresion2, Pattern.MULTILINE);
        String informacion = Files.readString(archivo2);
        System.out.println(informacion);
        final Matcher matcher = pattern.matcher(informacion);
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Grupo No." + i + ": " + matcher.group(i));
            }
        }

/*
        //1 forma de verificar la informacion
        String linea = "ramonperez12356@gmail.com" ;
        System.out.println(linea.matches("([a-z]|[0-9])+@[a-z]+\\.[a-z]+" ));

        //2 forma de verificar la informacion
        String regex = "([a-z]|[0-9])+@[a-z]+\\.[a-z]+" ;
        final Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher(linea).matches());*/
    }
}