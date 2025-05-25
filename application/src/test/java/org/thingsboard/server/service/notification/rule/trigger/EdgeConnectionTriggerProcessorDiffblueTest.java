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
import org.thingsboard.server.common.data.notification.info.EdgeConnectionNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.EdgeConnectionTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeConnectionNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectionNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeConnectionNotificationRuleTriggerConfig.EdgeConnectivityEvent;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {EdgeConnectionTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class EdgeConnectionTriggerProcessorDiffblueTest {
  @Autowired
  private EdgeConnectionTriggerProcessor edgeConnectionTriggerProcessor;

  /**
   * Test {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)} with {@code EdgeConnectionTrigger}, {@code EdgeConnectionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig) with 'EdgeConnectionTrigger', 'EdgeConnectionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeConnectionTriggerProcessor.matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeConnectionTriggerEdgeConnectionNotificationRuleTriggerConfig() {
    // Arrange
    EdgeConnectionTrigger trigger = mock(EdgeConnectionTrigger.class);
    when(trigger.isConnected()).thenReturn(true);

    // Act
    boolean actualMatchesFilterResult = edgeConnectionTriggerProcessor.matchesFilter(trigger,
        new EdgeConnectionNotificationRuleTriggerConfig());

    // Assert
    verify(trigger).isConnected();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)} with {@code EdgeConnectionTrigger}, {@code EdgeConnectionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig) with 'EdgeConnectionTrigger', 'EdgeConnectionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeConnectionTriggerProcessor.matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeConnectionTriggerEdgeConnectionNotificationRuleTriggerConfig2() {
    // Arrange
    EdgeConnectionTrigger trigger = mock(EdgeConnectionTrigger.class);
    when(trigger.isConnected()).thenReturn(false);

    // Act
    boolean actualMatchesFilterResult = edgeConnectionTriggerProcessor.matchesFilter(trigger,
        new EdgeConnectionNotificationRuleTriggerConfig());

    // Assert
    verify(trigger).isConnected();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)} with {@code EdgeConnectionTrigger}, {@code EdgeConnectionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig) with 'EdgeConnectionTrigger', 'EdgeConnectionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeConnectionTriggerProcessor.matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeConnectionTriggerEdgeConnectionNotificationRuleTriggerConfig3() {
    // Arrange
    EdgeConnectionTrigger trigger = mock(EdgeConnectionTrigger.class);
    when(trigger.isConnected()).thenReturn(true);
    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = builderResult.edges(new HashSet<>());
    EdgeConnectionNotificationRuleTriggerConfig triggerConfig = edgesResult.notifyOn(new HashSet<>()).build();

    // Act
    boolean actualMatchesFilterResult = edgeConnectionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).isConnected();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)} with {@code EdgeConnectionTrigger}, {@code EdgeConnectionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig) with 'EdgeConnectionTrigger', 'EdgeConnectionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeConnectionTriggerProcessor.matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeConnectionTriggerEdgeConnectionNotificationRuleTriggerConfig4() {
    // Arrange
    EdgeConnectionTrigger trigger = mock(EdgeConnectionTrigger.class);
    when(trigger.isConnected()).thenReturn(true);

    HashSet<EdgeConnectivityEvent> notifyOn = new HashSet<>();
    notifyOn.add(EdgeConnectivityEvent.CONNECTED);
    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig triggerConfig = builderResult.edges(new HashSet<>())
        .notifyOn(notifyOn)
        .build();

    // Act
    boolean actualMatchesFilterResult = edgeConnectionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).isConnected();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)} with {@code EdgeConnectionTrigger}, {@code EdgeConnectionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig) with 'EdgeConnectionTrigger', 'EdgeConnectionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeConnectionTriggerProcessor.matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeConnectionTriggerEdgeConnectionNotificationRuleTriggerConfig5() {
    // Arrange
    EdgeConnectionTrigger trigger = mock(EdgeConnectionTrigger.class);
    when(trigger.isConnected()).thenReturn(false);

    HashSet<EdgeConnectivityEvent> notifyOn = new HashSet<>();
    notifyOn.add(EdgeConnectivityEvent.CONNECTED);
    EdgeConnectionNotificationRuleTriggerConfigBuilder builderResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder();
    EdgeConnectionNotificationRuleTriggerConfig triggerConfig = builderResult.edges(new HashSet<>())
        .notifyOn(notifyOn)
        .build();

    // Act
    boolean actualMatchesFilterResult = edgeConnectionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).isConnected();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)} with {@code EdgeConnectionTrigger}, {@code EdgeConnectionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig) with 'EdgeConnectionTrigger', 'EdgeConnectionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean EdgeConnectionTriggerProcessor.matchesFilter(EdgeConnectionTrigger, EdgeConnectionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithEdgeConnectionTriggerEdgeConnectionNotificationRuleTriggerConfig6() {
    // Arrange
    EdgeConnectionTrigger trigger = mock(EdgeConnectionTrigger.class);
    when(trigger.getEdgeId()).thenReturn(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(trigger.isConnected()).thenReturn(true);

    HashSet<UUID> edges = new HashSet<>();
    edges.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeConnectionNotificationRuleTriggerConfigBuilder edgesResult = EdgeConnectionNotificationRuleTriggerConfig
        .builder()
        .edges(edges);

    HashSet<EdgeConnectivityEvent> notifyOn = new HashSet<>();
    notifyOn.add(EdgeConnectivityEvent.CONNECTED);
    EdgeConnectionNotificationRuleTriggerConfig triggerConfig = edgesResult.notifyOn(notifyOn).build();

    // Act
    boolean actualMatchesFilterResult = edgeConnectionTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getEdgeId();
    verify(trigger).isConnected();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link EdgeConnectionTriggerProcessor#constructNotificationInfo(EdgeConnectionTrigger)} with {@code EdgeConnectionTrigger}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#constructNotificationInfo(EdgeConnectionTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(EdgeConnectionTrigger) with 'EdgeConnectionTrigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleOriginatedNotificationInfo EdgeConnectionTriggerProcessor.constructNotificationInfo(EdgeConnectionTrigger)"})
  void testConstructNotificationInfoWithEdgeConnectionTrigger() {
    // Arrange
    EdgeConnectionTrigger trigger = mock(EdgeConnectionTrigger.class);
    when(trigger.isConnected()).thenReturn(true);
    when(trigger.getEdgeName()).thenReturn("Edge Name");
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getCustomerId()).thenReturn(customerId);
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getEdgeId()).thenReturn(edgeId);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getTenantId()).thenReturn(tenantId);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = edgeConnectionTriggerProcessor
        .constructNotificationInfo(trigger);
    Map<String, String> actualTemplateData = actualConstructNotificationInfoResult.getTemplateData();

    // Assert
    verify(trigger).getCustomerId();
    verify(trigger).getEdgeId();
    verify(trigger).getEdgeName();
    verify(trigger).getTenantId();
    verify(trigger).isConnected();
    assertTrue(actualConstructNotificationInfoResult instanceof EdgeConnectionNotificationInfo);
    assertEquals("Edge Name", ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getEdgeName());
    assertEquals("connected", ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getEventType());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(3, templateData.size());
    assertTrue(templateData.containsKey("edgeId"));
    assertTrue(templateData.containsKey("edgeName"));
    assertTrue(templateData.containsKey("eventType"));
    assertEquals(templateData, actualTemplateData);
    assertSame(customerId, ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getCustomerId());
    assertSame(customerId, actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertSame(edgeId, ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getEdgeId());
    assertSame(edgeId, actualConstructNotificationInfoResult.getStateEntityId());
    assertSame(tenantId, ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getTenantId());
    assertSame(tenantId, actualConstructNotificationInfoResult.getAffectedTenantId());
  }

  /**
   * Test {@link EdgeConnectionTriggerProcessor#constructNotificationInfo(EdgeConnectionTrigger)} with {@code EdgeConnectionTrigger}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#constructNotificationInfo(EdgeConnectionTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(EdgeConnectionTrigger) with 'EdgeConnectionTrigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleOriginatedNotificationInfo EdgeConnectionTriggerProcessor.constructNotificationInfo(EdgeConnectionTrigger)"})
  void testConstructNotificationInfoWithEdgeConnectionTrigger2() {
    // Arrange
    EdgeConnectionTrigger trigger = mock(EdgeConnectionTrigger.class);
    when(trigger.isConnected()).thenReturn(false);
    when(trigger.getEdgeName()).thenReturn("Edge Name");
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getCustomerId()).thenReturn(customerId);
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getEdgeId()).thenReturn(edgeId);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(trigger.getTenantId()).thenReturn(tenantId);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = edgeConnectionTriggerProcessor
        .constructNotificationInfo(trigger);
    Map<String, String> actualTemplateData = actualConstructNotificationInfoResult.getTemplateData();

    // Assert
    verify(trigger).getCustomerId();
    verify(trigger).getEdgeId();
    verify(trigger).getEdgeName();
    verify(trigger).getTenantId();
    verify(trigger).isConnected();
    assertTrue(actualConstructNotificationInfoResult instanceof EdgeConnectionNotificationInfo);
    assertEquals("Edge Name", ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getEdgeName());
    assertEquals("disconnected",
        ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getEventType());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(3, templateData.size());
    assertTrue(templateData.containsKey("edgeId"));
    assertTrue(templateData.containsKey("edgeName"));
    assertTrue(templateData.containsKey("eventType"));
    assertEquals(templateData, actualTemplateData);
    assertSame(customerId, ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getCustomerId());
    assertSame(customerId, actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertSame(edgeId, ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getEdgeId());
    assertSame(edgeId, actualConstructNotificationInfoResult.getStateEntityId());
    assertSame(tenantId, ((EdgeConnectionNotificationInfo) actualConstructNotificationInfoResult).getTenantId());
    assertSame(tenantId, actualConstructNotificationInfoResult.getAffectedTenantId());
  }

  /**
   * Test {@link EdgeConnectionTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link EdgeConnectionTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType EdgeConnectionTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.EDGE_CONNECTION, (new EdgeConnectionTriggerProcessor()).getTriggerType());
  }
}
