
public class ArvoreDeLivros {
    private No raiz;

    // Inserção baseada no título
    public void inserir(Livro livro)    {
        raiz = inserirRecursivo(raiz, livro);
    }

    private No inserirRecursivo(No atual, Livro livro)  {
        if (atual == null) return new No(livro);

        if(livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) < 0)    {
            atual.esquerdo = inserirRecursivo(atual.esquerdo, livro);
        } else {
            atual.direito = inserirRecursivo(atual.direito, livro);
        }

        return atual;
    }

    // Busca por título
    public Livro buscaPorTitulo(String titulo)  {
        return buscarRecursivo(raiz, titulo);
    }

    private Livro buscarRecursivo(No atual, String titulo)  {
        if (atual == null) return null;

        int comp = titulo.compareToIgnoreCase(atual.livro.getTitulo());
        if (comp == 0) return atual.livro;
        else if (comp < 0) return buscarRecursivo(atual.esquerdo, titulo);
        else return buscarRecursivo(atual.direito, titulo);
    }

    // Exibição ordenada por título
    public void exibirOrdem()   {
        exibirEmOrdemRec(raiz);
    }

    private void exibirEmOrdemRec(No atual) {
        if(atual != null)   {
            exibirEmOrdemRec(atual.esquerdo);
            System.out.println(atual.livro);
            exibirEmOrdemRec(atual.direito);
        }
    }
}


