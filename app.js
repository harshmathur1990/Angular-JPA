(function(){
	var app = angular.module('store', []);
 
	app.controller('StoreController', function() {
		this.products = gems;
	});
	
	app.controller('ProductController', function() {
		this.i = 0;
		this.setNext = function() {
			this.i++;
		};
		this.setPrev = function() {
			this.i--;
		};
	});
		
	var gems = [
		{
		 name: "Dodecahedron",
		 price: 2.00,
		 description: ". . .",
		 canPurchase: true,
		 soldOut: false,
		},
		{
		 name: "Pentaginal Gem",
		 price: 8.67,
		 description: ". . .",
		 canPurchase: false,
		 soldOut: false,
		 }
	];
})();