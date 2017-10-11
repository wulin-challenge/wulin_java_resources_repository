<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
 	<%@ include file="/WEB-INF/jsp/primary/common/common.jsp" %>
  </head>
  
  <body>
    
			<ul id="tt1"  class="easyui-tree" animate="true" dnd="true" >
				<li state="closed">
				<span >Folder</span>
					<ul>
						<li state="closed">
							<span>Sub Folder 1</span>
							<ul>
								<li>
									<span><a href="#">File 11</a></span>
								</li>
								<li>
									<span>File 12</span>
								</li>
								<li>
									<span>File 13</span>
								</li>
							</ul>
						</li>
						<li>
							<span>File 2</span>
						</li>
						<li>
							<span>File 3</span>
						</li>
						<li>File 4</li>
						<li>File 5</li>
					</ul>
				</li>
				<li>
					<span><a href="javascript:addPage()">添加页面</a></span>
				</li>
			</ul>
		
  </body>
</html>
