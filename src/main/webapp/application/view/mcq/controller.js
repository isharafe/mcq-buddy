angular.module("momcq")
.controller("McqCtrl",
["$scope", "momcqService", function($scope, momcqService) {
	$scope.msg = {save:'', load:''};
	$scope.subjects = [];
	$scope.mcqs = [];
	
	momcqService.browseMcq({}).then(function(data){
		$scope.mcqs = data;
	});
	momcqService.browseSubject({}).then(function(data){
		$scope.subjects = data;
	});

	$scope.save = function(mcq) {
		momcqService.addMcq(mcq).then(function(saved) {
			$scope.msg.save = "Mcq Saved";
			$scope.mcqs.push(saved);
		}, function(err) {
			$scope.msg.save = "Save Failed";
		});
	};
	
	$scope.load = function(){
		momcqService.browseMcq().then(function(data){
			$scope.mcqs = data;
		});
	};
	
	$scope.load();
}
]);