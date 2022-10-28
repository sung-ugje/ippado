<%--
  Class Name : EgovPasswordUpdt.jsp
  Description : 암호수정 JSP
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.03.03   JJY              최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 JJY
    since    : 2009.03.03
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/IpdIncPageTop.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<title>암호 수정</title>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="passwordChgVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
function fnListPage(){
    document.passwordChgVO.action = "<c:url value='/sys/user/UserManage.do'/>";
    document.passwordChgVO.submit();
}
function fnUpdate(){
    if(validatePasswordChgVO(document.passwordChgVO)){
        if(document.passwordChgVO.newPassword.value != document.passwordChgVO.newPassword2.value){
            alert("<spring:message code="fail.user.passwordUpdate2" />");
            return;
        }
        document.passwordChgVO.submit();
    }
}
<c:if test="${!empty resultMsg}">alert("<spring:message code="${resultMsg}" />");</c:if>
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
                <div id="cur_loc">
                    <div id="cur_loc_align">
                        <ul>
                            <li>HOME</li>
                            <li>&gt;</li>
                            <li>내부시스템관리</li>
                            <li>&gt;</li>
                            <li><strong>사용자관리</strong></li>
                        </ul>
                    </div>
                </div>
                <!-- 검색 필드 박스 시작 -->
                <div id="search_field">
                    <div id="search_field_loc"><h2><strong>업무사용자 암호변경</strong></h2></div>
                </div>

		        <form name="passwordChgVO" method="post" 
		              action="${pageContext.request.contextPath}/sys/user/UserPasswordUpdt.do" 
		              >
		              <input type="submit" id="invisible" class="invisible"/>
		              <!-- onsubmit="javascript:return FormValidation(document.passwordChgVO);" >  -->
			        <!-- 상세정보 사용자 삭제시 prameter 전달용 input -->
			        <input name="checkedIdForDel" type="hidden" />
			        <!-- 검색조건 유지 -->
			        <input type="hidden" name="searchCondition" value="<c:out value='${userSearchVO.searchCondition}'/>"/>
			        <input type="hidden" name="searchKeyword" value="<c:out value='${userSearchVO.searchKeyword}'/>"/>
			        <input type="hidden" name="sbscrbSttus" value="<c:out value='${userSearchVO.sbscrbSttus}'/>"/>
			        <input type="hidden" name="pageIndex" value="<c:out value='${userSearchVO.pageIndex}'/>"/>
			        <!-- 우편번호검색 -->
			        <input type="hidden" name="url" value="<c:url value='/sym/ccm/zip/EgovCcmZipSearchPopup.do'/>" />

                    <div class="modify_user" >
        
				        <table>
				            <tr>
				                <th width="20%" height="23" class="required_text" nowrap >사용자아이디</th>
				                <td width="80%" nowrap="nowrap">
				                    <input name="emplyrId" id="emplyrId" title="사용자아이디" type="text" size="20" value="<c:out value='${userManageVO.emplyrId}'/>"  maxlength="20" readonly="readonly"/>
				                    <input name="uniqId" id="uniqId" title="uniqId" type="hidden" size="20" value="<c:out value='${userManageVO.uniqId}'/>"/>
				                    <input name="userTy" id="userTy" title="userTy" type="hidden" size="20" value="<c:out value='${userManageVO.userTy}'/>"/>
				                </td>
				            </tr>
				            <tr> 
				                <th width="20%" height="23" class="required_text" nowrap >기존 비밀번호</th>
				                <td width="80%" nowrap="nowrap"><input name="oldPassword" id="oldPassword" title="기존 비밀번호" type="password" size="20" value=""  maxlength="100" /></td>
				            </tr>
				            <tr> 
				                <th width="20%" height="23" class="required_text" nowrap >비밀번호</th>
				                <td width="80%" nowrap="nowrap"><input name="newPassword" id="newPassword" title="비밀번호" type="password" size="20" value=""  maxlength="100" /></td>
				            </tr>
				            <tr>
				                <th width="20%" height="23" class="required_text" nowrap >비밀번호확인</th>
				                <td width="80%" nowrap="nowrap"><input name="newPassword2" id="newPassword2" title="비밀번호확인" type="password" size="20" value=""  maxlength="100" /></td>
				            </tr>
				        </table>
                    </div>

                    <!-- 버튼 시작(상세지정 style로 div에 지정) -->
                    <div class="buttons" style="padding-top:10px;padding-bottom:10px;">

                       <!-- 목록/저장버튼  -->
                       <table border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr> 
                          <!-- 수정 -->
                          <td>
                            <a href="#LINK" onclick="JavaScript:fnUpdate(); return false;"><spring:message code="button.save" /></a> 
                          </td>
                          <td width="10"></td>
                        <!-- 목록 -->
                          <td>
                            <a href="<c:url value='/sys/user/UserManage.do'/>" onclick="fnListPage(); return false;"><spring:message code="button.list" /></a>
                          </td>      
                          <td width="10"></td>
                        <!-- 취소 -->
                          <td>
                            <a href="#LINK" onclick="javascript:document.passwordChgVO.reset();"><spring:message code="button.reset" /></a>
                          </td>      

                        </tr>
                       </table>
                    </div>
                    <!-- 버튼 끝 -->                           
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

