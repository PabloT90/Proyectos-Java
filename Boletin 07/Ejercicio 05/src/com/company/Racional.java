/* Enunciado: Estudiar e implementar una clase racional. Un racional tiene numerador y un denominador.
              Queremos las funcionalidades: multiplicar, dividir.
*
*   Propiedades basicas:  numerador entero, consultable y modificable.
*                         denominador entero, consultable y modificable.
*   Propiedades derivadas: no hay.
*   Propiedades compartidas: nada.
*   Añadidas: multiplicar y dividir racionales.
*
*   Interfaz
*   Getters y setters
*   int getNumerador()
*   void setNumerador(int numerador)
*
*   int getDenominador()
*   void setDenominador(int denominador)
* */
package com.company;
public class Racional {
    private int numerador;
    private int denominador;

    //Constructores
    //Por defecto
    public Racional(){
        numerador = 0;
        denominador = 1; //No lo inicializo a 0 porque un denominador no puede ser 0
    }

    //Con parametros
    public Racional(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }

    //De copia
    public Racional(Racional racional){
        this.numerador = racional.numerador;
        this.denominador = racional.denominador;
    }

    //Getters/Setters

    public int getNumerador(){
        return numerador;
    }
    public void setNumerador(int numerador){
        this.numerador = numerador;
    }

    public int getDenominador(){
        return denominador;
    }
    public void setDenominador(int denominador){
        if(denominador != 0)
            this.denominador = denominador;
    }

    @Override
    public String toString(){
        return (numerador+"/"+denominador);
    }

    //En este punto la clase estaria a la mitad. Aun faltan el CompareTo y demas pero aun no los hemos dado.

    /*  prototipo: public Racional multiplicarRacionales(Racional multiplicacion)
		comentarios: multiplica 2 racionales.
		precondiciones: no hay
		entradas: 1 Racionales. Se pasan por referencia
		salidas: un Racional
		entr/sal: no hay
		postcondiciones: devuelve un Racional asociado al nombre.
	*/
    public Racional multiplicarRacionales(Racional multiplicacion){
        Racional resultado = new Racional();

        resultado.setNumerador(this.getNumerador()*multiplicacion.getNumerador());
        resultado.setDenominador(this.getDenominador()*multiplicacion.getDenominador());

        return resultado;
    }

    /*  prototipo: public Racional dividirRacionales(Racional division)
		comentarios: divide 2 racionales.
		precondiciones: no hay
		entradas: 1 Racionales. Se pasan por referencia
		salidas: un Racional
		entr/sal: no hay
		postcondiciones: devuelve un Racional asociado al nombre.
	*/
    public Racional dividirRacionales(Racional division){
        Racional resultado = new Racional();

        resultado.setNumerador(this.getNumerador()*division.getDenominador());
        resultado.setDenominador(this.getDenominador()*division.getNumerador());

        return resultado;
    }
}