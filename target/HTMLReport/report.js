$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/pageClasses/BugCreation.feature");
formatter.feature({
  "line": 1,
  "name": "To test Bugzilla bug creation",
  "description": "",
  "id": "to-test-bugzilla-bug-creation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 624600,
  "error_message": "java.lang.RuntimeException: D:\\EclipseProject\\MavenCuc\\target\\test-classes\\config.properties (The system cannot find the file specified)\r\n\tat utilsPackage.ReadConfigProperties.getDataFromeProperties(ReadConfigProperties.java:47)\r\n\tat utilsPackage.ReadConfigProperties.initPropertiesFile(ReadConfigProperties.java:16)\r\n\tat utilsPackage.ReadConfigProperties.\u003cinit\u003e(ReadConfigProperties.java:26)\r\n\tat webDriverServices.DriverServices.launchBrowser(DriverServices.java:33)\r\n\tat webDriverServices.DriverServices.\u003cinit\u003e(DriverServices.java:73)\r\n\tat sun.reflect.GeneratedConstructorAccessor8.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.picocontainer.injectors.AbstractInjector.newInstance(AbstractInjector.java:145)\r\n\tat org.picocontainer.injectors.ConstructorInjector$1.run(ConstructorInjector.java:342)\r\n\tat org.picocontainer.injectors.AbstractInjector$ThreadLocalCyclicDependencyGuard.observe(AbstractInjector.java:270)\r\n\tat org.picocontainer.injectors.ConstructorInjector.getComponentInstance(ConstructorInjector.java:364)\r\n\tat org.picocontainer.injectors.AbstractInjectionFactory$LifecycleAdapter.getComponentInstance(AbstractInjectionFactory.java:56)\r\n\tat org.picocontainer.behaviors.AbstractBehavior.getComponentInstance(AbstractBehavior.java:64)\r\n\tat org.picocontainer.behaviors.Stored.getComponentInstance(Stored.java:91)\r\n\tat org.picocontainer.DefaultPicoContainer.getInstance(DefaultPicoContainer.java:699)\r\n\tat org.picocontainer.DefaultPicoContainer.getComponent(DefaultPicoContainer.java:647)\r\n\tat org.picocontainer.DefaultPicoContainer.getComponent(DefaultPicoContainer.java:632)\r\n\tat org.picocontainer.parameters.BasicComponentParameter$1.resolveInstance(BasicComponentParameter.java:118)\r\n\tat org.picocontainer.parameters.ComponentParameter$1.resolveInstance(ComponentParameter.java:136)\r\n\tat org.picocontainer.injectors.SingleMemberInjector.getParameter(SingleMemberInjector.java:78)\r\n\tat org.picocontainer.injectors.ConstructorInjector$CtorAndAdapters.getParameterArguments(ConstructorInjector.java:309)\r\n\tat org.picocontainer.injectors.ConstructorInjector$1.run(ConstructorInjector.java:335)\r\n\tat org.picocontainer.injectors.AbstractInjector$ThreadLocalCyclicDependencyGuard.observe(AbstractInjector.java:270)\r\n\tat org.picocontainer.injectors.ConstructorInjector.getComponentInstance(ConstructorInjector.java:364)\r\n\tat org.picocontainer.injectors.AbstractInjectionFactory$LifecycleAdapter.getComponentInstance(AbstractInjectionFactory.java:56)\r\n\tat org.picocontainer.behaviors.AbstractBehavior.getComponentInstance(AbstractBehavior.java:64)\r\n\tat org.picocontainer.behaviors.Stored.getComponentInstance(Stored.java:91)\r\n\tat org.picocontainer.DefaultPicoContainer.getInstance(DefaultPicoContainer.java:699)\r\n\tat org.picocontainer.DefaultPicoContainer.getComponent(DefaultPicoContainer.java:647)\r\n\tat org.picocontainer.DefaultPicoContainer.getComponent(DefaultPicoContainer.java:678)\r\n\tat cucumber.runtime.java.picocontainer.PicoFactory.getInstance(PicoFactory.java:40)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat cucumber.api.testng.AbstractTestNGCucumberTests.feature(AbstractTestNGCucumberTests.java:21)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:133)\r\n\tat org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:584)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:172)\r\n\tat org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)\r\n\tat org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:804)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:145)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)\r\n\tat java.util.ArrayList.forEach(Unknown Source)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:770)\r\n\tat org.testng.TestRunner.run(TestRunner.java:591)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:402)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:396)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:355)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:304)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1180)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1102)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1032)\r\n\tat org.testng.TestNG.run(TestNG.java:1000)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 3,
  "name": "Bugzilla test",
  "description": "",
  "id": "to-test-bugzilla-bug-creation;bugzilla-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Bugzilla_I am at buzilla home page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Bugzilla_I click on file a bug and navigate to login page",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Bugzilla_I log into the application and navigate to enter bug page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Bugzilla_I provide the details component as \"TestComponent\" version as \"unspecified\" severity as \"normal\" hardware as \"Other\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Bugzilla_I provide other details like operating system as \"Linux\" priority as \"Normal\" summery as \"Bug details\" description as \"Test Bugzilla\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Bugzilla_I select submit bug button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Bugzilla_I am at summery page and i click logout button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Bugzilla_I check the page title",
  "rows": [
    {
      "cells": [
        "Bugzilla"
      ],
      "line": 12
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "BugCreationStepDefnition.bugzilla_i_am_at_buzilla_home_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BugCreationStepDefnition.bugzilla_i_click_on_file_a_bug_and_navigate_to_login_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BugCreationStepDefnition.bugzilla_i_log_into_the_application_and_navigate_to_enter_bug_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "TestComponent",
      "offset": 45
    },
    {
      "val": "unspecified",
      "offset": 72
    },
    {
      "val": "normal",
      "offset": 98
    },
    {
      "val": "Other",
      "offset": 119
    }
  ],
  "location": "BugCreationStepDefnition.bugzilla_i_provide_the_details_component_as_version_as_severity_as_hardware_as(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Linux",
      "offset": 59
    },
    {
      "val": "Normal",
      "offset": 79
    },
    {
      "val": "Bug details",
      "offset": 99
    },
    {
      "val": "Test Bugzilla",
      "offset": 128
    }
  ],
  "location": "BugCreationStepDefnition.bugzilla_i_provide_other_details_like_operating_system_as_priority_as_summery_as_description_as(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BugCreationStepDefnition.bugzilla_i_select_submit_bug_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BugCreationStepDefnition.bugzilla_i_am_at_summery_page_and_i_click_logout_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BugCreationStepDefnition.bugzilla_i_check_the_page_title(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 362000,
  "error_message": "java.lang.RuntimeException: D:\\EclipseProject\\MavenCuc\\target\\test-classes\\config.properties (The system cannot find the file specified)\r\n\tat utilsPackage.ReadConfigProperties.getDataFromeProperties(ReadConfigProperties.java:47)\r\n\tat utilsPackage.ReadConfigProperties.initPropertiesFile(ReadConfigProperties.java:16)\r\n\tat utilsPackage.ReadConfigProperties.\u003cinit\u003e(ReadConfigProperties.java:26)\r\n\tat webDriverServices.DriverServices.launchBrowser(DriverServices.java:33)\r\n\tat webDriverServices.DriverServices.\u003cinit\u003e(DriverServices.java:73)\r\n\tat sun.reflect.GeneratedConstructorAccessor8.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.picocontainer.injectors.AbstractInjector.newInstance(AbstractInjector.java:145)\r\n\tat org.picocontainer.injectors.ConstructorInjector$1.run(ConstructorInjector.java:342)\r\n\tat org.picocontainer.injectors.AbstractInjector$ThreadLocalCyclicDependencyGuard.observe(AbstractInjector.java:270)\r\n\tat org.picocontainer.injectors.ConstructorInjector.getComponentInstance(ConstructorInjector.java:364)\r\n\tat org.picocontainer.injectors.AbstractInjectionFactory$LifecycleAdapter.getComponentInstance(AbstractInjectionFactory.java:56)\r\n\tat org.picocontainer.behaviors.AbstractBehavior.getComponentInstance(AbstractBehavior.java:64)\r\n\tat org.picocontainer.behaviors.Stored.getComponentInstance(Stored.java:91)\r\n\tat org.picocontainer.DefaultPicoContainer.getInstance(DefaultPicoContainer.java:699)\r\n\tat org.picocontainer.DefaultPicoContainer.getComponent(DefaultPicoContainer.java:647)\r\n\tat org.picocontainer.DefaultPicoContainer.getComponent(DefaultPicoContainer.java:632)\r\n\tat org.picocontainer.parameters.BasicComponentParameter$1.resolveInstance(BasicComponentParameter.java:118)\r\n\tat org.picocontainer.parameters.ComponentParameter$1.resolveInstance(ComponentParameter.java:136)\r\n\tat org.picocontainer.injectors.SingleMemberInjector.getParameter(SingleMemberInjector.java:78)\r\n\tat org.picocontainer.injectors.ConstructorInjector$CtorAndAdapters.getParameterArguments(ConstructorInjector.java:309)\r\n\tat org.picocontainer.injectors.ConstructorInjector$1.run(ConstructorInjector.java:335)\r\n\tat org.picocontainer.injectors.AbstractInjector$ThreadLocalCyclicDependencyGuard.observe(AbstractInjector.java:270)\r\n\tat org.picocontainer.injectors.ConstructorInjector.getComponentInstance(ConstructorInjector.java:364)\r\n\tat org.picocontainer.injectors.AbstractInjectionFactory$LifecycleAdapter.getComponentInstance(AbstractInjectionFactory.java:56)\r\n\tat org.picocontainer.behaviors.AbstractBehavior.getComponentInstance(AbstractBehavior.java:64)\r\n\tat org.picocontainer.behaviors.Stored.getComponentInstance(Stored.java:91)\r\n\tat org.picocontainer.DefaultPicoContainer.getInstance(DefaultPicoContainer.java:699)\r\n\tat org.picocontainer.DefaultPicoContainer.getComponent(DefaultPicoContainer.java:647)\r\n\tat org.picocontainer.DefaultPicoContainer.getComponent(DefaultPicoContainer.java:678)\r\n\tat cucumber.runtime.java.picocontainer.PicoFactory.getInstance(PicoFactory.java:40)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:206)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat cucumber.api.testng.AbstractTestNGCucumberTests.feature(AbstractTestNGCucumberTests.java:21)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:133)\r\n\tat org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:584)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:172)\r\n\tat org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)\r\n\tat org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:804)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:145)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)\r\n\tat java.util.ArrayList.forEach(Unknown Source)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:770)\r\n\tat org.testng.TestRunner.run(TestRunner.java:591)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:402)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:396)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:355)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:304)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1180)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1102)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1032)\r\n\tat org.testng.TestNG.run(TestNG.java:1000)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\n",
  "status": "failed"
});
});