<%--
  Class Name : EgovNormalCalPopup.jsp
  Description : EgovNormalCalPopup 화면(system)
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.04.01    이중호              최초 생성
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 이중호
    since    : 2009.04.01
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/IpdIncPageTop.jsp"%>
<title>일반달력</title>
<meta http-equiv="content-language" content="ko">
<script type="text/javaScript" language="javascript">
</script>
<style TYPE="text/css">
    form {
        margin :0px 0px 0px 0px;
    }
    iframe {
        margin :0px 0px 0px 0px;
    }
    body { 
        margin-top: 0px; margin-left: 0px;
    }
</style>
</head>
<body style="margin :0px;">
<iframe name="ifcal" src="<c:url value='/sym/cmm/EgovselectNormalCalendar.do'/>" style="width:275px; height:200px;" frameborder="0" scrolling="no" title="달력호출"></iframe>
</body>
</html>