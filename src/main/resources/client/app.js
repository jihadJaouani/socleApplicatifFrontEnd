var app = angular.module('SocleApplicatif', [
		'ngRoute'
	])
	.config(function ($routeProvider) {
		$routeProvider
			.when('/formations', {
				templateUrl: 'view/formations.html',
				controller: 'formations'
					
			})
			.when('/plus', {
				templateUrl: 'view/plusFormation.html',
				controller: 'formations'
					
			})
			.when('/creerFormation', {
				templateUrl: 'view/creerFormation.html',
				controller: 'creerFormation'
					
			})
			.when('/plusformation/:id', {
				templateUrl: 'view/plusFormation.html',
				controller: 'plusformation'
					
			})
			.when('/enseignants', {
				templateUrl: 'view/enseignants.html',
				controller: 'enseignants'
					
			})
			.when('/creerEnseignant', {
				templateUrl: 'view/creerEnseignant.html',
				controller: 'creerEnseignant'
					
			})
			.when('/plusEnseignant/:id', {
				templateUrl: 'view/plusEnseignant.html',
				controller: 'plusEnseignant'
					
			})
			.when('/modifierEnseignant/:id', {
				templateUrl: 'view/modifierEnseignant.html',
				controller: 'modifierEnseignant'
					
			})
			
			.otherwise({
				redirectTo: '/'
			});
	});

