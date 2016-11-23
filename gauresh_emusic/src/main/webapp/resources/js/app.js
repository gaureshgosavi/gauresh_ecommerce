

var app = angular
			.module("myModule", [])
			.controller("productController", [$scope, $http, function($scope, $http){
				$scope.products = [];
				$http.get('gauresh_emusic.controller.ProductController.java')
					.then (function(response){
						$scope.products = response.data;
					});
			}]);