<div class="container">

	<div class="row">
		<div class="col-md-3">
			<!-- SIDEBAR SECTION -->
			<%@include file="./shared/sidebar.jsp"%>
			<!--------------------------------->
		</div>
		<div class="col-md-9">
			<!--Adding The Breadcrumb component -->
			<div class="row">
				<div class="col-md-12">
					<c:if test="${userClicksShowAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">HOME</a></li>
							<li class="active">ALL PRODUCTS</li>
						</ol>
					</c:if>
					<c:if test="${userClicksShowCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">HOME</a></li>
							<li>PRODUCTS</li>
							<li>CATEGORY</li>
							<li class="active">${categoryName}</li>
						</ol>
					</c:if>

				</div>

			</div>
	
			<div class="row">
				<div class="col-xs-12">
					<table id="productListTable" class="table table-striped table-borderd">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>
						
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>
						
						</tfoot>					
					
					</table>
				
				</div>
				
			</div>
		</div>

	</div>


</div>