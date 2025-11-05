package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class UserEmailInfoDiffblueTest {
  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe");
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe");

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    assertEquals(userEmailInfo.hashCode(), userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserId id = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserEmailInfo userEmailInfo = new UserEmailInfo(id, "jane.doe@example.org", "Jane", "Doe");
    UserId id2 = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(id2, "jane.doe@example.org", "Jane", "Doe");

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    assertEquals(userEmailInfo.hashCode(), userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, null, "Jane", "Doe");
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(null, null, "Jane", "Doe");

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    assertEquals(userEmailInfo.hashCode(), userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", null, "Doe");
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(null, "jane.doe@example.org", null, "Doe");

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    assertEquals(userEmailInfo.hashCode(), userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", null);
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(null, "jane.doe@example.org", "Jane", null);

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    assertEquals(userEmailInfo.hashCode(), userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserId id = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserEmailInfo userEmailInfo = new UserEmailInfo(id, "jane.doe@example.org", "Jane", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "john.smith@example.org", "Jane", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, null, "Jane", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "John", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", null, "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Smith");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", null);

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange, Act and Assert
    assertNotEquals(new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"), 1);
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "john.smith@example.org", "Jane", "Doe");
    UserId id = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(id, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#getId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserEmailInfo#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserId UserEmailInfo.getId()"})
  void testGetId_thenReturnNull() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe");

    // Act and Assert
    assertNull(userEmailInfo.getId());
  }
}
