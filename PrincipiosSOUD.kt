// Principio Solid
/*
1. Single Responsability Principle (SRP) - Principio de Responsabilidad Unica
*/

//Ejemplo de no uso de SRP
/* 
class factura(val Items: List<Item>) {
    fun calcularTotal()= Double {
        return Items.sumof (it.precio)
    }

    fun generarReporte(): String {
        return "Reporte de la Factura"
    }
 }
*/  
 
//
class Factura() {
    fun calcularTotal(): String {
        return "Este es el total"
    }
}

class ReporteFactura {
    fun generar(factura: Factura): String {
        return " Reporte de la Factura"
    }
}

/*
2. Open/Closed Principles (OCP) - Principio Abierto/Cerrado
*/

open class Empleado(val nombre: String, val horasTrabajadas: Int, val preciHoras: Double) {
    open fun calcularSalario(): Double{
        return horasTrabajadas*preciHoras
    }
}

class EmpleadoConBono(nombre: String, horasTrabajadas: Int, preciHoras: Double, val Bono: Double): Empleado(nombre, horasTrabajadas, preciHoras) {
    override fun calcularSalario():Double {
        return super. calcularSalario() + Bono
    }
}

/*
3. Liskov Substitution Principle (LSP) - Principio de sutitucion Liskov
*/

fun main(args: Array<String>) {
    fun imprimirSalario(empleado: Empleado) {
        val nombre = empleado.nombre
        val salario = empleado.calcularSalario()
        println("El salario de $nombre es de $salario")
    }

    val empleado1 = Empleado("Daniel", 40, 12.0)
    val empleado2 =  EmpleadoConBono("Fernanda", 40, 12.0, 70.0)

    imprimirSalario(empleado1)
    imprimirSalario(empleado2)
}

/*
4. Interface Segregation Princeple (ISP) - Principio de Segregation de Interfaces
*/
interface Trabajador {
    fun trabajar()
}

interface Asistente{
    fun asistir()
}

interface Reportero {
    fun generarReporte()
}

class programador: Trabajador {
    override fun trabajar() {
       println("El programador esta programando")
    }
}

class Albañil: Trabajador {
    override fun trabajar() {
        // Agragar de trabajo
    }
}

/*
5. Dependency Inversion Princiole (DIP) - Principio de Inversion de Dependencias
*/

interface Notificaciones {
    fun enviarNotificacion(mensaje: String)
}

class ServicioEmail:Notificaciones {
    override fun enviarNotificacion(mensaje: String) {
        println("Enviando Email: $mensaje")
    }
}

class Notificacion(val servicio: Notificaciones) {
    fun enviarUnaNotificacion() {
        servicio.enviarNotificacion("Notificacion importante")
    }
}