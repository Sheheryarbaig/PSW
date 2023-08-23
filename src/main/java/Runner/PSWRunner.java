package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//features = "src/main/java/FeatureFiles/Subscription/02Subscribe.feature",
//features = "src/main/java/FeatureFiles/Subscription/feature-test.feature",
        features = "src/main/java/FeatureFiles/Permits/ImportPermit.feature",
        monochrome = true,
    //   tags = "@OGA_FCL_without_import_permit_AQD or @OGA_FCL_without_import_permit_AQD_AIRLCL or @OGA_FCL_without_import_permit_AQD_LCL",
//tags="@OGA_FCL_without_import_permit_AQD_AIR_LCL",
//        tags="@Subscribe or @Subscribe_Already_Subscribed_User",

        plugin = {"json:target/cucumber.json", "pretty"},
        glue = {"Helpers",
        "Setup.Initialization"})

public class PSWRunner extends AbstractTestNGCucumberTests {


}