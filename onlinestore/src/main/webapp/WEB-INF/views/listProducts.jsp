
<div class="container">

	<div class="row">
		<!--  to display sidebar -->
		<div class="col-md3">
			<%@include file="./shared/sidebar.jsp"%>

		</div>
		<!--  to display actual products -->
		<div class="col-md9">

			<!--  add breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">
							<li><a href="/onlinestore/home">Home</a></li>
							<li class="active"> &nbsp / All products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts==true }">
						<ol class="breadcrumb">
							<li><a href="/onlinestore/home">Home </a></li>
							<li class="active">&nbsp / Category &nbsp/</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>


				</div>

			</div>


		</div>

	</div>


</div>

