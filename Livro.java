import java.util.Objects;

public class Livro {

    private String titulo;
    private String autor;
    private String genero;
    private int ano;
    private int paginas;
    
    
    public Livro(String titulo, String autor, String genero, int ano, int paginas) {

        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
        this.paginas = paginas;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getAno() {
        return ano;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return titulo.equals(livro.titulo) && autor.equals(livro.autor);
    }

    @Override
    public int hashCode()   {
        return Objects.hash(titulo, autor);
    }

    @Override
    public String toString() {
        return "\"" + titulo + "\" de " + autor;
    }


}


