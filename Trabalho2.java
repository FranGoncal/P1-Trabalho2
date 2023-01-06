import java.util.Scanner;
public class Trabalho2 {
	/*
	 * Francisco Mateus Goncalves Nº20221849 Engenharia Informática	TP5
	 * Pedro Daniel Ribeiro Duarte Nº20221701 Engenharia Informática TP5
	 */

	static String usarScannerStringChar() {																	//Metodo que retorna uma string indroduzida pelo utilizador. 
		Scanner input = new Scanner(System.in);
		String userEscreveString=input.nextLine();
		return(userEscreveString);
	}

	static int pedeInteiro(int numero) {																	//Metodo que retorna um int indroduzido pelo utilizador. 
		Scanner input = new Scanner(System.in);
		boolean naoEInt = true;
		do{																									//Este do while confirma se o utilizador indroduz mesmo um numero, caso não o faça continua o ciclo.
			if(input.hasNextInt()) {																		//No caso do utilizador escrever um int.
				numero = input.nextInt();																	//Guarda o int na variável "numero".
				naoEInt = false;																			//Quando o utilizador introduzir um int esta variável será false, ou seja não a "não é int", ou seja é um int.

			}
			else {																							//No caso do utilizador não escrever um int.
				System.out.println("Escreva um número válido!");
				input.nextLine();	
			}
		}
		while(naoEInt == true);																				//O ciclo repete-se enquanto "não é int" for true. Quando o utilizador escrever um int e a variável nEInt ficar false, o ciclo acaba. 
		return (numero);
	}

	static int contaNLinhas(int nLinhas, int tamMax, String[] linhas) {										//Este metodo conta o numero de linhas que estão escritas, ou seja sempre que é necessário o número total de linhas escritas contamos quantas são, assim não temos de retornar nLinhas em outros metodos.
		nLinhas = 0;
		for (int i = 0;i < tamMax; i++) {																	//Este for percorre o array de linhas.
			if(linhas[i] != null) {																			//No caso de a linha não ser vazia.
				nLinhas++;																					//Adiciona +1 ao número de linhas
			}
		}
		return(nLinhas);
	}

	static String menuInicial() {																			// Mostra o menu inicial e retorna a opção escolhida.
		System.out.println("(I)nserir linhas no fim (termine com uma linha vazia)");					
		System.out.println("(L)istar linhas");
		System.out.println("(A)pagar última linha");
		System.out.println("(E)ditar");
		System.out.println("(F)erramentas");
		System.out.println("(S)air");
		String escolhaMenuI=usarScannerStringChar();														//Guarda a opção que o utilizador escrever numa String.
		return escolhaMenuI;																				//retorno da opção escolhida.
	}

	static String menuEditar() {																			// Mostra o menu editar e retorna a opção escolhida.
		System.out.println("\n(I)nserir linha na posição n");								
		System.out.println("(A)pagar linha na posição n");
		System.out.println("Apagar (l)inhas da posição n à posição m");
		System.out.println("(R)ecuperar linha");
		System.out.println("(E)liminar linhas apagadas");
		System.out.println("(V)oltar");	
		String escolhaMenuI=usarScannerStringChar();														//Guarda a opção que o utilizador escrever numa String.
		return escolhaMenuI;																				//retorno da opção escolhida.
	}

	static String menuFerramentas() {																		// Mostra o menu Ferramentas e retorna a opção escolhida.
		System.out.println("\n(M)ostrar linhas onde ocorre a palavra p.");						
		System.out.println("(S)ubstituir a palavra p na linha n.");
		System.out.println("Mostrar número de (l)inhas.");
		System.out.println("Mostrar número de (p)palavras.");
		System.out.println("Mostrar número de (c)aracteres.");
		System.out.println("\n(V)oltar.");
		String escolhaMenuI=usarScannerStringChar();														//Guarda a opção que o utilizador escrever numa String.
		return escolhaMenuI;																				//Retorno da opção escolhida.
	}

	static String[] inserirLinhaFim(int tamMax, String[] linhas, int nLinhas){								//Método que insere linhas escritas pelo utilizador até que este escreva uma linha vazia.

		String frase = " ";
		nLinhas = contaNLinhas( nLinhas, tamMax, linhas);													//Atualiza a variável nLinhas.
		if(nLinhas != tamMax) {																				//Verifica se foi atingido o tamMax, que é o limite de linhas, antes de podermos escrever linhas.
			System.out.println("Escreva várias linhas, para terminar insira um linha vazia.");
			while(frase != "" && (nLinhas <= 99)){															//Este while serve para inserir linhas enquanto o utilizador não der um enter vazio.
				frase = usarScannerStringChar();															//Armazena numa variável chamada frase cada linha escrita pelo utilizador. 

				if(frase != "") {																			//Este if verifica se a variável frase tem algo escrito.
					nLinhas++;																				//Por cada vez que este if é ativo dentro do while é somado +1 à variável nLinhas porque por cada vez que isto acontece também é inserida uma linha pelo utilizador e guardado no array linhas[].
					linhas[nLinhas-1] = frase;																//No caso da string frase conter texto este é guardado no array linhas[].
				}
			}
		}
		if(nLinhas == tamMax) {																				//Sempre que o utilizador chegar ou tiver 100 linhas já escritas este if mostra uma mensagem que ajuda o utilizador a entender o está a acontecer e o que pode fazer para solucionar o seu problema.
			System.out.println("Chegou ao limite de linhas, para escrever mais terá que apagar uma destas.\n");
		}

		return(linhas);																						//Retorna o array  linhas[].
	}

	static void listarLinhas(boolean[] apagada, String[] linhas, int nLinhas, int tamMax){					//Método que printa todas as linhas visiveis do array  linhas[]
		nLinhas = contaNLinhas( nLinhas, tamMax, linhas);														//Atualiza a variável nLinhas.
		for(int i = 0; i < nLinhas; i++) {																	//Este for percorre os arrays apagada[] e linhas[], usando o apagada[] para verificar se pode ou não mostrar o que está guardado no array linhas[].
			System.out.print("Linha Nº" + (i + 1) + " - ");													//Identifica a linha que será printada para uma mais fácil leitura. Usamos apenas um print porque não queremos passar de linha.
			if(apagada[i] == false) {																		//Verifica se o que ta escrito na linha i do array apagado[]	é falso ou seja, se a frase está visível.							
				System.out.println(linhas[i]);																//Este println escreve as linhas do array linhas[] consoante o seu estado visível ou não.
			}
			else{																							//No caso de a linha estar oculta fazemos um println para passar para a linha seguinte visto que a última coisa que apareceu na consola foi um print e não um println.
				System.out.println();
			}
		}
		System.out.println();																				//Este print serve apenas para dar um espaço entre o menu principal e o que mostra esta ferramenta.
	}

	static void apagarLinha(boolean[] apagada, int apagarL) {												//Este método serve para apagar uma linha numa posição "apagarL".
		if(apagada[apagarL-1] == false) {																	//Verifica se a última linha está visível.
			apagada[apagarL-1] = true;																		//Caso a linha esteja visível mudamos o valor desta variável para true no array apagada[].
			System.out.println("A linha foi apagada.\n");													//Mostra uma mensagem que confirma ao utilizador que a linha foi apagada.
		}
		else {
			System.out.println("A linha já se encontra apagada.");											//No caso da última linha já esta apagada ou seja com o valor true no array apagada[], mostramos só uma mensagem ao utilizador que diz isso mesmo.
		}
	}

	static void inserirLPosicaoN(int tamMax, String[] linhas, boolean[] apagada, int nLinhas) {				//Este método insere uma linha numa posição que o utilizador escolhe entre a primeira e última linha escrita.
		nLinhas = contaNLinhas(nLinhas, tamMax, linhas);													//Atualiza a variável nLinhas.
		if(nLinhas == tamMax) {																				//No caso de o número de linhas já ser igual ao tamMax, não permite que esta funcionalidade continue porque não é possível adicionar mais linhas.
			System.out.println("Chegou ao limite de linhas, para escrever mais terá que apagar uma destas.\n");	//Avisa o utilizador de que chegou ao limite de linhas e escreve uma solução ao seu problema.
		}

		else {
			System.out.println("Qual a posição em que deseja inserir uma linha?");							//Pede uma posição ao utilizador para inserir uma linha.
			int inserirL = 0;

			inserirL = pedeInteiro(inserirL);																//Guardamos o que o utilizador introduz na consola na variável inserirL, que simboliza o número da linha onde o utilizador quer introduzir a linha. 
			if(inserirL > 0 && inserirL <= nLinhas) {														//Este if faz uma validação do número da linha introduzida pelo utilizador.
				for(int i = 0; i <= nLinhas-inserirL; i++) {												//Este for percorre os arrays linhas[] e apagada[] desde a última linha até à linha que o utilizador escolheu, representando isso o intervalo (nLinhas-inserirL).									
					linhas[nLinhas-i] = linhas[nLinhas-1-i];												//Guardamos os valores por baixo da linha que vai ser introduzida do array linhas[] no espaço seguinte do mesmo array. 
					apagada[nLinhas-i] = apagada[nLinhas-1-i];												//Guardamos os valores por baixo da linha que vai ser introduzida do array apagada[] no espaço seguinte do mesmo array.
				}
				System.out.print("Escreva uma linha: \n");													//Pedimos o texto ao utilizador para ele por na linha.			
				linhas[inserirL-1] = usarScannerStringChar();												//E guardamos esse texto na posição correspondente no array linhas[] a inserirL.
				apagada[inserirL-1] = false;																//Tornamos essa linha visível independentemente do seu estado anterior.
			}
			else {																							//Caso o utilizador tenha escrito uma linha inválida ele mostra um aviso.
				System.out.println("Escolheu uma linha inválida.");
			}
		}

	}

	static void apagarLPosicaoN(boolean[] apagada, int tamMax, String[] linhas, int nLinhas) {				//Este método pede e verifica a linha que o utilizador quer apagar e utiliza o metodo apagarLinha para apagar a linha escolhida.
		System.out.println("Qual a posição que deseja apagar?");											//Pede a posição a apagar ao utilizador.
		int apagarL = 0;
		apagarL = pedeInteiro(apagarL);																		//Guarda o valor introduzido.
		nLinhas = contaNLinhas(nLinhas, tamMax, linhas);													//Atualiza a variável nLinhas.
		if(apagarL > 0 && apagarL <= nLinhas) {																//Verifica se a linha introduzida é válida.
			apagarLinha(apagada, apagarL);																	//Utiliza o método apagarLinha para a apagar.
		}
		else {
			System.out.println("Linha inválida.\n");														//Caso a linha escolhida seja inválida, aparece uma mensagem que avisa o utilizador de que a linha escolhida é inválida.
		}
	}

	static void apagarIntervaloLinhas(boolean[] apagada, int tamMax, String[] linhas, int nLinhas) {		//Método que apaga um intervalo de linhas.
		System.out.println("Qual a linha que em que deseja começar a apagar? ");							//Pedimos a linha onde o utilizador quer começar e acabar de apagar, guardando respetivamente estes valores nas variáveis apagarInicio e apagarFim.
		int apagarInicio = 0;
		apagarInicio = pedeInteiro(apagarInicio);
		System.out.println("Qual a última linha que deseja apagar? ");
		int apagarFim=0;
		apagarFim = pedeInteiro(apagarFim);
		nLinhas = contaNLinhas(nLinhas, tamMax, linhas);													//Atualiza a variável nLinhas.
		if(apagarInicio > 0 && apagarInicio < apagarFim && apagarFim <= nLinhas) {							//Este if verifica se as linhas têm valores válidos.
			System.out.println("As linhas foram apagadas com sucesso!");
			for(int i = 0; i <= apagarFim-apagarInicio; i++) {												//Este for percorre o intervalo (apagarFim-apagarInicio), ou seja percorre as linhas que o utilizador que apagar e altera os seus valores independentemente de como estejam para true no array apagada[].							
				apagada[apagarInicio-1+i] = true;															//Define true todas as linhas entre o intervalo (apagarFim-apagarInicio) no array apagada[].
			}
		}
		else {
			System.out.println("Limite de linhas inválido.\n");												//Caso os limites das linhas sejam inválidos avisa o utilizador de tal.
		}
	}

	static void recuperarLinha(boolean[] apagada, String[] linhas, int tamMax, int nLinhas) {				//Este metodo recupera uma linha escolhida pelo utilizador que estava apagada.
		nLinhas=contaNLinhas(nLinhas, tamMax, linhas);														//Atualiza a variável nLinhas.
		for(int i = 0; i < nLinhas; i++) {																	//Este for mostra todas as linhas para o utilizador escolher a linha que vai recuperar.
			System.out.print("Linha Nº" + (i+1) + " - ");
			if (apagada[i] == false) {
				System.out.println(linhas[i]);
			}
			else {
				System.out.println(linhas[i] + "\t(apagada)");
			}
		}
		System.out.println("\nPretende recuperar qual das linhas?");
		int recuperarL = 0;
		recuperarL = pedeInteiro(recuperarL);																//Pedimos ao utilizador a posição da linha para recuperar.
		if(recuperarL < 1 || recuperarL > nLinhas) {														//Verificamos se é uma linha válida e informamos o utilizador caso não seja.
			System.out.println("A linha introduzida foi inválida!");
		}
		else if(apagada[recuperarL-1] == true) {															//Sendo a linha válida, caso a linha esteja apagada, mudamos o seu estado para visível e mostramos uma mensagem ao utilizador de que isso aconteceu.
			System.out.println("A linha foi recuperada.");	
			apagada[recuperarL-1] = false;																	//Torna a linha da posição pedida ao utilizador visível.
		}		
		else if(apagada[recuperarL-1] == false) {															//Sendo a linha válida, mas já estando visível, mostra ao utilizador uma mensagem que o informe.
			System.out.println("Escolheu uma linha visível.");
		}
	}

	static void eliminarLinhasApagadas(boolean[] apagada, String[] linhas, int tamMax, int nLinhas) {		//Método que elimina definitivamente as linhas apagadas,
		int linhasOcultas = 0;
		nLinhas=contaNLinhas(nLinhas, tamMax, linhas);														//Atualiza a variável nLinhas.
		for(int i = 0; i < nLinhas; i++) {																	//Este for percorre o array em busca de linhas ocultas.
			if(apagada[i] == true) {																		//Comparação de cada linha ao valor true (oculto).
				linhasOcultas++;																			//Caso a linha esteja oculta a variável linhasOcultas soma +1.
				if(i < nLinhas) {
					for(int l = i; l <= nLinhas; l++) {														//Este for percorre um array entre a linha i e a última linha do array ou seja entre i e nLinhas.
						linhas[(l)] = linhas[l+1];															//Guarda todas as linhas por baixo da linha oculta numa posição acima.
						apagada[(l)] = apagada[l+1];														//São guardados no array apagada[] os estados das linhas abaixo da linha oculta uma linha para cima.
					}
				}

				linhas[nLinhas]=null;
				apagada[nLinhas]=false;
				nLinhas--;																					//Reduz o número total de linhas porque retiramos uma por cada vez que i soma +1.
				i--;  																						//Serve para quando encontrarmos uma linha oculta, após fazerem-se as trocas de strings e booleans entre as linhas, para voltar a verificar se a linha que eliminou voltou a tomar o valor de oculta (se a linha que estava por baixo também era oculta).							
			}
		}
		if(linhasOcultas == 0) {																			//No caso de ele não ter encontrado nenhuma linha oculta, é apresentado ao utilizador uma mensagem de que não aconteceu nenhuma alteração.
			System.out.println("Não existem linhas ocultas, logo não houve nenhuma alteração.\n");
		}
		else {
			System.out.println("As linhas ocultas foram eliminadas com sucesso!\n");						//No caso contrário do if anterior, este confirma ao utilizador que as linhas foram eliminadas com sucesso.
		}
	}

	static void mensagemPadrao() {																			//Método que mostra uma mensagem padrão no caso do utilizador introduzir incorretamente uma opção dentro de um menu.
		System.out.println("A opção introduzida é inválida!\n");
	}

	static void mostrarLinhasComPalavraP(String[] linhas, int tamMax, int nLinhas) {						//Método que mostra as linhas em que surge uma palavra introduzida pelo utilizador.		
		String palavra = "";
		System.out.println("Qual é a palavra que procura?");
		palavra = usarScannerStringChar();																	//Pedimos ao utilizador a palavra que procuramos no texto.
		boolean frasePrintada = false;																		//Variável que verifica se encontramos a palavra que procuramos.
		nLinhas=contaNLinhas(nLinhas, tamMax, linhas);														//Atualiza a variável nLinhas.
		for(int i = 0; i < nLinhas; i++) {																	//Percorre as linhas que foram inseridas uma a uma.
			String palavras[] = linhas[i].split(" ");														//Guarda cada palavra de uma linha num array chamado palavras[].
			for(int j = 0; j < palavras.length; j++) {														//Este for percorre o array palavras[], ou seja percorre todas as palavras da linha.
				if(palavras[j].equals(palavra)) {															//Compara as palavras de cada posição do array palavras[] com a variável palavra que o utilizador introduziu.
					System.out.println("Linha Nº" + (i+1) + " - " + linhas[i]);								//Printa a linha se a condição anterior acontecer (se encontrar a palavra que o utilizador pede na linha).
					frasePrintada = true; 																	//Atribui o estado de true para sabermos que encontrou a palavra.
					break;																					//Só nos interessa printar a linha uma vez, sendo o número de vezes que aparece a palavra que procuramos na linha indiferente, por isso usamos um break.
				}
			}
		}
		if(frasePrintada == false) {																		//No caso de não termos encontrado a palavra ou seja a variável frasePrintada ser false.
			System.out.println("A palavra \"" + palavra + "\" não existe no texto.");						//Mostramos ao utilizador uma mensagem de que a palavra não foi encontrada.
		}
	}

	static void susbstituirPalavraP(String[] linhas, int tamMax, int nLinhas) {								//Método que subsitui uma palavra escolhida pelo utilizador por outra escolhida pelo mesmo.
		int numLinha = 0;
		boolean encontrouPalavra = false;
		do {																								//Este do while certifica-se de que a linha onde vamos substituir a palavra é válida.
			System.out.println("Qual a linha em que deseja substituir a palavra?");
			numLinha = pedeInteiro(numLinha); 
			nLinhas=contaNLinhas(nLinhas, tamMax, linhas);													//Atualiza a variável nLinhas.
			if(numLinha > nLinhas || numLinha <= 0) {													
				System.out.println("Número de linha inválido.");											//No caso da linha ser inválida avisa o utilizador.			
			}
		}
		while(numLinha > nLinhas || numLinha <= 0);
		System.out.println("Qual é a palavra que procura?");
		String palavraProcurada = usarScannerStringChar();					 								//Guarda a palavra que vamos procurar na linha.

		String palavras[] = linhas[numLinha-1].split(" "); 													//Guarda todas as palavras da linha numLinha num array chamado palavras[]. 
		for(int j = 0; j < palavras.length; j++) {															//Este for percorre o array palavras[] todo.
			if(palavras[j].equals(palavraProcurada)) {														//Compara as palavras do array com a palavraProcurada.
				encontrouPalavra = true;																	//Variável que serve para verificar se chega a encontrar palavra.
				break;
			}
		}					
		if(encontrouPalavra == false) {																		//Verifica se encontrou a variável ou não através da variável encontrouPalavra.
			System.out.println("Nenhuma palavra encontrada.");												//Como não encontrou a palavra escrevemos esta mensagem.
		}
		else {																								//No caso de encontrar a palavra.
			System.out.println("Qual é a palavra que substituirá?");
			String palavraSubstituta = usarScannerStringChar();												//Guardamos a palavra que vamos substituir na linha.

			for(int i = 0; i < palavras.length; i++) {														//Este for percorre o array de palavras[].
				if(palavras[i].equals(palavraProcurada)) {													//Compara as palavras do array com a palavraProcurada.
					palavras[i] = palavraSubstituta;														//Substitui a palavra que procurámos pela substituta na posição posicaoP em que encontramos a palavra dentro deste array de palavras.
				}
			}

			linhas[numLinha-1] = "";																		//Limpa a string que é a linha toda na posição numLinha.							
			for(int j = 0; j < palavras.length; j++) {														//Este for serve para adicionar uma a uma, todas as palavras do array palavras[] já "atualizado",à linha numLinha.			
				linhas[numLinha-1] += (palavras[j]);														//Adicionamos sequencialmente na linha numLinhas do array linhas[] as palavras do array palavras[].
				if(j < (palavras.length-1)) {																//Este if serve para adicionar um espaço entre cada palavra, por isso o uso do -1 na condição.
					linhas[numLinha-1] += " ";
				}
			}
			System.out.println("Linha Nº" + (numLinha) + " - " + linhas[numLinha-1]);						//Imprime o resultado da linha.
		}	
	}

	static void contarLinhasVisiveis(boolean[] apagada, int tamMax, String[] linhas, int nLinhas) {			//Método que conta as linhas visiveis do array linhas[], usando o valor do array apagada[].
		int fraseVisivel = 0;																				//Inicializamos a variável fraseVisivel que vai contar quantas linhas estão visíveis.
		nLinhas=contaNLinhas(nLinhas, tamMax, linhas);														//Atualiza a variável nLinhas.
		for(int i = 0; i < nLinhas; i++) {																	//Percorre as linhas inseridas.
			if(apagada[i] == false) {																		//Verifica se a linha está visível.
				fraseVisivel++;																				//Por cada linha visível ele soma +1 à variável fraseVisivel.
			}
		}
		System.out.println("O número de linhas visíveis é " + fraseVisivel + ".\n");						//Mostra quantas linhas estão visíveis.
	}

	static void contarPalavras(String[] linhas,int tamMax,int[] nPalavras, int nLinhas) {					//Método que conta as palavras de todas as linhas inseridas.
		int contaPalavras = 0;																				//Inicializa a variável que faz a soma de palavras de cada linha a zero.
		nLinhas=contaNLinhas(nLinhas, tamMax, linhas);														//Atualiza a variável nLinhas.
		for(int i = 0; i < nLinhas; i++) {																	//Este for percorre as linhas inseridas.
			String[] palavras = linhas[i].split(" ");														//Guardamos todas as palavras de cada linha num array chamado palavras[].
			for(int j = 0; j < palavras.length; j++) {														//Este for percorre o array palavras[].
				if(palavras[j] != "") {																		//Confirma se foi guardado texto no array palavras[].
					nPalavras[i]++;																			//No caso dessa linha do array palavras[] ter texto soma +1 à mesma linha do array nPalavras[].
				}
			}
			contaPalavras += nPalavras[i];																	//Somamos todas as linhas do array nPalavras na variável contaPalavras.
		}
		System.out.println("O número total de palavras é " + contaPalavras + "."); 							//Mostra quantas palavras.
		for(int i = 0; i < tamMax; i++) {																	//Este for repõe todas as linhas do nosso array nPalavras[] a zero.
			nPalavras[i] = 0;
		}
	}

	static void contarCaracteres(String[] linhas, int[] nChars, int tamMax, int nLinhas) {					//Método que conta os caractéres existentes nas linhas introduzidas.
		int contaChars = 0;																					//Inicializa a variável que faz a soma de caracteres de cada linha a zero.
		nLinhas=contaNLinhas(nLinhas, tamMax, linhas);														//Atualiza a variável nLinhas.
		for(int i = 0; i < nLinhas; i++) {																	//Este for percorre as linhas do array linhas[].
			for(int j = 0; j < linhas[i].length(); j++){													//Este for percorre todos os caracteres da linha i.
				if(linhas[i].charAt(j) != ' ') {  															//Este if verifica se os caracteres são diferentes de um espaço vazio.
					nChars[i]++;																			//Por cada vez que a condição anterior seja verdade soma +1 ao array nChars.
				}
			}
			contaChars += nChars[i];																		//Soma todas as linhas do array nChars para a variável contaChars.
		}
		System.out.println("O número total de caracteres é " + contaChars + ".");					
		for(int i = 0; i < tamMax; i++) {																	//Este for repõe todas as linhas do nosso array nChars[] a zero.
			nChars[i] = 0;
		}
	}

	static void casosMenuEditar(String userInput, int tamMax, String[] linhas, boolean[] apagada, int nLinhas ) {//Este método faz a ligação entre o menu inicial e todas as opções do menu editar.
		do {
			userInput = menuEditar();

			switch(userInput) {

			case "I" :
			case "i" :
				inserirLPosicaoN(tamMax, linhas, apagada, nLinhas);												
				break;

			case "A" :
			case "a" :
				apagarLPosicaoN(apagada, tamMax, linhas, nLinhas);
				break;

			case "l" :
			case "L" :
				apagarIntervaloLinhas(apagada, tamMax, linhas, nLinhas);
				break;

			case "R" :
			case "r" :
				recuperarLinha(apagada, linhas, tamMax, nLinhas);
				break;

			case "E" :
			case "e" :
				eliminarLinhasApagadas(apagada, linhas, tamMax, nLinhas);
				break;

			case "V":
			case "v":
				System.out.println();
				break;

			default:																						//No caso de o utilizador não introduzir um caracter inválido, avisa o utilizador disso.
				mensagemPadrao();
				break;
			}
		}
		while(!(userInput.equals("v") || userInput.equals("V")));											//Do while que permanece no menu ferramentas enquanto o utilizador não escrever "v" ou "V";
	}

	static void casosMenuFerramentas(String userInput, String[] linhas, int tamMax, int nLinhas, boolean[] apagada, int[] nPalavras, int[] nChars) {//Este método faz a ligação entre o menu inicial e todas as opções do menu ferramentas.
		do { 
			userInput = menuFerramentas();

			switch(userInput) {

			case "M":
			case "m":	
				mostrarLinhasComPalavraP(linhas, tamMax, nLinhas);
				break;

			case "S" :
			case "s" :
				susbstituirPalavraP(linhas, tamMax, nLinhas);
				break;

			case "L" :
			case "l" :
				contarLinhasVisiveis(apagada, tamMax, linhas, nLinhas);
				break;

			case "P" :
			case "p" :
				contarPalavras(linhas, tamMax, nPalavras, nLinhas);
				break;

			case "C" :
			case "c" :
				contarCaracteres(linhas, nChars , tamMax, nLinhas);

				break;
			case "V":
			case "v":
				System.out.println();
				break;
			default:																						//No caso de o utilizador não introduzir um caracter inválido, avisa o utilizador disso.
				mensagemPadrao();
				break;
			}
		}
		while(!(userInput.equals("v") || userInput.equals("V")));											//Do while que permanece no menu ferramentas enquanto o utilizador não escrever "v" ou "V";
	}

	public static void main(String[] args) {
		int nLinhas=0;
		int tamMax = 100;
		String userInput;
		String[] linhas = new String[tamMax];
		int[] nPalavras = new int[tamMax];
		int[] nChars = new int[tamMax];
		boolean[] apagada = new boolean[tamMax];

		do {
			userInput =	menuInicial();

			switch(userInput) {
			case "I" :
			case "i" :
				inserirLinhaFim(tamMax, linhas, nLinhas);
				break;

			case "L" :
			case "l" :
				listarLinhas(apagada, linhas, nLinhas, tamMax);
				break;

			case "A" :
			case "a" :
				nLinhas=contaNLinhas(nLinhas, tamMax, linhas);
				apagarLinha(apagada, nLinhas);
				break;

			case "E" :
			case "e" :
				casosMenuEditar(userInput, tamMax, linhas, apagada, nLinhas );
				break;																					

			case "F" :
			case "f" :
				casosMenuFerramentas(userInput, linhas, tamMax, nLinhas, apagada, nPalavras, nChars);
				break;	

			case "s":
			case "S":		
				break;

			default:																						// No caso de o utilizador não introduzir um caracter inválido, avisa o utilizador disso.
				mensagemPadrao();
			}	
		} 
		while(!(userInput.equals("s") || userInput.equals("S")));											// Este while faz com que apareça este menu sucessivamente até que o utilizador queira sair deste menu.
		System.out.println("Saiu do programa.");
	}
}