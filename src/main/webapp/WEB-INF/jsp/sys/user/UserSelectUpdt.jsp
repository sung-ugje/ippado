<%--
  Class Name : EgovUserSelectUpdt.jsp
  Description : 사용자상세조회, 수정 JSP
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
<title>사용자 상세 및 수정</title>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="userManageVO" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javascript" src="<c:url value='/js/EgovZipPopup.js' />" ></script>
<script type="text/javaScript" language="javascript" defer="defer">

function fnListPage(){
    document.userManageVO.action = "<c:url value='/sys/user/UserManage.do'/>";
    document.userManageVO.submit();
}
function fnDeleteUser(checkedIds) {
    if(confirm("<spring:message code="common.delete.msg" />")){
        document.userManageVO.checkedIdForDel.value=checkedIds;
        document.userManageVO.action = "<c:url value='/sys/user/UserDelete.do'/>";
        document.userManageVO.submit(); 
    }
}
function fnPasswordMove(){
    document.userManageVO.action = "<c:url value='/sys/user/UserPasswordUpdtView.do'/>";
    document.userManageVO.submit();
}
function fnUpdate(){
    if(validateUserManageVO(document.userManageVO)){
        document.userManageVO.submit();
    }
}

function fn_egov_dn_info_setting(dn) {
    var frm = document.userManageVO;
    
    frm.subDn.value = dn;
}

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
                    <div id="search_field_loc"><h2><strong>업무사용자 상세조회(수정)</strong></h2></div>
                </div>
		        <form:form commandName="userManageVO" action="${pageContext.request.contextPath}/sys/user/UserSelectUpdt.do" name="userManageVO" method="post" >
		        
			        <!-- 상세정보 사용자 삭제시 prameter 전달용 input -->
			        <input name="checkedIdForDel" type="hidden" />
			        <!-- 검색조건 유지 -->
			        <input type="hidden" name="searchCondition" value="<c:out value='${userSearchVO.searchCondition}'/>"/>
			        <input type="hidden" name="searchKeyword" value="<c:out value='${userSearchVO.searchKeyword}'/>"/>
			        <input type="hidden" name="sbscrbSttus" value="<c:out value='${userSearchVO.sbscrbSttus}'/>"/>
			        <input type="hidden" name="pageIndex" value="<c:out value='${userSearchVO.pageIndex}'/>"/>
			        <!-- 우편번호검색 -->
			        <input type="hidden" name="zip_url" value="<c:url value='/sym/cmm/EgovCcmZipSearchPopup.do'/>" />
			        <!-- 사용자유형정보 : password 수정화면으로 이동시 타겟 유형정보 확인용, 만약검색조건으로 유형이 포함될경우 혼란을 피하기위해 userTy명칭을 쓰지 않음-->
			        <input type="hidden" name="userTyForPassword" value="<c:out value='${userManageVO.userTy}'/>" />

                    <div class="modify_user" >
                        <table>
                            <tr> 
                                <th width="20%" height="23" class="required_text"  >사용자아이디
                                    <img src="<c:url value='/'/>images/required.gif" width="15" height="15" alt="필수" />
                                </th>
				                <td width="30%" >
				                    <form:input path="emplyrId" id="emplyrId" cssClass="txaIpt" size="20" maxlength="20" readonly="readonly" />
				                    <form:errors path="emplyrId" cssClass="error"/>
				                    <form:hidden path="uniqId" />
				                </td>
				                <th width="20%" height="23" class="required_text"  >핸드폰번호&nbsp;&nbsp;</th>
				                <td width="30%" >
				                    <form:input path="moblphonNo" id="moblphonNo" cssClass="txaIpt" size="20" maxlength="15" />
				                    <form:errors path="moblphonNo" cssClass="error" />
				                </td>
                            </tr>
                            <tr> 
                                <th width="20%" height="23" class="required_text">이름
                                    <img src="<c:url value='/'/>images/required.gif" width="15" height="15" alt="필수" />
                                </th>
				                <td width="30%" >
				                    <form:input path="emplyrNm" id="emplyrNm" cssClass="txaIpt" size="20"  maxlength="60" />
				                    <form:errors path="emplyrNm" cssClass="error" />
				                </td>
                                <th width="20%" height="23" class="required_text" >이메일주소
                                </th>
				                <td width="30%" >
				                    <form:input path="emailAdres" id="emailAdres" cssClass="txaIpt" size="20" maxlength="50" />
				                    <form:errors path="emailAdres" cssClass="error" />
				                </td>
                            </tr>

                            <tr> 
                                <th width="20%" height="23" class="required_text"  > 사용자상태코드
                                    <img src="<c:url value='/'/>images/required.gif" width="15" height="15" alt="필수" />
                                </th>
				                <td width="30%" >
				                    <form:select path="emplyrSttusCode" id="emplyrSttusCode">
				                        <form:option value="" label="--선택하세요--"/>
				                        <form:options items="${emplyrSttusCode_result}" itemValue="code" itemLabel="codeNm"/>
				                    </form:select>
				                    <form:errors path="emplyrSttusCode" cssClass="error"/>
				                </td>
                                <th width="20%" height="23" class="required_text"  > 권한코드</th>
				                <td width="30%" >
				                    <input type="text" disabled="disabled" value="<c:out value="${userManageVO.groupId }"/>" >
				                    <form:errors path="groupId" cssClass="error" />
				                </td>
                            </tr>
                        </table>
                    </div>

                    <!-- 버튼 시작(상세지정 style로 div에 지정) -->
                    <div class="buttons" style="padding-top:10px;padding-bottom:10px;" >
                       <!-- 목록/저장버튼  -->
                       <table border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr> 
                          <td>
                            <a href="#LINK" onclick="JavaScript:fnUpdate(); return false;"><spring:message code="button.save" /></a>
                          </td>
                          <td width="10"></td>
                          <td>
                            <a href="<c:url value='/sys/user/UserDelete.do'/>" onclick="fnDeleteUser('<c:out value='${userManageVO.userTy}'/>:<c:out value='${userManageVO.uniqId}'/>'); return false;"><spring:message code="button.delete" /></a> 
                          </td>
                          <td width="10"></td>
                          <td>
                            <a href="<c:url value='/sys/user/UserManage.do'/>" onclick="fnListPage(); return false;"><spring:message code="button.list" /></a>
                          </td>      
                          <td width="10"></td>
                          <td>
                            <a href="<c:url value='/sys/user/UserPasswordUpdtView.do'/>" onclick="fnPasswordMove(); return false;"><spring:message code="button.passwordUpdate" /></a>
                          </td>      
                          <td width="10"></td>
                          <td>
                            <a href="#LINK" onclick="javascript:document.userManageVO.reset();"><spring:message code="button.reset" /></a>
                          </td>      

                        </tr>
                       </table>
                    </div>
                    <!-- 버튼 끝 -->    
                    <form:hidden path="password" />                       
                </form:form>

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

