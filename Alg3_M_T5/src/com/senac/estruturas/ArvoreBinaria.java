package com.senac.estruturas;

public class ArvoreBinaria<T extends Comparable<T>> 
{
	
	private Nodo<T> raiz;
	private int totalNodos;
	
	
	public ArvoreBinaria(Nodo<T> raiz)
	{
		this.raiz = raiz;
		this.totalNodos = 1;
	}
	
	public ArvoreBinaria()
	{
		raiz = null;
		totalNodos = 0;
	}
	
	public Nodo<T> getRaiz()
	{
		return raiz;
	}
	
	public int getTotalNodos()
	{
		return totalNodos;
	}
		
	/**
	 * Metodo que insere um novo nodo a partir da raiz
	 * incrementa o total de nodos armazenados
	 * @param raiz
	 * @param novo
	 * @return nodo inserido
	 */	
	public Nodo<T> insere(Nodo<T> r, Nodo<T> novo)
	{
		
		
		if( r==null )
		{
			raiz = novo;
			totalNodos++;
		}
		else
		{
			int cmp = novo.compareTo(r);
			
			//se nodo menor que a raiz
			if( cmp < 0 ) 
			{
				//se raiz nao tem filho no lado esquerdo
				if( r.getEsquerda() == null )
				{
					//insere e incrementa o total de nodos da arvore
					r.setEsquerda(novo);
					totalNodos++;
			
		
				}
				
				//senao chamo o metodo de insercao enviando a raiz da esquerda
				else
					
					r.setEsquerda(insere(r.getEsquerda(),novo));
			}
			//se nodo maior que a raiz
			else if( cmp > 0 )
			{
				//raiz nao tem filho a direita
				if( r.getDireita() == null )
				{
					//insere e incrementa o total de nodos da arvore
					r.setDireita(novo);
					totalNodos++;					
				}
				//senao chama o metodo insercao enviando a raiz da direita
				else				
					r.setDireita(insere(r.getDireita(),novo));
			}
			//eh igual
			else
				System.out.println("Dado ja esta na arvore");		
		}
				
		return r;
	}
	
	
	
	/*
	 * Nao sei usar compare
	 */
	public int compareTo(Nodo<T> o) {
		return raiz.compareTo(o);
	}
	
	/**
	 * Metodo que imprime os nodos da arvore
	 * na sequencia infixa
	 * filho da esquerda
	 * raiz
	 * filho da direita
	 *  
	 * @param nodoRaiz
	 */
	public void travessiaInfixa(Nodo<T> nodoRaiz)
	{
		if( nodoRaiz != null )
		{
			travessiaInfixa(nodoRaiz.getEsquerda());
			System.out.println(nodoRaiz);
			travessiaInfixa(nodoRaiz.getDireita());	
		}			
	}
	
	/**
	 * Metodo que imprime os nodos da arvore 
	 * na sequencia prefixa
	 * raiz
	 * filho da esquerda
	 * filho da direita
	 * 
	 * @param nodoRaiz
	 */
	public void travessiaPrefixa(Nodo<T> nodoRaiz)
	{
		if( nodoRaiz != null )
		{
			System.out.println(nodoRaiz);
			travessiaInfixa(nodoRaiz.getEsquerda());
			travessiaInfixa(nodoRaiz.getDireita());
		}
	}
	
	/**
	 * Metodo que imprime os nodos da arvore
	 * na sequencia posfixa
	 * filho da esquerda
	 * filho da direita
	 * raiz
	 * @param nodoRaiz
	 */
	public void travessiaPosFixa(Nodo<T> nodoRaiz)
	{
		if( nodoRaiz != null )
		{			
			travessiaInfixa(nodoRaiz.getEsquerda());
			travessiaInfixa(nodoRaiz.getDireita());
			System.out.println(nodoRaiz);
		}
	}
	
	/**
	 * Metodo que busca um nodo na arvore
	 * se existir exibe seu conteudo e nr de comparacoes
	 * @param nodoRaiz
	 * @param chave
	 * @param nrComparacoes
	 */
	
	public void busca(Nodo<T> nodoRaiz, T chave, int nrComparacoes)
	{
		/*
		 * Quando ja percorreu toda arvore
		 * pegando o nodo raiz da ultima busca
		 * o qual eh uma referencia da esquerda ou direita
		 * por nao possuir mais elemento eh nulo 
		 */
		if ( nodoRaiz == null)
			System.out.println("Dado nao existe na arvore" +
					"\nNumero de comparacoes: " + nrComparacoes);
		else
		{
			//compara a chave de busca com a raiz
			int cmp = chave.compareTo(nodoRaiz.getChave());
			
			/*
			 * Achou
			 * Imprime o nodo e o nr de comparoes
			 */
			if( cmp == 0 )
			{
				nrComparacoes++;
				System.out.println(nodoRaiz + "\nNumero de comparacoes: " + nrComparacoes);				
			}				
			
			/*
			 * a chave de busca eh maior que a raiz 
			 * incrementa o nr de comparacoes
			 * chama metodo de busca com o filho da esquerda como raiz
			 */
			else if( cmp < 0 )
			{
				nrComparacoes++;
				busca(nodoRaiz.getEsquerda(), chave, nrComparacoes);
					
			}
			/*
			 * a chave de busca eh menor que a raiz 
			 * incrementa o nr de comparacoes
			 * chama metodo de busca com o filho da direita como raiz
			 */
			else
			{
				nrComparacoes++;
				busca(nodoRaiz.getDireita(),chave, nrComparacoes);
			}
					
		}
	}
	/**
	 * Metodo para remover um nodo
	 * 
	 * @param raiz
	 * @param chave
	 * @return nodo removido
	 */	
	public Nodo<T> remove(Nodo<T> r, T chave)
	{
		//atualiza a altura
		//nr de nodos
		if(r == null)
			System.out.println("Dado nao existe na arvore");
		
		else
		{
			int cmp = chave.compareTo(r.getChave());
			
			//nao achou e esta na parte direita da arvore
			//eh maior que a raiz
			if ( cmp > 0)
				remove(r.getDireita(), chave);
			
			//nao achou e esta na parte esquerda da arvora
			//eh menor que a raiz
			else if ( cmp < 0)
				remove(r.getEsquerda(), chave);
			
			//encontrou o nodo
			else
			{
				/*verifica se o nodo a ser removido eh
				 * folha
				 * raiz com um filho a direita
				 * raiz com um filho a esquerda
				 * raiz com dois filhos
				 */
				
				/*
				 * verifica se o nodo a ser excluido eh uma folha 
				 * busca o pai do nodo e apaga a referencia da esq ou da dir
				 */
				if ( r.getDireita()==null && r.getEsquerda() == null )
				{
					/*System.out.println("Pai " + buscaPai(r));
					System.out.println("Eh uma folha!");
					*/
					Nodo<T> pai = buscaPai(r);
					
					//se o filho for da direita
					if ( r.compareTo(pai) > 0 )
						//apaga a referencia da direita
						pai.setDireita(null);
					//senao
					else
						//apaga referencia da esquerda
						pai.setEsquerda(null);
					totalNodos--;
				}
				
				
				/*
				 * Verifica se o nodo tem um filho a esquerda
				 * filho a esquerda passa a ser a raiz
				 */
				else if ( r.getDireita() == null)
				{
					
					
					
					r.setChave(r.getEsquerda().getChave());
					r.setDado(r.getEsquerda().getDado());
					
					
					Nodo<T> pai = buscaPai(r);
					
					if( pai != null )
					{	
						if ( r.compareTo(pai) > 0 )
							pai.setDireita(r.getEsquerda());

						else
							pai.setEsquerda(r.getEsquerda());
					}
					else
						r.setEsquerda(r.getEsquerda().getEsquerda());
					
					totalNodos--;
				}
				
				/* Verifica se o nodo tem um filho a esquerda
				 * filho a esquerda passa a ser a raiz 
				 */
				
				else if ( r.getEsquerda() == null)
				{
					
					
					r.setChave(r.getDireita().getChave());
					r.setDado(r.getDireita().getDado());
					
					
					Nodo<T> pai = buscaPai(r);
					//System.out.println(pai);
					
					if ( pai != null )
					{
						if ( r.compareTo(pai) > 0 )
							pai.setDireita(r.getDireita());
						else
							pai.setEsquerda(r.getDireita());
					}
					else
						r.setDireita(r.getDireita().getDireita());
					
					totalNodos--;
				}

				//nodo tem filhos esq e direita
				//busca a menor folha da direita
				//a menor folha assume o lugar da raiz - nodo a ser removido
				// nodo ser removido recebe as informacoes da menor folha
				// apaga as referencias do antigo pai da folha
				else
				{
					Nodo<T> menorFolha = menorFolhaDireita(r.getDireita());
					Nodo<T> pai = buscaPai(menorFolha);
					
					if(menorFolha.compareTo(pai) > 0)
						pai.setDireita(null);
					else
						pai.setEsquerda(null);
					r.setChave(menorFolha.getChave());
					r.setDado(menorFolha.getDado());
					
					totalNodos--;
				}
					
			}
				
		}		
		
		return r;
	}
	/**
	 * Metodo que recebe um nodo filho
	 * percorre a arvore comparando se o nodo de 
	 * entrada eh filho do nodo corrente
	 * @param filho
	 * @return pai
	 */
	public Nodo<T> buscaPai(Nodo<T> filho)
	{
		
		//System.out.println("FIlho " + filho);
		
		if ( filho == raiz)
			return null;
		
		Nodo<T> anterior = null;
		Nodo<T> atual = raiz;
		
		while( filho != atual)
		{
			//System.out.println("Filho "+filho);
			anterior = atual;
			//System.out.println("Anterior "+anterior);
			if( filho.compareTo(atual)>0)
					atual = atual.getDireita();
			else
				atual = atual.getEsquerda();
		}
		
		return anterior;
		
	}	
	
	/**
	 * Metodo que percorre a arvore do nodo direito
	 * returno a menor folha - ultima folha filha esquerda
	 * @param nodo - raiz
	 * @return menor folha
	 */
	
	public Nodo<T> menorFolhaDireita(Nodo<T> nodo)
	{
		/*
		 * Percorre a arvore ate a ultima folha
		 * 	
		 */
		while(nodo.getEsquerda() != null )

			//nodo atual recebe o filho da esquerda
			nodo = nodo.getEsquerda();		
		
		return nodo;
	}
	
	public int altura(Nodo<T> nodoRaiz)
	{
		if ( nodoRaiz == null )
			return 0;
		
		else
		{
			int alturaDireita = altura(nodoRaiz.getDireita());
			int alturaEsquerda = altura(nodoRaiz.getEsquerda());
			
			if ( alturaDireita>alturaEsquerda )
				return alturaDireita + 1;
			else
				return alturaEsquerda + 1;
		}
			
	}
	
	
	/*public void buscaEMProfundidade(Nodo<T> nodoRaiz)
	{
		//declara uma fila
		//e r d
	}	*/
	
	/*public void buscaemLargura(Nodo<T> nodoRaiz)
	{
	//declara uma pilha
	 //e r d
		
	}
	*/
		
	public static void main(String[] args) {
		
		ArvoreBinaria<String> arvore = new ArvoreBinaria<String>(new Nodo<String>("j","716276336"));

		//System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("b","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo<String>("c","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo<String>("k","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo<String>("a","282737347"));
		arvore.insere(arvore.getRaiz(), new Nodo<String>("d","282737347"));
		/*System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("c","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("d","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("e","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("f","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("g","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("a","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("p","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("r","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo<String>("k","282737347"));
		System.out.println(arvore.getTotalNodos());*/
		
		/*arvore.busca(arvore.getRaiz(), "j", 0);
		arvore.busca(arvore.getRaiz(), "g", 0);
		arvore.busca(arvore.getRaiz(), "a", 0);
		arvore.busca(arvore.getRaiz(), "x", 0);
		arvore.remove(arvore.getRaiz(), "x");*/

		//System.out.println(arvore.getTotalNodos());
		//System.out.println("Altura " + arvore.altura(arvore.getRaiz()));
		//arvore.travessiaInfixa(arvore.getRaiz());
		//arvore.remove(arvore.getRaiz(), "c");
		//System.out.println(arvore.getTotalNodos());
		//arvore.travessiaInfixa(arvore.getRaiz());
	//	System.out.println(arvore.filhosEsquerda(arvore.getRaiz()));
	
	
	}
	
}
