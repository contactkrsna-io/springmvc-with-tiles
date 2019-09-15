<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">    
<html>    
<head>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
<title><tiles:insertAttribute name="title" ignore="true" /></title>    

<link href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js" ></script>

<link   href="${pageContext.request.contextPath}/static/css/main.css"  rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>

</head>   
 
        <div>
	        <tiles:insertAttribute name="header" />
        </div>    
        
        <body class="d-flex flex-column">
			  <div id="page-content">
			    	<tiles:insertAttribute name="body" />  
			  </div>
			 <tiles:insertAttribute name="footer" />   
		</body>
        
        
        
         
</html>    