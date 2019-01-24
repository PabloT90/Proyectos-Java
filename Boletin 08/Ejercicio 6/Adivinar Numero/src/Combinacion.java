/*
Propiedades basicas:
    - int[] codigo, consultable y modificable.
    - boolean unlocked, consultable y modificable
Propiedades derivadas: no hay.
Propiedades compartidas: no hay.
Propiedades añadidas:
    - equals
    - toString
    - clone

Gets Sets
    int[] getCodigo()
    void setCodigo(int[] codigo)

    boolean getUnlocked()
    void setUnlocked(boolean unlock)
*/
public class Combinacion implements Cloneable{
    private int[] codigo;
    private boolean unlocked;

    //CONSTRUCTORES
    //Por defecto
    public Combinacion(){
        codigo = new int[3];
        unlocked = false;
    }

    //Con parametros
    public Combinacion(int[] codigo,boolean unlocked){
        this.codigo = codigo;
        this.unlocked = unlocked;
    }

    //De copia
    public Combinacion(Combinacion copia){
        this.codigo = copia.getCodigo();
        this.unlocked = copia.getUnlocked();
    }

    //Gets Sets
    public int[] getCodigo(){
        return codigo;
    }
    public void setCodigo(int[] codigo){
        this.codigo = codigo;
    }

    public boolean getUnlocked(){
        return unlocked;
    }
    public void setUnlocked(boolean unlock){
        this.unlocked = unlock;
    }

    @Override
    public String toString(){
        return "Codigo: "+ getCodigo();
    }


    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if(this == obj){
            ret = true;
        }else{
            if(obj != null && obj instanceof Combinacion){
                Combinacion otro = (Combinacion)obj;
                if(this.getCodigo() == otro.getCodigo()){
                    ret = true;
                }
            }
        }
        return ret;
    }

    @Override
    public Combinacion clone(){
        Combinacion copia = null;

        try{
            copia = (Combinacion)super.clone();
        }catch(CloneNotSupportedException error){
            System.out.println("Error en la clonacion");
        }

        return copia;
    }

}