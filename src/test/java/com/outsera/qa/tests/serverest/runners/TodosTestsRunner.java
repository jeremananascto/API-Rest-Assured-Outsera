package com.outsera.qa.tests.serverest.runners;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.outsera.qa.tests.serverest")
@IncludeTags("todos")
public class TodosTestsRunner {
}
