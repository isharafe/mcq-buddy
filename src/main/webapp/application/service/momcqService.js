angular.module("momcq").factory("momcqService",
["$http", function($http) {
	
	var objType = Object.prototype.toString.call({});
	var arrType = Object.prototype.toString.call([]);
	var isObject = function(meta){
		return meta===objType;
	}
	var isArray = function(meta){
		return meta===arrType;
	}
	/**
	 * remove these fields before send data to server.
	 * or else there will be errors when convert json to object.
	 */
	var fieldsToClear = ["$$hashKey"];
	var objCache = [];
	var formatObj = function(obj){
		for(var key in obj){
			var value = obj[key];
			var meta = Object.prototype.toString.call(value);
			if(isObject(meta)){
				formatObj(value);
			}else if(isArray(meta)){
				value.forEach(formatObj);
			}else if(value!=null && fieldsToClear.indexOf(key)>-1){
				delete obj[key];
			}
		}
		return obj;
	};
	
	var rest = function(url, data){
		data = formatObj(data);
		data = "data="+ encodeURIComponent(JSON.stringify(data));
		var config = {headers:{"Content-Type":"application/x-www-form-urlencoded"}};
		return $http.post(url, data, config).then(function(data){
			return data.data;
		});
	};
	
	var addMcq = function(data){
		return rest("momcq/mcq/add", data);
	};
	
	var browseMcq = function(data){
		return rest("momcq/mcq/browse", data);
	};
	
	var addSubject = function(data){
		return rest("momcq/subject/add", data);
	};
	
	var browseSubject = function(data){
		return rest("momcq/subject/browse", data);
	};
	
	return {
		addMcq: addMcq,
		browseMcq: browseMcq,
		addSubject: addSubject,
		browseSubject: browseSubject
	};
}]);