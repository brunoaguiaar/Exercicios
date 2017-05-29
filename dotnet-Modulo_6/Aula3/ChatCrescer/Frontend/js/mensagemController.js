app.controller('chatController', function ($scope, $routeParams, serviceMensagem, $localStorage, toastr) {
    
    
    if(localStorage.getItem("nome") === null && localStorage.getItem("foto") === null) logout();

        $scope.logout = logout;

        function logout() {
            localStorage.clear();
            location.href = '#!/login';
            toastr.error("Informações invalidas ou usuario nao cadastrado!");
        }

    function todasMensagens() {
    mensagemService.listarMensagens().then(function (response) {
        $scope.mensagens = response.data;
        setTimeout (todasMensagens, 1000);
        setTimeout (setarScrollParaBaixo, 100);
      });
    }

    todasMensagens();
    setTimeout (setarScrollParaBaixoIncial,1000);

    $scope.usuario = {nome:localStorage.getItem('nome'), UrlFoto:localStorage.getItem('foto')};


    $scope.enviarMensagem = function () {
    if ($scope.input == "") { return; }
    let mensagem = {
      texto:$scope.input,
      Usuario : user
    }
    ervice.create(mensagem);
    $scope.input = "";
    delete $scope.mensagem;
  }
});