var modulo = angular.module('aula02-2', []);

modulo.filter('mascada', function(){
  return function(nome){
    return nome.replace(/(nunes)/i, '$ $1 $');
  }
})

modulo.filter('nomeAula', function(){
  return function(aula){
    return aula.numero.toString().padStart(3, '0') +
    " - " + aula.nome.toUpperCase();
  }
})

modulo.controller('Exemplo2', function($scope,$filter) {

  let instrutores = [{
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  },
  {
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  }
];

var aulaDosInstrutores = [];
  for(instrutor of instrutores){
    for(aulas of instrutor.aula){
      let retorno = {numero:aulas.numero,nome:aulas.nome,instrutor:instrutor.nome}
        aulaDosInstrutores.push(retorno);
    }
  }

$scope.aulaDosInstrutores = aulaDosInstrutores;
$scope.instrutores = instrutores;

});
