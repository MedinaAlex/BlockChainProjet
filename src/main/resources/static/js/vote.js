var vote = angular.module('vote', ['blockVote', 'ngResource']);

/* Controllers des bases*/
vote.controller('addBallot', function ($scope, $rootScope, $location, ballotFactory) {
    console.log("addBallot")
    $scope.ballot = ballotFactory.getEmpty({});

    $("#datepicker").datepicker();


    console.log($scope.ballot)

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

        console.log(m_candidates)
        console.log(m_infos)
        console.log(m_check)
        console.log(m_date)

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

/* Controllers des bases*/
vote.controller('addPollingPlace', function ($scope, $rootScope, $location, pollingPlaceFactory) {
  
    console.log("addPollingPlace")
    $scope.pollingPlace = pollingPlaceFactory.getEmpty({});

    console.log($scope.pollingPlace)


    $scope.savePollingPlace = function(){
        var m_department = document.getElementById("department").value
        var m_city = document.getElementById("city").value
        var m_numberPolling = document.getElementById("numberPolling").value

        console.log(m_department)
        console.log(m_city)
        console.log(m_numberPolling)

        pollingPlaceFactory.addPollingPlace({
            department: m_department,
            city: m_city,
            pollingPlaceNumber: m_numberPolling
        }, function(){
            console.log("success")
        })
    }
})

/* Factories */
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

        getEmpty:
        {
            method: 'GET',
            params: { methodeRest: "empty"}
        },

        addPollingPlace:
        {
            method: 'POST',
            params: { pollingPlace: {"city": '@city', "department": '@department', "pollingPlaceNumber": '@pollingPlaceNumber' }}
        },
       
    })
})

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

        getEmpty:
        {
            method: 'GET',
            params: { methodeRest: "empty"}
        },

        addBallot:
        {
            method: 'POST',
            params: { ballot: {"infos": '@m_infos', "type": '@m_type', "candidates": '@m_candidates', "date":'@date' }}
        },
    })
})