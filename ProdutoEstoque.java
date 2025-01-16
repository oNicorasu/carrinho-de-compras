public class ProdutoEstoque {
   String nome;
   Double valor;
   Integer qtd;

   // Construtor da classe ProdutoEstoque 
   public ProdutoEstoque(String nomeProduto, Double valorProduto, Integer qtdProduto){
      nome = nomeProduto;
      valor = valorProduto;
      qtd = qtdProduto;
   }
   // Método para obter o nome do produto
   public String getNome(){
      return nome;
   }

   // Método para obter o valor do produto
   public Double getValor(){
      return this.valor;
   }

   // Método para obter a quantidade do produto
   public Integer getQuantidade(){
      return qtd;
   }

   // Método para definir a quantidade do produto
   public void setQuantidade(int quantidade){
      this.qtd = quantidade;
   }

   // Método para definir o valor do produto
   public void setValor(Double valor){
      this.valor = valor;
   }
}
