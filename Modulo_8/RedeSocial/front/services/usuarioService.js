angular.module('app').factory('UsuarioService', function ($http) {
    
    var urlBase = 'http://localhost:9090/usuario';

    function listarUsuarios() {
        return $http.get(urlBase);
    };

    function cadastrarUsuario(usuario) {
        return $http.post(urlBase, usuario);
    };

    function buscarPorNome(texto) {
        return $http.get(urlBase + "/nome/" + texto);
    };

    function buscarUsuarioPorId(id) {
        return $http.get(urlBase + "/" + id);
    };

    function buscarAmigos() {
        return $http.get(urlBase + "/amigos");
    };

    function buscarUsuarioPorEmail(email) {
        return $http.get(urlBase + "/email/" + email);
    };

    function editarUsuario(usuario) {
        return $http.put(urlBase + "/editar" + usuario);
    };

    function buscarUsuarioLogado() {
        return $http.get(urlBase + "/userLogado");
    };

    return {
        buscarUsuarioLogado: buscarUsuarioLogado,
        editarUsuario: editarUsuario,
        buscarUsuarioPorEmail: buscarUsuarioPorEmail,
        buscarAmigos: buscarAmigos,
        buscarUsuarioPorId: buscarUsuarioPorId,
        buscarPorNomeOuEmail: buscarPorNomeOuEmail,
        listarUsuarios: listarUsuarios,
        cadastrarUsuario: cadastrarUsuario
    };

})