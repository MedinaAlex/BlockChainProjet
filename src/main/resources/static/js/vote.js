/** Angular module */
var vote = angular.module('vote', ['blockVote', 'ngResource']);

/** ballot Controller*/
vote.controller('addBallot', function ($scope, $rootScope, $location, ballotFactory) {

    /** add a datepicker */
    $("#datepicker").datepicker();

    /** Function to save a ballot */
    $scope.saveBallot = function(){
        var m_candidates = document.getElementById("candidates").value
        m_candidates = m_candidates.split(", ")
        var m_infos = document.getElementById("infos").value
        var m_check = ""

        if(document.getElementById("presidentielle").checked){
            m_check = "PRESIDENTIELLE"
        }else {
            m_check = "MUNICIPALE"
        }

        var m_date = $( "#datepicker" ).datepicker( "getDate" );
        m_date.setMinutes(m_date.getMinutes() - m_date.getTimezoneOffset());

        ballotFactory.addBallot({
            infos: m_infos,
            type: m_check,
            candidates: m_candidates,
            date: m_date
        }, function(){
            console.log("success")
        })
    }

})

/* Polling Place Controller*/
vote.controller('addPollingPlace', function ($scope, $rootScope, $location, pollingPlaceFactory) {

    /** Function to save a polling place */
    $scope.savePollingPlace = function(){
        var m_department = document.getElementById("department").value
        var m_city = document.getElementById("city").value
        var m_numberPolling = document.getElementById("numberPolling").value

        pollingPlaceFactory.addPollingPlace({
            department: m_department,
            city: m_city,
            pollingPlaceNumber: m_numberPolling
        }, function(){
            console.log("success")
        })
    }
})

/* polling place Factory */
vote.factory('pollingPlaceFactory', function ($resource) {
    return $resource('./rest/pollingplace/:methodeRest/:id', {
        methodeRest: '@methodeRest',
        id: '@id'
    }, {
        getList:
        {
            method: 'GET',
            params: {},
            isArray: true,
        },

        addPollingPlace:
        {
            method: 'POST',
            params: { pollingPlace: {"city": '@city', "department": '@department', "pollingPlaceNumber": '@pollingPlaceNumber' }}
        },
       
    })
})

/* ballot factory */
vote.factory('ballotFactory', function ($resource) {
    return $resource('./rest/ballot/:methodeRest/:id', {
        methodeRest: '@methodeRest',
        id: '@id'
    }, {
        getList:
        {
            method: 'GET',
            params: {},
            isArray: true,
        },

        addBallot:
        {
            method: 'POST',
            params: { ballot: {"infos": '@m_infos', "type": '@m_type', "candidates": '@m_candidates', "date":'@date' }}
        },
    })
})