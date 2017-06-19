angular.module('app').factory('AcessorioService', function ($http) {
    
    var urlBase = 'http://localhost:64376/Api/Acessorios'

    function listarAcessorios() {
        return $http.get(urlBase);
    };

    return {
        listarAcessorios: listarAcessorios
    };

})