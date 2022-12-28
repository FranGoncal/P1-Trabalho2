import java.util.Scanner;

public class Trabalho2 {

	
	
	static void menuInicial() {																			// Mostra o menu inicial.
		System.out.println("(I)nserir linhas no fim (termine com uma linha vazia)");					
		System.out.println("(L)istar linhas");
		System.out.println("(A)pagar última linha");
		System.out.println("(E)ditar");
		System.out.println("(F)erramentas");
		System.out.println("(S)air");
	}
	static void menuEditar() {																			// Mostra o menu editar.
		System.out.println("\n(I)nserir linha na posição n");								
		System.out.println("(A)pagar linha na posição n");
		System.out.println("Apagar (l)inhas da posição n à posição m");
		System.out.println("(R)ecuperar linha");
		System.out.println("(E)liminar linhas apagadas");
		System.out.println("(V)oltar");	
	}
	static void menuFerramentas() {																		// Mostra o menu Ferramentas.
		System.out.println("\n(M)ostrar linhas onde ocorre a palavra p.");						
		System.out.println("(S)ubstituir a palavra p na linha n.");
		System.out.println("Mostrar número de (l)inhas.");
		System.out.println("Mostrar número de (p)palavras.");
		System.out.println("Mostrar número de (c)aracteres.");
		System.out.println("\n(V)oltar.");
	}
	public static void main(String[] args) {
		/*
		 * Francisco Mateus Goncalves Nº20221849 Engenharia Informática	TP5
		 * Pedro Daniel Duarte Nº20221701 Engenharia Informática TP5
		 */

		Scanner input = new Scanner(System.in);

		int tamMax = 100;

		String [] linhas = new String[tamMax];
		int [] nPalavras = new int[tamMax];
		int [] nChars = new int[tamMax];
		boolean [] apagada = new boolean[tamMax];

		int nLinhas = 0;
		int numLinha = 0;
		String userInput;
		String opcaoFerramenta;
		String palavra = "";	
		boolean encontrouPalavra = false;


		do {
			menuInicial();

			userInput = input.nextLine();
			switch(userInput) {
			case "I" :
			case "i" :
				String frase = " ";
				if(nLinhas != tamMax) {																		// Verifica se foi atingido o tamMax o limite de linhas antes de podermos escrever linhas.
					System.out.println("Escreva várias linhas, para terminar insira um linha vazia.");
					while(frase != "" && (nLinhas <= 99)){													// Este while serve para inserir linhas enquanto o utilizador não der um enter vazio.
						frase = input.nextLine();															// Armazena numa variável chamada frase cada linha escrita pelo utilizador. 
						if(frase != "") {																	// Este if verifica se a variável frase tem algo escrito, para não contar o enter que finaliza esta ferramenta nos contadores nLinhas e linhasAdicionadas e para não adicionar nada no array linhas[].
							nLinhas++;																		// Por cada vez que este if é ativo dentro do while é somado +1 à variável nLinhas porque por cada vez que isto acontece também é inserida uma linha pelo utilizador e guardado no array linhas[].
							linhas[nLinhas-1] = frase;														// No caso da string frase conter texto este é guardado no array linhas[].
						}
					}
				}

				if(nLinhas == 100) {																		// Sempre que o utilizador chegar ou tiver 100 linhas já escritas este if mostra uma mensagem que ajuda o utilizador a entender o está a acontecer e o que pode fazer para solucionar o seu problema.
					System.out.println("Chegou ao limite de linhas, para escrever mais terá que apagar uma destas.\n");
				}
				break;

			case "L" :
			case "l" :
				for(int i = 0; i < nLinhas; i++) {															// Este for percorre os arrays apagada[] e linhas[], usando o apagada[] para verificar se pode ou não mostrar o que está guardado no array linhas[].
					System.out.print("Linha Nº" + (i + 1) + " - ");											// Identifica a linha que será printada para uma mais fácil leitura. Usamos apenas um print porque não queremos passar de linha.
					if(apagada[i] == false) {																// Verifica se o que ta escrito na linha i (que vai mudando consoante o for) do array apagado[]	é falso ou seja, se a frase está visível.							
						System.out.println(linhas[i]);														// Este println escreve as linhas do array linhas[] consoante o seu estado visível ou não.
					}
					else{																					// No caso de a linha estar oculta fazemos um println para passar para a linha seguinte visto que a última coisa que apareceu na consola foi um print e não um println.
						System.out.println();
					}
				}
				System.out.println();																		// Este print serve apenas para dar um espaço entre o menu principal e o que mostra esta ferramenta.
				break;
			case "A" :
			case "a" :

				if(apagada[nLinhas-1] == false) {															// Verifica se a última linha está visível.
					apagada[nLinhas-1] = true;																// Caso a linha esteja visível mudamos o valor desta variável para true no array apagada[].
					System.out.println("A linha foi apagada.\n");											// Mostra uma mensagem que confirma ao utilizador que a linha foi apagada.
				}
				else {
					System.out.println("A última linha já se encontra apagada.\n");							// No caso da última linha já esta apagada ou seja com o valor true no array apagada[], mostramos só uma mensagem ao utilizador que diz isso mesmo.
				}
				break;

			case "E" :
			case "e" :
				do {
					menuEditar();
									

					userInput = input.nextLine();
					switch(userInput) {


					case "I" :
					case "i" :
						if(nLinhas == tamMax) {																// No caso de o número de linhas já ser igual ao tamMax, não permite que esta funcionalidade continue porque não é possível adicionar mais linhas.
							System.out.println("Chegou ao limite de linhas, para escrever mais terá que apagar uma destas.\n");	// Avisa o utilizador de que chegou ao limite de linhas e escreve uma solução ao seu problema.
							break;
						}
						System.out.println("Qual a posição em que deseja inserir uma linha?");				// Pede uma posição ao utilizador para inserir uma linha.
						int inserirL = input.nextInt();														// Guardamos o que o utilizador introduz na consola na variável inserirL, que simboliza o número da linha onde o utilizador quer introduzir a linha. 
						input.nextLine();																	// Faz uma limpeza do scanner.
						if(inserirL > 0 && inserirL <= nLinhas) {											// Este if faz uma validação do número da linha introduzida pelo utilizador.
							for(int i = 0; i <= nLinhas-inserirL; i++) {									// Este for percorre os arrays linhas[] e apagada[] desde a última linha até à linha que o utilizador escolheu, representando isso o intervalo (nLinhas-inserirL).									
								linhas[nLinhas-i] = linhas[nLinhas-1-i];									// Guardamos os valores por baixo da linha que vai ser introduzida do array linhas[] no espaço seguinte do mesmo array. 
								apagada[nLinhas-i] = apagada[nLinhas-1-i];									// Guardamos os valores por baixo da linha que vai ser introduzida do array apagada[] no espaço seguinte do mesmo array.
							}
							System.out.print("Escreva uma linha: ");										// Pedimos o texto ao utilizador para ele por na linha.			
							linhas[inserirL-1] = input.nextLine();											// E guardamos esse texto na posição correspondente no array linhas[] a inserirL.
							apagada[inserirL-1] = false;													// Tornamos essa linha visível independentemente do seu estado anterior.
							nLinhas++;																		// Como adicionamos uma linha adicionamos +1 à variável nLinhas.
						}
						else {																				// Caso o utilizador tenha escrito uma linha inválida ele mostra um aviso.
							System.out.println("Escolheu uma linha inválida.");
						}
						break;

					case "A" :
					case "a" :

						System.out.println("Qual a posição que deseja apagar?");							// Pedimos a posição a apagar ao utilizador.
						int apagarL = input.nextInt();														// Guardamos essa posição na variável apagarL.
						input.nextLine();
						if(apagarL > 0 && apagarL <= nLinhas) {												// Verificamos se a linha introduzida é válida.
							if(apagada[apagarL-1] == false) {												// Caso seja válida e esteja visível o valor troca para true, ou seja apagada.
								apagada[apagarL-1] = true;
								System.out.println("A linha escolhida foi apagada com sucesso!");
							}
							else {
								System.out.println("A " + apagarL + "ª linha já se encontra apagada.\n");	// Caso seja válida mas não esteja visível, o utilizador recebe uma mensagem que o avisa de que a linha já estava apagada.
							}
						}
						else {
							System.out.println("Linha inválida.\n");										// Caso a linha escolhida seja inválida, aparece uma mensagem que avisa o utilizador de que a linha escolhida é inválida.
						}
						break;

					case "l" :
					case "L" :
						System.out.println("Qual a linha que em que deseja começar a apagar? ");			// Pedimos a linha onde o utilizador quer começar e acabar de apagar, guardando respetivamente estes valores nas variáveis apagarInicio e apagarFim.
						int apagarInicio = input.nextInt();
						System.out.println("Qual a última linha que deseja apagar? ");
						int apagarFim = input.nextInt();
						input.nextLine();
						if(apagarInicio > 0 && apagarInicio < apagarFim && apagarFim <= nLinhas) {			// Este if verifica se as linhas têm valores válidos.
							System.out.println("As linhas foram apagadas com sucesso!");
							for(int i = 0; i <= apagarFim-apagarInicio; i++) {								// Este for percorre o intervalo (apagarFim-apagarInicio), ou seja percorre as linhas que o utilizador que apagar e altera os seus valores independentemente de como estejam para true no array apagada[].							
								apagada[apagarInicio-1+i] = true;											// Define true todas as linhas entre o intervalo (apagarFim-apagarInicio) no array apagada[].
							}
						}
						else {
							System.out.println("Limite de linhas inválido.\n");								// Caso os limites das linhas sejam inválidos avisa o utilizador de tal.
						}
						break;

					case "R" :
					case "r" :
						for(int i = 0; i < nLinhas; i++) {													// Este for mostra todas as linhas para o utilizador escolher a linha que vai recuperar.
							System.out.print("Linha Nº" + (i+1) + " - ");
							if (apagada[i] == false) {
								System.out.println(linhas[i]);
							}
							else {
								System.out.println(linhas[i] + "\t(apagada)");
							}

						}
						System.out.println("\nPretende recuperar qual das linhas?");
						int recuperarL = input.nextInt();													// Pedimos ao utilizador a posição da linha para recuperar.
						input.nextLine();
						if(recuperarL < 1 || recuperarL > nLinhas) {										// Verificamos se é uma linha válida e informamos o utilizador caso não seja.
							System.out.println("A linha introduzida foi inválida!");
						}
						else if(apagada[recuperarL-1] == true) {											// Sendo a linha válida, caso a linha esteja apagada, mudamos o seu estado para visível e mostramos uma mensagem ao utilizador de que isso aconteceu.
							System.out.println("A linha foi recuperada.");	
							apagada[recuperarL-1] = false;													// Torna a linha da posição pedida ao utilizador visível.
						}		
						else if(apagada[recuperarL-1] == false) {											// Sendo a linha válida, mas já estando visível, mostra ao utilizador uma mensagem que o informe.
							System.out.println("Escolheu uma linha visível.");
						}
						break;

					case "E" :
					case "e" :

						int linhasOcultas = 0;
						for(int i = 0; i < nLinhas; i++) {													// Este for percorre o array em busca de linhas ocultas.
							if(apagada[i] == true) {														// Comparação de cada linha ao valor true (oculto).
								linhasOcultas++;															// Caso a linha esteja oculta a variável linhasOcultas soma +1.
								if(i < nLinhas-1) {
									for(int l = i; l <= nLinhas; l++) {										// Este for percorre um array entre a linha i e a última linha do array ou seja entre i e nLinhas.
										linhas[(l)] = linhas[l+1];											// Guarda todas as linhas por baixo da linha oculta numa posição acima.
										apagada[(l)] = apagada[l+1];										// São guardados no array apagada[] os estados das linhas abaixo da linha oculta uma linha para cima.
									}
								}
								else {
									apagada[(i)] = false;
								}
								nLinhas--;																	// Reduz o número total de linhas porque retiramos uma por cada vez que i soma +1.
								i--;  																		// Serve para quando encontrarmos uma linha oculta, após fazerem-se as trocas de strings e booleans entre as linhas, para voltar a verificar se a linha que eliminou voltou a tomar o valor de oculta (se a linha que estava por baixo também era oculta).							
							}
						}
						if(linhasOcultas == 0) {															// No caso de ele não ter encontrado nenhuma linha oculta, é apresentado ao utilizador uma mensagem de que não aconteceu nenhuma alteração.
							System.out.println("Não existem linhas ocultas, logo não houve nenhuma alteração.\n");
						}
						else {
							System.out.println("As linhas ocultas foram eliminadas com sucesso!\n");		// No caso contrário do if anterior, este confirma ao utilizador que as linhas foram eliminadas com sucesso.
						}
						break;
					case "V":
					case "v":
						System.out.println();
						break;
					default:																				// No caso de o utilizador não introduzir um caracter inválido, avisa o utilizador disso.
						System.out.println("A opção introduzida é inválida!\n");
						break;
					}
				}
				while(!(userInput.equals("v") || userInput.equals("V")));
				break;																						// Este while faz com que apareça este menu sucessivamente até que o utilizador queira sair deste menu.

			case "F" :
			case "f" :
				do {
					menuFerramentas();
					

					opcaoFerramenta = input.nextLine();														// A opcaoFerramentas é a variável deste menu de modo a evitar que caso o utilizador escolha a opção "s" no menu editar, o switch do menu principal não entre dentro do case "s" do menu principal.
					switch(opcaoFerramenta) {

					case "M":
					case "m":													
						System.out.println("Qual é a palavra que procura?");
						palavra = input.nextLine();															// Pedimos ao utilizador a palavra que procuramos no texto.
						boolean frasePrintada = false;														// Variável que verifica se encontramos a palavra que procuramos.
						for(int i = 0; i < nLinhas; i++) {													// Percorre as linhas que foram inseridas uma a uma.
							String palavras[] = linhas[i].split(" ");										// Guarda cada palavra de uma linha num array chamado palavras[].
							for(int j = 0; j < palavras.length; j++) {										// Este for percorre o array palavras[], ou seja percorre todas as palavras da linha.
								if(palavras[j].equals(palavra)) {											// Compara as palavras de cada posição do array palavras[] com a variável palavra que o utilizador introduziu.
									System.out.println("Linha Nº" + (i+1) + " - " + linhas[i]);				// Printa a linha se a condição anterior acontecer (se encontrar a palavra que o utilizador pede na linha).
									frasePrintada = true; 													// Atribui o estado de true para sabermos que encontrou a palavra.
									break;																	// Só nos interessa printar a linha uma vez, sendo o número de vezes que aparece a palavra que procuramos na linha indiferente, por isso usamos um break.
								}
							}
						}
						if(frasePrintada == false) {														// No caso de não termos encontrado a palavra ou seja a variável frasePrintada ser false.
							System.out.println("A palavra \"" + palavra + "\" não existe no texto.");		// Mostramos ao utilizador uma mensagem de que a palavra não foi encontrada.
						}
						break;

					case "S" :
					case "s" :
						do {																				// Este do while certifica-se de que a linha onde vamos substituir a palavra é válida.
							System.out.println("Qual a linha em que deseja substituir a palavra?");
							numLinha = input.nextInt(); 
							input.nextLine();
							if(numLinha > nLinhas || numLinha <= 0) {													
								System.out.println("Numero de linha invalido.");							// No caso da linha ser inválida avisa o utilizador.			
							}
						}
						while(numLinha > nLinhas || numLinha <= 0);
						System.out.println("Qual é a palavra que procura?");
						String palavraProcurada = input.next();												// Guardamos a palavra que vamos procurar na linha.
						input.nextLine();

						String palavras[] = linhas[numLinha-1].split(" "); 									// Guardamos todas as palavras da linha numLinha num array chamado palavras[]. 
						for(int i = 0; i < palavras.length; i++) {											// Este for percorre o array palavras[] todo.
							if(palavras[i].equals(palavraProcurada)) {										// Compara as palavras do array com a palavraProcurada.
								encontrouPalavra = true;													// Variável que serve para verificar se chega a encontrar palavra.
								break;
							}
						}					
						if(encontrouPalavra == false) {														// Verifica se encontrou a variável ou não através da variável encontrouPalavra.
							System.out.println("Nenhuma palavra encontrada.");								// Como não encontrou a palavra escrevemos esta mensagem.
						}
						else {																				// No caso de encontrar a palavra.
							System.out.println("Qual é a palavra que substituirá?");
							String palavraSubstituta = input.next();										// Guardamos a palavra que vamos substituir na linha.
							input.nextLine();

							for(int i = 0; i < palavras.length; i++) {										// Este for percorre o array de palavras[].
								if(palavras[i].equals(palavraProcurada)) {									// Compara as palavras do array com a palavraProcurada.
									palavras[i] = palavraSubstituta;										// Substitui a palavra que procurámos pela substituta na posição posicaoP em que encontramos a palavra dentro deste array de palavras.
								}
							}
							
							linhas[numLinha-1] = "";														// Limpa a string que é a linha toda na posição numLinha.							
							for(int j = 0; j < palavras.length; j++) {										// Este for serve para adicionar uma a uma, todas as palavras do array palavras[] já "atualizado",à linha numLinha.			
								linhas[numLinha-1] += (palavras[j]);										// Adicionamos sequencialmente na linha numLinhas do array linhas[] as palavras do array palavras[].
								if(j < (palavras.length-1)) {												// Este if serve para adicionar um espaço entre cada palavra, por isso o uso do -1 na condição.
									linhas[numLinha-1] += " ";
								}
							}
							
							System.out.println("Linha Nº" + (numLinha) + " - " + linhas[numLinha-1]);		// Imprime o resultado da linha.

						}	
						break;

					case "L" :
					case "l" :
						int fraseVisivel = 0;																// Inicializamos a variável fraseVisivel que vai contar quantas linhas estão visíveis.
						for(int i = 0; i < nLinhas; i++) {													// Percorre as linhas inseridas.
							if(apagada[i] == false) {														// Verifica se a linha está visível.
								fraseVisivel++;																// Por cada linha visível ele soma +1 à variável fraseVisivel.
							}
						}
						System.out.println("O número de linhas visíveis é " + fraseVisivel + ".\n");		// Mostra quantas linhas estão visíveis.
						break;

					case "P" :
					case "p" :
						int contaPalavras = 0;																// Inicializa a variável que faz a soma de palavras de cada linha a zero.
						for(int i = 0; i < nLinhas; i++) {													// Este for percorre as linhas inseridas.
							palavras = linhas[i].split(" ");												// Guardamos todas as palavras de cada linha num array chamado palavras[].
							for(int j = 0; j < palavras.length; j++) {										// Este for percorre o array palavras[].
								if(palavras[j] != "") {														// Confirma se foi guardado texto no array palavras[].
									nPalavras[i]++;															// No caso dessa linha do array palavras[] ter texto soma +1 à mesma linha do array nPalavras[].
								}
							}
							contaPalavras += nPalavras[i];													// Somamos todas as linhas do array nPalavras na variável contaPalavras.
						}
						System.out.println("O número total de palavras é " + contaPalavras + "."); 			// Mostra quantas palavras.
						for(int i = 0; i < tamMax; i++) {													// Este for repõe todas as linhas do nosso array nPalavras[] a zero.
							nPalavras[i] = 0;
						}
						break;

					case "C" :
					case "c" :
						int contaChars = 0;																	// Inicializa a variável que faz a soma de caracteres de cada linha a zero.
						for(int i = 0; i < nLinhas; i++) {													// Este for percorre as linhas do array linhas[].
							for(int j = 0; j < linhas[i].length(); j++){									// Este for percorre todos os caracteres da linha i.
								if(linhas[i].charAt(j) != ' ') {  											// Este if verifica se os caracteres são diferentes de um espaço vazio.
									nChars[i]++;															// Por cada vez que a condição anterior seja verdade soma +1 ao array nChars.
								}
							}
							contaChars += nChars[i];														// Soma todas as linhas do array nChars para a variável contaChars.
						}
						System.out.println("O número total de caracteres é " + contaChars + ".");					
						for(int i = 0; i < tamMax; i++) {													// Este for repõe todas as linhas do nosso array nChars[] a zero.
							nChars[i] = 0;
						}
						break;
					case "V":
					case "v":
						System.out.println();
						break;
					default:																				// No caso de o utilizador não introduzir um caracter inválido, avisa o utilizador disso.
						System.out.println("A opção introduzida é inválida!\n");
						break;
					}
				}
				while(!(opcaoFerramenta.equals("v") || opcaoFerramenta.equals("V")));
				break;																						// Este while faz com que apareça este menu sucessivamente até que o utilizador queira sair deste menu.

			case "s":
			case "S":				
				break;

			default:																						// No caso de o utilizador não introduzir um caracter inválido, avisa o utilizador disso.
				System.out.println("A opção introduzida é inválida!\n");
			}
		} 
		while(!(userInput.equals("s") || userInput.equals("S")));											// Este while faz com que apareça este menu sucessivamente até que o utilizador queira sair deste menu.
		System.out.println("Saiu do programa.");
		input.close();
	}
}