<%--
  Class Name : AuthorMenuManage.jsp
  Description : 권한별메뉴관리 조회 화면
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.03.10    이용             최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 이용
    since    : 2009.03.10
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/IpdIncPageTop.jsp"%>
<%
  /* Image Path 설정 */
  String imagePath_icon   = "/images/egovframework/sym/mpm/icon/";
  String imagePath_button = "/images/egovframework/sym/mpm/button/";
%>
<title>권한별메뉴관리</title>
<style type="text/css">
    h1 {font-size:12px;}
    caption {visibility:hidden; font-size:0; height:0; margin:0; padding:0; line-height:0;}
</style>
<script type="text/javaScript">
<!--
/* ********************************************************
 * 최초조회 함수
 ******************************************************** */
function fAuthorMenuManageSelect(){ 
    document.menuCreatManageForm.action = "<c:url value='/sys/author/AuthorMenuManageSelect.do'/>";
    document.menuCreatManageForm.submit();
}

/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
    document.menuCreatManageForm.pageIndex.value = pageNo;
    document.menuCreatManageForm.action = "<c:url value='/sys/author/AuthorMenuManageSelect.do'/>";
    document.menuCreatManageForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectAuthorMenuManageList() { 
    document.menuCreatManageForm.pageIndex.value = 1;
    document.menuCreatManageForm.action = "<c:url value='/sys/author/AuthorMenuManageSelect.do'/>";
    document.menuCreatManageForm.submit();
}

/* ********************************************************
 * 권한별메뉴 화면 호출
 ******************************************************** */
function selectAuthorMenu(vAuthorCode) {
    document.menuCreatManageForm.authorCode.value = vAuthorCode;
    document.menuCreatManageForm.action = "<c:url value='/sys/author/AuthorMenuSelect.do'/>";
    window.open("#", "_menuCreat", "scrollbars = yes, top=100px, left=100px, height=700px, width=850px");    
    document.menuCreatManageForm.target = "_menuCreat";
    document.menuCreatManageForm.submit();  
}
<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
//-->
</script>
</head>

<body>
<noscript>자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>    
<!-- 전체 레이어 시작 -->
<div id="wrap">
    <!-- header 시작 -->
    <div id="header"><c:import url="/EgovPageLink.do?link=main/inc/IncHeader" /></div>
    <div id="topnavi"><c:import url="/main/MainMenuHead.do" /></div>        
    <!-- //header 끝 --> 
    <!-- container 시작 -->
    <div id="container">
        <!-- 좌측메뉴 시작 -->
        <div id="leftmenu"><c:import url="/main/MainMenuLeft.do" /></div>
        <!-- //좌측메뉴 끝 -->
            <!-- 현재위치 네비게이션 시작 -->
            <div id="content">
            <form name="menuCreatManageForm" action ="<c:url value='/sys/author/AuthorMenuManageSelect.do'/>" method="post">
            <input type="submit" id="invisible" class="invisible"/>
                <div id="cur_loc">
                    <div id="cur_loc_align">
                        <ul>
                            <li>HOME</li>
                            <li>&gt;</li>
                            <li>내부시스템관리</li>
                            <li>&gt;</li>
                            <li>메뉴관리</li>
                            <li>&gt;</li>
                            <li><strong>권한별메뉴관리</strong></li>
                        </ul>
                    </div>
                </div>

                <!-- 검색 필드 박스 시작 -->
                <div id="search_field">
                    <div id="search_field_loc"><h2><strong>권한별메뉴관리</strong></h2></div>
					
						<input name="checkedMenuNoForDel" type="hidden" />
						<input name="authorCode"          type="hidden" />
						<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>

                        <fieldset><legend>조건정보 영역</legend>    
                        <div class="sf_start">
                            <ul id="search_first_ul">
                                <li>
                                    <label for="searchKeyword">보안설정대상ID : </label>
                                    <input id="searchKeyword" name="searchKeyword" type="text" size="80" value=""  maxlength="60" title="검색조건"/> 
                                </li>
                            </ul>
                            <ul id="search_second_ul">
                                <li>
                                    <div class="buttons" style="float:right;">
                                        <a href="#LINK" onclick="javascript:selectAuthorMenuManageList(); return false;"><img src="<c:url value='/images/img_search.gif' />" alt="search" />조회 </a>
                                    </div>                              
                                </li>
                            </ul>           
                        </div>          
                        </fieldset>
                </div>
                <!-- //검색 필드 박스 끝 -->
                <div id="page_info"><div id="page_info_align"></div></div>                    
                <!-- table add start -->
                <div class="default_tablestyle">
                    <table summary="권한별메뉴관리  목록화면으로 권한코드, 권한명, 권한설명, 권한별메뉴여부, 권한별메뉴으로 구성됨" cellpadding="0" cellspacing="0">
                    <caption>권한별메뉴관리 목록</caption>
                    <colgroup>
                    <col width="20%" >
                    <col width="20%" >  
                    <col width="20%" >
                    <col width="20%" >
                    <col width="20%" >
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col" class="f_field" nowrap="nowrap">권한코드</th>
                        <th scope="col" nowrap="nowrap">권한명</th>
                        <th scope="col" nowrap="nowrap">권한 설명</th>
                        <th scope="col" nowrap="nowrap">권한별메뉴여부</th>
                        <th scope="col" nowrap="nowrap">권한별메뉴</th>
                    </tr>
                    </thead>
                    <tbody>                 

                    <c:forEach var="result" items="${list_menumanage}" varStatus="status">
                    <!-- loop 시작 -->                                
                      <tr>
					    <td nowrap="nowrap"  ><c:out value="${result.authorCode}"/></td>
					    <td nowrap="nowrap"  ><c:out value="${result.authorNm}"/></td>
					    <td nowrap="nowrap"  ><c:out value="${result.authorDc}"/></td>
					    <td nowrap="nowrap"  >
					          <c:if test="${result.chkYeoBu > 0}">Y</c:if>
					          <c:if test="${result.chkYeoBu == 0}">N</c:if>
					    </td>
					    <td nowrap="nowrap" >
                            <a href="<c:url value='/sys/author/AuthorMenuSelect.do'/>?authorCode='<c:out value="${result.authorCode}"/>'"  onclick="selectAuthorMenu('<c:out value="${result.authorCode}"/>'); return false;">[권한별메뉴설정]</a>
					    </td>
                      </tr>
                     </c:forEach>     
                    </tbody>
                    </table>
                </div>

                <!-- 페이지 네비게이션 시작 -->
                <div id="paging_div">
                    <ul class="paging_align">
                        <ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="linkPage"/>
                    </ul>
                </div>                          
                <!-- //페이지 네비게이션 끝 -->  

                <input type="hidden" name="req_menuNo">
            </form>

            </div>
            <!-- //content 끝 -->    
        </div>  
        <!-- //container 끝 -->
        <!-- footer 시작 -->
        <div id="footer"><c:import url="/EgovPageLink.do?link=main/inc/IncFooter" /></div>
        <!-- //footer 끝 -->
    </div>
    <!-- //전체 레이어 끝 -->
 </body>
</html>