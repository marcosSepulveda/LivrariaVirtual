
package livrariavirtual;


/**
 *
 * @author Marcos
 */
public abstract class Livro {
    
    private String titulo;
    private String autores;
    private String editora;
    private float preco;
    
    //Contrutor livre
    public Livro() {

    }
    
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autores
     */
    public String getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(String autores) {
        this.autores = autores;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public String toString() {
        return "Título: " + this.getTitulo() + ", Autores: " + this.getAutores() +
               ", Editora: " + this.getEditora() + ", Preço: " + this.getPreco();
    }
}
