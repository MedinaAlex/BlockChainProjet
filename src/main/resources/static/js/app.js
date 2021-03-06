
/** App module */
var myApp = angular.module('blockVote', ['vote', 'ngResource']);
var my = '.'

/** route configuration */
myApp.config(function ($routeProvider, $httpProvider) {

    /** Home */
    $routeProvider.when('/', {
        templateUrl: my + '/partials/home.html',
        controller: '',
        pageKey: 'HOME'

    }).when('/admin', {
        templateUrl: my + '/partials/admin.html',
        controller: '',
        pageKey: 'HOME'

    })
    .when('/vote', {
        templateUrl: my + '/partials/vote.html',
        controller: 'voteCTRL',
        pageKey: 'HOME'

    }).when('/createBallot', {
        templateUrl: my + '/partials/addBallot.html',
        controller: 'addBallot',
        pageKey: 'HOME'

    }).when('/createPollingPlace', {
        templateUrl: my + '/partials/addPollingPlace.html',
        controller: 'addPollingPlace',
        pageKey: 'HOME'

    }).otherwise({
        redirectTo: '/'
    });
});


/** Controller. */
myApp.controller('VoteCtrl', function ($route, $scope, $rootScope, $location) {
})