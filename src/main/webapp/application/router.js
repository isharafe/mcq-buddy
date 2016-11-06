angular.module("momcq").config(
[ '$routeProvider', '$locationProvider',
	function($routeProvider, $locationProvider) {
		$routeProvider.when('/subject', {
			templateUrl : 'application/view/subject/view.html',
			controller : 'SubjectCtrl'
		}).when('/mcq', {
			templateUrl : 'application/view/mcq/view.html',
			controller : 'McqCtrl'
		});

		// $locationProvider.html5Mode(true);
	}
]);