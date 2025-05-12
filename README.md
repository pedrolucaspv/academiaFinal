Padrões de projeto implementados

✅ 1. Strategy
Uso: Cálculo de IMC com diferentes estratégias.

Classes:

CalculoIMCStrategy (interface)

CalculoIMCPadrao (implementação concreta)

Local de uso: AvaliacaoFisica usa a estratégia para calcular o IMC.

✅ 2. Observer
Uso: Aluno é notificado quando uma nova avaliação física é registrada.

Classes:

Observador (interface)

Aluno (observador)

AvaliacaoFisica (sujeito)

Status: Já implementado no seu código, inclusive com notificar() e atualizar().

✅ 3. Decorator
Uso: Adição de informações de endereço à exibição dos dados do aluno.

Classes:

ExibirDadosDecorator (abstrato)

ExibirDadosComEndereco (concreto)

Interface comum: IExibirDados

✅ 4. Factory Method
Uso: Criação de planos de treino por meio de uma fábrica abstrata.

Classes:

PlanoTreinoFactory (abstrata)

PlanoMusculacaoFactory (implementação concreta)

Benefício: Flexibilidade para criar diferentes tipos de planos.

✅ 5. Singleton
Uso: Garantir que exista apenas uma instância de Academia.

Classe: Academia

Método: getInstancia() garante uma única instância.

