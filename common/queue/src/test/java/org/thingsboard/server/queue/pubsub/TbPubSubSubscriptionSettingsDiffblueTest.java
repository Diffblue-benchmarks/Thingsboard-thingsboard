package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbPubSubSubscriptionSettingsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPubSubSubscriptionSettings#getCoreSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getEdgeSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getJsExecutorSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getNotificationsSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getRuleEngineSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getTransportApiSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getVcSettings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Map TbPubSubSubscriptionSettings.getCoreSettings()",
    "Map TbPubSubSubscriptionSettings.getEdgeSettings()",
    "Map TbPubSubSubscriptionSettings.getJsExecutorSettings()",
    "Map TbPubSubSubscriptionSettings.getNotificationsSettings()",
    "Map TbPubSubSubscriptionSettings.getRuleEngineSettings()",
    "Map TbPubSubSubscriptionSettings.getTransportApiSettings()",
    "Map TbPubSubSubscriptionSettings.getVcSettings()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings = new TbPubSubSubscriptionSettings();

    // Act
    Map<String, String> actualCoreSettings = tbPubSubSubscriptionSettings.getCoreSettings();
    Map<String, String> actualEdgeSettings = tbPubSubSubscriptionSettings.getEdgeSettings();
    Map<String, String> actualJsExecutorSettings =
        tbPubSubSubscriptionSettings.getJsExecutorSettings();
    Map<String, String> actualNotificationsSettings =
        tbPubSubSubscriptionSettings.getNotificationsSettings();
    Map<String, String> actualRuleEngineSettings =
        tbPubSubSubscriptionSettings.getRuleEngineSettings();
    Map<String, String> actualTransportApiSettings =
        tbPubSubSubscriptionSettings.getTransportApiSettings();

    // Assert
    assertNull(actualCoreSettings);
    assertNull(actualEdgeSettings);
    assertNull(actualJsExecutorSettings);
    assertNull(actualNotificationsSettings);
    assertNull(actualRuleEngineSettings);
    assertNull(actualTransportApiSettings);
    assertNull(tbPubSubSubscriptionSettings.getVcSettings());
  }
}
