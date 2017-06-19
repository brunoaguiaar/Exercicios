angular.module('app').controller('RelatorioController', 
            function ($scope, $routeParams, $localStorage, $location, LocacoesService) {
    
    if ($location.$$path === '/relatorio'){
        usuarioNaoGerenteAcessaPagina();
    } else {
        listarLocacoesAtrasadas();
    }

    $scope.voltar = voltar;
    $scope.listarLocacoes = listarLocacoes;
    $scope.exibirRelatorio = false;

    function voltar(){
         $location.path('/menu');
    }

    function listarLocacoes(dataFiltro) {
        LocacoesService.listarLocacoes(dataFiltro)
            .then (response => {
                $scope.locacoes = response.data.dados;
                $scope.valorTotal = calculaTotalLocacoes($scope.locacoes);
                $scope.exibirRelatorio = true;
            });
    };

    function calculaTotalLocacoes(locacoes){
        var valorTotal = 0;
        for (var locaca of locacoes) {
            valorTotal += locacao.ValorRealLocacao;
        };
        return valorTotal;
    };

    function usuarioNaoGerenteAcessaPagina() {
    let usuarioLogado = JSON.parse(localStorage.getItem('ngStorage-usuarioLogado'));
    if (usuarioLogado.Permissoes[0].Nome != 'Gerente')
      $location.path('/menu')
  }

});