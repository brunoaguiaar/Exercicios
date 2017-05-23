var modulo = angular.module('crud', ['ngRoute']);

modulo.config(function ($routeProvider) {

  $routeProvider
    .when('/pagina1', {
      controller: 'Pagina1Controller',
      templateUrl: 'pagina1.html'
    })
    .when('/pagina2', {
      controller: 'Pagina2Controller',
      templateUrl: 'pagina2.html'
    })
    .otherwise({
      redirectTo: '/pagina1'
    });
});

modulo.controller('Pagina1Controller', function ($scope) {
  $scope.controller = 'Pagina1Controller';
});

modulo.controller('Pagina2Controller', function ($scope) {
  $scope.controller = 'Pagina2Controller';
});

function create(aula) {
  aulaService.create(aula);
};

function findById(id) {
  aulaService.findById(id).then(function (response) {
    $scope.aula = response.data;
  });
};

function list() {
  aulaService.list().then(function (response) {
    $scope.aulas = response.data;
  });
}

function update(aula) {
  aulaService.update(aula).then(function () {
    list();
  });
};
