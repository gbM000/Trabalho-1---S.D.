package trabalho1sd.servidor.model;

public class Livro {
    
    private int codigo;
    private String titulo;
    private boolean disponivel;
    
    public Livro(int cod, String tit){
        this.codigo = cod;
        this.titulo = tit;
        this.disponivel = true;
    }
}
