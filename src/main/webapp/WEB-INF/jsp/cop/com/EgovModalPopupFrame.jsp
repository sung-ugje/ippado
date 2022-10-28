<%--
  Class Name : EgovModalPopupFrame.jsp
  Description : 모달 팝업을 위한 외부 프레임
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.04.06   이삼섭              최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 이삼섭
    since    : 2009.04.06
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/IpdIncPageTop.jsp"%>
<script type="text/javascript" src="<c:url value='/js/showModalDialogCallee.js'/>" ></script>
<script type="text/javascript">
	function fn_egov_returnValue(retVal){
		setReturnValue(retVal);
		window.returnValue = retVal;
		window.close();
	}
	
	function closeWindow(){
		window.close();
	}
</script>
<title>선택 목록</title>

<style type="text/css">
	h1 {font-size:12px;}
	caption {visibility:hidden; font-size:0; height:0; margin:0; padding:0; line-height:0;}
    #iframe align:middle
</style>


</head>
<body>
	<iframe id="popupFrame" title="템플릿 목록 선택" src="<c:url value='${requestUrl}' />" width="${width}" height="${height}" frameborder="0"></iframe>
</body>
</html>