
package livrariavirtual;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Marcos
 */
public class Venda
{
    private static int numVendas;
    private static int numero;
    private static String cliente;
    private static float valor;
    private ArrayList<Livro> livros = new  ArrayList<Livro>();

    public Venda() {
    }

    public int getNumVendas() {
        return numVendas;
    }

    public void setNumVendas(int codigo) {
        this.numVendas = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int codigo) {
        this.numero = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String descricao) {
        this.cliente = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void addLivro(Livro livro, int index){
        try{
            if (livro instanceof  Impresso){
                
            }
            else if (livro instanceof  Eletronico){
                
            }
            this.livros.add(livro);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERRO: " + e);
            throw e;
        }
        catch(Exception e){
            System.out.println("ERRO: " + e);
            throw e;
        }
    } 

    public int qtdeLivros(){
        return this.livros.size();
    }
            
    public String toString() {
        String strReturn = "";
                
        strReturn = "Cliente: " + this.getCliente() + ", Qtd Livros: " + this.qtdeLivros() + " \n";
        strReturn = strReturn + "  ##Livros: \n";
        
        for (int i = 0; i < this.qtdeLivros(); i++) {
            strReturn = strReturn + ("             - " + (i+1) + " - ");
            strReturn = strReturn + this.livros.get(i).toString();
            strReturn = strReturn + " \n";
	}
        
        return strReturn;
    }
}