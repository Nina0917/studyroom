# studyroom

## Install
### Tomcat
This project uses tomcat-8.5.78. Any version above tomcat-8 should work. 

[Tomcat8.5 Download Tutorial](https://www.youtube.com/watch?v=grW6afp8yE4)

### MySQL：


### IntelliJ IDEA
I am using IntelliJ IDEA as my IDE. Below is the step by step that shows how to run this project in the local server using Intellij IDEA.
* git clone the project into your local computer, use IntelliJ IDEA to open it as a project
* change the project into a web project. There are several things you need to pay attention. Open the File —> Project Structure, configure every option below the "Project 
Settings". They include "Project", "Modules", "Libraries", "Facets", "Artifacts". [Tutorial for Configue](https://blog.csdn.net/weixin_44789861/article/details/117396684)

If you find the error associated with can not resolve javax.servlet API, ___you need to included the 
javax.servlet.jar library in your project manually.___

[Add javax.servlet API in IntelliJ IDEA](https://stackoverflow.com/questions/43502232/javaconfig-the-type-javax-servlet-servletcontext-and-javax-servlet-servletexce)
