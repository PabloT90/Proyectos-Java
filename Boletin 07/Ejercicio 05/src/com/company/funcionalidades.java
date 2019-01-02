package com.company;
public class funcionalidades {
    /*  prototipo: public Racional multiplicarRacionales(Racional multipli1, Racional multipli2)
		comentarios: multiplica 2 racionales.
		precondiciones: no hay
		entradas: 2 Racionales. Se pasan por referencia?
		salidas: un Racional
		entr/sal: no hay
		postcondiciones: devuelve un Racional asociado al nombre.?
	*/
    public static Racional multiplicarRacionales(Racional multipli1, Racional multipli2){
        Racional resultado = new Racional();
        resultado.setNumerador(multipli1.getNumerador()*multipli2.getNumerador());
        resultado.setDenominador(multipli1.getDenominador()*multipli2.getDenominador());

        return resultado;
    }

    /*  prototipo: public Racional dividirRacionales(Racional division1, Racional division2)
		comentarios: divide 2 racionales.
		precondiciones: no hay
		entradas: 2 Racionales. Se pasan por referencia?
		salidas: un Racional
		entr/sal: no hay
		postcondiciones: devuelve un Racional asociado al nombre.?
	*/
    public static Racional dividirRacionales(Racional division1, Racional division2){
        Racional resultado = new Racional();
        resultado.setNumerador(division1.getNumerador()*division2.getDenominador());
        resultado.setDenominador(division1.getDenominador()*division2.getNumerador());

        return resultado;
    }
}