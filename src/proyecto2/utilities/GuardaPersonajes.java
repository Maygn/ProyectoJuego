package proyecto2.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import proyecto2.models.Personaje;

public class GuardaPersonajes {



    public void guardar(Personaje p) throws IOException{
        FileOutputStream guardaTexto = new FileOutputStream(new File("myObjects.txt"));
        ObjectOutputStream guardaObjetos = new ObjectOutputStream(guardaTexto);

        guardaObjetos.writeObject(p);
        guardaObjetos.close();
    }
}
