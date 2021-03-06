package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Date;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CrearController
{
    @FXML private TextField isbn;
    @FXML private TextField titulo;
    @FXML private TextField autor;
    @FXML private TextField editorial;
    @FXML private TextField edicion;

    @FXML private TextField nombre;
    @FXML private TextField direccion;
    @FXML private TextField telefono;
    @FXML private TextField fecha_final;

    @FXML private Button _back;

    public void save()
    {
        Files archivo_prestamo = new Files("prestamos.txt");
        Files archivo_id = new Files("id.txt");
        
        String _id = archivo_id.read().replace("\n", "");
        int id;

        if(_id.equals("")) id = -1;  
        else id = Integer.parseInt(_id);

        _id = Integer.toString(++id);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Date hoy = new Date();

        String prestamo = _id + "," + this.titulo.getText() + "," + 
        this.autor.getText() + "," + this.editorial.getText() + "," + this.edicion.getText() + "," +
        this.nombre.getText() + "," + this.direccion.getText() + "," + this.telefono.getText() + "," +
        sdf.format(hoy) + "," + this.fecha_final.getText() + "," + "#";
        
        archivo_prestamo.save(prestamo);
        archivo_id.override(_id);
    }

    public void back()
    {
        Window window = new Window();
        window.open("menu.fxml", "Inicio");
        window.close(this._back.getScene());
    }
}
