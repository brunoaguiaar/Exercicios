angular.module('app').factory('ServiceClie', function ($http) {
    var urlBase = 'http://localhost:64376/Api/Clientes'

    function listarClientes() {
        return $http.get(urlBase);
    };


    function buscarPorCpf(cpf) {
        return $http.get(urlBase + "/" + cpf);
    };

    function cadastrarCliente(cliente) {
        return $http.post(urlBase, cliente);
    };

    return {
        listarClientes: listarClientes,
        buscarPorCpf: buscarPorCpf,
        cadastrarCliente: cadastrarCliente
    };

})