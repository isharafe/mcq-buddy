angular.module("momcq").controller("SubjectCtrl",
	[ "$scope", "momcqService",
	  function($scope, momcqService) {
		$scope.msg = {save:'', load:''};
		$scope.subjects = [];
	
		$scope.save = function(subject) {
			momcqService.addSubject(subject).then(function(saved) {
				$scope.msg.save = "Subject Saved";
				$scope.subjects.push(saved);
			}, function(err) {
				$scope.msg.save = "Save Failed";
			});
		};
	
		$scope.load = function() {
			momcqService.browseSubject({}).then(function(data) {
				$scope.msg.load = "Subjects Loaded";
				$scope.subjects = data;
			}, function(err) {
				$scope.msg.load = "load Failed";
			});
		};
	
		$scope.load();
	}
]);