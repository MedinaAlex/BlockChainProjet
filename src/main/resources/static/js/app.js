var myApp = angular.module('blockVote', ['vote', 'ngResource']);
var my = '.'

/** Configuration des routes de l'application*/
myApp.config(function ($routeProvider, $httpProvider) {

    // Ajout de l'intercepteur HTTP
    // $httpProvider.responseInterceptors.push('IntercepteurHTTP');

    /** Accueil */
    $routeProvider.when('/', {
        templateUrl: my + '/partials/choixVote.html',
        controller: '',
        pageKey: 'HOME'

    }).when('/createBallot', {
        templateUrl: my + '/partials/addBallot.html',
        controller: 'addBallot',
        pageKey: 'HOME'

    }).when('/createPollingPlace', {
        templateUrl: my + '/partials/addPollingPlace.html',
        controller: 'addPollingPlace',
        pageKey: 'HOME'

    /** Sinon */
    }).otherwise({
        redirectTo: '/'
    });
});


/** Controller. */
myApp.controller('VoteCtrl', function ($route, $scope, $rootScope, $location) {
})