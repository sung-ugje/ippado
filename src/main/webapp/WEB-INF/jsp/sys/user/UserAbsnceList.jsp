<%--
  Class Name : EgovUserAbsnceList.jsp
  Description : EgovUserAbsnceList 화면
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.07.01   lee.m.j            최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 lee.m.j
    since    : 2009.07.01
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/IpdIncPageTop.jsp"%>
<title>사용자부재 목록조회</title>

<script type="text/javaScript" language="javascript" defer="defer">
<!--
function fncSelectUserAbsnceList(pageNo) {
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/sys/user/UserAbsnceList.do'/>";
    document.listForm.submit();
}

function fncSelectUserAbsnce(userId, regYn) {
    if(regYn == 'N') {
        if(confirm("등록된 사용자부재 정보가 없습니다. 등록페이지로 이동하시겠습니까?")) {
            location.replace("<c:url value='/sys/user/UserAbsnceAdd.do'/>?userId="+userId);
        } else {
            return;
        }
    }
    document.listForm.userId.value = userId;
    document.listForm.action = "<c:url value='/sys/user/UserAbsnceUpdate.do'/>";
    document.listForm.submit();     
}


function linkPage(pageNo){
    document.listForm.searchCondition.value = "1";
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/sys/user/UserAbsnceList.do'/>";
    document.listForm.submit();
}

function press() {
    if (event.keyCode==13) {
        fncSelectUserAbsnceList('1');
    }
}
-->
</script>

</head>
<body>
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
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
              <form name="listForm" action="<c:url value='/sys/user/UserManage.do'/>" method="post">
              <input type="submit" id="invisible" class="invisible"/>
				<input type="hidden" name="userId">
				<input type="hidden" name="pageIndex" value="<c:if test="${empty userAbsnceVO.pageIndex }">1</c:if><c:if test="${!empty userAbsnceVO.pageIndex }"><c:out value='${userAbsnceVO.pageIndex}'/></c:if>">
				<input type="hidden" name="searchCondition" value="1">
                <div id="cur_loc">
                    <div id="cur_loc_align">
                        <ul>
                            <li>HOME</li>
                            <li>&gt;</li>
                            <li>사용자관리</li>
                            <li>&gt;</li>
                            <li><strong>사용자부재 관리</strong></li>
                        </ul>
                    </div>
                </div>
                <!-- 검색 필드 박스 시작 -->
                <div id="search_field">
                    <div id="search_field_loc"><h2><strong>사용자부재 관리</strong></h2></div>
                        <fieldset>
                            <legend>조건정보 영역</legend>    
                            <div class="sf_start">
                                <ul id="search_first_ul">
                                    <li>
                                        <label for="searchKeyword">사용자 명 : </label>
                                        <input id="searchKeyword" name="searchKeyword" type="text" value="<c:out value="${userAbsnceVO.searchKeyword}"/>" size="25" title="검색" onkeypress="press();" >
                                    </li>       
                                    <li>
                                        <label for="selAbsnceAt">부재여부 : </label>
    	                                <select id="selAbsnceAt" name="selAbsnceAt">
    		                                <option value="A" <c:if test="${userAbsnceVO.selAbsnceAt eq 'A'}">selected</c:if>>전체</option>
    		                                <option value="Y" <c:if test="${userAbsnceVO.selAbsnceAt eq 'Y'}">selected</c:if>>Y</option>
    		                                <option value="N" <c:if test="${userAbsnceVO.selAbsnceAt eq 'N'}">selected</c:if>>N</option>
    	                                </select>
                                    </li>       
                                </ul>
                                <ul id="search_second_ul">
                                    <li>
                                        <div class="buttons" style="float:right;">
                                            <a href="<c:url value='/sys/user/UserAbsnceList.do'/>" onclick="javascript:fncSelectUserAbsnceList('1'); return false;"><img src="<c:url value='/images/img_search.gif' />" alt="search" />조회 </a>
                                        </div>                              
                                    </li>
                                </ul>           
                            </div>          
                        </fieldset>
                    </div>
                </form>
                <!-- //검색 필드 박스 끝 -->

                <div id="page_info"><div id="page_info_align"></div></div>                    
                <!-- table add start -->
                <div class="default_tablestyle">
                    <table summary="사용자부재정보에 대한 목록을 제공한다." cellpadding="0" cellspacing="0">
                    <caption>사용자부재 관리</caption>
                    <colgroup>
                        <col width="25%" >
                        <col width="25%" >  
                        <col width="15%" >
                        <col width="15%" >
                        <col width="20%" >
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col" class="f_field" nowrap="nowrap">사용자 ID</th>
                        <th scope="col" nowrap="nowrap">사용자 명</th>
                        <th scope="col" nowrap="nowrap">부재여부</th>
                        <th scope="col" nowrap="nowrap">등록여부</th>
                        <th scope="col" nowrap="nowrap">등록일시</th>
                    </tr>
                    </thead>
                    <tbody>                 

                    <c:forEach var="userAbsnce" items="${userAbsnceList}" varStatus="status">
                    <!-- loop 시작 -->                                
                      <tr>
                        <td nowrap="nowrap">
                        <%--
					        <form name="item" method="post" action="<c:url value='/sys/user/UserAbsnceUpdate.do'/>">
					            <input type="hidden" name="userId" value="<c:out value="${userAbsnce.userId}"/>">
					            <input type="hidden" name="selAbsnceAt" value="<c:out value="${userAbsnceVO.selAbsnceAt}"/>">
					            <input type="hidden" name="pageIndex" value="<c:out value='${userAbsnceVO.pageIndex}'/>">
					            <input type="hidden" name="searchCondition" value="<c:out value='${userAbsnceVO.searchCondition}'/>">
					            <input type="hidden" name="searchKeyword" value="<c:out value="${userAbsnceVO.searchKeyword}"/>">
                                <span class="link"><c:out value="${userAbsnce.userId}"/> <input type="submit" onclick="fncSelectUserAbsnce('<c:out value="${userAbsnce.userId}"/>', '<c:out value="${userAbsnce.regYn}"/>'); return false;" value="등록"></span>
					        </form>
					         --%>
					         <span class="link"><a href="#LINK" onclick="fncSelectUserAbsnce('<c:out value="${userAbsnce.userId}"/>', '<c:out value="${userAbsnce.regYn}"/>'); return false;"><c:out value="${userAbsnce.userId}"/></a></span>
                        </td>
					    <td nowrap="nowrap"><c:out value="${userAbsnce.userNm}"/></td>
					    <td nowrap="nowrap">
					      <c:if test="${userAbsnce.userAbsnceAt eq 'Y'}" ><c:out value="Y"/></c:if>
					      <c:if test="${userAbsnce.userAbsnceAt eq 'N'}" ><c:out value="N"/></c:if>
					    </td>
					    <td nowrap="nowrap">
					      <c:if test="${userAbsnce.regYn eq 'Y'}" ><c:out value="Y"/></c:if>
					      <c:if test="${userAbsnce.regYn eq 'N'}" ><c:out value="N"/></c:if>
					    </td>
					    <td nowrap="nowrap"><c:out value="${userAbsnce.lastUpdusrPnttm}"/></td>
                      </tr>
                     </c:forEach>
                     
                     <c:if test="${empty userAbsnceList}">
                        <tr>
                            <td colspan="5">검색된 값이 없습니다.</td>
                        </tr>
                     </c:if>
                    </tbody>
                  </table>
                </div>
                <!-- 페이지 네비게이션 시작 -->
				<c:if test="${!empty userAbsnceVO.pageIndex }">
                    <div id="paging_div">
                        <ul class="paging_align">
					        <ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="linkPage" />
                        </ul>
                    </div>                          
				</c:if>
                <!-- //페이지 네비게이션 끝 -->  

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