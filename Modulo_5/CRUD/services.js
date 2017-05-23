modulo.factory('aulaService', function () {

  let aulas = [
    { id: 0, nome: 'OO' },
    { id: 1, nome: 'HTML e CSS' }
  ];

  function getTodasAsAulas(params) {
    return aulas;
  };

  return {
    list: getTodasAsAulas
  }

});
