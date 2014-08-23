(function() {
	var app = angular.module('login', [ 'ngRoute' ]);

	app.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/', {
			templateUrl : 'main.html',
			controller : 'MainController'
		}).when('/login', {
			templateUrl : 'login.html',
			controller : 'LoginController'
		}).when('/home', {
			templateUrl : 'home.html',
			controller : 'HomeController'
		}).otherwise({
			redirectTo : '/'
		});
	} ]);

	app.controller('IndexController', function() {
		this.i = 1;
	});

	app.controller('LoginController', [ '$scope', 'LoginService',
			function($scope, LoginService) {
				$scope.msg = "LoginPage";
				$scope.login = function(userinfo) {
					LoginService.authenticate(userinfo);
				};
			} ]);

	app.controller('HomeController',['$scope', 'Credentials', function($scope, Credentials) {
		$scope.msg = "Welcome" + Credentials.firstName + " " + Credentials.lastName + "!";
		
	}]);

	app.controller('MainController', function($scope) {
		$scope.msg = "MainPage";
	});

	app.factory('LoginFactory', [ '$http', function($http) {
		var urlBase = "http://localhost:8080/app";
		var fact = {};
		fact.login = function(userinfo) {
			return $http({
				method : 'POST',
				url : urlBase + '/login',
				data : userinfo,
				headers : {
					'Content-Type' : 'application/json',
					'Accept' : 'application/json'
				}
			});
		};
		fact.validate = function(sessionId) {
			return $http({
				method : 'GET',
				url : urlBase + '/validate?sessionId=' + sessionId,
			});
		};
		return fact;
	} ]);

	app.value('Credentials', {
		'sessionId' : 'junk',
		'firstName' : 'junk',
		'lastName' : 'junk'
	});

	app.factory('LoginService', [
			'Credentials',
			'$location',
			'LoginFactory',
			function(Credentials, $location, LoginFactory) {
				var fact = {};
				fact.isLoggedin = function() {
					var result = false;
					LoginFactory.validate(Credentials.sessionId).success(
							function(data, status, headers, config) {
								result = true;
							}).error(function(data, status, headers, config) {
						result = false;
					});
					return result;
				};
				fact.authenticate = function(userinfo) {
					LoginFactory.login(userinfo).success(
							function(data, status, headers, config) {
								Credentials = data;
								$location.path('/home');
							}).error(function(data, status, headers, config) {
						$location.path('/login');
					});
				};
				return fact;
			} ]);

	app.run(function($rootScope, $location, LoginService) {
		$rootScope.$on('$routeChangeStart', function(event, next, current) {
			console.log(LoginService.isLoggedin());
			if (!LoginService.isLoggedin()) {
				$location.path('/login');
			}
		});
	});
})();