angular.module('app').controller('CadastroLocacaoController', 
            function ($scope, $routeParams, $localStorage, LocacaoService, ServiceClie, 
                    VideoGameService, PacoteService, AcessorioService, $location, toastr) {

    $scope.cadastrar = cadastrar;
    $scope.buscarCliente = buscarCliente;
    $scope.voltar = voltar;
    $scope.exibirFormulario = false;
    $scope.mostrarValor = false;

    function voltar(){
         $location.path('/menu');
    }

    function cadastrar(locacao){
        locacao.Id = 0;
        locacao.Cliente = $scope.clienteBuscado;
        LocacaoService.cadastrarLocacao(locacao)
                    .then( function() {
                        toastr.success('Locação incluída');
                        $location.path('/menu'); 
                    });
    };

    function buscarCliente(cpf){
        ServiceClie.buscarPorCpf(cpf)
        .then( response =>  {
            $scope.clienteBuscado = response.data.dados;  
            if ($scope.clienteBuscado !== null) {
                    buscarVideoGames();
                    buscarPacotes();
                    buscarAcessorios();
                $scope.exibirFormulario = true;
            } else if(typeof cpf !== 'undefined'){
                toastr.warning('Cliente não localizado');
            };
        });
    };
    $scope.videoGames = [];
    function buscarVideoGames() {
        VideoGameService.listarProdutos()
            .then (response => {
                for (var videoGame of response.data.dados) {
                    if (videoGame.QtdEstoque !== 0){
                        $scope.videoGames.push(videoGame);
                    };
                };
            })        
    };

    function buscarPacotes() {
        PacotesService.listarPacotes()
            .then (response => {
                $scope.pacotes = response.data.dados;
            });        
    };

    $scope.acessorios = [];
    function buscarAcessorios() {
        AcessorioService.listarAcessorio()
            .then (response => {
                for (var acessorio of response.data.dados) {
                    if (acessorio.QtdEstoque !== 0){
                        $scope.acessorios.push(acessorio);
                    };
                };
            });        
    };
});