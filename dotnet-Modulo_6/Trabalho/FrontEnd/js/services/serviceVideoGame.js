angular.module('app').factory('VideoGameService', function ($http) {
    
    var urlBase = 'http://localhost:64376/Api/VideoGame'

    function listarVideoGames() {
        return $http.get(urlBase);
    };

    return {
        listarVideoGames: listarVideoGames
    };

})