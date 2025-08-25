# POO2_Trabalho_Pratico_2
# BeForward MZ - Sistema de Gestão de Vendas de Veículos

<div align="center">
  <img src="Imagens/progIcon.png" alt="BeForward MZ Logo" width="100"/>
  
  [![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://java.com)
  [![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)
  [![License](https://img.shields.io/badge/License-Academic-green?style=for-the-badge)](#)
</div>

## 📋 Sobre o Projeto

BeForward MZ é um sistema de gestão desenvolvido em Java Swing para a administração de vendas de veículos. O sistema oferece uma interface gráfica completa para gerenciar clientes, visualizar estatísticas de vendas, e gerar relatórios detalhados.

### 🏆 Equipe de Desenvolvimento

| Nome | Código de Estudante |
|------|---------------------|
| Vritik Valabdas | 20190025 |
| Vicente Macuacua | 20240208 |
| Yasin Magno | 20240260 |

## ✨ Funcionalidades Principais

### 🔐 Sistema de Autenticação
- Login seguro com validação de usuários
- Registro de novos usuários
- Recuperação de senha
- Gestão de perfis de utilizador

### 👥 Gestão de Clientes
- **Adicionar** novos clientes
- **Procurar** clientes existentes
- **Editar** informações de clientes
- **Remover** clientes do sistema

### 📊 Tipos de Cliente Suportados
1. **Cliente Normal** - Clientes particulares
2. **Cliente Doutorado** - Clientes com grau de doutoramento
3. **Cliente Estado** - Instituições governamentais
4. **Cliente Revendedor** - Empresas revendedoras

### 📈 Dashboard e Estatísticas
- Visualização de quantidade de clientes por tipo
- Cálculo de valores totais pagos à empresa
- Cálculo de direitos aduaneiros
- Análise de margem de lucro
- Gráficos interativos

### 📑 Sistema de Relatórios
- Tabela de todos os clientes
- Tabela de clientes por tipo
- Exportação para PDF
- Relatórios personalizados

### 🎨 Interface Personalizável
- Múltiplos temas visuais:
  - Tema Lilas Escuro (padrão)
  - Tema Vermelho Ford
  - Tema Azul SkyLine
  - Tema Lilaz Labo
- Menu contextual (right-click)
- Interface responsiva

### 🎵 Recursos Extra
- Reprodutor de vídeo integrado
- Player de música
- Manual do utilizador interativo com guia visual
- Calculadora integrada

### 📚 Sistema de Ajuda Integrado
- **Manual Visual Interativo** - Interface gráfica com explicações detalhadas
- **Guia Passo-a-Passo** - Orientações sobre cada funcionalidade
- **Suporte Técnico** - Contacto direto com a equipe
- **Interface Didática** - Explicações com imagens e descrições

## 🛠️ Tecnologias Utilizadas

- **Java SE** - Linguagem principal
- **Swing** - Interface gráfica
- **AWT** - Componentes gráficos
- **File I/O** - Manipulação de arquivos
- **Collections Framework** - Estruturas de dados

## 📁 Estrutura do Projeto

```
BeForward-MZ/
├── src/
│   ├── Login.java              # Tela de login
│   ├── Menu.java               # Menu principal
│   ├── Ajuda.java              # Sistema de ajuda visual
│   ├── Usuario.java            # Classe de usuário
│   ├── Cliente/                # Classes de tipos de cliente
│   │   ├── Normal.java
│   │   ├── Doutorado.java
│   │   ├── Estado.java
│   │   └── Revendedor.java
│   ├── GUI/                    # Interfaces gráficas
│   ├── Utils/                  # Classes utilitárias
│   └── Reports/                # Sistema de relatórios
├── Imagens/                    # Recursos visuais
│   ├── bara.png               # Imagens do manual
│   ├── Home.png
│   ├── Utilizador.png
│   ├── Registar.png
│   ├── Operacoes.png
│   ├── Relatorio.png
│   ├── Ajuda.png
│   ├── Extra.png
│   └── ...                    # Outras imagens
├── Dados.txt                   # Arquivo de dados
├── users.txt                   # Arquivo de usuários
└── README.md
```

## 🚀 Como Executar

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior
- IDE Java (NetBeans, Eclipse, IntelliJ IDEA)

### Instalação e Execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/beforward-mz.git
   cd beforward-mz
   ```

2. **Compile o projeto**
   ```bash
   javac *.java
   ```

3. **Execute a aplicação**
   ```bash
   java Login
   ```

### Arquivos de Dados

Certifique-se de que os seguintes arquivos estejam presentes:

- `users.txt` - Contém os dados dos usuários do sistema
- `Dados.txt` - Contém os dados dos clientes e vendas
- Pasta `Imagens/` - Contém os recursos visuais da aplicação

## 📖 Manual de Uso

### 1. Login no Sistema
- Execute a aplicação
- Selecione seu nome na lista suspensa
- Insira sua senha
- Clique em "Log In" para acessar o sistema

### 2. Carregar Dados
- No menu principal, vá para **Home → Ler Ficheiro de Texto**
- Os dados serão carregados automaticamente do arquivo `Dados.txt`

### 3. Gestão de Clientes
- Acesse **Registar** no menu principal
- Escolha a ação desejada (Adicionar, Procurar, Editar, Remover)

### 4. Visualizar Relatórios
- Vá para **Relatório** no menu
- Escolha entre tabelas ou exportação PDF

### 5. Dashboard
- Clique em **Dashboard** para visualizar estatísticas completas

### 6. Sistema de Ajuda
- Acesse **Ajuda → Manual de Utilizador** para o guia interativo
- O manual oferece explicações visuais de cada funcionalidade:
  - **Barra de Menu** - Navegação principal
  - **Item Home** - Funcionalidades básicas (ler ficheiro, dashboard)
  - **Item Utilizador** - Gestão de contas e logout
  - **Item Registar** - CRUD de clientes
  - **Item Relatório** - Tabelas e exportações
  - **Item Ajuda** - Suporte e documentação
  - **Item Extra** - Recursos adicionais

## 🎨 Personalizações

### Mudança de Tema
- Clique com o botão direito na tela principal
- Selecione "Tema" no menu contextual
- Escolha o tema desejado

### Recursos Extras
- Acesse vídeos e músicas através do menu contextual
- Utilize o **Manual Interativo** em **Ajuda → Manual de Utilizador**
- O manual oferece guia visual completo com:
  - Screenshots de cada funcionalidade
  - Explicações detalhadas de cada menu
  - Contacto para suporte técnico: **+258 86977652**

## 📊 Exemplo de Dados

O arquivo `Dados.txt` deve seguir o formato:
```
numeroTelefone;nomeCliente;dataCompra;estadoCompra;marca;modelo;codigo;cilindragem;preco;tipo;...
```

## 🔧 Configurações

### Estrutura de Usuários (users.txt)
```
nome;senha;telefone
Vicente Macuacua;123456;+258123456789
Vritik Valabdas;654321;+258987654321
```

## 🤝 Contribuições

Este é um projeto acadêmico. Para sugestões ou melhorias:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto foi desenvolvido para fins acadêmicos. Todos os direitos reservados aos autores mencionados.

## 💡 Funcionalidades Especiais

### 🎓 Sistema de Ajuda Avançado
A classe `Ajuda.java` implementa um manual interativo único que oferece:

- **Interface Visual Dividida**: 
  - Painel esquerdo com descrições detalhadas
  - Painel direito com imagens explicativas
- **Explicações Contextuais** de cada menu:
  - Home, Utilizador, Registar, Relatório, Ajuda, Extra
- **Design Responsivo** com fundo personalizado
- **Suporte Técnico Integrado** com contacto direto

### 🎯 Navegação Intuitiva
- Menu contextual (right-click) com acesso rápido
- Atalhos de teclado em todas as funcionalidades
- Interface com feedback visual em tempo real

## 📞 Suporte

## 📞 Suporte

Para suporte técnico ou dúvidas sobre o sistema:

- 📖 Consulte o **Manual Interativo** integrado no sistema
- 📱 **Contacto Técnico**: +258 86977652
- 💬 Entre em contato com a equipe de desenvolvimento
- 🔧 Suporte disponível para instalação e configuração

### Equipe de Suporte
- **Vicente Macuacua** - Desenvolvedor Principal
- **Vritik Valabdás** - Especialista em Interface
- **Yasin Magno** - Analista de Sistemas

---

<div align="center">
  
**BeForward MZ** - Sistema de Gestão de Vendas de Veículos
  
*Desenvolvido com ❤️ pela equipe BeForward*

</div>
