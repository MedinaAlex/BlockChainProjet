var vote = angular.module('vote', ['blockVote', 'ngResource']);

/* Controllers des bases*/
vote.controller('addBallot', function ($scope, $rootScope, $location, ballotFactory) {
    console.log("addBallot")
    $scope.ballot = ballotFactory.getEmpty({});

    console.log($scope.ballot)

})

/* Controllers des bases*/
vote.controller('addPollingPlace', function ($scope, $rootScope, $location, pollingPlaceFactory) {
  
    console.log("addPollingPlace")
    $scope.pollingPlace = pollingPlaceFactory.getEmpty({});

    console.log($scope.pollingPlace)
})

/* Factories */
vote.factory('pollingPlaceFactory', function ($resource) {
    return $resource('./rest/pollingplace/:methodeRest/:id', {
        methodeRest: '@methodeRest',
        id: '@id'
    }, {
        getConversation:
        {
            method: 'GET',
            params: { id: '@id'},
            isArray: true,
        },

        getEmpty:
        {
            method: 'GET',
            params: { methodeRest: "empty"}
        },
       
    })
})

vote.factory('ballotFactory', function ($resource) {
    return $resource('./rest/ballot/:methodeRest/:id', {
        methodeRest: '@methodeRest',
        id: '@id'
    }, {
        getUsers:
        {
            method: 'GET',
            params: {},
            isArray: true,
        },

        getEmpty:
        {
            method: 'GET',
            params: { methodeRest: "empty"}
        },
    })
})