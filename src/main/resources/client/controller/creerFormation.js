

app.controller('creerFormation',['$scope','$http','$location' ,function($scope,$http,$location) {

    $scope.saveFormation = function(formation) {
        	    	var data={
        	    	  codeFormation:formation.codeFormation,
    	        	  debutAccreditation:formation.debutAccreditation,
    	              diplome:formation.diplome,
    	              doubleDiplome:formation.doubleDiplome,
    	              finAccreditation:formation.finAccreditation,
    	        	  n0Annee:formation.n0Annee,
    	        	  nomFormation : formation.nomFormation
    	        	  
        	  };
                
                $http.post('/formations', data)
                .success(function (data, status, headers, config) {
                	console.log("adjouteeeee");
                	$location.path("/formations");
                })
                .error(function (data, status, header, config) {
                	console.log("nnnnnnnnnnnne");
                }); 
          }
    }
   
]);

/*formation={
codeFormation:"",
debutAccreditation:"",
diplome:"",
doubleDiplome:"",
finAccreditation:"",
N0Annee:0,
nomFormation : ""     	  
};
$scope.getUsers = function() {
$http({
method: 'GET',
url: '/formations',
headers:'Accept:application/json'
}).then( function(response){
return response.data;
} );
}  */