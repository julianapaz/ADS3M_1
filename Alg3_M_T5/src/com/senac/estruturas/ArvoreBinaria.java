package com.senac.estruturas;

public class ArvoreBinaria<T extends Comparable<T>> 
{
	
	private Nodo raiz;
	private int totalNodos;

	
	
	public ArvoreBinaria(Nodo raiz)
	{
		this.raiz = raiz;
		this.totalNodos = 1;
		

	}
	
	public ArvoreBinaria()
	{
		raiz = null;
		totalNodos = 0;
	}
	
	public Nodo getRaiz()
	{
		return raiz;
	}
	
	public int getTotalNodos()
	{
		return totalNodos;
	}
	
	/**
	 * Metodo que insere um nodo nodo a partir da raiz
	 * @param r
	 * @param novo
	 * @return nodo inserido
	 */
	
	public Nodo insere(Nodo r, Nodo novo)
	{
		
		if( r==null )
			r = novo;
		else
		{
			int cmp = novo.compareTo(r);
		
			if( cmp < 0 ) 
			{
				if( r.getEsquerda() == null )
				{
					r.setEsquerda(novo);
					totalNodos++;
				}
		
				else
					r.setEsquerda(insere(r.getEsquerda(),novo));
			}
			else if( cmp > 0 )
			{
				if( r.getDireita() == null )
				{
					r.setDireita(novo);
					totalNodos++;
				}
				else
					r.setDireita(insere(r.getDireita(),novo));
			}
			else
				System.out.println("Nodo ja existe na arvore");	
		}
		
		
		return r;
	}

	/*
	 * Nao sei usar compare
	 */
	public int compareTo(Nodo o) {
		return raiz.compareTo(o);
	}
	
	
	public void printInfixa(Nodo nodo)
	{
		if( nodo != null )
		{
			printInfixa(nodo.getEsquerda());
			System.out.println(nodo);
			printInfixa(nodo.getDireita());
			
		}
			
	}
	
	public void printPrefixa(Nodo nodo)
	{
		if( nodo != null )
		{
			System.out.println(nodo);
			printInfixa(nodo.getEsquerda());
			printInfixa(nodo.getDireita());
		}
	}
	
	/**
	 * Metodo que busca um nodo na arvore
	 * se existir exibe seu conteudo e nr de comparacoes
	 * @param nodoRaiz
	 * @param chave
	 * @param nrComparacoes
	 */
	
	public void busca(Nodo nodoRaiz, String chave, int nrComparacoes)
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
	 * Metodo recursivo de remover um nodo
	 * @param r
	 * @param chave
	 * @return
	 */
	
	
	public Nodo remove(Nodo r, String chave)
	{
		
		if(r == null)
			System.out.println("Nao existe o dado na arvore");
		
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
					System.out.println("Pai " + buscaPai(r));
					System.out.println("Eh uma folha!");
					Nodo pai = buscaPai(r);
					
					//se o filho for da direita
					if ( r.compareTo(pai) > 0 )
						//apaga a referencia da direita
						pai.setDireita(null);
					//senao
					else
						//apaga referencia da esquerda
						pai.setEsquerda(null);
					
				}
				
				
				/*
				 * Verifica se o nodo tem um filho a esquerda
				 * filho a esquerda passa a ser a raiz
				 */
				else if ( r.getDireita() == null)
				{
					
					Nodo pai = buscaPai(r);
					
					if ( r.compareTo(pai) > 0 )
						pai.setDireita(r.getEsquerda());
					else
						pai.setEsquerda(r.getEsquerda());
					r.setEsquerda(null);
			
				}
				
				/* Verifica se o nodo tem um filho a esquerda
				 * filho a esquerda passa a ser a raiz 
				 */
				
				else if ( r.getEsquerda() == null)
				{
					
					Nodo pai = buscaPai(r);
					
					if ( r.compareTo(pai) > 0 )
						pai.setDireita(r.getDireita());
					else
						pai.setEsquerda(r.getDireita());
					r.setDireita(null);
			
				}

				//nodo tem filhos esq e direita
				//busca a menor folha da direita da esquerda
				//a menor folha assume o lugar da raiz - nodo a ser removido
				// nodo ser removido recebe as informacoes da menor folha
				// apaga as referencias do antigo pai da folha
				else
				{
					Nodo menorFolha = menorFolhaEsquerda(r.getDireita());
					Nodo pai = buscaPai(menorFolha);
					
					if(menorFolha.compareTo(pai) > 0)
						pai.setDireita(null);
					else
						pai.setEsquerda(null);
					r.setChave(menorFolha.getChave());
					r.setDado(menorFolha.getDado());
				}
					
			}
				
		}
		
		
		
		return r;
	}
	
	
	public Nodo buscaPai(Nodo filho)
	{
		
		//System.out.println("FIlho " + filho);
		
		if ( filho == raiz)
			return null;
		
		Nodo anterior = null;
		Nodo atual = raiz;
		
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
	
	public Nodo menorFolhaEsquerda(Nodo nodo)
	{
		System.out.println("Metodo menor a direita da esquerda");
		
		while(nodo.getEsquerda() != null )
		{
			nodo = nodo.getEsquerda();
			System.out.println("Nodo esquerda " + nodo);
		}
		
		return nodo;
	}
		
	public static void main(String[] args) {
		
		ArvoreBinaria<String> arvore = new ArvoreBinaria<>(new Nodo("j","716276336"));

		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("b","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("c","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("d","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("e","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("f","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("g","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("a","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("p","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("r","282737347"));
		System.out.println(arvore.getTotalNodos());
		arvore.insere(arvore.getRaiz(), new Nodo("k","282737347"));
		System.out.println(arvore.getTotalNodos());
		
		arvore.busca(arvore.getRaiz(), "j", 0);
		arvore.busca(arvore.getRaiz(), "g", 0);
		arvore.busca(arvore.getRaiz(), "a", 0);
		arvore.busca(arvore.getRaiz(), "x", 0);

		
		arvore.remove(null, "j");
		arvore.printInfixa(arvore.getRaiz());
	}
	
}
