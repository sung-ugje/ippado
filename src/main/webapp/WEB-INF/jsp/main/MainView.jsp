<%--
  Class Name : MainView.jsp 
  Description : 메인화면
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 실행환경개발팀 JJY
    since    : 2011.08.31 
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/IpdIncPageTop.jsp"%>
<title>서해도선 관리자 페이지</title>
<link href="/css/styles.css" rel="stylesheet" type="text/css" >
</head>
<body>
<noscript>자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>	
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">서해도선 예약관리자</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#">예약관리</a></li>
                <li class="nav-item"><a class="nav-link" href="http://www.ippado.co.kr/" target="_blank">홈페이지</a></li>
                <li class="nav-item"><a class="nav-link" href="/sys/user/UserManage.do?baseMenuNo=6000000"><i class="bi-alarm"></i>설정</a></li>
            </ul>
        </div>
    </div>
</nav>	
<div id="wrap">
	<!-- container 시작 -->
	<div id="main_container" class="container">
		<!-- title 시작 -->
		<span class="label label-default bg-primary me-4">승선일시</span>

			<div class="btn-group  my-3 border" role="group" aria-label="Basic radio toggle button group">
			  <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off">
			  <label class="btn btn-outline-primary" for="btnradio1"><</label>
			
			  <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
			  <label class="btn btn-outline-primary" for="btnradio2">2022.04.04</label>
	
			  <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off" checked>
			  <label class="btn btn-outline-primary" for="btnradio3">2022.04.05</label>
	
			  <input type="radio" class="btn-check" name="btnradio" id="btnradio4" autocomplete="off">
			  <label class="btn btn-outline-primary" for="btnradio4">2022.04.06</label>
			
			  <input type="radio" class="btn-check" name="btnradio" id="btnradio5" autocomplete="off">
			  <label class="btn btn-outline-primary" for="btnradio5">></label>
			</div>
			
		<!-- 게시판 시작 -->
		<div class="accordion w-100">
			<div class="accordion-item my-3 bo border">
			 <h2 class="accordion-header" id="headingOne">
			 <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
			<span class="badge bg-primary">09시 30분 (궁평항 -> 입파도)</span>
			<div class="progress" style="width:60%;margin:0 10px">
  			<div class="progress-bar bg-info" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100">25 / 60</div>
			</div>
			<span class="badge bg-secondary">완료</span>
			</button>
			    </h2>
		    <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
		      <div class="accordion-body">
		        입파도 승객 목록
		      </div>
		    </div>
			</div>

			<div class="accordion-item my-3 border">
			 <h2 class="accordion-header" id="headingTwo">
			 <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
			<span class="badge bg-primary">11시 00분 (궁평항 -> 입파도)</span>
			<div class="progress" style="width:60%;margin:0 10px">
  			<div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">25 / 60</div>
			</div>
			<span class="badge bg-success">승선대기</span>
			</button>
			    </h2>
		    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
		      <div class="accordion-body">
		        입파도 승객 목록
		      </div>
		    </div>
			</div>
		</div>		
		</div>
	<!-- //게시판 끝 -->
	<!-- footer 시작 -->
	<div id="footer"><c:import url="/EgovPageLink.do?link=main/inc/IncFooter" /></div>
	<!-- //footer 끝 -->
</div>
<!-- //전체 레이어 끝 -->
</body>
</html>