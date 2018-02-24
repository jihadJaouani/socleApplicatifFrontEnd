app.controller('plusEnseignant', function($scope, $http, $routeParams) {

		   $http.get("/enseignants/"+$routeParams.id)
		   .then( function(response){
			   
			   $scope.plusEnseignant = response.data; 

			   console.log( "rf");
			   console.log( $scope.plusEnseignant);
		   });
});