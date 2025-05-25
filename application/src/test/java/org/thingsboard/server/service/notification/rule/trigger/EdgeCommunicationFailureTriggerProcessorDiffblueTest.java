package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.EdgeCommunicationFailureNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.EdgeCommunicationFailureTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeCommunicationFailureNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {EdgeCommunicationFailureTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class EdgeCommunicationFailureTriggerProcessorDiffblueTest {
  @Autowired
  private EdgeCommunicationFailureTriggerProcessor edgeCommunicationFailureTriggerProcessor;

  /**
   * Test {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)} with {@code EdgeCommunicationFailureTrigger}, {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeCommunicationFailureTriggerProcessor.matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig() {
    // Arrange, Act and Assert
    assertTrue(edgeCommunicationFailureTriggerProcessor.matchesFilter(null,
        new EdgeCommunicationFailureNotificationRuleTriggerConfig()));
  }

  /**
   * Test {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)} with {@code EdgeCommunicationFailureTrigger}, {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeCommunicationFailureTriggerProcessor.matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig2() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig triggerConfig = new EdgeCommunicationFailureNotificationRuleTriggerConfig();
    triggerConfig.setEdges(new HashSet<>());

    // Act and Assert
    assertTrue(edgeCommunicationFailureTriggerProcessor.matchesFilter(null, triggerConfig));
  }

  /**
   * Test {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)} with {@code EdgeCommunicationFailureTrigger}, {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeCommunicationFailureTriggerProcessor.matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig3() {
    // Arrange
    EdgeCommunicationFailureTrigger trigger = mock(EdgeCommunicationFailureTrigger.class);
    when(trigger.getEdgeId()).thenReturn(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    HashSet<UUID> edges = new HashSet<>();
    edges.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeCommunicationFailureNotificationRuleTriggerConfig triggerConfig = new EdgeCommunicationFailureNotificationRuleTriggerConfig();
    triggerConfig.setEdges(edges);

    // Act
    boolean actualMatchesFilterResult = edgeCommunicationFailureTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getEdgeId();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)} with {@code EdgeCommunicationFailureTrigger}, {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeCommunicationFailureTriggerProcessor.matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig4() {
    // Arrange
    EdgeCommunicationFailureTriggerProcessor edgeCommunicationFailureTriggerProcessor = new EdgeCommunicationFailureTriggerProcessor();
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.randomUUID());
    EdgeCommunicationFailureTrigger trigger = mock(EdgeCommunicationFailureTrigger.class);
    when(trigger.getEdgeId()).thenReturn(edgeId);

    HashSet<UUID> edges = new HashSet<>();
    edges.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeCommunicationFailureNotificationRuleTriggerConfig triggerConfig = new EdgeCommunicationFailureNotificationRuleTriggerConfig();
    triggerConfig.setEdges(edges);

    // Act
    boolean actualMatchesFilterResult = edgeCommunicationFailureTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(edgeId).getId();
    verify(trigger).getEdgeId();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link EdgeCommunicationFailureTriggerProcessor#constructNotificationInfo(EdgeCommunicationFailureTrigger)} with {@code EdgeCommunicationFailureTrigger}.
   * <p>
   * Method under test: {@link EdgeCommunicationFailureTriggerProcessor#constructNotificationInfo(EdgeCommunicationFailureTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(EdgeCommunicationFailureTrigger) with 'EdgeCommunicationFailureTrigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleOriginatedNotificationInfo EdgeCommunicationFailureTriggerProcessor.constructNotificationInfo(EdgeCommunicationFailureTrigger)"})
  void testConstructNotificationInfoWithEdgeCommunicationFailureTrigger() {
    // Arrange
    EdgeCommunicationFailureTrigger trigger = mock(EdgeCommunicationFailureTrigger.class);
    when(trigger.getEdgeName()).thenReturn("Edge Name");
    when(trigger.getFailureMsg()).thenReturn("Failure Msg");
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getCustomerId()).thenReturn(customerId);
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getEdgeId()).thenReturn(edgeId);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getTenantId()).thenReturn(tenantId);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = edgeCommunicationFailureTriggerProcessor
        .constructNotificationInfo(trigger);
    Map<String, String> actualTemplateData = actualConstructNotificationInfoResult.getTemplateData();

    // Assert
    verify(trigger).getCustomerId();
    verify(trigger).getEdgeId();
    verify(trigger).getEdgeName();
    verify(trigger).getFailureMsg();
    verify(trigger).getTenantId();
    assertTrue(actualConstructNotificationInfoResult instanceof EdgeCommunicationFailureNotificationInfo);
    assertEquals("Edge Name",
        ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getEdgeName());
    assertEquals("Failure Msg",
        ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getFailureMsg());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(3, templateData.size());
    assertTrue(templateData.containsKey("edgeId"));
    assertTrue(templateData.containsKey("edgeName"));
    assertTrue(templateData.containsKey("failureMsg"));
    assertEquals(templateData, actualTemplateData);
    assertSame(customerId,
        ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getCustomerId());
    assertSame(customerId, actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertSame(edgeId, ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getEdgeId());
    assertSame(edgeId, actualConstructNotificationInfoResult.getStateEntityId());
    assertSame(tenantId,
        ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getTenantId());
    assertSame(tenantId, actualConstructNotificationInfoResult.getAffectedTenantId());
  }

  /**
   * Test {@link EdgeCommunicationFailureTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link EdgeCommunicationFailureTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType EdgeCommunicationFailureTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.EDGE_COMMUNICATION_FAILURE,
        (new EdgeCommunicationFailureTriggerProcessor()).getTriggerType());
  }
}
