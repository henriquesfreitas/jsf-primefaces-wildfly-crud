# Exemplo de CRUD utilizando as tecnologias abaixo:
- Java 14.0.2
- Wildfly 19.1.0
- JSF 2.3
- Primefaces 8.0
- EJB
- Hibernate
- Postgres 12.3

## Configuração:

### Configuração o standalone:
- standalone: https://github.com/henriquesfreitas/jsf-primefaces-wildfly-crud/blob/master/standalone.xml.

### Instalando Postgres no Wildfly:
- Copiar pasta postgres (https://github.com/henriquesfreitas/jsf-primefaces-ejb-wildfly-financeiro/tree/master/postgresql) para dentro do repositório: wildfly-19.1.0.Final\modules\system\layers\base\org
- Opcional: Baixar uma versão mais recente do jdbc do postgres: https://jdbc.postgresql.org/download.html, substituir pelo jar dentro da pasta main, depois editar o module.xml com a nova versão do arquivo.

- Subir o docker do Postgres, arquivo: https://github.com/henriquesfreitas/jsf-primefaces-wildfly-crud/blob/master/docker-compose.yaml
