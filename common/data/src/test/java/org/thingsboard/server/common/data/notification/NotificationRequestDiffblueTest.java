package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequest.NotificationRequestBuilder;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;

class NotificationRequestDiffblueTest {
  /**
   * Test {@link NotificationRequest#equals(Object)}, and
   * {@link NotificationRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequest#equals(Object)}
   *   <li>{@link NotificationRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);

    ArrayList<UUID> targets = new ArrayList<>();
    targets.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(targets);
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder templateResult = statusResult.targets(new ArrayList<>())
        .template(null);
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder templateResult = statusResult.targets(new ArrayList<>())
        .template(mock(NotificationTemplate.class));
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult.templateId(new NotificationTemplateId(EntityId.NULL_UUID))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest buildResult = targetsResult.template(new NotificationTemplate())
        .templateId(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest.NotificationRequestBuilder templateIdResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest buildResult = templateIdResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(null)
        .build();
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder2
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRequestConfig additionalConfig = new NotificationRequestConfig();
    additionalConfig.setSendingDelayInSec(1);
    NotificationRequest.NotificationRequestBuilder builderResult = NotificationRequest.builder();
    builderResult.additionalConfig(additionalConfig);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(builderResult);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder2
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder2
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder3 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder3
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder2
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    NotificationRequestConfig additionalConfig = new NotificationRequestConfig();
    additionalConfig.setSendingDelayInSec(3);
    NotificationRequest.NotificationRequestBuilder builderResult = NotificationRequest.builder();
    builderResult.additionalConfig(additionalConfig);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder3 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.info(Mockito.<NotificationInfo>any())).thenReturn(builderResult);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder3
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder2
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder3 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder4 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder3);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder4
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder3 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder2);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder3
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder4 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder5 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder4);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder5
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder3 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder2);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder3
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder4 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder5 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder4);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder6 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder6.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder5);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder6
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.stats(Mockito.<NotificationRequestStats>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.ruleId(Mockito.<NotificationRuleId>any())).thenReturn(notificationRequestBuilder);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder3 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder2);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder4 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder3);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder4
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder5 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder6 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder6.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder5);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder7 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder7.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder6);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder7
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.status(Mockito.<NotificationRequestStatus>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.stats(Mockito.<NotificationRequestStats>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder3 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.ruleId(Mockito.<NotificationRuleId>any())).thenReturn(notificationRequestBuilder2);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder4 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder3);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder5 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder4);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder5
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder6 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder6.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder7 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder7.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder6);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder8 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder8.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder7);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder8
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.targets(Mockito.<List<UUID>>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder2 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.status(Mockito.<NotificationRequestStatus>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder3 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.stats(Mockito.<NotificationRequestStats>any()))
        .thenReturn(notificationRequestBuilder2);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder4 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.ruleId(Mockito.<NotificationRuleId>any())).thenReturn(notificationRequestBuilder3);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder5 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder4);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder6 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder6.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder5);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder6
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder7 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder7.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder8 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder8.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder7);
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder9 = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder9.info(Mockito.<NotificationInfo>any())).thenReturn(notificationRequestBuilder8);
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult2 = notificationRequestBuilder9
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult2 = originatorEntityIdResult2
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult2 = ruleIdResult2.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult2 = targetsResult2
        .template(new NotificationTemplate());
    NotificationRequest buildResult2 = templateResult2
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to NotificationRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequest#NotificationRequest()}
   *   <li>
   * {@link NotificationRequest#setAdditionalConfig(NotificationRequestConfig)}
   *   <li>{@link NotificationRequest#setInfo(NotificationInfo)}
   *   <li>{@link NotificationRequest#setOriginatorEntityId(EntityId)}
   *   <li>{@link NotificationRequest#setRuleId(NotificationRuleId)}
   *   <li>{@link NotificationRequest#setStats(NotificationRequestStats)}
   *   <li>{@link NotificationRequest#setStatus(NotificationRequestStatus)}
   *   <li>{@link NotificationRequest#setTargets(List)}
   *   <li>{@link NotificationRequest#setTemplate(NotificationTemplate)}
   *   <li>{@link NotificationRequest#setTemplateId(NotificationTemplateId)}
   *   <li>{@link NotificationRequest#setTenantId(TenantId)}
   *   <li>{@link NotificationRequest#toString()}
   *   <li>{@link NotificationRequest#getAdditionalConfig()}
   *   <li>{@link NotificationRequest#getInfo()}
   *   <li>{@link NotificationRequest#getOriginatorEntityId()}
   *   <li>{@link NotificationRequest#getRuleId()}
   *   <li>{@link NotificationRequest#getStats()}
   *   <li>{@link NotificationRequest#getStatus()}
   *   <li>{@link NotificationRequest#getTargets()}
   *   <li>{@link NotificationRequest#getTemplate()}
   *   <li>{@link NotificationRequest#getTemplateId()}
   *   <li>{@link NotificationRequest#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequest actualNotificationRequest = new NotificationRequest();
    NotificationRequestConfig additionalConfig = new NotificationRequestConfig();
    additionalConfig.setSendingDelayInSec(3);
    actualNotificationRequest.setAdditionalConfig(additionalConfig);
    NotificationInfo info = mock(NotificationInfo.class);
    actualNotificationRequest.setInfo(info);
    actualNotificationRequest.setOriginatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRuleId ruleId = new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRequest.setRuleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    actualNotificationRequest.setStats(stats);
    actualNotificationRequest.setStatus(NotificationRequestStatus.PROCESSING);
    ArrayList<UUID> targets = new ArrayList<>();
    actualNotificationRequest.setTargets(targets);
    NotificationTemplate template = new NotificationTemplate();
    actualNotificationRequest.setTemplate(template);
    NotificationTemplateId templateId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRequest.setTemplateId(templateId);
    actualNotificationRequest.setTenantId(TenantId.SYS_TENANT_ID);
    actualNotificationRequest.toString();
    NotificationRequestConfig actualAdditionalConfig = actualNotificationRequest.getAdditionalConfig();
    NotificationInfo actualInfo = actualNotificationRequest.getInfo();
    EntityId actualOriginatorEntityId = actualNotificationRequest.getOriginatorEntityId();
    NotificationRuleId actualRuleId = actualNotificationRequest.getRuleId();
    NotificationRequestStats actualStats = actualNotificationRequest.getStats();
    NotificationRequestStatus actualStatus = actualNotificationRequest.getStatus();
    List<UUID> actualTargets = actualNotificationRequest.getTargets();
    NotificationTemplate actualTemplate = actualNotificationRequest.getTemplate();
    NotificationTemplateId actualTemplateId = actualNotificationRequest.getTemplateId();
    TenantId actualTenantId = actualNotificationRequest.getTenantId();

    // Assert that nothing has changed
    assertEquals(0L, actualNotificationRequest.getCreatedTime());
    assertEquals(3, actualAdditionalConfig.getSendingDelayInSec());
    assertEquals(NotificationRequestStatus.PROCESSING, actualStatus);
    assertTrue(actualTargets.isEmpty());
    assertSame(targets, actualTargets);
    assertSame(ruleId, actualRuleId);
    assertSame(templateId, actualTemplateId);
    assertSame(additionalConfig, actualAdditionalConfig);
    assertSame(stats, actualStats);
    assertSame(template, actualTemplate);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
    assertSame(info, actualInfo);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Given three.</li>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NotificationRequest#NotificationRequest(TenantId, List, NotificationTemplateId, NotificationTemplate, NotificationInfo, NotificationRequestConfig, EntityId, NotificationRuleId, NotificationRequestStatus, NotificationRequestStats)}
   *   <li>
   * {@link NotificationRequest#setAdditionalConfig(NotificationRequestConfig)}
   *   <li>{@link NotificationRequest#setInfo(NotificationInfo)}
   *   <li>{@link NotificationRequest#setOriginatorEntityId(EntityId)}
   *   <li>{@link NotificationRequest#setRuleId(NotificationRuleId)}
   *   <li>{@link NotificationRequest#setStats(NotificationRequestStats)}
   *   <li>{@link NotificationRequest#setStatus(NotificationRequestStatus)}
   *   <li>{@link NotificationRequest#setTargets(List)}
   *   <li>{@link NotificationRequest#setTemplate(NotificationTemplate)}
   *   <li>{@link NotificationRequest#setTemplateId(NotificationTemplateId)}
   *   <li>{@link NotificationRequest#setTenantId(TenantId)}
   *   <li>{@link NotificationRequest#toString()}
   *   <li>{@link NotificationRequest#getAdditionalConfig()}
   *   <li>{@link NotificationRequest#getInfo()}
   *   <li>{@link NotificationRequest#getOriginatorEntityId()}
   *   <li>{@link NotificationRequest#getRuleId()}
   *   <li>{@link NotificationRequest#getStats()}
   *   <li>{@link NotificationRequest#getStatus()}
   *   <li>{@link NotificationRequest#getTargets()}
   *   <li>{@link NotificationRequest#getTemplate()}
   *   <li>{@link NotificationRequest#getTemplateId()}
   *   <li>{@link NotificationRequest#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; given three; when SYS_TENANT_ID")
  void testGettersAndSetters_givenThree_whenSys_tenant_id() {
    // Arrange
    ArrayList<UUID> targets = new ArrayList<>();
    NotificationTemplateId templateId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationTemplate template = new NotificationTemplate();
    NotificationInfo info = mock(NotificationInfo.class);

    NotificationRequestConfig additionalConfig = new NotificationRequestConfig();
    additionalConfig.setSendingDelayInSec(3);
    NotificationRuleId ruleId = new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationRequest actualNotificationRequest = new NotificationRequest(TenantId.SYS_TENANT_ID, targets, templateId,
        template, info, additionalConfig, TenantId.SYS_TENANT_ID, ruleId, NotificationRequestStatus.PROCESSING,
        new NotificationRequestStats());
    NotificationRequestConfig additionalConfig2 = new NotificationRequestConfig();
    additionalConfig2.setSendingDelayInSec(3);
    actualNotificationRequest.setAdditionalConfig(additionalConfig2);
    NotificationInfo info2 = mock(NotificationInfo.class);
    actualNotificationRequest.setInfo(info2);
    actualNotificationRequest.setOriginatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRuleId ruleId2 = new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRequest.setRuleId(ruleId2);
    NotificationRequestStats stats = new NotificationRequestStats();
    actualNotificationRequest.setStats(stats);
    actualNotificationRequest.setStatus(NotificationRequestStatus.PROCESSING);
    ArrayList<UUID> targets2 = new ArrayList<>();
    actualNotificationRequest.setTargets(targets2);
    NotificationTemplate template2 = new NotificationTemplate();
    actualNotificationRequest.setTemplate(template2);
    NotificationTemplateId templateId2 = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRequest.setTemplateId(templateId2);
    actualNotificationRequest.setTenantId(TenantId.SYS_TENANT_ID);
    actualNotificationRequest.toString();
    NotificationRequestConfig actualAdditionalConfig = actualNotificationRequest.getAdditionalConfig();
    NotificationInfo actualInfo = actualNotificationRequest.getInfo();
    EntityId actualOriginatorEntityId = actualNotificationRequest.getOriginatorEntityId();
    NotificationRuleId actualRuleId = actualNotificationRequest.getRuleId();
    NotificationRequestStats actualStats = actualNotificationRequest.getStats();
    NotificationRequestStatus actualStatus = actualNotificationRequest.getStatus();
    List<UUID> actualTargets = actualNotificationRequest.getTargets();
    NotificationTemplate actualTemplate = actualNotificationRequest.getTemplate();
    NotificationTemplateId actualTemplateId = actualNotificationRequest.getTemplateId();
    TenantId actualTenantId = actualNotificationRequest.getTenantId();

    // Assert that nothing has changed
    assertEquals(0L, actualNotificationRequest.getCreatedTime());
    assertEquals(3, actualAdditionalConfig.getSendingDelayInSec());
    assertEquals(NotificationRequestStatus.PROCESSING, actualStatus);
    assertTrue(actualTargets.isEmpty());
    assertSame(targets2, actualTargets);
    assertSame(ruleId2, actualRuleId);
    assertSame(templateId2, actualTemplateId);
    assertSame(additionalConfig2, actualAdditionalConfig);
    assertSame(stats, actualStats);
    assertSame(template2, actualTemplate);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
    assertSame(info2, actualInfo);
  }

  /**
   * Test {@link NotificationRequest#NotificationRequest(NotificationRequest)}.
   * <p>
   * Method under test:
   * {@link NotificationRequest#NotificationRequest(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequest(NotificationRequest)")
  void testNewNotificationRequest() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest other = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(other, new NotificationRequest(other));
  }

  /**
   * Test {@link NotificationRequest#NotificationRequest(NotificationRequest)}.
   * <ul>
   *   <li>When {@link NotificationRequest#NotificationRequest()}.</li>
   *   <li>Then return {@link NotificationRequest#NotificationRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequest#NotificationRequest(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequest(NotificationRequest); when NotificationRequest(); then return NotificationRequest()")
  void testNewNotificationRequest_whenNotificationRequest_thenReturnNotificationRequest() {
    // Arrange
    NotificationRequest other = new NotificationRequest();

    // Act and Assert
    assertEquals(other, new NotificationRequest(other));
  }

  /**
   * Test {@link NotificationRequest#getName()}.
   * <ul>
   *   <li>Given {@link NotificationRequest#NotificationRequest()}.</li>
   *   <li>Then return {@code To targets null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#getName()}
   */
  @Test
  @DisplayName("Test getName(); given NotificationRequest(); then return 'To targets null'")
  void testGetName_givenNotificationRequest_thenReturnToTargetsNull() {
    // Arrange, Act and Assert
    assertEquals("To targets null", (new NotificationRequest()).getName());
  }

  /**
   * Test {@link NotificationRequest#getName()}.
   * <ul>
   *   <li>Then return {@code To targets []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'To targets []'")
  void testGetName_thenReturnToTargets() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals("To targets []", buildResult.getName());
  }

  /**
   * Test {@link NotificationRequest#getSenderId()}.
   * <p>
   * Method under test: {@link NotificationRequest#getSenderId()}
   */
  @Test
  @DisplayName("Test getSenderId()")
  void testGetSenderId() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNull(buildResult.getSenderId());
  }

  /**
   * Test {@link NotificationRequest#getSenderId()}.
   * <ul>
   *   <li>Given {@link NotificationRequest#NotificationRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#getSenderId()}
   */
  @Test
  @DisplayName("Test getSenderId(); given NotificationRequest()")
  void testGetSenderId_givenNotificationRequest() {
    // Arrange, Act and Assert
    assertNull((new NotificationRequest()).getSenderId());
  }

  /**
   * Test {@link NotificationRequest#isSent()}.
   * <p>
   * Method under test: {@link NotificationRequest#isSent()}
   */
  @Test
  @DisplayName("Test isSent()")
  void testIsSent() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertFalse(buildResult.isSent());
  }

  /**
   * Test {@link NotificationRequest#isSent()}.
   * <ul>
   *   <li>Given {@link NotificationRequest#NotificationRequest()} Status is
   * {@link NotificationRequestStatus#SENT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#isSent()}
   */
  @Test
  @DisplayName("Test isSent(); given NotificationRequest() Status is SENT; then return 'true'")
  void testIsSent_givenNotificationRequestStatusIsSent_thenReturnTrue() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setStatus(NotificationRequestStatus.SENT);

    // Act and Assert
    assertTrue(notificationRequest.isSent());
  }

  /**
   * Test {@link NotificationRequest#isSent()}.
   * <ul>
   *   <li>Given {@link NotificationRequest#NotificationRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#isSent()}
   */
  @Test
  @DisplayName("Test isSent(); given NotificationRequest(); then return 'false'")
  void testIsSent_givenNotificationRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new NotificationRequest()).isSent());
  }

  /**
   * Test {@link NotificationRequest#isScheduled()}.
   * <p>
   * Method under test: {@link NotificationRequest#isScheduled()}
   */
  @Test
  @DisplayName("Test isScheduled()")
  void testIsScheduled() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertFalse(buildResult.isScheduled());
  }

  /**
   * Test {@link NotificationRequest#isScheduled()}.
   * <ul>
   *   <li>Given {@link NotificationRequest#NotificationRequest()} Status is
   * {@link NotificationRequestStatus#SCHEDULED}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#isScheduled()}
   */
  @Test
  @DisplayName("Test isScheduled(); given NotificationRequest() Status is SCHEDULED; then return 'true'")
  void testIsScheduled_givenNotificationRequestStatusIsScheduled_thenReturnTrue() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setStatus(NotificationRequestStatus.SCHEDULED);

    // Act and Assert
    assertTrue(notificationRequest.isScheduled());
  }

  /**
   * Test {@link NotificationRequest#isScheduled()}.
   * <ul>
   *   <li>Given {@link NotificationRequest#NotificationRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequest#isScheduled()}
   */
  @Test
  @DisplayName("Test isScheduled(); given NotificationRequest(); then return 'false'")
  void testIsScheduled_givenNotificationRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new NotificationRequest()).isScheduled());
  }

  /**
   * Test NotificationRequestBuilder {@link NotificationRequestBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequest.NotificationRequestBuilder#build()}
   *   <li>
   * {@link NotificationRequest.NotificationRequestBuilder#info(NotificationInfo)}
   *   <li>
   * {@link NotificationRequest.NotificationRequestBuilder#originatorEntityId(EntityId)}
   *   <li>
   * {@link NotificationRequest.NotificationRequestBuilder#ruleId(NotificationRuleId)}
   *   <li>
   * {@link NotificationRequest.NotificationRequestBuilder#stats(NotificationRequestStats)}
   *   <li>
   * {@link NotificationRequest.NotificationRequestBuilder#status(NotificationRequestStatus)}
   *   <li>{@link NotificationRequest.NotificationRequestBuilder#targets(List)}
   *   <li>
   * {@link NotificationRequest.NotificationRequestBuilder#template(NotificationTemplate)}
   *   <li>
   * {@link NotificationRequest.NotificationRequestBuilder#templateId(NotificationTemplateId)}
   *   <li>{@link NotificationRequest.NotificationRequestBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationRequestBuilder build()")
  void testNotificationRequestBuilderBuild() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRuleId ruleId = new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(stats)
        .status(NotificationRequestStatus.PROCESSING);
    ArrayList<UUID> targets = new ArrayList<>();
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(targets);
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationRequest actualBuildResult = templateResult.templateId(templateId)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    EntityId originatorEntityId = actualBuildResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals("To targets []", actualBuildResult.getName());
    assertNull(actualBuildResult.getUuidId());
    assertNull(actualBuildResult.getId());
    assertNull(actualBuildResult.getSenderId());
    assertNull(actualBuildResult.getAdditionalConfig());
    assertEquals(0L, actualBuildResult.getCreatedTime());
    assertEquals(NotificationRequestStatus.PROCESSING, actualBuildResult.getStatus());
    assertFalse(actualBuildResult.isScheduled());
    assertFalse(actualBuildResult.isSent());
    List<UUID> targets2 = actualBuildResult.getTargets();
    assertTrue(targets2.isEmpty());
    assertSame(targets, targets2);
    assertSame(ruleId, actualBuildResult.getRuleId());
    assertSame(templateId, actualBuildResult.getTemplateId());
    assertSame(stats, actualBuildResult.getStats());
    assertSame(template, actualBuildResult.getTemplate());
    assertSame(originatorEntityId, actualBuildResult.getTenantId());
  }
}
