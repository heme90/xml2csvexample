<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

    <title>뉴스 결과 com:path</title>

    <!-- 부트스트랩 -->
    <link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.js"
        integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
        integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet"
        integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link href="css/searchmain.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900|Poppins:700" rel="stylesheet" />

</head>

<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-light sticky-top bg-white">
            <!-- 컨테이너를 설정하지 않으면 메뉴바가 펼쳐지고 난리난리 납니당 컨테이너 설정 = 1170px 안으로 담겠다 -->
            <a class="navbar-brand" href="http://playdata.io" class="navbar-brand">
                <img src="img/com_path.png" alt="com:path" size="150px">
            </a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- justify-content-end 는 컨테이너 끝쪽으로 몰아넣도록 함-->
            <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                <ul class="col-8 navbar-nav mr-auto">

                    <ul class="col-8 navbar-nav mr-auto">

                        <li class="nav-item active">
                            <a class="nav-link" href="#" class="nav-link">트렌드</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="#">기업정보</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="#">채용정보</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="#">스크랩북</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="#">마이페이지</a>
                        </li>
                    </ul>
                </ul>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" data-toggle="collapse" href="#colsearch" aria-expanded="true"
                            aria-controls="colsearch">
                            상세검색
                        </a>
                    </li>
                    <form class="form-inline">
                        <input class="form-control mr-sm-2" title="검색어 입력" type="search" placeholder="찾기"
                            aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit"
                            onclick="location.href=''">Search</button>
                    </form>
                </ul>
            </div>
            <!-- modal 구동 버튼 (trigger) -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal"> Log-in</button>
        </nav>
    </header>


    <div class="s011" id="colsearch">
        <form>
            <fieldset>
                <legend>어떤 정보를 찾고 계세요?</legend>
            </fieldset>
            <div class="inner-form">
                <header>
                    <div class="travel-type-wrap">
                        <div class="item active">
                            <span>키워드검색</span>
                        </div>
                        <div class="item">
                            <span>기업정보검색</span>
                        </div>
                        <div class="item">
                            <span>채용정보검색</span>
                        </div>
                    </div>
                </header>
                <div class="main-form" id="main-form">
                    <div class="roww">
                        <div class="input-wrap">
                            <div class="input-field">
                                <label>검색어</label>
                                <input type="text" placeholder="검색하고 싶은 키워드를 입력하세요" />
                            </div>
                        </div>
                    </div>
                    <div class="roww second">
                        <div class="input-wrap">
                            <div class="input-field">
                                <label>시작날짜</label>
                                <input class="datepicker" type="text" placeholder="mm/dd/yy" />
                            </div>
                        </div>
                        <div class="input-wrap">
                            <div class="input-field">
                                <label>종료날짜</label>
                                <input class="datepicker" type="text" placeholder="mm/dd/yy" />
                            </div>
                        </div>
                    </div>
                    <div class="roww second">
                        <div class="input-wrap">
                            <div class="input-field">
                                <label>포함할 검색어</label>
                                <input type="text" />
                            </div>
                        </div>
                        <div class="input-wrap">
                            <div class="input-field">
                                <label>제외할 검색어</label>
                                <input type="text" />
                            </div>
                        </div>
                    </div>
                    <!--<div class="row third">
                  <div class="input-checkbox-group">
                    <div class="input-checkbox">
                      <input id="yes" type="checkbox" name="customer" value="yes" checked="checked" />
                      <label for="yes">ADD A FLIGHT</label>
                    </div>
                    <div class="input-checkbox">
                      <input id="no" type="checkbox" name="customer" value="no" />
                      <label for="no">ADD A CAR</label>
                    </div>
                  </div>
                </div>-->

                    <div class="roww justify-content-center">
                        <button class="col btn-search" type="button">검 색</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script src="js/extention/choices.js"></script>
    <script>
        const choices = new Choices('[data-trigger]',
            {
                searchEnabled: false,
                itemSelectText: '',
            });

    </script>
    <script src="js/extention/flatpickr.js"></script>
    <script>
        flatpickr(".datepicker",
            {
                dateFormat: "m/d/y"
            });
        var btnTypes = document.querySelectorAll('.travel-type-wrap .item')
        var mainForm = document.getElementById('main-form')
        for (let i = 0; i < btnTypes.length; i++) {
            btnTypes[i].addEventListener('click', function () {
                for (let i = 0; i < btnTypes.length; i++) {
                    btnTypes[i].classList.remove('active')
                }
                btnTypes[i].classList.add('active')
                let className = 'type' + i
                mainForm.className = `${className} main-form`
            })
        }

    </script>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <!--왜인지 얘가 있어야 닫기 버튼이 닫힘-->
        </div>
        <div class="wrapper fadeInDown" id="myModal">
            <div id="formContent">
                <!-- Tabs Titles -->

                <!-- Icon -->
                <div class="fadeIn first">
                    <img src="C:\Bootstrap\compath\img\com_path.png" id="icon" alt="User Icon" />
                    <h1>로그인 하세요.</h1>
                </div>

                <!-- Login Form -->

                <form>
                    <input type="text" id="login" class="fadeIn second" name="login" placeholder="username">
                    <input type="text" id="password" class="fadeIn third" name="login" placeholder="password">
                    <input type="submit" class="fadeIn fourth" value="Log In">
                </form>

                <!-- Remind Passowrd -->
                <div id="formFooter">
                    <a class="underlineHover" href="#">회원가입</a>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>
</body>

</html>