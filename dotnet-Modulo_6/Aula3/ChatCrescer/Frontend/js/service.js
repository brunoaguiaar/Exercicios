app.factory('mensagemService', function ($http) {

    let urlBase = 'http://localhost:58139/api/mensagem';

    function getMensagens(){
        return $http.get(urlBase);
    }

    function incluirMensagem(){
        return $http.post(urlBase, mensagem);
    }

    return{
        listarMensagens: getMensagens,
        criarMensagens: incluirMensagem
    }
});