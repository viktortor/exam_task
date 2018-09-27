This project automates the testing of search on the Google site.
You need do next steps to run this project:
1. Install JDK.
Find in google.com «jdk» (Java SE Development Kit ) or download installation package from: https://www.oracle.com/technetwork/java/javase/downloads/index.html
2. Install Intellij idea.
Find in google.com «intellij idea» or download installation package from: https://www.jetbrains.com/idea/download
3. Install Chrome browser
Find in google.com «chrome browser» or download installation package from: https://www.google.com/chrome/
4. Install ChromeDriver
Find in google.com «ChromeDriver» or download installation package from: https://sites.google.com/a/chromium.org/chromedriver/downloads
5. Install Selenium WD
Find in google.com «selenium webdriver» or download installation package from: https://www.seleniumhq.org/download/
Extract the content from downloaded file to your directory
6. Install Apache Maven
Find in google.com «apache maven» or download installation package from: https://maven.apache.org/download.cgi
Extract the content from downloaded file to your directory
7. Install Git utility
Download installation package from: https://gitforwindows.org/
8. Make sure utilities are included into your PATH variable
*<path to>\selenium-java-3.14.0
*<path to>\chromedriver_win32
*<path to>\Git\cmd
*<path to>\apache-maven-3.5.4\bin
9. Start Intellij idea and create new maven project:
9.1 File - New - Project
9.2 choose Maven and click Next
9.3 enter GroupId and ArtifactId. Click Finish
10. Clone project from GitHub with HTTPS:
10.1 VCS - Checkout from Version Control - Git
10.2 Enter link into field URL - https://github.com/viktortor/exam_task.git
10.3 click Clone button
10.4 Choose your directory
10.5 Import project from external model
10.6 Mark Maven and click Next
10.7 Click Next
10.8 Click Next
10.9 Click Next
10.10 Click Finish

You have three ways to run these tests:
- use login-test-2-browsers.xml
    *mark login-test-2-browsers.xml
    *open Context Menu
    *choose Run '<your path to file login-test-2-browsers.xml>/login-test-2-browsers.xml'
- use GoogleSearchTest
    *open GoogleSearchTest from folder <project_name>/src/test/java/test/
    *find annotation @Test
    *open @Test Context Menu
    *choose Run 'successfullSearchTest()'
- use command line:
    *go to terminal in intellij idea
    *execute command: mvn clean install



