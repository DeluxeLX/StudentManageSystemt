<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/liaozihaoUser.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username"/>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index">
				<a href="${pageContext.request.contextPath}/pages/main.jsp">
					<i class="fa fa-dashboard"></i>
					<span>首页</span>
				</a>
			</li>

			<%--<li class="treeview">
				<a href="#">
					<i class="fa fa-sticky-note-o"></i>
					<span>成绩管理</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li id="system-setting78">
						<a href="${pageContext.request.contextPath}/Grade/findAllGrade.do">
							<i class="fa fa-circle-o"></i> 学生成绩管理
						</a>
					</li>
				</ul>
			</li>--%>

			<security:authorize access="hasRole('ADMIN')">
				<li class="treeview">
					<a href="#"> <i class="fa fa-cube"></i>
						<span>学生数据</span>
						<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
					</a>
					<ul class="treeview-menu">
						<li id="system-setting5">
							<a href="${pageContext.request.contextPath}/student/findAllStudent.do">
								<i class="fa fa-circle-o"></i> 学生信息
							</a>
						</li>
					</ul>
				</li>

				<li class="treeview">
					<a href="#">
						<i class="fa fa-cogs"></i>
						<span>信息管理</span>
						<span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>

					<ul class="treeview-menu">
						<li id="system-setting2">
							<a href="${pageContext.request.contextPath}/change/findAllChange.do">
								<i class="fa fa-circle-o"></i> 学籍更改管理
							</a>
						</li>
						<li id="system-setting3">
							<a href="${pageContext.request.contextPath}/reward/findAllReward.do">
								<i class="fa fa-circle-o"></i> 奖励奖金管理
							</a>
						</li>
						<li id="system-setting4">
							<a href="${pageContext.request.contextPath}/punishment/findAllPunishment.do">
								<i class="fa fa-circle-o"></i> 处罚情况管理
							</a>
						</li>
					</ul>
				</li>
			</security:authorize>
			<security:authorize access="hasRole('USER')">
				<li class="treeview">
					<a href="#">
						<i class="fa fa-sticky-note-o"></i>
						<span>选课管理</span>
						<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
					</a>
					<ul class="treeview-menu">
						<li id="system-setting6">
							<a href="${pageContext.request.contextPath}/course/findAllCourse.do">
								<i class="fa fa-circle-o"></i> 学生选课
							</a>
						</li>
						<li id="system-setting8">
							<a href="${pageContext.request.contextPath}/course/courseTable.do">
								<i class="fa fa-circle-o"></i> 课表查询
							</a>
						</li>
						<li id="system-setting7">
							<a href="${pageContext.request.contextPath}/course/findAllScoreByOneStudent.do">
								<i class="fa fa-circle-o"></i> 个人成绩
							</a>
						</li>
					</ul>
				</li>
			</security:authorize>
			<security:authorize access="hasRole('TEACHER')">
				<li class="treeview">
					<a href="#">
						<i class="fa fa-book"></i>
						<span>教师课程管理</span>
						<span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li id="system-setting10">
							<a href="${pageContext.request.contextPath}/teacher/findCourseBySelf.do">
								<i class="fa fa-circle-o"></i> 课程设置申请
							</a>
						</li>
						<li id="system-setting8=11">
							<a href="${pageContext.request.contextPath}/teacher/findScoreList.do">
								<i class="fa fa-circle-o"></i> 学员成绩管理
							</a>
						</li>
					</ul>
				</li>
			</security:authorize>
			<security:authorize access="hasRole('ADMIN')">
				<li class="treeview">
					<a href="#">
						<i class="fa fa-calendar"></i>
						<span>课程审批管理</span>
						<span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li id="system-setting18">
							<a href="${pageContext.request.contextPath}/education/findCourseByApply.do">
								<i class="fa fa-circle-o"></i> 课程设置审批
							</a>
						</li>
						<li id="system-setting1l">
							<a href="${pageContext.request.contextPath}/education/findAllCourseList.do">
								<i class="fa fa-circle-o"></i> 教学安排
							</a>
						</li>
					</ul>
				</li>
			</security:authorize>
			<security:authorize access="hasRole('ADMIN')">
				<li id="admin-documentation">
					<a href="${pageContext.request.contextPath}/sysLog/findAll.do">
						<i class="fa fa-user"></i>
						<span>访问日志</span>
					</a>
				</li>
			</security:authorize>

			<li id="admin-documentation">
				<a href="${pageContext.request.contextPath}/pages/chat.jsp">
					<i class="fa fa-commenting-o"></i>
					<span>智能AI客服</span>
				</a>
			</li>

			<%--<li id="admin-documentation2">
				<a href="${pageContext.request.contextPath}/AboutUs/main.do">
					<i class="fa fa-user"></i>
					<span>关于作者</span>
				</a>
			</li>--%>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>