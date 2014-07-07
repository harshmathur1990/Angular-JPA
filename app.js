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
		this.showNext = function(products) {
			return ((this.i + 1) < products.length);
		};
		this.showPrev = function(products) {
			return (this.i > 0);
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
	
	app.controller('ReviewController', function() {
		this.review = {};
	
		this.addReview = function(product) {
			product.reviews.push(this.review);
			this.review = {};
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
			body: "I love this Dodecahedron gem!",
			author: "joeDodecahedron@example.org",
			createdOn: 1397490980837
			}, 
			{
			stars: 1,
			body: "This Dodecahedron gem sucks.",
			author: "timDodecahedron@example.org",
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
			body: "I love this Pentagonal gem!",
			author: "joePentagonal@example.org",
			createdOn: 1397490980837
			}, 
			{
			stars: 1,
			body: "This Pentagonal gem sucks.",
			author: "timPentagonal@example.org",
			createdOn: 1397490980837
			}
		]
		}
	];
})();