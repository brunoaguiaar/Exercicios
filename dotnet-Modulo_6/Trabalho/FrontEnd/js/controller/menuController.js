angular.module('app').controller('HomepagesController', 
            function ($scope, $routeParams, $localStorage, $location, authService) {

    $scope.cadastrarCliente = cadastrarCliente;
    $scope.cadastrarLocacao = cadastrarLocacao;
    $scope.gerarRelatorio = gerarRelatorio;
    $scope.logout = authService.logout;
    $scope.colaborador = authService.possuiPermissao('Colaborador');
    $scope.gerente = authService.possuiPermissao('Gerente');
    
    function gerarRelatorio(){
        $location.path('/relatorio');
    };

    function cadastrarCliente(){
        $location.path('/cadastrarCliente');
    };

    function cadastrarLocacao(){
        $location.path('/cadastrarLocacao');
    };

});