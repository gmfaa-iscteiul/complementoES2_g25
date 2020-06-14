Requisito 1 -> Miguel Sequeira 83658

Requisito 2 -> Gonçalo Almeida 82983

Requisito 4 -> João Carvalho 82582

Requisito 5 -> Beatriz Katzenstein 82959

Requisito 6 -> Miguel Clemente 82159


#REQUISITO 1

FUNCIONALIDADES:
Foram implementados todos os pontos.

INSTRUÇÕES:
Entrar no link 192.168.99.100:8000 e fazer login como Administrador(user: administrador, pass: administrador), Member(user: member, pass: member) ou visitor(user: visitor, pass: visitor).

#REQUISITO 2

FUNCIONALIDADES: Todos os pontos foram corretamente implementados sem o contexto do Ponto 1, ou seja, no meu "Sample Page" do Wordpress foi acrescentado algum conteúdo HTML (podem ver a Sample Page nos dois links seguintes https://prnt.sc/szhs53 https://prnt.sc/szhsap) para puder de certa forma ter algum contexto para testar. Assim, podem ver o "Contact Us" com o meu email pessoal a simular o "forms and email available", e para os repositórios eu meti o link "June 2020", tudo para efeitos de teste e simulação. Caso fosse para completar com o Requisito 1, bastava substituir estas linhas de código por algo semelhante (dependendo do HTML). Ainda foi adicionado ao código algumas Thread.sleep para puder ver o que se está a passar com mais calma. No fim, meti um sleep um bocado maior (5 segundos) por isso não fechar janelas do browser, ele fecha sozinho!!! As métricas são contabilizadas num ficheiro HTML "record.html".

INSTRUÇÕES: Neste repositório GITHUB há uma pasta chamada "Requisito 2". Nesta pasta podem encontrar um ficheiro bat e um README.md onde pode se observar um link file.io isto porque o "jar" usado no projeto é de 50MB e o GITHUB não consegue guardar ficheiros tão grandes por isso, esta foi a forma mais razoável que encontrei de passar o ficheiro. Depois de fazer o download do "bat" e do "jar", deve editar o "bat" (com o notepad por exemplo) e alterar o caminho do "java.exe" e o caminho do "jar" para o caminho apropriado ao do respetivo cliente. A seguir é só abrir o Windows Scheduler e meter uma tarefa a repetir-se de 2 em 2h (se for para seguir o que diz o ponto B) onde vai executar o "bat". O programa é facilmente executado no Windows Scheduler pois o ficheiro "bat" corre "jar". Este "jar" foi criado a partir de uma classe main que a única coisa que faz é chamar o código que está no "JUnit Test Case". Caso queira mudar o site, era necessário entrar no eclipse e mudar o link que está presente na linha 100 mas atenção!!! se mudar o link e o site não estiver em ordem, ele vai enviar um email para o administrador para resolver os problemas (por favor mudar os emails usados nas linhas 153 até à 156 em caso de testes). 

ATENÇÃO: NUMERO 1 -> os ficheiros geckodriver.exe e chromedriver.exe estão mencionados no eclipse com o seguinte caminho: "C:/iscte/chromedriver.exe". Para evitar este erro deverá mudar os ficheiros do seu computador para este caminho ou abrir o eclipse e nas linhas 60 e 66 mudar o caminho. NUMERO 2 -> caso seja efetuado alguma alteração ao eclipse e queria criar-se um novo jar para puder efetuar a verificação de 2 em 2 horas (ponto B) é necessário correr ("Run as Java Application") a classe "complemento.java" e depois de acabada, no package explorer, clicar no Java Project com o botão direito, clicar em "Export", procurar por "Runnable JAR file", no "launch" selecionar aquilo que acabou de correr (provavelmente deve ser "complemento - Complemento2ES2", selecionar o local para onde quer exportar e "finish" (irá aparecer avisos para ignorar e coisas para aceitar).



#REQUISITO 4

FUNCIONALIDADES:


INSTRUÇÕES:


#REQUISITO 5

FUNCIONALIDADES:


INSTRUÇÕES:



#REQUISITO 6

FUNCIONALIDADES:


INSTRUÇÕES:






