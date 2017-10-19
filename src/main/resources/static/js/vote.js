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

/* Polling Place Controller*/
vote.controller('voteCTRL', function ($scope, $rootScope, $location, pollingPlaceFactory, ballotFactory, voteFactory) {

    pollingPlaceFactory.getList({}, function(pollingplaces){
        $scope.pollingplaces = pollingplaces;
    })


    ballotFactory.getList({}, function(ballots){
        $scope.ballots = ballots
        $scope.candidates = ballots[0].candidates
    })

    $(document).on('change','#ballot',function(){
        console.log("test")
        var x = document.getElementById("ballot").selectedIndex;
        var y = document.getElementById("ballot").options;
        var ballot = y[x].value
        
        ballot = JSON.parse(ballot);
        $scope.candidates = ballot.candidates
        $scope.$apply()
    });

    /** Function to save a polling place */
    $scope.saveVote = function(){
        var x = document.getElementById("pollingPlace").selectedIndex;
        var y = document.getElementById("pollingPlace").options;
        var m_polling = JSON.parse(y[x].value)
        var m_department = m_polling.department
        var m_city = m_polling.city
        var m_numberPolling = m_polling.pollingPlaceNumber

        var x2 = document.getElementById("ballot").selectedIndex;
        var y2 = document.getElementById("ballot").options;
        var m_ballot = JSON.parse(y2[x2].value)
        var m_ballotId = m_ballot.id

        var x3 = document.getElementById("candidate").selectedIndex;
        var y3 = document.getElementById("candidate").options;
        var m_candidate = y3[x3].value

        voteFactory.addVote({
            ballotId: m_ballotId,
            choice: m_candidate,
            department: m_department,
            city: m_city,
            pollingPlaceId: m_numberPolling
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
            params: { ballot: {"infos": '@infos', "type": '@type', "candidates": '@candidates', "date":'@date' }}
        },
    })
})


/* ballot factory */
vote.factory('voteFactory', function ($resource) {
    return $resource('./rest/vote/:methodeRest/:id', {
        methodeRest: '@methodeRest',
        id: '@id'
    }, {
        getList:
        {
            method: 'GET',
            params: {},
            isArray: true,
        },

        addVote:
        {
            method: 'POST',
            params: { vote: {"ballotId": '@ballotId', "choice": '@choice', "city": '@city', "department": '@department', "pollingPlaceId": '@pollingPlaceId' }}
        },
    })
})