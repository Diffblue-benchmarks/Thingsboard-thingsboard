package org.thingsboard.server.service.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.RuleNode;

class RuleNodeClassInfoDiffblueTest {
  /**
   * Test {@link RuleNodeClassInfo#getClassName()}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName(); given 'java.lang.Object'; then return 'java.lang.Object'")
  void testGetClassName_givenJavaLangObject_thenReturnJavaLangObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("java.lang.Object", (new RuleNodeClassInfo(clazz, mock(RuleNode.class))).getClassName());
  }

  /**
   * Test {@link RuleNodeClassInfo#getSimpleName()}.
   * <ul>
   *   <li>Given {@code java.lang.Object}.</li>
   *   <li>Then return {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#getSimpleName()}
   */
  @Test
  @DisplayName("Test getSimpleName(); given 'java.lang.Object'; then return 'Object'")
  void testGetSimpleName_givenJavaLangObject_thenReturnObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Object", (new RuleNodeClassInfo(clazz, mock(RuleNode.class))).getSimpleName());
  }

  /**
   * Test {@link RuleNodeClassInfo#getCurrentVersion()}.
   * <p>
   * Method under test: {@link RuleNodeClassInfo#getCurrentVersion()}
   */
  @Test
  @DisplayName("Test getCurrentVersion()")
  void testGetCurrentVersion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNode annotation = mock(RuleNode.class);
    when(annotation.version()).thenReturn(1);
    Class<Object> clazz = Object.class;

    // Act
    int actualCurrentVersion = (new RuleNodeClassInfo(clazz, annotation)).getCurrentVersion();

    // Assert
    verify(annotation).version();
    assertEquals(1, actualCurrentVersion);
  }

  /**
   * Test {@link RuleNodeClassInfo#isVersioned()}.
   * <ul>
   *   <li>Given {@link RuleNode} {@link RuleNode#version()} return one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given RuleNode version() return one; then return 'true'")
  void testIsVersioned_givenRuleNodeVersionReturnOne_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNode annotation = mock(RuleNode.class);
    when(annotation.version()).thenReturn(1);
    Class<Object> clazz = Object.class;

    // Act
    boolean actualIsVersionedResult = (new RuleNodeClassInfo(clazz, annotation)).isVersioned();

    // Assert
    verify(annotation).version();
    assertTrue(actualIsVersionedResult);
  }

  /**
   * Test {@link RuleNodeClassInfo#isVersioned()}.
   * <ul>
   *   <li>Given {@link RuleNode} {@link RuleNode#version()} return zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given RuleNode version() return zero; then return 'false'")
  void testIsVersioned_givenRuleNodeVersionReturnZero_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNode annotation = mock(RuleNode.class);
    when(annotation.version()).thenReturn(0);
    Class<Object> clazz = Object.class;

    // Act
    boolean actualIsVersionedResult = (new RuleNodeClassInfo(clazz, annotation)).isVersioned();

    // Assert
    verify(annotation).version();
    assertFalse(actualIsVersionedResult);
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}, and
   * {@link RuleNodeClassInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeClassInfo#equals(Object)}
   *   <li>{@link RuleNodeClassInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Class<Object> clazz = Object.class;
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(clazz, null);
    Class<Object> clazz2 = Object.class;
    RuleNodeClassInfo ruleNodeClassInfo2 = new RuleNodeClassInfo(clazz2, null);

    // Act and Assert
    assertEquals(ruleNodeClassInfo, ruleNodeClassInfo2);
    int expectedHashCodeResult = ruleNodeClassInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeClassInfo2.hashCode());
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}, and
   * {@link RuleNodeClassInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeClassInfo#equals(Object)}
   *   <li>{@link RuleNodeClassInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Class<Object> clazz = Object.class;
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(clazz, mock(RuleNode.class));

    // Act and Assert
    assertEquals(ruleNodeClassInfo, ruleNodeClassInfo);
    int expectedHashCodeResult = ruleNodeClassInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeClassInfo.hashCode());
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Class<Object> clazz = Object.class;
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(clazz, mock(RuleNode.class));
    Class<Object> clazz2 = Object.class;

    // Act and Assert
    assertNotEquals(ruleNodeClassInfo, new RuleNodeClassInfo(clazz2, mock(RuleNode.class)));
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Class<RuleNodeClassInfo> clazz = RuleNodeClassInfo.class;
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(clazz, mock(RuleNode.class));
    Class<Object> clazz2 = Object.class;

    // Act and Assert
    assertNotEquals(ruleNodeClassInfo, new RuleNodeClassInfo(clazz2, mock(RuleNode.class)));
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(null, mock(RuleNode.class));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNotEquals(ruleNodeClassInfo, new RuleNodeClassInfo(clazz, mock(RuleNode.class)));
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Class<Object> clazz = Object.class;
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(clazz, null);
    Class<Object> clazz2 = Object.class;

    // Act and Assert
    assertNotEquals(ruleNodeClassInfo, new RuleNodeClassInfo(clazz2, mock(RuleNode.class)));
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(null, mock(RuleNode.class));

    // Act and Assert
    assertNotEquals(ruleNodeClassInfo, new RuleNodeClassInfo(null, mock(RuleNode.class)));
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNotEquals(new RuleNodeClassInfo(clazz, mock(RuleNode.class)), null);
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNotEquals(new RuleNodeClassInfo(clazz, mock(RuleNode.class)), "Different type to RuleNodeClassInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeClassInfo#RuleNodeClassInfo(Class, RuleNode)}
   *   <li>{@link RuleNodeClassInfo#toString()}
   *   <li>{@link RuleNodeClassInfo#getAnnotation()}
   *   <li>{@link RuleNodeClassInfo#getClazz()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    Class<Object> clazz = Object.class;
    RuleNode annotation = mock(RuleNode.class);

    // Act
    RuleNodeClassInfo actualRuleNodeClassInfo = new RuleNodeClassInfo(clazz, annotation);
    actualRuleNodeClassInfo.toString();
    RuleNode actualAnnotation = actualRuleNodeClassInfo.getAnnotation();
    Class<?> actualClazz = actualRuleNodeClassInfo.getClazz();

    // Assert
    Class<Object> expectedClazz = Object.class;
    assertEquals(expectedClazz, actualClazz);
    assertSame(clazz, actualClazz);
    assertSame(annotation, actualAnnotation);
  }
}
