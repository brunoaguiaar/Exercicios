angular.module('app').factory('ServiceClie', function ($http) {

    var urlBase = 'http://localhost:64376/Api/Clientes'


  function listarClientes(headerAuth) {
    return $http({
      url: url,
      method: 'GET',
      headers: {
        Authorization: headerAuth
      }
    });
  }
  function cadastrarCliente (cliente, headerAuth) {
    return $http({
      url: url + '/registrar',
      method: 'POST',
      headers: {
        Authorization: headerAuth
      },
      data: cliente
    });
  }

  function buscarPorCpf(cpf, headerAuth) {
    return $http({
      url: url + '/cpf',
      method: 'GET',
      params: cpf,
      headers: {
        Authorization: headerAuth
      }
    });
  }

  return {
      listarClientes: listarClientes,
      buscarPorCpf: buscarPorCpf,
      cadastrarCliente: cadastrarCliente
  };

})