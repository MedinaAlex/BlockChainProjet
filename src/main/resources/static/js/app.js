var myApp = angular.module('CHATBOT', ['Chat', 'ngResource']);
var my = '.'

// TODO page de recherche 
/** Configuration des routes de l'application*/
myApp.config(function ($routeProvider, $httpProvider) {

    // Ajout de l'intercepteur HTTP
    // $httpProvider.responseInterceptors.push('IntercepteurHTTP');

    /** Accueil */
    $routeProvider.when('/', {
        templateUrl: my + '/partials/chat.html',
        controller: 'afficherChat',
        pageKey: 'HOME'

    /** Sinon */
    }).otherwise({
        redirectTo: '/'
    });
});


/** Controller. */
myApp.controller('ChatCtrl', function ($route, $scope, $rootScope, $location) {

})