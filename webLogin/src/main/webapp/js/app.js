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

	app.controller('LoginController', function($scope) {
		$scope.msg = "LoginPage";
	});

	app.controller('HomeController', function($scope) {
		$scope.msg = "HomePage";
	});

	app.controller('MainController', function($scope) {
		$scope.msg = "MainPage";
	});

	app.factory('LoginFactory', [ '$scope', '$http', function($scope, $http) {
		var urlBase = "http://localhost:8080/app";
		fact = {};
		fact.login = function(userinfo) {
			return $http({
				method : 'POST',
				url : urlBase + '/login',
				data : userinfo,
				headers : {
					'Content-Type' : 'application/json'
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
			function(Credentials, LoginFactory) {
				var fact = {};
				fact.isLoggedin = function() {
					LoginFactory.validate(Credentials.sessionId).success(
							function(data, status, headers, config) {
								return true;
							}).error(function(data, status, headers, config) {
								return false;
					});
				};
			} ]);

	// app.run(function($rootScope, $location, LoginFactory) {
	// $rootScope.$on('$routeChangeStart', function (event, next, current){

	// });
	// });
})();