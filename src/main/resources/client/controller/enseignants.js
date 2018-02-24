app.controller('enseignants', function($scope, $http) {

	 $scope.supprimer = function(id){
		 console.log("jdg");
		 $http.delete("/enseignants/"+id)
		 .then(res => {
			 $http.get("/enseignants")
			    .then(function(response) {
			        $scope.enseignants = response.data;
			        
			    });
		 });
	 }
	 
	 $http.get("/enseignants")
	    .then(function(response) {
	        $scope.enseignants = response.data;
	        
	    });
	
	 
	
	 
});