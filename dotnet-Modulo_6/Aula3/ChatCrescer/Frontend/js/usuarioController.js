app.controller('UsuarioController', function ($scope, $routeParams, serviceMensagem, $localStorage, toastr){

    $scope.addUsuario = function (usuario){
        UsuarioService.criarUsuario(usuario).then(function (response){
            toastr.info("Login efetuado com sucesso!");
            localStorage.setItem('nome', usuario.Nome,toString());
            localStorage.setItem('foto', usuario.UrlFoto,toString());
            location.href = '#!/chat';
            toastr.success("Você entrou no Chat Creser");
            listarUsuarios();
        });
    }
});