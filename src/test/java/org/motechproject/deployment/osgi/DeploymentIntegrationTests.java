package org.motechproject.deployment.osgi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * HelloWorld bundle integration tests suite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DeploymentWebIT.class
})
public class DeploymentIntegrationTests {
}
