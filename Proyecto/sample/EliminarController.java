package sample;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.collections.ObservableList;

public class EliminarController implements Initializable
{  

    @FXML private TextField _titulo;
    @FXML private TextField _autor;
    @FXML private TextField _editorial;
    @FXML private TextField _edicion;

    @FXML private TextField _nombre;
    @FXML private TextField _direccion;
    @FXML private TextField _telefono;
    @FXML private TextField _fecha_inicial;
    @FXML private TextField _fecha_final;
    @FXML private TextField _fecha_entrega;

    @FXML private Button _back;

    private String id;
    private String titulo;
    private String autor;
    private String editorial;
    private String edicion;
    private String nombre;
    private String direccion;
    private String telefono;
    private String fecha_inicial;
    private String fecha_final;
    private String fecha_entrega;

    public EliminarController(String id, String titulo, String autor, String editorial, String edicion, String nombre, String direccion, String telefono, String fecha_inicial, String fecha_final, String fecha_entrega)
    {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.edicion = edicion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
        this.fecha_entrega = fecha_entrega;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this._titulo.setText(titulo);
        this._autor.setText(autor);
        this._editorial.setText(editorial);
        this._edicion.setText(edicion);

        this._nombre.setText(nombre);
        this._direccion.setText(direccion);
        this._telefono.setText(telefono);
        this._fecha_inicial.setText(fecha_inicial);
        this._fecha_final.setText(fecha_final);
        this._fecha_entrega.setText(fecha_entrega);
    }

    public void save()
    {
        Files archivo_prestamos = new Files("prestamos.txt");
        String prestamos[] = archivo_prestamos.read().split("\n");
        String prestamos_editado[] = new String[prestamos.length - 1];

        int j = 0;

        for (int i = 0; i < prestamos.length; ++i) 
        {
            if(prestamos[i].split(",")[0].equals(this.id))
            { 
                prestamos_editado[j++] = prestamos[i];
            }
        }
        
        archivo_prestamos.override(String.join("\n", prestamos_editado));

        back();
    }


    public void back()
    {
        Window window = new Window();
        window.open("menu.fxml", "Inicio");
        window.close(this._back.getScene());
    }
}