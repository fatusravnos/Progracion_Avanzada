public class ProduccionAeronaves {
    public static void main(String[] args) {
        System.out.println("Inicio Sistema de fabricacion de aeronaves");
        Fabricante fabricante = new Fabricante(); 
        fabricante.iniciarProduccion(); // Metodo que inicia el proceso
    }
}

// Clase fabricante
class Fabricante {
    private String nombre;
    private String pais;
    
    public void iniciarProduccion() {
        // for crea 3 modelos diferentes
        for(int i = 1; i <= 3; i++) {  
            Modelo modelo = new Modelo(); // Crear un nuevo Modelo
            
            // If para diferenciar modelos
            if(i == 1) { 
                modelo.configurar("Boeing", "747", "Estados Unidos");
            } else if(i == 2) {
                modelo.configurar("Airbus", "A380", "Francia");
            } else {
                modelo.configurar("Embraer", "E190", "Brasil");
            }
            modelo.fabricarAviones(); // Metodo para aviones del modelo actual
        }
        
        // While para control de calidad
        int unidadesInspeccion = 3; 
        while(unidadesInspeccion > 0) {
            System.out.println("Inspeccionando unidad: " + unidadesInspeccion);
            unidadesInspeccion--;
        }
        System.out.println("Control de calidad completado");
    }
}

// Clase modelo de aeronave
class Modelo {
    private String marca;
    private String nombreModelo;
    private String paisOrigen;
    
    public void configurar(String marca, String modelo, String pais) { // Metodo para configurar el modelo
        this.marca = marca;
        this.nombreModelo = modelo;
        this.paisOrigen = pais;
    }
    
    public void fabricarAviones() { // Metodo para fabricar aeronaves
        System.out.println("Iniciando fabricacion del modelo: " + marca + " " + nombreModelo);
        
        // FOR para 3 versiones diferentes del modelo
        System.out.println("Creando versiones del modelo:");
        for(int version = 1; version <= 3; version++) {
            String tipoVersion = "";
            
            // IF para Asignar tipo de version segun el numero
            if(version == 1) {
                tipoVersion = "Version Pasajeros";
                System.out.println("Configurando " + tipoVersion);
            } else if(version == 2) {
                tipoVersion = "Version Carga";
                System.out.println("Configurando " + tipoVersion);
            } else {
                tipoVersion = "Version Mixta";
                System.out.println("Configurando " + tipoVersion);
            }
            
            // Crear aeronave para cada version
            Aeronave aeronave = new Aeronave();
            aeronave.producir(marca, nombreModelo, tipoVersion);
        }
        
        // WHILE la certificacion del modelo
        System.out.println("Iniciando certificacion del modelo " + nombreModelo);
        int etapasCertificacion = 3;
        int etapaActual = 1;
        
        while(etapaActual <= etapasCertificacion) {
            // IF para Determinar etapa de certificacion
            if(etapaActual == 1) {
                System.out.println("Certificacion etapa " + etapaActual + ": Pruebas estructurales");
            } else if(etapaActual == 2) {
                System.out.println("Certificacion etapa " + etapaActual + ": Pruebas de sistemas");
            } else {
                System.out.println("Certificacion etapa " + etapaActual + ": Pruebas de vuelo");
            }
            etapaActual++;
        }
        
        System.out.println("Modelo " + marca + " " + nombreModelo + " certificado completamente\n");
    }
}

// Clase para aeronave individual
class Aeronave {
    private String tipoConfiguracion;
    private String estadoProduccion;
    
    public void producir(String marca, String modelo, String configuracion) { // Metodo para producir la aeronave
        this.tipoConfiguracion = configuracion;
        System.out.println("Produciendo: " + marca + " " + modelo + " - " + configuracion);
        
        // If para características segun configuracion
        if(configuracion.equals("Version Pasajeros")) { 
            estadoProduccion = "Alta capacidad";
        } else if(configuracion.equals("Version Carga")) {
            estadoProduccion = "Gran volumen";
        } else {
            estadoProduccion = "Flexible";
        }
        
        // For para la instalacion de los motores
        for(int motor = 1; motor <= 2; motor++) { 
            Motor nuevoMotor = new Motor();
            
            // Estructura if para determinar ubicacion del motor
            if(motor == 1) { 
                nuevoMotor.instalar("Motor izquierdo", estadoProduccion);
            } else {
                nuevoMotor.instalar("Motor derecho", estadoProduccion);
            }
        }
        
        // While para instalacion de sistemas
        int sistemasRestantes = 3;
        int numeroSistema = 1;
        while(sistemasRestantes > 0) {
            // If determina tipo de sistema
            if(numeroSistema == 1) {
                System.out.println("Sistema avionica instalado");
            } else if(numeroSistema == 2) {
                System.out.println("Sistema navegacion instalado");
            } else {
                System.out.println("Sistema comunicacion instalado");
            }
            sistemasRestantes--;
            numeroSistema++;
        }
        
        // Instalar Asientos
        System.out.println("Instalando asientos en la aeronave:");
        Asiento asiento = new Asiento();
        asiento.instalar(estadoProduccion, "Cabina principal");
    }
}

// Clase para el motor de la aeronave
class Motor {
    private String tipo;
    private int potencia;
    private String ubicacion;
    
    public void instalar(String ubicacion, String tipoAeronave) { // Metodo para instalar el motor
        this.ubicacion = ubicacion;
        
        // If para motor segun tipo de aeronave
        if(tipoAeronave.equals("Alta capacidad")) { 
            tipo = "TurboFan High-Thrust";
            potencia = 90000;
        } else if(tipoAeronave.equals("Gran volumen")) {
            tipo = "TurboFan Efficient";
            potencia = 85000;
        } else {
            tipo = "TurboFan Balanced";
            potencia = 70000;
        }
        
        System.out.println("Instalando " + ubicacion + " - Tipo: " + tipo);
        
        // For para calibracr los tipos específicos
        for(int calibracion = 1; calibracion <= 3; calibracion++) { 
            // if para tipo de calibracion
            if(calibracion == 1) {
                System.out.println("Calibracion electrica");
            } else if(calibracion == 2) {
                System.out.println("Calibracion mecanica");
            } else {
                System.out.println("Calibracion hidraulica");
            }
        }
        
        // While para pruebas
        int pruebas = 3;
        int numeroPrueba = 1;
        while(pruebas > 0) { 
            // If para tipo de prueba
            if(numeroPrueba == 1) {
                System.out.println("Prueba electrica");
            } else if(numeroPrueba == 2) {
                System.out.println("Prueba mecanica");
            } else {
                System.out.println("Prueba hidraulica");
            }
            pruebas--;
            numeroPrueba++;
        }
        
        System.out.println(ubicacion + " instalado correctamente\n");
    }
}

// Clase para asientos
class Asiento {    
    private String clase;
    private int cantidad;
    private String ubicacion;
    
    public void instalar(String tipoAeronave, String area) { // Metodo para instalar asientos
        this.ubicacion = area;
        System.out.println("Instalando asientos en: " + area);
        
        // For para 3 tipos de asientos
        for(int tipoAsiento = 1; tipoAsiento <= 3; tipoAsiento++) { 
            // If para clases de asientos
            if(tipoAsiento == 1) { 
                clase = "Primera Clase";
                // If para cantidad
                if(tipoAeronave.equals("Alta capacidad")) {
                    cantidad = 20;
                } else {
                    cantidad = 10;
                }
            } else if(tipoAsiento == 2) {
                clase = "Ejecutiva";
                cantidad = 50;
            } else {
                clase = "Economica";
                // If para cantidad segun tipo de aeronave
                if(tipoAeronave.equals("Alta capacidad")) { 
                    cantidad = 330;
                } else {
                    cantidad = 140;
                }
            }
            System.out.println("Asientos instalados: " + cantidad + " - " + clase);
        }
        
        // While para verificaciones
        int verificaciones = 3;
        int numeroVerificacion = 1;
        while(verificaciones > 0) {
            // If para tipo de verificacion
            if(numeroVerificacion == 1) {
                System.out.println("Verificacion electrica completada");
            } else if(numeroVerificacion == 2) {
                System.out.println("Verificacion espacios completada");
            } else {
                System.out.println("Verificacion Cojineria completada");
            }
            verificaciones--;
            numeroVerificacion++;
        }
        System.out.println("Asientos instalados completamente en: " + area + "\n");
    }
}