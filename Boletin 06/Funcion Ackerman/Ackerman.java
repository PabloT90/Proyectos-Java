public class Ackerman{
	public static void main(String[]args){
		System.out.println(funcionAckerman(2,2));
	}
	
	
	public static int funcionAckerman(int m, int n){
		int resultado=0;
		if(m==0)
			resultado=n+1;
		else if(m>0 && n>0)
			resultado = funcionAckerman(m-1,funcionAckerman(m,n-1));
			else if(m>0 && n==0)
				resultado = funcionAckerman(m-1,1);
			
		return resultado;
	}
}
