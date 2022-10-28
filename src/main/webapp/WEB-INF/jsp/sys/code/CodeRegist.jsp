<%--
  Class Name : EgovCcmCmmnCodeRegist.jsp
  Description : EgovCcmCmmnCodeRegist 화면
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.04.01   이중호              최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 이중호
    since    : 2009.04.01
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/IpdIncPageTop.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<title>공통코드 등록</title>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="cmmnCode" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">
<!--
/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_egov_list_CmmnCode(){
    location.href = "<c:url value='/sys/code/CodeList.do'/>";
}
/* ********************************************************
 * 저장처리화면
 ******************************************************** */
 function fn_egov_regist_CmmnCode(form){
    if(confirm("<spring:message code='common.save.msg'/>")){
        if(!validateCmmnCode(form)){            
            return;
        }else{
            form.submit();
        }
    }
}
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
                            <li>코드관리</li>
                            <li>&gt;</li>
                            <li><strong>공통코드관리</strong></li>
                        </ul>
                    </div>
                </div>
                <!-- 검색 필드 박스 시작 -->
                <div id="search_field">
                    <div id="search_field_loc"><h2><strong>공통코드 등록</strong></h2></div>
                </div>

                <form:form commandName="cmmnCode" name="cmmnCode" method="post">

                    <div class="modify_user" >
                        <table summary="분류코드, 코드ID, 코드ID명, 코드ID설명, 사용여부를 입력하는 공통코드 등록 테이블이다.">
						  <tr>
						    <th width="20%" height="23" class="required_text" scope="row" nowrap ><label for="clCode">분류코드</label><img src="${ImgUrl}/required.gif" alt="필수"  width="15" height="15"></th>          
						    <td width="80%" nowrap colspan="3">
						        <select name="clCode" class="select" id="clCode">
						            <c:forEach var="result" items="${cmmnClCode}" varStatus="status">
						                <option value='<c:out value="${result.clCode}"/>'><c:out value="${result.clCodeNm}"/></option>
						            </c:forEach>                       
						        </select>
						    </td>
						  </tr> 
						  <tr>
						    <th width="20%" height="23" class="required_text" scope="row" nowrap ><label for="codeId">코드ID</label><img src="${ImgUrl}/required.gif" alt="필수"  width="15" height="15"></th>          
						    <td width="80%" nowrap colspan="3">
						      <form:input  path="codeId" size="6" maxlength="6" id="codeId"/>
						      <form:errors path="codeId"/>
						    </td>
						  </tr> 
						  <tr>
						    <th width="20%" height="23" class="required_text" scope="row" nowrap ><label for="codeIdNm">코드ID명</label><img src="${ImgUrl}/required.gif" alt="필수"  width="15" height="15"></th>          
						    <td width="80%" nowrap="nowrap">
						      <form:input  path="codeIdNm" size="60" maxlength="60" id="codeIdNm"/>
						      <form:errors path="codeIdNm"/>
						    </td>    
						  </tr> 
						  <tr> 
						    <th height="23" class="required_text" scope="row" ><label for="codeIdDc">코드ID설명</label><img src="${ImgUrl}/required.gif" alt="필수"  width="15" height="15"></th>
						    <td>
						      <form:textarea path="codeIdDc" cols="100" rows="5" id="codeIdDc"/>
						      <form:errors   path="codeIdDc"/>
						    </td>
						  </tr> 
						  <tr> 
						    <th width="20%" height="23" class="required_text" scope="row" nowrap ><label for="useAt">사용여부</label><img src="${ImgUrl}/required.gif" alt="필수"  width="15" height="15"></th>
						    <td width="30%" nowrap class="title_left" colspan="3">
						      <form:select path="useAt" id="useAt">
						          <form:option value="Y" label="Yes"/>
						          <form:option value="N" label="No"/>
						      </form:select>
						    </td>    
						  </tr>     
                        </table>
                    </div>

                    <!-- 버튼 시작(상세지정 style로 div에 지정) -->
                    <div class="buttons" style="padding-top:10px;padding-bottom:10px;">
                        <!-- 목록/저장버튼  -->
                        <table border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr> 
                          <td>
                            <a href="#noscript" onclick="fn_egov_list_CmmnCode(); return false;">목록</a>
                          </td>
                          <td width="10"></td>
                          <td>
                            <a href="#noscript" onclick="fn_egov_regist_CmmnCode(document.cmmnCode); return false;">저장</a> 
                          </td>
                        </tr>
                        </table>
                    </div>
                    <!-- 버튼 끝 -->                           

                    <!-- 검색조건 유지 -->
                    <input name="cmd" type="hidden" value="<c:out value='save'/>"/>
                    <!-- 검색조건 유지 -->
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

