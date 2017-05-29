app.factory('mensagemUsuario', function ($http) {

    let urlBase = 'http://localhost:58139/api/usuario';

    function getUsuario() {
        return $http.get(urlBase);
    };

    function enviarUsuario() {
        return $http.post(urlBase, usuario);
    };

    return {
        listarUsuarios: getUsuario,
        criarUsuario: enviarUsuario,
    }

});