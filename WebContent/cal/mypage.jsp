<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>com:path 스크랩북 게시판</title>
<!-- Bootstrap -->

<link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.js"
	integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/main.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/html"
	href="/fullcalendar-master/assets/">
</head>


<body class>
	<div class="container">
		<header>

			<!-- 헤더 들어가는 부분 -->



			<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
				<!-- 컨테이너를 설정하지 않으면 메뉴바가 펼쳐지고 난리난리 납니당 컨테이너 설정 = 1170px 안으로 담겠다 -->
				<a class="navbar-brand" href="http://playdata.io"
					class="navbar-brand"> <img src="img/com_path.png"
					alt="com:path" size="150px">
				</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#navbarsExampleDefault"
					aria-controls="navbarsExampleDefault" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<!-- justify-content-end 는 컨테이너 끝쪽으로 몰아넣도록 함-->
				<div class="collapse navbar-collapse justify-content-end"
					id="navbarsExampleDefault">
					<ul class="navbar-nav mr-auto">

						<li class="nav-item active"><a class="nav-link" href="#"
							class="nav-link">트렌드 <span class="sr-only">(current)</span></a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">기업정보</a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="#">대기업</a> <a
									class="dropdown-item" href="#">공기업</a> <a class="dropdown-item"
									href="#">외국계기업</a> <a class="dropdown-item" href="#">중견/강소기업</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> 스크랩북</a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="#">전체</a> <a
									class="dropdown-item" href="#">기업</a> <a class="dropdown-item"
									href="#">산업</a> <a class="dropdown-item" href="#">직무 및 채용정보</a>
							</div></li>

						<li class="nav-item"><a class="nav-link" href="#">마이페이지</a></li>
					</ul>
					<form class="form-inline">
						<input class="form-control mr-sm-2" type="search" placeholder="찾기"
							aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				</div>

			</nav>
		</header>
		<hr />




		<!-- Sidebar -->


		<nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
			<ul class="nav nav-pills flex-column">
				<li class="nav-item">
					<h3>
						<a class="nav-link-success" href="#">카테고리 </a>
					</h3>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">직 업 정 보</a></li>
				<li class="nav-item"><a class="nav-link" href="#">직 무 정 보</a></li>
				<li class="nav-item"><a class="nav-link" href="#">산 업 정 보</a></li>
				<li class="nav-item"><a class="nav-link" href="#">채 용 정 보</a></li>
			</ul>
		</nav>


		<!-- /#sidebar-->

		<div class="row">
			<div class="col-md-9">
				<div class="row">
					<div class="col-md-12">
						<button type="button" class="btn btn-primary btn-lg ">기업
						</button>
						<button type="button" class="btn btn-secondary btn-lg">
							산업</button>
						<button type="button" class="btn btn-success btn-lg">직무</button>
						<button type="button" class="btn btn-danger btn-lg">관심단어
						</button>
					</div>
				</div>
				</br>
				</br>
				<div class="row">
					<div class="col-md-12">
						<button type="button" class="btn btn-primary btn-sm">LG</button>
						<button type="button" class="btn btn-primary btn-sm">삼성</button>
						<button type="button" class="btn btn-primary btn-sm">롯데</button>
						<button type="button" class="btn btn-primary btn-sm">회사1</button>
						<button type="button" class="btn btn-primary btn-sm">회사2</button>
						<button type="button" class="btn btn-primary btn-sm">회사3</button>
						<button type="button" class="btn btn-primary btn-sm">회사4</button>
						<button type="button" class="btn btn-primary btn-sm">회사5</button>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<h3>자주 찾는 메뉴 설정</h3>
			</div>


			<div class="row">
				<div class="col-md-6">
					<div class="row">
						</br>
						</br>
						</br>
						<div class="col-md-12">
							<table class="table table-dark">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col">이름</th>
										<th scope="col">성</th>
										<th scope="col">아이디</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td>Mark</td>
										<td>Otto</td>
										<td>@mdo</td>
									</tr>
									<tr>
										<th scope="row">2</th>
										<td>Jacob</td>
										<td>Thornton</td>
										<td>@fat</td>
									</tr>
									<tr>
										<th scope="row">3</th>
										<td>Larry</td>
										<td>the Bird</td>
										<td>@twitter</td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							</br>
							</br>
							</br>
							</br>
							</br>
							</br>
							</br>
							<div class="progress">
								<div class="progress-bar w-75" role="progressbar"
									aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
							</div>

						</div>
					</div>
				</div>



				<div class="col-md-6">
					<div class="list-group">
						<a href="#"
							class="list-group-item list-group-item-action flex-column align-items-start active">
							<div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1">List group item heading</h5>
								<small>3 days ago</small>
							</div>
							<p class="mb-1">Donec id elit non mi porta gravida at eget
								metus. Maecenas sed diam eget risus varius blandit.</p> <small>Donec
								id elit non mi porta.</small>
						</a> <a href="#"
							class="list-group-item list-group-item-action flex-column align-items-start">
							<div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1">List group item heading</h5>
								<small class="text-muted">3 days ago</small>
							</div>
							<p class="mb-1">Donec id elit non mi porta gravida at eget
								metus. Maecenas sed diam eget risus varius blandit.</p> <small
							class="text-muted">Donec id elit non mi porta.</small>
						</a> <a href="#"
							class="list-group-item list-group-item-action flex-column align-items-start">
							<div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1">List group item heading</h5>
								<small class="text-muted">3 days ago</small>
							</div>
							<p class="mb-1">Donec id elit non mi porta gravida at eget
								metus. Maecenas sed diam eget risus varius blandit.</p> <small
							class="text-muted">Donec id elit non mi porta.</small>
						</a>
					</div>
				</div>


			</div>

			<div class="row">
				<div class="col-md-5">

					<div class="row">
						<div class="col-md-12">
							<h3>Schedule</h3>
						</div>
					</div>
					<div class="row">
						<jsp:include page="fullcalendar.html"/>
					</div>
				</div>

				<div class="col-md-2">
					<div class="alert alert-primary" role="alert">삼성1</div>
					<div class="alert alert-secondary" role="alert">삼성2</div>
					<div class="alert alert-success" role="alert">삼성3</div>
					<div class="alert alert-danger" role="alert">삼성4</div>
					<div class="alert alert-warning" role="alert">삼성5</div>
					<div class="alert alert-info" role="alert">삼성6</div>
				</div>

				<div class="col-md-5">

					<div class="row">
						<div class="col-md-12">
							<h3>관심 공채 Update</h3>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">



							<div class="row">
								<div class="col-4">
									<div class="list-group" id="list-tab" role="tablist">
										<a class="list-group-item list-group-item-action active"
											id="list-home-list" data-toggle="list" href="#list-home"
											role="tab" aria-controls="home">Home</a> <a
											class="list-group-item list-group-item-action"
											id="list-profile-list" data-toggle="list"
											href="#list-profile" role="tab" aria-controls="profile">Profile</a>
										<a class="list-group-item list-group-item-action"
											id="list-messages-list" data-toggle="list"
											href="#list-messages" role="tab" aria-controls="messages">Messages</a>
										<a class="list-group-item list-group-item-action"
											id="list-settings-list" data-toggle="list"
											href="#list-settings" role="tab" aria-controls="settings">Settings</a>
									</div>
								</div>


								<div class="col-8">
									<div class="tab-content" id="nav-tabContent">
										<div class="tab-pane fade show active" id="list-home"
											role="tabpanel" aria-labelledby="list-home-list">...</div>
										<div class="tab-pane fade" id="list-profile" role="tabpanel"
											aria-labelledby="list-profile-list">...</div>
										<div class="tab-pane fade" id="list-messages" role="tabpanel"
											aria-labelledby="list-messages-list">...</div>
										<div class="tab-pane fade" id="list-settings" role="tabpanel"
											aria-labelledby="list-settings-list">...</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<script src="js/jquery.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/scripts.js"></script>

			<hr />

			<!-- 푸터 들어가는 부분 -->
			<div class="container">
				<p class="text-center">
					<small><strong> com:path</strong></small><br> <small>주소
						: 대호 프레조빌 ㆍ 사업자등록번호:123-12-12345 ㆍ 전화 : 010-000-0000</small><br> <small>Copyrightⓒ
						test.com All rights reserved.</small>
				</p>
			</div>
			<!--// 푸터 들어가는 부분 -->
</body>

</html>
