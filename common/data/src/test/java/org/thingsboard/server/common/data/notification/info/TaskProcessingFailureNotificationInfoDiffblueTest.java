package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder;

@ContextConfiguration(classes = {TaskProcessingFailureNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class TaskProcessingFailureNotificationInfoDiffblueTest {
  @Autowired
  private TaskProcessingFailureNotificationInfoBuilder taskProcessingFailureNotificationInfoBuilder;

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return size is seven.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TaskProcessingFailureNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsSeven() {
    // Arrange and Act
    Map<String, String> actualTemplateData =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build()
            .getTemplateData();

    // Assert
    assertEquals(7, actualTemplateData.size());
    assertEquals("1", actualTemplateData.get("attempt"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("entityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("An error occurred", actualTemplateData.get("error"));
    assertEquals("Task Description", actualTemplateData.get("taskDescription"));
    assertEquals("Tenant", actualTemplateData.get("entityType"));
    assertEquals("attributes deletion", actualTemplateData.get("taskType"));
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo2 =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(taskProcessingFailureNotificationInfo, taskProcessingFailureNotificationInfo2);
    assertEquals(
        taskProcessingFailureNotificationInfo.hashCode(),
        taskProcessingFailureNotificationInfo2.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(null)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo2 =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(null)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(taskProcessingFailureNotificationInfo, taskProcessingFailureNotificationInfo2);
    assertEquals(
        taskProcessingFailureNotificationInfo.hashCode(),
        taskProcessingFailureNotificationInfo2.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error(null)
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo2 =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error(null)
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(taskProcessingFailureNotificationInfo, taskProcessingFailureNotificationInfo2);
    assertEquals(
        taskProcessingFailureNotificationInfo.hashCode(),
        taskProcessingFailureNotificationInfo2.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription(null)
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo2 =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription(null)
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(taskProcessingFailureNotificationInfo, taskProcessingFailureNotificationInfo2);
    assertEquals(
        taskProcessingFailureNotificationInfo.hashCode(),
        taskProcessingFailureNotificationInfo2.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo2 =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(taskProcessingFailureNotificationInfo, taskProcessingFailureNotificationInfo2);
    assertEquals(
        taskProcessingFailureNotificationInfo.hashCode(),
        taskProcessingFailureNotificationInfo2.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(null)
            .build();
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo2 =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(null)
            .build();

    // Act and Assert
    assertEquals(taskProcessingFailureNotificationInfo, taskProcessingFailureNotificationInfo2);
    assertEquals(
        taskProcessingFailureNotificationInfo.hashCode(),
        taskProcessingFailureNotificationInfo2.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertEquals(taskProcessingFailureNotificationInfo, taskProcessingFailureNotificationInfo);
    int expectedHashCodeResult = taskProcessingFailureNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, taskProcessingFailureNotificationInfo.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(3)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(null)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TaskProcessingFailureNotificationInfoBuilder attemptResult =
        TaskProcessingFailureNotificationInfo.builder().attempt(1);
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        attemptResult
            .entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("Task Description")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error(null)
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("An error occurred")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription(null)
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_TELEMETRY)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TaskProcessingFailureNotificationInfoBuilder taskTypeResult =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        taskTypeResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TaskProcessingFailureNotificationInfo taskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(null)
            .build();

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureNotificationInfo,
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        null);
  }

  /**
   * Test {@link TaskProcessingFailureNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationInfo.equals(Object)",
    "int TaskProcessingFailureNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build(),
        "Different type to TaskProcessingFailureNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#TaskProcessingFailureNotificationInfo()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setAttempt(int)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setEntityId(EntityId)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setError(String)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTaskDescription(String)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTaskType(HousekeeperTaskType)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#toString()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getAffectedTenantId()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getAttempt()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getEntityId()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getError()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTaskDescription()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTaskType()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaskProcessingFailureNotificationInfo.<init>()",
    "void TaskProcessingFailureNotificationInfo.<init>(TenantId, EntityId, HousekeeperTaskType, String, String, int)",
    "TenantId TaskProcessingFailureNotificationInfo.getAffectedTenantId()",
    "int TaskProcessingFailureNotificationInfo.getAttempt()",
    "EntityId TaskProcessingFailureNotificationInfo.getEntityId()",
    "String TaskProcessingFailureNotificationInfo.getError()",
    "String TaskProcessingFailureNotificationInfo.getTaskDescription()",
    "HousekeeperTaskType TaskProcessingFailureNotificationInfo.getTaskType()",
    "TenantId TaskProcessingFailureNotificationInfo.getTenantId()",
    "void TaskProcessingFailureNotificationInfo.setAttempt(int)",
    "void TaskProcessingFailureNotificationInfo.setEntityId(EntityId)",
    "void TaskProcessingFailureNotificationInfo.setError(String)",
    "void TaskProcessingFailureNotificationInfo.setTaskDescription(String)",
    "void TaskProcessingFailureNotificationInfo.setTaskType(HousekeeperTaskType)",
    "void TaskProcessingFailureNotificationInfo.setTenantId(TenantId)",
    "String TaskProcessingFailureNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TaskProcessingFailureNotificationInfo actualTaskProcessingFailureNotificationInfo =
        new TaskProcessingFailureNotificationInfo();
    actualTaskProcessingFailureNotificationInfo.setAttempt(1);
    actualTaskProcessingFailureNotificationInfo.setEntityId(TenantId.SYS_TENANT_ID);
    actualTaskProcessingFailureNotificationInfo.setError("An error occurred");
    actualTaskProcessingFailureNotificationInfo.setTaskDescription("Task Description");
    actualTaskProcessingFailureNotificationInfo.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    actualTaskProcessingFailureNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualTaskProcessingFailureNotificationInfo.toString();
    TenantId actualAffectedTenantId =
        actualTaskProcessingFailureNotificationInfo.getAffectedTenantId();
    int actualAttempt = actualTaskProcessingFailureNotificationInfo.getAttempt();
    EntityId actualEntityId = actualTaskProcessingFailureNotificationInfo.getEntityId();
    String actualError = actualTaskProcessingFailureNotificationInfo.getError();
    String actualTaskDescription = actualTaskProcessingFailureNotificationInfo.getTaskDescription();
    HousekeeperTaskType actualTaskType = actualTaskProcessingFailureNotificationInfo.getTaskType();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals("Task Description", actualTaskDescription);
    assertEquals(
        "TaskProcessingFailureNotificationInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000"
            + "-1dd2-11b2-8080-808080808080, taskType=DELETE_ATTRIBUTES, taskDescription=Task Description, error=An"
            + " error occurred, attempt=1)",
        actualToStringResult);
    assertEquals(1, actualAttempt);
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualTaskType);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTaskProcessingFailureNotificationInfo.getTenantId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       TaskProcessingFailureNotificationInfo#TaskProcessingFailureNotificationInfo(TenantId,
   *       EntityId, HousekeeperTaskType, String, String, int)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setAttempt(int)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setEntityId(EntityId)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setError(String)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTaskDescription(String)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTaskType(HousekeeperTaskType)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#toString()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getAffectedTenantId()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getAttempt()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getEntityId()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getError()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTaskDescription()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTaskType()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaskProcessingFailureNotificationInfo.<init>()",
    "void TaskProcessingFailureNotificationInfo.<init>(TenantId, EntityId, HousekeeperTaskType, String, String, int)",
    "TenantId TaskProcessingFailureNotificationInfo.getAffectedTenantId()",
    "int TaskProcessingFailureNotificationInfo.getAttempt()",
    "EntityId TaskProcessingFailureNotificationInfo.getEntityId()",
    "String TaskProcessingFailureNotificationInfo.getError()",
    "String TaskProcessingFailureNotificationInfo.getTaskDescription()",
    "HousekeeperTaskType TaskProcessingFailureNotificationInfo.getTaskType()",
    "TenantId TaskProcessingFailureNotificationInfo.getTenantId()",
    "void TaskProcessingFailureNotificationInfo.setAttempt(int)",
    "void TaskProcessingFailureNotificationInfo.setEntityId(EntityId)",
    "void TaskProcessingFailureNotificationInfo.setError(String)",
    "void TaskProcessingFailureNotificationInfo.setTaskDescription(String)",
    "void TaskProcessingFailureNotificationInfo.setTaskType(HousekeeperTaskType)",
    "void TaskProcessingFailureNotificationInfo.setTenantId(TenantId)",
    "String TaskProcessingFailureNotificationInfo.toString()"
  })
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange and Act
    TaskProcessingFailureNotificationInfo actualTaskProcessingFailureNotificationInfo =
        new TaskProcessingFailureNotificationInfo(
            TenantId.SYS_TENANT_ID,
            TenantId.SYS_TENANT_ID,
            HousekeeperTaskType.DELETE_ATTRIBUTES,
            "Task Description",
            "An error occurred",
            1);
    actualTaskProcessingFailureNotificationInfo.setAttempt(1);
    actualTaskProcessingFailureNotificationInfo.setEntityId(TenantId.SYS_TENANT_ID);
    actualTaskProcessingFailureNotificationInfo.setError("An error occurred");
    actualTaskProcessingFailureNotificationInfo.setTaskDescription("Task Description");
    actualTaskProcessingFailureNotificationInfo.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    actualTaskProcessingFailureNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualTaskProcessingFailureNotificationInfo.toString();
    TenantId actualAffectedTenantId =
        actualTaskProcessingFailureNotificationInfo.getAffectedTenantId();
    int actualAttempt = actualTaskProcessingFailureNotificationInfo.getAttempt();
    EntityId actualEntityId = actualTaskProcessingFailureNotificationInfo.getEntityId();
    String actualError = actualTaskProcessingFailureNotificationInfo.getError();
    String actualTaskDescription = actualTaskProcessingFailureNotificationInfo.getTaskDescription();
    HousekeeperTaskType actualTaskType = actualTaskProcessingFailureNotificationInfo.getTaskType();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals("Task Description", actualTaskDescription);
    assertEquals(
        "TaskProcessingFailureNotificationInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000"
            + "-1dd2-11b2-8080-808080808080, taskType=DELETE_ATTRIBUTES, taskDescription=Task Description, error=An"
            + " error occurred, attempt=1)",
        actualToStringResult);
    assertEquals(1, actualAttempt);
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualTaskType);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTaskProcessingFailureNotificationInfo.getTenantId());
  }

  /**
   * Test TaskProcessingFailureNotificationInfoBuilder {@link
   * TaskProcessingFailureNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfoBuilder#build()}
   *   <li>{@link TaskProcessingFailureNotificationInfoBuilder#attempt(int)}
   *   <li>{@link TaskProcessingFailureNotificationInfoBuilder#entityId(EntityId)}
   *   <li>{@link TaskProcessingFailureNotificationInfoBuilder#error(String)}
   *   <li>{@link TaskProcessingFailureNotificationInfoBuilder#taskDescription(String)}
   *   <li>{@link TaskProcessingFailureNotificationInfoBuilder#taskType(HousekeeperTaskType)}
   *   <li>{@link TaskProcessingFailureNotificationInfoBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test TaskProcessingFailureNotificationInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaskProcessingFailureNotificationInfoBuilder.<init>()",
    "TaskProcessingFailureNotificationInfoBuilder TaskProcessingFailureNotificationInfoBuilder.attempt(int)",
    "TaskProcessingFailureNotificationInfo TaskProcessingFailureNotificationInfoBuilder.build()",
    "TaskProcessingFailureNotificationInfoBuilder TaskProcessingFailureNotificationInfoBuilder.entityId(EntityId)",
    "TaskProcessingFailureNotificationInfoBuilder TaskProcessingFailureNotificationInfoBuilder.error(String)",
    "TaskProcessingFailureNotificationInfoBuilder TaskProcessingFailureNotificationInfoBuilder.taskDescription(String)",
    "TaskProcessingFailureNotificationInfoBuilder TaskProcessingFailureNotificationInfoBuilder.taskType(HousekeeperTaskType)",
    "TaskProcessingFailureNotificationInfoBuilder TaskProcessingFailureNotificationInfoBuilder.tenantId(TenantId)",
    "String TaskProcessingFailureNotificationInfoBuilder.toString()"
  })
  void testTaskProcessingFailureNotificationInfoBuilderBuild() {
    // Arrange and Act
    TaskProcessingFailureNotificationInfo actualTaskProcessingFailureNotificationInfo =
        TaskProcessingFailureNotificationInfo.builder()
            .attempt(1)
            .entityId(TenantId.SYS_TENANT_ID)
            .error("An error occurred")
            .taskDescription("Task Description")
            .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();

    // Assert
    Map<String, String> templateData =
        actualTaskProcessingFailureNotificationInfo.getTemplateData();
    assertEquals(7, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("entityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    assertEquals("An error occurred", templateData.get("error"));
    assertEquals("An error occurred", actualTaskProcessingFailureNotificationInfo.getError());
    assertEquals("Task Description", templateData.get("taskDescription"));
    assertEquals(
        "Task Description", actualTaskProcessingFailureNotificationInfo.getTaskDescription());
    assertEquals("Tenant", templateData.get("entityType"));
    assertEquals("attributes deletion", templateData.get("taskType"));
    assertNull(actualTaskProcessingFailureNotificationInfo.getAffectedCustomerId());
    assertNull(actualTaskProcessingFailureNotificationInfo.getDashboardId());
    assertNull(actualTaskProcessingFailureNotificationInfo.getStateEntityId());
    assertNull(actualTaskProcessingFailureNotificationInfo.getAffectedUserId());
    assertEquals(1, actualTaskProcessingFailureNotificationInfo.getAttempt());
    assertEquals(
        HousekeeperTaskType.DELETE_ATTRIBUTES,
        actualTaskProcessingFailureNotificationInfo.getTaskType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualTaskProcessingFailureNotificationInfo.getAffectedTenantId());
    assertSame(tenantId, actualTaskProcessingFailureNotificationInfo.getEntityId());
    assertSame(tenantId, actualTaskProcessingFailureNotificationInfo.getTenantId());
  }
}
