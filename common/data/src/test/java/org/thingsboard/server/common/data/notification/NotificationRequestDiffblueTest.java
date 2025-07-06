package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequest.NotificationRequestBuilder;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;

@ContextConfiguration(classes = {NotificationRequestBuilder.class})
@ExtendWith(SpringExtension.class)
class NotificationRequestDiffblueTest {
  @Autowired private NotificationRequestBuilder notificationRequestBuilder;

  /**
   * Test {@link NotificationRequest#equals(Object)}, and {@link NotificationRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequest#equals(Object)}
   *   <li>{@link NotificationRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    ArrayList<UUID> targets = new ArrayList<>();
    targets.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequestBuilder targetsResult = statusResult.targets(targets);
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder templateResult =
        statusResult.targets(new ArrayList<>()).template(null);
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder templateResult =
        statusResult.targets(new ArrayList<>()).template(mock(NotificationTemplate.class));
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(new NotificationTemplateId(EntityId.NULL_UUID))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest buildResult =
        targetsResult
            .template(new NotificationTemplate())
            .templateId(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequestBuilder templateIdResult =
        templateResult.templateId(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest buildResult =
        templateIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(null)
            .build();
    NotificationRequestBuilder originatorEntityIdResult2 =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder2
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRequestConfig additionalConfig = new NotificationRequestConfig();
    additionalConfig.setSendingDelayInSec(1);
    NotificationRequestBuilder builderResult = NotificationRequest.builder();
    builderResult.additionalConfig(additionalConfig);
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any()))
        .thenReturn(builderResult);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder2
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder2
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder3 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.info(Mockito.<NotificationInfo>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder3
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder2
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    NotificationRequestConfig additionalConfig = new NotificationRequestConfig();
    additionalConfig.setSendingDelayInSec(3);
    NotificationRequestBuilder builderResult = NotificationRequest.builder();
    builderResult.additionalConfig(additionalConfig);
    NotificationRequestBuilder notificationRequestBuilder3 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.info(Mockito.<NotificationInfo>any()))
        .thenReturn(builderResult);
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder3
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder2
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder3 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder4 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder3);
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder4
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequestBuilder notificationRequestBuilder3 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder2);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder3
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder4 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder5 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder4);
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder5
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequestBuilder notificationRequestBuilder3 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder2);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder3
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder4 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder5 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder4);
    NotificationRequestBuilder notificationRequestBuilder6 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder6.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder5);
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder6
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.stats(Mockito.<NotificationRequestStats>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequestBuilder notificationRequestBuilder3 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder2);
    NotificationRequestBuilder notificationRequestBuilder4 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder3);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder4
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder5 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder6 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder6.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder5);
    NotificationRequestBuilder notificationRequestBuilder7 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder7.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder6);
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder7
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.status(Mockito.<NotificationRequestStatus>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.stats(Mockito.<NotificationRequestStats>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequestBuilder notificationRequestBuilder3 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(notificationRequestBuilder2);
    NotificationRequestBuilder notificationRequestBuilder4 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder3);
    NotificationRequestBuilder notificationRequestBuilder5 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder4);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder5
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder6 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder6.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder7 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder7.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder6);
    NotificationRequestBuilder notificationRequestBuilder8 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder8.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder7);
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder8
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRequestBuilder notificationRequestBuilder = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder.targets(Mockito.<List<UUID>>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder2 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder2.status(Mockito.<NotificationRequestStatus>any()))
        .thenReturn(notificationRequestBuilder);
    NotificationRequestBuilder notificationRequestBuilder3 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder3.stats(Mockito.<NotificationRequestStats>any()))
        .thenReturn(notificationRequestBuilder2);
    NotificationRequestBuilder notificationRequestBuilder4 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder4.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(notificationRequestBuilder3);
    NotificationRequestBuilder notificationRequestBuilder5 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder5.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder4);
    NotificationRequestBuilder notificationRequestBuilder6 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder6.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder5);
    NotificationRequestBuilder originatorEntityIdResult =
        notificationRequestBuilder6
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestBuilder notificationRequestBuilder7 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder7.ruleId(Mockito.<NotificationRuleId>any()))
        .thenReturn(NotificationRequest.builder());
    NotificationRequestBuilder notificationRequestBuilder8 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder8.originatorEntityId(Mockito.<EntityId>any()))
        .thenReturn(notificationRequestBuilder7);
    NotificationRequestBuilder notificationRequestBuilder9 = mock(NotificationRequestBuilder.class);
    when(notificationRequestBuilder9.info(Mockito.<NotificationInfo>any()))
        .thenReturn(notificationRequestBuilder8);
    NotificationRequestBuilder originatorEntityIdResult2 =
        notificationRequestBuilder9
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult2 =
        originatorEntityIdResult2.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult2 =
        ruleIdResult2
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult2 = statusResult2.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult2 =
        targetsResult2.template(new NotificationTemplate());
    NotificationRequest buildResult2 =
        templateResult2
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link NotificationRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequest.equals(Object)",
    "int NotificationRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest buildResult =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to NotificationRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequest#NotificationRequest()}
   *   <li>{@link NotificationRequest#setAdditionalConfig(NotificationRequestConfig)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void NotificationRequest.<init>()",
    "void NotificationRequest.<init>(TenantId, List, NotificationTemplateId, NotificationTemplate, NotificationInfo, NotificationRequestConfig, EntityId, NotificationRuleId, NotificationRequestStatus, NotificationRequestStats)",
    "NotificationRequestConfig NotificationRequest.getAdditionalConfig()",
    "NotificationInfo NotificationRequest.getInfo()",
    "EntityId NotificationRequest.getOriginatorEntityId()",
    "NotificationRuleId NotificationRequest.getRuleId()",
    "NotificationRequestStats NotificationRequest.getStats()",
    "NotificationRequestStatus NotificationRequest.getStatus()",
    "List NotificationRequest.getTargets()",
    "NotificationTemplate NotificationRequest.getTemplate()",
    "NotificationTemplateId NotificationRequest.getTemplateId()",
    "TenantId NotificationRequest.getTenantId()",
    "void NotificationRequest.setAdditionalConfig(NotificationRequestConfig)",
    "void NotificationRequest.setInfo(NotificationInfo)",
    "void NotificationRequest.setOriginatorEntityId(EntityId)",
    "void NotificationRequest.setRuleId(NotificationRuleId)",
    "void NotificationRequest.setStats(NotificationRequestStats)",
    "void NotificationRequest.setStatus(NotificationRequestStatus)",
    "void NotificationRequest.setTargets(List)",
    "void NotificationRequest.setTemplate(NotificationTemplate)",
    "void NotificationRequest.setTemplateId(NotificationTemplateId)",
    "void NotificationRequest.setTenantId(TenantId)",
    "java.lang.String NotificationRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequest actualNotificationRequest = new NotificationRequest();
    NotificationRequestConfig additionalConfig = new NotificationRequestConfig();
    additionalConfig.setSendingDelayInSec(3);
    actualNotificationRequest.setAdditionalConfig(additionalConfig);
    NotificationInfo info = mock(NotificationInfo.class);
    actualNotificationRequest.setInfo(info);
    actualNotificationRequest.setOriginatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRuleId ruleId =
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRequest.setRuleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    actualNotificationRequest.setStats(stats);
    actualNotificationRequest.setStatus(NotificationRequestStatus.PROCESSING);
    ArrayList<UUID> targets = new ArrayList<>();
    actualNotificationRequest.setTargets(targets);
    NotificationTemplate template = new NotificationTemplate();
    actualNotificationRequest.setTemplate(template);
    NotificationTemplateId templateId =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRequest.setTemplateId(templateId);
    actualNotificationRequest.setTenantId(TenantId.SYS_TENANT_ID);
    actualNotificationRequest.toString();
    NotificationRequestConfig actualAdditionalConfig =
        actualNotificationRequest.getAdditionalConfig();
    NotificationInfo actualInfo = actualNotificationRequest.getInfo();
    EntityId actualOriginatorEntityId = actualNotificationRequest.getOriginatorEntityId();
    NotificationRuleId actualRuleId = actualNotificationRequest.getRuleId();
    NotificationRequestStats actualStats = actualNotificationRequest.getStats();
    NotificationRequestStatus actualStatus = actualNotificationRequest.getStatus();
    List<UUID> actualTargets = actualNotificationRequest.getTargets();
    NotificationTemplate actualTemplate = actualNotificationRequest.getTemplate();
    NotificationTemplateId actualTemplateId = actualNotificationRequest.getTemplateId();
    TenantId actualTenantId = actualNotificationRequest.getTenantId();

    // Assert
    assertNull(actualNotificationRequest.getId());
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
   *
   * <ul>
   *   <li>Given three.
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequest#NotificationRequest(TenantId, List, NotificationTemplateId,
   *       NotificationTemplate, NotificationInfo, NotificationRequestConfig, EntityId,
   *       NotificationRuleId, NotificationRequestStatus, NotificationRequestStats)}
   *   <li>{@link NotificationRequest#setAdditionalConfig(NotificationRequestConfig)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void NotificationRequest.<init>()",
    "void NotificationRequest.<init>(TenantId, List, NotificationTemplateId, NotificationTemplate, NotificationInfo, NotificationRequestConfig, EntityId, NotificationRuleId, NotificationRequestStatus, NotificationRequestStats)",
    "NotificationRequestConfig NotificationRequest.getAdditionalConfig()",
    "NotificationInfo NotificationRequest.getInfo()",
    "EntityId NotificationRequest.getOriginatorEntityId()",
    "NotificationRuleId NotificationRequest.getRuleId()",
    "NotificationRequestStats NotificationRequest.getStats()",
    "NotificationRequestStatus NotificationRequest.getStatus()",
    "List NotificationRequest.getTargets()",
    "NotificationTemplate NotificationRequest.getTemplate()",
    "NotificationTemplateId NotificationRequest.getTemplateId()",
    "TenantId NotificationRequest.getTenantId()",
    "void NotificationRequest.setAdditionalConfig(NotificationRequestConfig)",
    "void NotificationRequest.setInfo(NotificationInfo)",
    "void NotificationRequest.setOriginatorEntityId(EntityId)",
    "void NotificationRequest.setRuleId(NotificationRuleId)",
    "void NotificationRequest.setStats(NotificationRequestStats)",
    "void NotificationRequest.setStatus(NotificationRequestStatus)",
    "void NotificationRequest.setTargets(List)",
    "void NotificationRequest.setTemplate(NotificationTemplate)",
    "void NotificationRequest.setTemplateId(NotificationTemplateId)",
    "void NotificationRequest.setTenantId(TenantId)",
    "java.lang.String NotificationRequest.toString()"
  })
  void testGettersAndSetters_givenThree_whenSys_tenant_id() {
    // Arrange
    ArrayList<UUID> targets = new ArrayList<>();
    NotificationTemplateId templateId =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationTemplate template = new NotificationTemplate();
    NotificationInfo info = mock(NotificationInfo.class);

    NotificationRequestConfig additionalConfig = new NotificationRequestConfig();
    additionalConfig.setSendingDelayInSec(3);
    NotificationRuleId ruleId =
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationRequest actualNotificationRequest =
        new NotificationRequest(
            TenantId.SYS_TENANT_ID,
            targets,
            templateId,
            template,
            info,
            additionalConfig,
            TenantId.SYS_TENANT_ID,
            ruleId,
            NotificationRequestStatus.PROCESSING,
            new NotificationRequestStats());
    NotificationRequestConfig additionalConfig2 = new NotificationRequestConfig();
    additionalConfig2.setSendingDelayInSec(3);
    actualNotificationRequest.setAdditionalConfig(additionalConfig2);
    NotificationInfo info2 = mock(NotificationInfo.class);
    actualNotificationRequest.setInfo(info2);
    actualNotificationRequest.setOriginatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRuleId ruleId2 =
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRequest.setRuleId(ruleId2);
    NotificationRequestStats stats = new NotificationRequestStats();
    actualNotificationRequest.setStats(stats);
    actualNotificationRequest.setStatus(NotificationRequestStatus.PROCESSING);
    ArrayList<UUID> targets2 = new ArrayList<>();
    actualNotificationRequest.setTargets(targets2);
    NotificationTemplate template2 = new NotificationTemplate();
    actualNotificationRequest.setTemplate(template2);
    NotificationTemplateId templateId2 =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRequest.setTemplateId(templateId2);
    actualNotificationRequest.setTenantId(TenantId.SYS_TENANT_ID);
    actualNotificationRequest.toString();
    NotificationRequestConfig actualAdditionalConfig =
        actualNotificationRequest.getAdditionalConfig();
    NotificationInfo actualInfo = actualNotificationRequest.getInfo();
    EntityId actualOriginatorEntityId = actualNotificationRequest.getOriginatorEntityId();
    NotificationRuleId actualRuleId = actualNotificationRequest.getRuleId();
    NotificationRequestStats actualStats = actualNotificationRequest.getStats();
    NotificationRequestStatus actualStatus = actualNotificationRequest.getStatus();
    List<UUID> actualTargets = actualNotificationRequest.getTargets();
    NotificationTemplate actualTemplate = actualNotificationRequest.getTemplate();
    NotificationTemplateId actualTemplateId = actualNotificationRequest.getTemplateId();
    TenantId actualTenantId = actualNotificationRequest.getTenantId();

    // Assert
    assertNull(actualNotificationRequest.getId());
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
   *
   * <p>Method under test: {@link NotificationRequest#NotificationRequest(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequest(NotificationRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequest.<init>(NotificationRequest)"})
  void testNewNotificationRequest() {
    // Arrange
    NotificationRequest other = new NotificationRequest();

    // Act and Assert
    assertEquals(other, new NotificationRequest(other));
  }

  /**
   * Test {@link NotificationRequest#getName()}.
   *
   * <p>Method under test: {@link NotificationRequest#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String NotificationRequest.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("To targets null", new NotificationRequest().getName());
  }

  /**
   * Test {@link NotificationRequest#getSenderId()}.
   *
   * <p>Method under test: {@link NotificationRequest#getSenderId()}
   */
  @Test
  @DisplayName("Test getSenderId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.UserId NotificationRequest.getSenderId()"
  })
  void testGetSenderId() {
    // Arrange, Act and Assert
    assertNull(new NotificationRequest().getSenderId());
  }

  /**
   * Test {@link NotificationRequest#isSent()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRequest#NotificationRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#isSent()}
   */
  @Test
  @DisplayName("Test isSent(); given NotificationRequest(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequest.isSent()"})
  void testIsSent_givenNotificationRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NotificationRequest().isSent());
  }

  /**
   * Test {@link NotificationRequest#isSent()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#isSent()}
   */
  @Test
  @DisplayName("Test isSent(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequest.isSent()"})
  void testIsSent_thenReturnTrue() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest(new NotificationRequest());
    notificationRequest.setStatus(NotificationRequestStatus.SENT);

    // Act and Assert
    assertTrue(notificationRequest.isSent());
  }

  /**
   * Test {@link NotificationRequest#isScheduled()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRequest#NotificationRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#isScheduled()}
   */
  @Test
  @DisplayName("Test isScheduled(); given NotificationRequest(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequest.isScheduled()"})
  void testIsScheduled_givenNotificationRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new NotificationRequest().isScheduled());
  }

  /**
   * Test {@link NotificationRequest#isScheduled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequest#isScheduled()}
   */
  @Test
  @DisplayName("Test isScheduled(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequest.isScheduled()"})
  void testIsScheduled_thenReturnTrue() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest(new NotificationRequest());
    notificationRequest.setStatus(NotificationRequestStatus.SCHEDULED);

    // Act and Assert
    assertTrue(notificationRequest.isScheduled());
  }

  /**
   * Test NotificationRequestBuilder {@link NotificationRequestBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestBuilder#build()}
   *   <li>{@link NotificationRequestBuilder#info(NotificationInfo)}
   *   <li>{@link NotificationRequestBuilder#originatorEntityId(EntityId)}
   *   <li>{@link NotificationRequestBuilder#ruleId(NotificationRuleId)}
   *   <li>{@link NotificationRequestBuilder#stats(NotificationRequestStats)}
   *   <li>{@link NotificationRequestBuilder#status(NotificationRequestStatus)}
   *   <li>{@link NotificationRequestBuilder#targets(List)}
   *   <li>{@link NotificationRequestBuilder#template(NotificationTemplate)}
   *   <li>{@link NotificationRequestBuilder#templateId(NotificationTemplateId)}
   *   <li>{@link NotificationRequestBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationRequestBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void NotificationRequestBuilder.<init>()",
    "NotificationRequestBuilder NotificationRequestBuilder.additionalConfig(NotificationRequestConfig)",
    "NotificationRequest NotificationRequestBuilder.build()",
    "NotificationRequestBuilder NotificationRequestBuilder.info(NotificationInfo)",
    "NotificationRequestBuilder NotificationRequestBuilder.originatorEntityId(EntityId)",
    "NotificationRequestBuilder NotificationRequestBuilder.ruleId(NotificationRuleId)",
    "NotificationRequestBuilder NotificationRequestBuilder.stats(NotificationRequestStats)",
    "NotificationRequestBuilder NotificationRequestBuilder.status(NotificationRequestStatus)",
    "NotificationRequestBuilder NotificationRequestBuilder.targets(List)",
    "NotificationRequestBuilder NotificationRequestBuilder.template(NotificationTemplate)",
    "NotificationRequestBuilder NotificationRequestBuilder.templateId(NotificationTemplateId)",
    "NotificationRequestBuilder NotificationRequestBuilder.tenantId(TenantId)",
    "java.lang.String NotificationRequestBuilder.toString()"
  })
  void testNotificationRequestBuilderBuild() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRuleId ruleId =
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequestBuilder statusResult =
        ruleIdResult.stats(stats).status(NotificationRequestStatus.PROCESSING);
    ArrayList<UUID> targets = new ArrayList<>();
    NotificationRequestBuilder targetsResult = statusResult.targets(targets);
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationRequest actualBuildResult =
        templateResult.templateId(templateId).tenantId(TenantId.SYS_TENANT_ID).build();

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
