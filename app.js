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
	
	app.controller('PanelController', function() {
		this.tab = 1;
		this.selectTab = function(setTab) {
			this.tab = setTab;
		};
		
		this.isSelected = function(checkTab) {
			return this.tab === checkTab;
		};
		
	});
		
	var gems = [
		{
		 name: "Dodecahedron",
		 price: 2.00,
		 description: "Description for Dodecahedron",
		 canPurchase: true,
		 soldOut: false,
		 specification: "Specification for Dodecahedron",
		 reviews: [
			{
			stars: 5,
			body: "Dodecahedron : I love this gem!",
			author: "Dodecahedron : joe@example.org",
			createdOn: 1397490980837
			}, 
			{
			stars: 1,
			body: "Dodecahedron : This gem sucks.",
			author: "Dodecahedron : tim@example.org",
			createdOn: 1397490980837
			}
		]
		},
		{
		 name: "Pentagonal Gem",
		 price: 8.67,
		 description: "Description for Pentagonal Gem",
		 canPurchase: false,
		 soldOut: false,
		 specification: "Specification for Pentagonal Gem",
		 reviews: [
			{
			stars: 5,
			body: "Pentagonal Gem : I love this gem!",
			author: "Pentagonal Gem : joe@example.org",
			createdOn: 1397490980837
			}, 
			{
			stars: 1,
			body: "Pentagonal Gem : This gem sucks.",
			author: "Pentagonal Gem : tim@example.org",
			createdOn: 1397490980837
			}
		]
		}
	];
})();