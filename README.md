Requisito 1 -> Miguel Sequeira 83658

Requisito 2 -> Gonçalo Almeida 82983

Requisito 4 -> João Carvalho 82582

Requisito 5 -> Beatriz Katzenstein 82959

Requisito 6 -> Miguel Clemente 82159


#REQUISITO 1

FUNCIONALIDADES:
Foram implementados todos os pontos.

INSTRUÇÕES:

.Instalar o docker
.Correr o docker
.Colar os ficheiros "docker-compose.yml" ,"Dockerfile" ,"mysql.rar" e "wordpress-with-java" na pasta pretendida
.Escrever "cd (caminho até à pasta pretendida)"
.Escrever "docker build -t wordpress-with-java:5.4.1 ."
.Escrever "docker-compose up -d"
.Escrever "docker load < wordpress-with-java"
.Escrever "docker load < mysql"


Entrar no link 192.168.99.100:8000 e fazer login como Administrador(user: administrador, pass: administrador), Member(user: member, pass: member) ou visitor(user: visitor, pass: visitor).

#REQUISITO 2

FUNCIONALIDADES: Todos os pontos foram corretamente implementados sem o contexto do Ponto 1, ou seja, no meu "Sample Page" do Wordpress foi acrescentado algum conteúdo HTML (podem ver a Sample Page nos dois links seguintes https://prnt.sc/szhs53 https://prnt.sc/szhsap) para poder de certa forma ter algum contexto para testar. Assim, podem ver o "Contact Us" com o meu email pessoal a simular o "forms and email available", e para os repositórios eu meti o link "June 2020", tudo para efeitos de teste e simulação. Caso fosse para completar com o Requisito 1, bastava substituir estas linhas de código por algo semelhante (dependendo do HTML). Ainda foi adicionado ao código algumas Thread.sleep para puder ver o que se está a passar com mais calma. No fim, meti um sleep um bocado maior (5 segundos) por isso não fechar janelas do browser, ele fecha sozinho!!! As métricas são contabilizadas num ficheiro HTML "record.html".

INSTRUÇÕES: Neste repositório GITHUB há uma pasta chamada "Requisito 2". Nesta pasta podem encontrar um ficheiro bat e um README.md onde pode se observar um link da minha drive do Google isto porque o "jar" usado no projeto é de 50MB e o GITHUB não consegue guardar ficheiros tão grandes por isso, esta foi a forma mais razoável que encontrei de passar o ficheiro. Depois de fazer o download do "bat" e do "jar", deve editar o "bat" (com o notepad por exemplo) e alterar o caminho do "java.exe" e o caminho do "jar" para o caminho apropriado ao do respetivo cliente. A seguir é só abrir o Windows Scheduler e meter uma tarefa a repetir-se de 2 em 2h (se for para seguir o que diz o ponto B) onde vai executar o "bat". O programa é facilmente executado no Windows Scheduler pois o ficheiro "bat" corre "jar". Este "jar" foi criado a partir de uma classe main que a única coisa que faz é chamar o código que está no "JUnit Test Case". Caso queira mudar o site, era necessário entrar no eclipse e mudar o link que está presente na linha 100 mas atenção!!! se mudar o link e o site não estiver em ordem, ele vai enviar um email para o administrador para resolver os problemas (por favor mudar os emails usados nas linhas 153 até à 156 em caso de testes). 

ATENÇÃO: NUMERO 1 -> os ficheiros geckodriver.exe e chromedriver.exe estão mencionados no eclipse com o seguinte caminho: "C:/iscte/chromedriver.exe". Para evitar este erro deverá mudar os ficheiros do seu computador para este caminho ou abrir o eclipse e nas linhas 60 e 66 mudar o caminho. NUMERO 2 -> caso seja efetuado alguma alteração ao eclipse e queria criar-se um novo jar para puder efetuar a verificação de 2 em 2 horas (ponto B) é necessário correr ("Run as Java Application") a classe "complemento.java" e depois de acabada, no package explorer, clicar no Java Project com o botão direito, clicar em "Export", procurar por "Runnable JAR file", no "launch" selecionar aquilo que acabou de correr (provavelmente deve ser "complemento - Complemento2ES2", selecionar o local para onde quer exportar e "finish" (irá aparecer avisos para ignorar e coisas para aceitar).



REQUISITO 4
FUNCIONALIDADES: Site wordpres a funcionar com docker e aplicação funciona como pertendido, mostrando todas as tags e suas informações e uma hyperligação ao site pretendido pelo professor. Único requisito que não está funcional é correr o ficheiro executável do projeto recorrendo ao wordpress, isto é, se se correr o ficheiro bash “à mão”, funciona como pretendido, abrindo uma página html, mas se se correr o mesmo ficheiro bash pelo wordpress não funciona aparecendo o erro “error 500 - Internal Error”. Resumindo, o wordpress não consegue correr esse ficheio bash em especifico mas no site está um botão “Teste” que corre um ficheiro bash simple e funciona. Não conseguindo resolver este problema mas tendo as duas funcionalidades a funcionar, adicionamos as 2 em separado.

INSTRUÇÕES: criar uma pasta e guardar dentro dessa pasta o ficheiro com a imagem pretendida a executar. Essa pasta será onde estará guardado o container com as informações todas dos jars, ficherios bash e toda a informação sobre o site e utilizadores. 
Criar container com a imagem recebida e executar. A aplicação wrodpress será acedida pelo brower escrevendo: “192.168.99.100:80”, sendo estão o valor 80 o numero do port para aceder ao site wordpress.
As credenciais para ter acesso ao site são:  
-nome: jrcos                                 -senha: es2complemento
Na página principal, encontram-se 3 botões. O botão “Complemento 4” (não funciona) corre o ficheiro bash que iria correr o jar (explicado anteriormente). O botão “Complemento 5” é exatamente igual ao botão 4 mas, em vez de correr o ficheiro bash correspondente ao complemento 4, corre o ficheiro bash do complemento 5 (Projeto da Beatriz Katzenstein). 
O botão “teste serve só de exemplo de como a ligação wordpress-java funciona, apresentando uma página html exemplo.
Para poder correr os ficheiros bash e ver as páginas html pretendidas de cada complemento, terá de executar os ficheiros à mão (enconram-se na pasta cgi-bin dentro da pasta onde está contido o container docker.



#REQUISITO 5

FUNCIONALIDADES:Site WP a funcionar com docker(juntamente com o requisito4) e aplicação. As funcionalidades não foram todas implementadas, relativamente à alinea b). Foram criados botões para cada informação que o cliente pretenda visualizar. Os botões criados foram de visualização do número de testes, internamentos e infeções de cada região, da soma dos internamentos do algarve com o alentejo e da soma total de internamentos. Relativamente aos testes unitários também não foram realizados. Como o WP não consegue correr o ficheiro bash pretendido foi adicionado um botão "Teste" para comprovar que o WP consegue correr ficheiros bash, apesar de não conseguir correr os nossos.

INSTRUÇÕES: Para correr a aplicação o cliente deve criar uma pasta e guardar o ficheiro com a imagem que pretende executar, nessa pasta está o container com os bash e jars. Ligar o docker para criar um container com a imagem que se pretende executar. Aceder ao WP com o link 192.168.99.100:80, autenticar o acesso ao site(nome:jrcos,senha es2complemento), como não conseguimos meter os botões a redirecionar para a página do complemento temos de correr o ficheiro bash cgi-java-bea.sh que se encontra na pasta C:\Utilizador\Utilizadores\docker\cgi-bin

NOTA:Ocorreu um problema que não permitiu utilizar o docker do meu computador, tentei ainda em dois outros computadores que tinha ca em casa, um Windows e um mac, mas sem sucesso, deste modo utilizei o docker do meu colega João.



#REQUISITO 6

FUNCIONALIDADES: O Site Wordpress está a funcionar com o docker, e a aplicação para mostrar os dois ficheiros com o highlight da diferença, está a funcionar parcialmente, isto é, apenas mostra um ficheiro RDF e numa caixa de texto, pois não consegui por o conteúdo a parecer diretamente na página como devia ser. Para correr o script, carregando no botão do complemento 6, dá erro, tem que se correr o jar diretamente na linha de comandos ou correr o script executável desse jar para fazer efeito e mostrar o conteúdo html pretendido na página. Experimentei correr o script diretamente no site do WordPress de outra aplicação de teste e funcionou bem, mas com a aplicação que é suposta, dá erro do tipo “Internal Server Error”. 


INSTRUÇÕES:Criar uma pasta e guardar dentro dessa pasta o ficheiro com a imagem pretendida a executar. Essa pasta é onde está guardado o container com a informação dos jars no cgi-bin, os scripts para executar os jars e outra informação relevante para o site, como credenciais do site e de utilizadores. Criar o container com a imagem recebida e de seguida executá-la. A aplicação do Wordpress pode ser acedida através do browser escrevendo 192.168.99.100:80. 
Nome: mmfce
Password: c!%dkbUOIPOajycIc2







