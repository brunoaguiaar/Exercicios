angular.module('app').controller('ClienteController', 
            function ($scope, $routeParams, $localStorage, ServiceClie, $location, toastr) {

    $scope.cadastrar = cadastrar;
    $scope.voltar = voltar;

    function cadastrar(cliente){

        if ($scope.addCliente.$valid) {
        cliente.Id = 0;
        ServiceClie.cadastrarCliente(cliente)
                    .then( function() {
                        toastr.success('Cliente incluído com sucesso!');
                        $location.path('/index'); 
                    });
        } else {
            toastr.warning('Dados inválidos!');
        }
    
};

    function voltar(){
         $location.path('/index');
    }

});