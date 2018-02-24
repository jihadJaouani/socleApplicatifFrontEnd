app.controller('formations', function($scope, $http) {
	
	$scope.supprimer = function(id){
		 console.log("jdg");
		 $http.delete("/formations/"+id)
		 .then(res => {
			 $http.get("/formations")
			    .then(function(response) {
			        $scope.formations ={};
			        
			    });
		 });
	 }
	
	 $http.get("/formations")
	    .then(function(response) {
	        $scope.formations = response.data;
	        
	    });
	 
	
	 
});