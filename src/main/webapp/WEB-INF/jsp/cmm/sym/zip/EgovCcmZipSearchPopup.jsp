<%--
  Class Name : EgovCcmZipSearchPopup.jsp
  Description : EgovCcmZipSearchPopup 화면
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
<title>우편번호 찾기</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/zip.css'/>" >
</head>
<body>
<form name="pForm" action="<c:url value='sym/cmm/EgovCcmZipSearchPopup.do'/>">
<input type="submit" id="invisible" class="invisible"/>
<input type="hidden" name="init" value="">
</form>
<!-- IE
<iframe name="ifcal" src="<c:url value='/sym/cmm/EgovCcmZipSearchList.do'/>" style="width:500px; height:325px;" frameborder=0></iframe>
-->
<!-- FIREFOX -->
<iframe name="ifcal" title="우편번호찾기 팝업" src="<c:url value='/sym/cmm/EgovCcmZipSearchList.do'/>" style="width:560px; height:340px;" frameborder=0></iframe>
</body>
</html>