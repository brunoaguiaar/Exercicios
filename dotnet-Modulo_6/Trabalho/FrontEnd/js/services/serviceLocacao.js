angular.module('app').factory('LocacaoService', function ($http) {

    var urlBase = 'http://localhost:64376/api/locacao'

    function listarLocacoes() {
        return $http.get(urlBase);
    };

    function cadastrarLocacao(locacao) {
        return $http.post(urlBase, locacao);
    };

    function devolver(locacao){
        return $http.put(urlBase + '/' + locacao.Id, locacao);
    };

    return {
        listarLocacoes: listarLocacoes,
        devolver: devolver,
        cadastrarLocacao: cadastrarLocacao
    };

})