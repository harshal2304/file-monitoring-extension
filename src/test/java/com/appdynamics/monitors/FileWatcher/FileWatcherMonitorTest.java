package com.appdynamics.monitors.FileWatcher;

import com.appdynamics.extensions.fileWatcher.FileWatcherMonitor;
import com.singularity.ee.agent.systemagent.api.exception.TaskExecutionException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhi.pandey on 9/4/14.
 */
public class FileWatcherMonitorTest {

    private static final String CONFIG_ARG = "config-file";

    private FileWatcherMonitor testClass;

    @Before
    public void init() throws Exception {
        testClass = new FileWatcherMonitor();
    }


    @Test(expected = TaskExecutionException.class)
    public void testWithNullArgsShouldResultInException() throws Exception {
        testClass.execute(null, null);
    }

    @Test(expected = TaskExecutionException.class)
    public void testWithEmptyArgsShouldResultInException() throws Exception {
        testClass.execute(new HashMap<String, String>(), null);
    }

    @Test
    public void testFileWatcherExtension() throws TaskExecutionException {

        Map<String, String> taskArgs = new HashMap();
        taskArgs.put(CONFIG_ARG, "src/test/resources/conf/config.yml");
        try {
            while(true)
            testClass.execute(taskArgs, null);
        } catch (TaskExecutionException e) {
            e.printStackTrace();
        }
    }
}
