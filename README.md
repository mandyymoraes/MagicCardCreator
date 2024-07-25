# Magic Card Creator 🎴

Projeto realizado para a disciplina de Programação Orientada a Objetos com objetivo de aplicar técnicas de implementação e modelagem de classes e seus atributos.

O projeto tem como objetivo ser uma aplicação interativa que permite que o usuário personalize uma carta voltada para o universo do jogo de cartas "Magic The Gathering" criado em 1993 e lançado
pela Wizards of the Coast.

## Dependências

[[Java](https://www.java.com/pt-BR/download/)]  versão 17.0.8.1.

[[JavaFX](https://gluonhq.com/products/javafx/)] 

[[Apache POI](https://archive.apache.org/dist/poi/release/bin/)]

[[LeonardoAI API](https://leonardo.ai/api/)]

[[Netbeans IDE](https://netbeans.apache.org/front/main/download/)]




## Sobre o Projeto

O projeto tem como objetivo ser uma aplicação interativa que permite a personalização de cartas dentro do universo do jogo Magic the Gathering, é permitido que o usuário escolha a 
categoria de carta a ser criada dentro das já pré-estabelecidas pelas regras do jogo (Craitura, Artefato, Instantânea e Feitiço) e complete os campos disponibilizados conforme a sua 
escolha e com a informação que desejar. 

Os campos comuns dentro das cartas são: Nome, Descrição, Descrição Imagem, Autor e Custo de Mana. Como as cartas são dividas conforme categorias certos campos são únicos de certos nichos, 
exemplificando, o campo "Ataque/Defesa" só é inserido no modal de criação da carta "Criatura" já que as outras classificações não compartilham desse campo nas cartas físicas. 

Após a inserção dos dados personalizados pelo usuário, se é feita uma requisição HTTP para a inteligência artificial LeonardoAI para que por meio dessa requisição via API,
um documento JSON com a descrição passada possa ser utilizado pela IA para a geraração de uma imagem única que será inserida no layout da carta para ser visualizada. 

Finalizada a requisição, é gerado um documento Word via a biblioteca Apache POI, onde a imagem da carta finalizada é inserida. Após a criação do documento, é realizado o download
desse arquivo no dispositivo do usuário para que a carta possa ser usada como recurso.


## Código

Primeiramente foram determinadas quais seriam as funcionalidades de cada método e as classes a serem modeladas e implementadas, já que havia uma restrição de serem criadas 8 classes com
2 atributos cada. Assim com o planejamento prévio o código poderia seguir posteriormente com fluídez e eficiência. 

Assim, a interface visual foi idealizada com o uso da ferramenta Figma e implementada posteriormente pelo uso do Scenebuilder, uma aplicativo que permite a construção mais 
rápida e prática de componentes, modais e janelas utilizando JavaFX. Por meio do Scebuilder os componentes criados já eram traduzidos para código na estrutura de pastas do projeto 
como documentos FXML. 

Definidos os layouts e janelas, o foco foi mudado para a implementação das classes e seus métodos. Cada classe foi criada em um arquivo separado dentro do pacote do projeto junto com seus
métodos respectivos para facilitar a organização, manutenção do código e possíveis adições de features. Já os métodos que possuiam funcionalidades mais práticas, como abertura de modais e 
registro de dados dentro das janelas, foram criados e mantidos dentro de um único arquivo. 

Após a implementação do projeto base, se foi voltada a atenção para a comunicação via protocolo HTTP com a API da inteligência artificial generativa (LeonardoAI). Por meio do HTTPClient
e a utilização de um JSON pré-formatado fornecido pela própria documentação da API foi estabelecida um método, que após o registro da descrição da imagem pelo usuário
ela seria transformada em uma string para facilitar a inserção em um campo especifíco dentro do JSON fornecido. 
Este JSON contém os campos necessários para que a comunicação com a IA seja estabelecida, e assim realizado o envio da proposta e geração da imagem em tempo de execução do programa. Após
o envio do prompt, se é esperado o retorno do status da API para que assim só seja inserida no layout de carta finalizada a imagem com status "COMPLETED", já que se o status estiver como 
"PENDING" ela não será renderizada na tela. Foi necessário realizar essa camada extra de verificação para que o resultado fosse retornado da maneira correta. 
O retorno da IA é um link gerado onde dentro dele está o ID de criação da imagem, então se é usado um expressão regular (regex) neste endereço para que a origem da imagem seja isolada, e 
ela possa ser colocada como um PNG dentro do layout final. 

Assim para a finalização do programa, se é criado um documento Word via Apache POI e tirado um print da tela, por meio de um método, para que a carta finalizada possa ser inserida
no documento e posteriomente ser feito automaticamente o download dele no dispositivo do usuário e a carta personalizada possa ser viabilizada. 

