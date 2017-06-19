angular.module('app').factory('PacoteService', function ($http) {

    var urlBase = 'http://localhost:64376/Api/Pacotes'

    function listarPacotes() {
        return $http.get(urlBase);
    };

    return {
        listarPacotes: listarPacotes
    };

})