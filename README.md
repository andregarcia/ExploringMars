# ExploringMars
Repositório com implementação da solução do teste de programação da elo7  


### Como gerar o jar executável

Para gerar o .jar executavel:  

```sh

mvn clean compile assembly:single  
```

Este comando gera o .jar na pasta target, já incluindo as dependências no próprio jar (para facilitar a execução). 


### Como executar
Deve ser passado como único parâmetro o caminho do arquivo contendo as entradas 


```sh

java -jar PATH_TO_JAR PATH_TO_INPUT_FILE  
```


por exemplo, após gerar o jar e estando este na pasta target, e existindo o arquivo sample_input.txt na raiz do projeto, o jar pode ser executado da seguinte forma: 

```sh

java -jar .\exploringmars-0.0.1-SNAPSHOT-jar-with-dependencies.jar ..\sample_input.txt
```

(obs: para um ambiente linux, alterar as barras invertidas nos caminhos da linha acima)


### Nomenclaturas utilizadas no código

As nomenclaturas utilizadas no código são: 

Probe -> representa uma sonda  
Grid -> representa a malha a ser explorada  
Direction -> representa uma direção à qual as sondas podem apontar  
ProbeCommand -> representa um comando da sonda  

