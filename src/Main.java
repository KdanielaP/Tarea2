import java.util.ArrayList;
import java.util.List;

// Clase base Cafe
abstract class Cafe {
    protected String nombre;
    protected String tamanio;
    protected double precio;

    public Cafe(String nombre, String tamanio, double precio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.precio = precio;
    }

    public abstract void preparar();
    public void servir() {
        System.out.println("Sirviendo " + nombre + " de tamaño " + tamanio);
    }
}

// Clases derivadas
class CafeColombiano extends Cafe {
    private String tipoGrano;

    public CafeColombiano(String tipoGrano) {
        super("Café Colombiano", "Mediano", 2.5);
        this.tipoGrano = tipoGrano;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando " + nombre + " con grano: " + tipoGrano);
    }
}

class EspressoItaliano extends Cafe {
    private int intensidad;

    public EspressoItaliano(int intensidad) {
        super("Espresso Italiano", "Pequeño", 3.0);
        this.intensidad = intensidad;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando " + nombre + " de intensidad " + intensidad);
    }
}

// Interfaz Ingrediente
interface Ingrediente {
    String obtenerNombre();
    int obtenerCantidad();
}

// Clases de ingredientes
class Granos implements Ingrediente {
    private String tipo;
    private int cantidad;

    public Granos(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    @Override
    public String obtenerNombre() {
        return tipo;
    }

    @Override
    public int obtenerCantidad() {
        return cantidad;
    }
}

class Agua implements Ingrediente {
    private int cantidad;

    public Agua(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String obtenerNombre() {
        return "Agua";
    }

    @Override
    public int obtenerCantidad() {
        return cantidad;
    }
}

class Leche implements Ingrediente {
    private String tipo;
    private int cantidad;

    public Leche(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    @Override
    public String obtenerNombre() {
        return tipo;
    }

    @Override
    public int obtenerCantidad() {
        return cantidad;
    }
}

class OtrosIngredientes implements Ingrediente {
    private String nombre;
    private int cantidad;

    public OtrosIngredientes(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }

    @Override
    public int obtenerCantidad() {
        return cantidad;
    }
}

// Clase Empleado
class Empleado {
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public void trabajar() {
        System.out.println(nombre + " está trabajando como " + puesto);
    }

    public void tomarOrden() {
        System.out.println(nombre + " está tomando la orden.");
    }
}

// Clase Equipo
class Equipo {
    private String tipo;
    private String estado;

    public Equipo(String tipo, String estado) {
        this.tipo = tipo;
        this.estado = estado;
    }

    public void encender() {
        estado = "encendido";
        System.out.println(tipo + " está " + estado);
    }

    public void apagar() {
        estado = "apagado";
        System.out.println(tipo + " está " + estado);
    }

    public void reparar() {
        estado = "reparado";
        System.out.println(tipo + " ha sido " + estado);
    }
}

// Clase Sucursal
class Sucursal {
    private String nombre;
    private String direccion;
    private List<Empleado> empleados;
    private List<Ingrediente> ingredientes;
    private List<Equipo> equipos;
    private List<Cafe> especialidades;

    public Sucursal(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.empleados = new ArrayList<>();
        this.ingredientes = new ArrayList<>();
        this.equipos = new ArrayList<>();
        this.especialidades = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado.nombre);
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
        System.out.println("Ingrediente agregado: " + ingrediente.obtenerNombre());
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
        System.out.println("Equipo agregado: " + equipo.tipo);
    }

    public void agregarEspecialidad(Cafe cafe) {
        especialidades.add(cafe);
        System.out.println("Café especialidad agregado: " + cafe.nombre);
    }
}

// Clase Main para ejecutar el programa
public class Cafeteria {
    public static void main(String[] args) {
        // Crear sucursal
        Sucursal sucursalBogota = new Sucursal("Café Bogotá", "Calle 123, Bogotá");

        // Agregar empleados
        Empleado empleado1 = new Empleado("Juan", "Barista", 1200.0);
        sucursalBogota.agregarEmpleado(empleado1);

        // Agregar ingredientes
        Granos granosColombianos = new Granos("Granos Colombianos", 100);
        Agua agua = new Agua(50);
        Leche lecheEntera = new Leche("Leche Entera", 30);
        sucursalBogota.agregarIngrediente(granosColombianos);
        sucursalBogota.agregarIngrediente(agua);
        sucursalBogota.agregarIngrediente(lecheEntera);

        // Agregar equipo
        Equipo maquinaCafetera = new Equipo("Máquina de Café", "apagada");
        sucursalBogota.agregarEquipo(maquinaCafetera);

        // Agregar café especialidades
        CafeColombiano cafeColombiano = new CafeColombiano("Suave");
        EspressoItaliano espresso = new EspressoItaliano(5);
        sucursalBogota.agregarEspecialidad(cafeColombiano);
        sucursalBogota.agregarEspecialidad(espresso);

        // Usar métodos
        empleado1.trabajar();
        empleado1.tomarOrden();
        maquinaCafetera.encender();
        cafeColombiano.preparar();
        cafeColombiano.servir();
    }
}