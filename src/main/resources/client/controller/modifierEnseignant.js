app.controller('modifierEnseignant', function($scope, $http, $routeParams,$location) {
	 $scope.enseignant = {};
		   $http.get("/enseignants/"+$routeParams.id)
		   .then( function(response){
			   
			   $scope.enseignant = response.data; 

			   console.log( "rf");
			   console.log( $scope.enseignant);
		   });
		   
		    $scope.modifierEnseignant = function() {
		    	console.log('saveEnseignant');
		        	    	
		                $http.post('/enseignants',  $scope.enseignant)
		                .success(function (data, status, headers, config) {
		                	console.log("modifié");
		                	$location.path("/enseignants");
		                })
		                .error(function (data, status, header, config) {
		                	console.log("non modifié");
		                }); 
		          }
		    
});