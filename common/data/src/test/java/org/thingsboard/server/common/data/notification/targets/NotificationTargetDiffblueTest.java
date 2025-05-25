package org.thingsboard.server.common.data.notification.targets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;

class NotificationTargetDiffblueTest {
  /**
   * Test {@link NotificationTarget#equals(Object)}, and {@link NotificationTarget#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    NotificationTarget notificationTarget2 = new NotificationTarget();

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}, and {@link NotificationTarget#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setTenantId(TenantId.SYS_TENANT_ID);

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}, and {@link NotificationTarget#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setName("Name");

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setName("Name");

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}, and {@link NotificationTarget#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}, and {@link NotificationTarget#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setExternalId(new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2
        .setExternalId(new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}, and {@link NotificationTarget#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget.hashCode());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTarget(), 1);
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setName("Name");

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setExternalId(new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationTarget, notificationTarget2);
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setName("Name");

    // Act and Assert
    assertNotEquals(notificationTarget, notificationTarget2);
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    assertNotEquals(notificationTarget, notificationTarget2);
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2
        .setExternalId(new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(notificationTarget, notificationTarget2);
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTarget(), null);
  }

  /**
   * Test {@link NotificationTarget#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationTarget.equals(Object)", "int NotificationTarget.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTarget(), "Different type to NotificationTarget");
  }

  /**
   * Test {@link NotificationTarget#getExternalId()}.
   * <p>
   * Method under test: {@link NotificationTarget#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTargetId NotificationTarget.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new NotificationTarget()).getExternalId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#NotificationTarget()}
   *   <li>{@link NotificationTarget#setConfiguration(NotificationTargetConfig)}
   *   <li>{@link NotificationTarget#setExternalId(NotificationTargetId)}
   *   <li>{@link NotificationTarget#setName(String)}
   *   <li>{@link NotificationTarget#setTenantId(TenantId)}
   *   <li>{@link NotificationTarget#toString()}
   *   <li>{@link NotificationTarget#getConfiguration()}
   *   <li>{@link NotificationTarget#getName()}
   *   <li>{@link NotificationTarget#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTarget.<init>()",
      "NotificationTargetConfig NotificationTarget.getConfiguration()", "String NotificationTarget.getName()",
      "TenantId NotificationTarget.getTenantId()", "void NotificationTarget.setConfiguration(NotificationTargetConfig)",
      "void NotificationTarget.setExternalId(NotificationTargetId)", "void NotificationTarget.setName(String)",
      "void NotificationTarget.setTenantId(TenantId)", "String NotificationTarget.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationTarget actualNotificationTarget = new NotificationTarget();
    MicrosoftTeamsNotificationTargetConfig configuration = new MicrosoftTeamsNotificationTargetConfig();
    actualNotificationTarget.setConfiguration(configuration);
    NotificationTargetId externalId = new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationTarget.setExternalId(externalId);
    actualNotificationTarget.setName("Name");
    actualNotificationTarget.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualNotificationTarget.toString();
    NotificationTargetConfig actualConfiguration = actualNotificationTarget.getConfiguration();
    String actualName = actualNotificationTarget.getName();
    TenantId actualTenantId = actualNotificationTarget.getTenantId();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("NotificationTarget(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, configuration=Microsoft"
        + "TeamsNotificationTargetConfig(webhookUrl=null, channelName=null, useOldApi=true), externalId=784f394c"
        + "-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertNull(actualNotificationTarget.getId());
    assertEquals(0L, actualNotificationTarget.getCreatedTime());
    assertSame(externalId, actualNotificationTarget.getExternalId());
    assertSame(configuration, actualConfiguration);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link NotificationTarget#NotificationTarget(NotificationTarget)}.
   * <p>
   * Method under test: {@link NotificationTarget#NotificationTarget(NotificationTarget)}
   */
  @Test
  @DisplayName("Test new NotificationTarget(NotificationTarget)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTarget.<init>(NotificationTarget)"})
  void testNewNotificationTarget() {
    // Arrange
    NotificationTarget other = new NotificationTarget();

    // Act and Assert
    assertEquals(other, new NotificationTarget(other));
  }
}
