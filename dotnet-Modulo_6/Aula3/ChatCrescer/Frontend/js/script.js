var app = angular.module('App', ['ngRoute', 'toastr', 'ngStorage']);

app.config(function ($routeProvider) {
    
    $routeProvider
    .when('/chat', {
        controller: 'chatController',
        templateUrl: 'html/chat.html'
    })
    
    .when('/login', { 
        controller: 'UsuarioController', 
        templateUrl: 'html/login.html' 
    })
    .otherwise({redirectTo:'/login'});
});