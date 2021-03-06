<div class="container">
	<!-- BREADCRUMB  -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>


	</div>

	<div class="row">
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.png" class="img img-responsive" />
			</div>
		</div>

		<div class="col-xs-12 col-sm-8">
			<h4>${product.name}</h4>
			<hr>
			<p>${product.description}</p>
			<hr>
			<h4>Price: &#36; ${product.unitPrice}</h4>
			<hr>
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>
						Qty. Available: <span style="color: red">Out of Stock!</span>
					</h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
			<hr>

			<c:choose>
				<c:when test="${product.quantity < 1}">
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span
							class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</strike></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.id}/product"
						class="btn btn-success"><span
						class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</a>
				</c:otherwise>
			</c:choose>

			<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
		</div>
	</div>
</div>