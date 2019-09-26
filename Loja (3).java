/* author : paulo cesar garcia junior 
matricula : 11811BCC003
*/
package prova_3;

import javax.swing.*;
import java.util.*;

public class Loja extends Produto implements Comparable{

    public Loja(String codigo) throws Exception {
        super(codigo);
    }
    
    void processoBusca(Produto a, Produto[] b){
        int flag=0;
        for(int i=0; i<b.length; i++){
            if(a.getCodigo() == b[i].getCodigo()){
                flag = 1;
                //return b[i];
            }
        }
        if(flag == 0){
            JOptionPane.showMessageDialog(null, "Produto nao encontrado ", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        //return null;
    }
    
    void processoOrdenacao(Produto[] array){
        Produto maior = array[0];
        Produto auxiliar = array[0];
        int i, j;
        for(i=0; i<array.length; i++){
            for(j=0; j<array.length; j++){
                if(array[j].getCodigo() > maior.getCodigo()){
                    maior = array[j];
                } else if(auxiliar.getCodigo() > maior.getCodigo()){
                    maior = auxiliar;
                }
            }
            auxiliar = array[i];
            array[i] = maior;
            maior = auxiliar;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Produto a = new Produto ("10");
        a.setDescricao("Produto 1");
        a.setCodigo("10");
        a.setPreco_unitario(10);
        a.setQuantidade(10);
        Produto b = new Produto ("20");
        b.setDescricao("Produto 2");
        b.setCodigo("20");
        b.setPreco_unitario(15);
        b.setQuantidade(5);
        Produto c = new Produto ("30");
        c.setDescricao("Produto 3");
        c.setCodigo("30");
        c.setPreco_unitario(5);
        c.setQuantidade(15);
        Produto d = new Produto ("40");
        d.setDescricao("Produto 4");
        d.setCodigo("40");
        d.setPreco_unitario(2);
        d.setQuantidade(7);
        Produto e = new Produto ("50");
        e.setDescricao("Produto 5");
        e.setCodigo("50");
        e.setPreco_unitario(7);
        e.setQuantidade(2);
        Produto[] array = {a,b,c,d,e};
        for(int i=0; i<array.length; i++){
            System.out.printf("Produto: "+array[i]+"\n");
        }
        for(int i=0; i<array.length; i++){
            System.out.printf("Descricao: "+array[i].getDescricao()+"\n");
            System.out.printf("Codigo: "+array[i].getCodigo()+"\n");
            System.out.printf("Preco unitario: "+array[i].getPreco_unitario()+"\n");
            System.out.printf("Quantidade: "+array[i].getQuantidade()+"\n");
        }
        Produto f = new Produto ("30");
        f.setDescricao("Produto 3");
        f.setCodigo("30");
        f.setPreco_unitario(5);
        f.setQuantidade(15);
        Produto g = new Produto ("30");
        g.setDescricao("Produto 3");
        g.setCodigo("35");
        g.setPreco_unitario(5);
        g.setQuantidade(15);
        //Produto novo = processoBusca(f, array);
        //Produto novoDenovo =processoBusca(g, array);
        //static processoBusca(f, array);
        //static processoBusca(g, array);
        java.util.Arrays.sort(array);
        for(int i=0; i<array.length; i++){
                System.out.printf("Descricao: "+array[i].getDescricao()+"\n");
                System.out.printf("Codigo: "+array[i].getCodigo()+"\n");
                System.out.printf("Preco unitario: "+array[i].getPreco_unitario()+"\n");
                System.out.printf("Quantidade: "+array[i].getQuantidade()+"\n");
            }
    }
    
    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

