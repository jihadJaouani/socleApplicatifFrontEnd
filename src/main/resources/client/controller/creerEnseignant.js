app.controller('creerEnseignant',['$scope','$http','$location', function($scope,$http,$location) {
    $scope.saveEnseignant = function(enseignant) {
    	console.log('saveEnseignant');
        	    	var data={
        	    			noEnseignant:enseignant.noEnseignant,
        	    			adresse:enseignant.adresse,
        	    			codePostal:enseignant.codePostal,
        	    			emailPerso:enseignant.emailPerso,
        	    			emailUbo:enseignant.emailUbo,
        	    			mobile:enseignant.mobile,
        	    			nom: enseignant.nom,
        	    			pays:enseignant.pays,
        	    			prenom:enseignant.prenom,
        	    			sexe:enseignant.sexe,
        	    			telephone:enseignant.telephone,
        	    			type:enseignant.type,
        	    			ville:enseignant.ville

        	  };
                $http.post('/enseignants', data)
                .success(function (data, status, headers, config) {
                	console.log("ajouté");
                	$location.path("/enseignants/");
                })
                .error(function (data, status, header, config) {
                	console.log("non ajouté");
                }); 
          }
    }
   
]);
