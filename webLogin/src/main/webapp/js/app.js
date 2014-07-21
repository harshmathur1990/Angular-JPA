(function() {
	var app = angular.module('webLogin', []);

	app.controller('LoginController', [ '$http', function($http) {
		this.userinfo = {};
		this.status = "NOT YET";
		
		this.validateUser = function() {
			$http({
				url: 'http://localhost:8080/users/search/findbyUserNameAndPassWord?userName='+this.userinfo.userName+'&passWord='+this.userinfo.passWord,
				method: 'POST',
				headers: {'Content-Type': 'application/json'}
			}).success(function(data, status, headers, config){ 
				this.status = data;
			}).error(function(data, status, headers, config){
				this.status = status;
			});
		};
	}]);
})();