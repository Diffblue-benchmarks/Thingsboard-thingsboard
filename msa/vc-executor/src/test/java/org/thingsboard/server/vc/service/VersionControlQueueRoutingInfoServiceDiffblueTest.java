package org.thingsboard.server.vc.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {VersionControlQueueRoutingInfoService.class})
@ExtendWith(SpringExtension.class)
class VersionControlQueueRoutingInfoServiceDiffblueTest {
  @Autowired
  private VersionControlQueueRoutingInfoService versionControlQueueRoutingInfoService;

  /**
   * Test {@link VersionControlQueueRoutingInfoService#getAllQueuesRoutingInfo()}.
   * <p>
   * Method under test: {@link VersionControlQueueRoutingInfoService#getAllQueuesRoutingInfo()}
   */
  @Test
  @DisplayName("Test getAllQueuesRoutingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List VersionControlQueueRoutingInfoService.getAllQueuesRoutingInfo()"})
  void testGetAllQueuesRoutingInfo() {
    // Arrange, Act and Assert
    assertTrue(versionControlQueueRoutingInfoService.getAllQueuesRoutingInfo().isEmpty());
  }
}
