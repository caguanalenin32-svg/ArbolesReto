package reto;

import arboles.modelo.ArbolBinario;
import arboles.negocio.VistaArbol;

public class MainReto {

    public static void main(String[] args) {
        // ==========================================
        // PARTE 1: CONSTRUIR EL ÁRBOL A
        // ==========================================
        ArbolBinario<String> arbolA = new ArbolBinario<>();
        arbolA.crearRaiz("LTX");
        
        // Subárbol izquierdo de LTX
        arbolA.agregarIzquierdo(arbolA.getRaiz(), "ATF");
        arbolA.agregarIzquierdo(arbolA.getIzquierdo(arbolA.getRaiz()), "TUA");
        arbolA.agregarDerecho(arbolA.getIzquierdo(arbolA.getRaiz()), "IBB");
        
        // Subárbol derecho de LTX
        arbolA.agregarDerecho(arbolA.getRaiz(), "MCH");
        arbolA.agregarIzquierdo(arbolA.getDerecho(arbolA.getRaiz()), "SNC");
        arbolA.agregarIzquierdo(arbolA.getIzquierdo(arbolA.getDerecho(arbolA.getRaiz())), "LGQ");
        arbolA.agregarDerecho(arbolA.getDerecho(arbolA.getRaiz()), "OCC");

        System.out.println("=== VISTA DEL ÁRBOL A ===");
        VistaArbol.mostrar(arbolA);

        // ==========================================
        // PARTE 2: CONSULTAR DATOS DEL ÁRBOL A
        // ==========================================
        System.out.println("\n=== CONSULTAS DEL ÁRBOL A ===");
        System.out.println("Raíz: " + arbolA.getRaiz().getDato());
        System.out.println("Cantidad de nodos: " + arbolA.contarNodos());
        System.out.println("Cantidad de hojas: " + arbolA.contarHojas());
        System.out.println("Altura: " + arbolA.altura());
        System.out.println("Grado de LTX: " + arbolA.grado(arbolA.getRaiz()));
        
        var nodoSnc = arbolA.getIzquierdo(arbolA.getDerecho(arbolA.getRaiz()));
        System.out.println("Grado de SNC: " + arbolA.grado(nodoSnc));

        // ==========================================
        // PARTE 3: CONSTRUIR EL ÁRBOL B Y DECIDIR
        // ==========================================
        ArbolBinario<String> arbolB = new ArbolBinario<>();
        arbolB.crearRaiz("GPS");
        arbolB.agregarDerecho(arbolB.getRaiz(), "SCY");
        arbolB.agregarDerecho(arbolB.getDerecho(arbolB.getRaiz()), "MRR");
        arbolB.agregarDerecho(arbolB.getDerecho(arbolB.getDerecho(arbolB.getRaiz())), "PTZ");
        arbolB.agregarDerecho(arbolB.getDerecho(arbolB.getDerecho(arbolB.getDerecho(arbolB.getRaiz()))), "TPN");

        System.out.println("\n=== VISTA DEL ÁRBOL B ===");
        VistaArbol.mostrar(arbolB);

        // Pruebas del método esCadena
        System.out.println("\n=== PRUEBAS DE ES CADENA ===");
        System.out.println("¿Es cadena el Árbol A?: " + esCadena(arbolA));
        System.out.println("¿Es cadena el Árbol B?: " + esCadena(arbolB));
        
        // Casos límite obligatorios
        ArbolBinario<String> arbolVacio = new ArbolBinario<>();
        ArbolBinario<String> arbolUnico = new ArbolBinario<>();
        arbolUnico.crearRaiz("UNICO");
        
        System.out.println("¿Es cadena un Árbol Vacío?: " + esCadena(arbolVacio));
        System.out.println("¿Es cadena un Árbol de un solo nodo?: " + esCadena(arbolUnico));

        // Respuesta a la pregunta final del reto
        System.out.println("\n=== RESPUESTA FINAL (Pregunta 4) ===");
        System.out.println("El Árbol B se parece a una lista. Al buscar un dato en él, "
                + "el rendimiento disminuye a O(n) porque se comporta de forma puramente secuencial, "
                + "perdiendo la eficiencia de búsqueda propia de un árbol binario equilibrado.");
    }

    /**
     * Valida si un árbol es una cadena (su altura es igual a la cantidad de nodos menos 1).
     */
    public static boolean esCadena(ArbolBinario<String> arbol) {
        if (arbol == null || arbol.esVacio()) {
            return false; 
        }
        int altura = arbol.altura();
        int nodos = arbol.contarNodos();
        
        return altura == (nodos - 1);
    }
}
