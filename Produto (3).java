/* author : paulo cesar garcia junior 
matricula : 11811BCC003
*/
package prova_3;

public class Produto {
    
    private String descricao;
    private double preco_unidade;
    private int qtd_estoque;
    private int cod_produto;
    
    public Produto(String descricao, double preco_unidade, int qtd_estoque, String cod_produto) {
        
        this.descricao = descricao;
        this.preco_unidade = preco_unidade;
        this.qtd_estoque = qtd_estoque;
        this.cod_produto = setCodigoBarra(cod_produto);
        
    }

    
    public static int setCodigoBarra(String cod){
	
        int soma = 0, resto = 0, dv = 0;
        
	String[] numeros = new String[cod.length()+1];
	
        int multi = 2;
	String aux;
	String aux2;
	String aux3;
	    
	for (int i = cod.length(); i > 0; i--) {  	    	

	    if(multi%2 == 0){
  
                numeros[i] = String.valueOf(Integer.valueOf(cod.substring(i-1,i))*2);
	    	multi = 1;
	    	}
            else{
                    numeros[i] = String.valueOf(Integer.valueOf(cod.substring(i-1,i))*1);
                    multi = 2;
	    	}
	    }  
	    
	    for(int i = (numeros.length-1); i > 0; i--){
	    	aux = String.valueOf(Integer.valueOf(numeros[i]));
	    	
	    	if(aux.length()>1){
	    		aux2 = aux.substring(0,aux.length()-1);	    		
	    		aux3 = aux.substring(aux.length()-1,aux.length());
	    		numeros[i] = String.valueOf(Integer.valueOf(aux2) + Integer.valueOf(aux3));	    		
	    	}
	    	else{
	    		numeros[i] = aux;    		
	    	}
	    }
	    
	    
	    for(int i = numeros.length; i > 0 ; i--){
	    	if(numeros[i-1] != null){
	    		soma += Integer.valueOf(numeros[i-1]);
	    	}
	    }
            
	resto = soma%10;
    	dv = 10 - resto;
	    
	return dv;
         
             
     }
    
    
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.cod_produto != other.cod_produto) {
            return false;
        }
        return true;
    }
    
    


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_unidade() {
        return preco_unidade;
    }

    public void setPreco_unidade(double preco_uni) {
        this.preco_unidade = preco_unidade;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    @Override
    public String toString() {
        return  "Produto : \n" +
                "Descrição = " + descricao +
                "\n Preço unitário = " + preco_unidade +
                "\n Quantidade em Estoque = " + qtd_estoque +
                "\n Código do produto = " + cod_produto ;
    }
 
}
