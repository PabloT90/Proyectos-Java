package com.company.objetos;
    /*
Propiedades basicas:
    - mina char consultable y modificable.
    - vacia char consultable y modificable.
    - numero char consultable y modificable.

Propiedades derivadas: no hay.
Propiedades añadidas: Las de object
Propiedades comunes: no hay.
Restricciones: no hay.

Gets/sets
boolean getVacia()
void setVacia(char vacia)

boolean getMina()
void setMina(char mina)

boolean getNumero()
void setNumero(char numero)
*/public class Casilla implements Cloneable{
    private char vacia;
    private char mina;
    private char numero;

    //Constructores
    //Por defecto
    public Casilla(){
        vacia = ' ';
        mina = '*';
        numero = '1';
    }
    //Con parametros
    public Casilla(char vacia, char mina, char numero){
        this.vacia = vacia;
        this.mina = mina;
        this.numero = numero;
    }
    //De copia
    public Casilla(Casilla casilla){
        this.vacia = casilla.getVacia();
        this.mina = casilla.getMina();
        this.numero = casilla.getNumero();
    }
    //Gets/sets
    public char getVacia(){
            return vacia;
        }
        public void setVacia(char vacia){
            this.vacia = vacia;
        }

        public char getMina(){
            return mina;
        }
        public void setMina(char mina){
            this.mina = mina;
        }

        public char getNumero(){
            return numero;
        }
        public void setNumero(char numero){
            this.numero = numero;
        }

        @Override
        public boolean equals(Object obj){
            boolean ret = false;

            if(this == obj){
                ret = true;
            }else{
                if(obj != null && obj instanceof Casilla){
                    Casilla otra = (Casilla)obj;
                    if(this.getMina() == otra.getMina() &&
                    this.getNumero() == otra.getNumero() &&
                    this.getVacia() == otra.getVacia()){
                        ret = true;
                    }
                }
            }
            return ret;
        }

        @Override
        public Casilla clone(){
            Casilla copia = null;

            try{
                copia = (Casilla)super.clone();
            }catch(CloneNotSupportedException error){
                System.out.println("Error en la copia");
            }

            return copia;
    }
}