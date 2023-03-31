package com.example.SpringbootWebApp;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.ArrayList;
import java.util.List;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {
    private List<TestResultStatus> testResultsStatus = new ArrayList<>();

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        int successCount = 0, failCount = 0;

        for (TestResultStatus results : testResultsStatus) {
            if(results == TestResultStatus.SUCCESSFUL) {
                successCount++;
            }
            else if(results == TestResultStatus.FAILED){
                failCount++;
            }
        }
        System.out.println("Test Results: " + successCount + " Tests passed, " + failCount + " Tests failed.");
    }

    private enum TestResultStatus {
        SUCCESSFUL, FAILED
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testResultsStatus.add(TestResultStatus.FAILED);
    }
}
