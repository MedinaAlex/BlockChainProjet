var chat = angular.module('Chat', ['CHATBOT', 'ngResource']);

/* Controllers des bases*/
chat.controller('afficherChat', function ($scope, $rootScope, $location, messagesFactory, usersFactory) {

    $scope.users = usersFactory.getUsers({});

    $scope.timeConverter = function(UNIX_timestamp){
      var a = new Date(UNIX_timestamp);
      var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
      var year = a.getFullYear();
      var month = months[a.getMonth()];
      var date = a.getDate();
      var hour = a.getHours();
      var min = a.getMinutes();
      var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min ;
      return time;
    }

    $scope.changeUser = function(userId){
        $scope.messages = messagesFactory.getConversation({
            id: userId
        })
    }
})


/* Factories */
chat.factory('messagesFactory', function ($resource) {
    return $resource('./rest/messages/:methodeRest/:id', {
        methodeRest: '@methodeRest',
        id: '@id'
    }, {
        getConversation:
        {
            method: 'GET',
            params: { id: '@id'},
            isArray: true,
        },
       
    })
})

chat.factory('usersFactory', function ($resource) {
    return $resource('./rest/users/:methodeRest/:id', {
        methodeRest: '@methodeRest',
        id: '@id'
    }, {
        getUsers:
        {
            method: 'GET',
            params: {},
            isArray: true,
        },
       
    })
})