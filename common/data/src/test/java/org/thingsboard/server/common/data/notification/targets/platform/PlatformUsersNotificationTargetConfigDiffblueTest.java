package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetType;

class PlatformUsersNotificationTargetConfigDiffblueTest {
  /**
   * Test {@link PlatformUsersNotificationTargetConfig#equals(Object)}, and {@link PlatformUsersNotificationTargetConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformUsersNotificationTargetConfig#equals(Object)}
   *   <li>{@link PlatformUsersNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformUsersNotificationTargetConfig.equals(Object)",
      "int PlatformUsersNotificationTargetConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(null);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig2 = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig2.setUsersFilter(null);

    // Act and Assert
    assertEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig2);
    int expectedHashCodeResult = platformUsersNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, platformUsersNotificationTargetConfig2.hashCode());
  }

  /**
   * Test {@link PlatformUsersNotificationTargetConfig#equals(Object)}, and {@link PlatformUsersNotificationTargetConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformUsersNotificationTargetConfig#equals(Object)}
   *   <li>{@link PlatformUsersNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformUsersNotificationTargetConfig.equals(Object)",
      "int PlatformUsersNotificationTargetConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig);
    int expectedHashCodeResult = platformUsersNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, platformUsersNotificationTargetConfig.hashCode());
  }

  /**
   * Test {@link PlatformUsersNotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformUsersNotificationTargetConfig.equals(Object)",
      "int PlatformUsersNotificationTargetConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig2 = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig2.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig2);
  }

  /**
   * Test {@link PlatformUsersNotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformUsersNotificationTargetConfig.equals(Object)",
      "int PlatformUsersNotificationTargetConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("Description");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig2 = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig2.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig2);
  }

  /**
   * Test {@link PlatformUsersNotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformUsersNotificationTargetConfig.equals(Object)",
      "int PlatformUsersNotificationTargetConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(null);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig2 = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig2.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig2);
  }

  /**
   * Test {@link PlatformUsersNotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformUsersNotificationTargetConfig.equals(Object)",
      "int PlatformUsersNotificationTargetConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, null);
  }

  /**
   * Test {@link PlatformUsersNotificationTargetConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PlatformUsersNotificationTargetConfig.equals(Object)",
      "int PlatformUsersNotificationTargetConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, "Different type to PlatformUsersNotificationTargetConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PlatformUsersNotificationTargetConfig}
   *   <li>{@link PlatformUsersNotificationTargetConfig#setUsersFilter(UsersFilter)}
   *   <li>{@link PlatformUsersNotificationTargetConfig#toString()}
   *   <li>{@link PlatformUsersNotificationTargetConfig#getType()}
   *   <li>{@link PlatformUsersNotificationTargetConfig#getUsersFilter()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PlatformUsersNotificationTargetConfig.<init>()",
      "NotificationTargetType PlatformUsersNotificationTargetConfig.getType()",
      "UsersFilter PlatformUsersNotificationTargetConfig.getUsersFilter()",
      "void PlatformUsersNotificationTargetConfig.setUsersFilter(UsersFilter)",
      "java.lang.String PlatformUsersNotificationTargetConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    PlatformUsersNotificationTargetConfig actualPlatformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    UsersFilter usersFilter = mock(UsersFilter.class);
    actualPlatformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    actualPlatformUsersNotificationTargetConfig.toString();
    NotificationTargetType actualType = actualPlatformUsersNotificationTargetConfig.getType();
    UsersFilter actualUsersFilter = actualPlatformUsersNotificationTargetConfig.getUsersFilter();

    // Assert
    assertNull(actualPlatformUsersNotificationTargetConfig.getDescription());
    assertEquals(NotificationTargetType.PLATFORM_USERS, actualType);
    assertSame(usersFilter, actualUsersFilter);
  }
}
