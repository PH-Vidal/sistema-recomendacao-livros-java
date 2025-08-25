import java.util.*;

public class SistemaRecomendacao {
    
    private GrafoLivros grafo;

    public SistemaRecomendacao(GrafoLivros grafo) {
        this.grafo = grafo;
    }

    public Set<Livro> recomendarBaseadoEm(Livro livro)  {
        Set<Livro> recomendados = new HashSet<>();
        Set<Livro> diretos = grafo.getRecomendacoes(livro);

        //Adiciona recomendações diretas
        recomendados.addAll(diretos);

        //Adiciona recomendações dos recomendados (recomendações de segundo grau)
        for (Livro I : diretos) {
            recomendados.addAll(grafo.getRecomendacoes(I));
        }

        //Remove o próprio livro para não se auto-recomendar
        recomendados.remove(livro);

        return recomendados;
    }
}
