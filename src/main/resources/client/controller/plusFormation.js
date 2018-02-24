app.controller('plusformation', function($scope, $http, $routeParams) {
	$scope.plusFor = "aa";

		   $http.get("/formations/"+$routeParams.id)
		   .then( function(response){
			   $scope.plusFor = response.data;     
		   });
});