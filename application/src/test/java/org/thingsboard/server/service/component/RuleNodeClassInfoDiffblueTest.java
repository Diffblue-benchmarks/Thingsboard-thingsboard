package org.thingsboard.server.service.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.RuleNode;

@ExtendWith(MockitoExtension.class)
class RuleNodeClassInfoDiffblueTest {
  @Mock private RuleNode ruleNode;

  @InjectMocks private RuleNodeClassInfo ruleNodeClassInfo;

  /**
   * Test {@link RuleNodeClassInfo#getClassName()}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName(); given 'java.lang.Object'; then return 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String RuleNodeClassInfo.getClassName()"})
  void testGetClassName_givenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(
        "java.lang.Object", new RuleNodeClassInfo(clazz, mock(RuleNode.class)).getClassName());
  }

  /**
   * Test {@link RuleNodeClassInfo#getSimpleName()}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#getSimpleName()}
   */
  @Test
  @DisplayName("Test getSimpleName(); given 'java.lang.Object'; then return 'Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String RuleNodeClassInfo.getSimpleName()"})
  void testGetSimpleName_givenJavaLangObject_thenReturnObject() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("Object", new RuleNodeClassInfo(clazz, mock(RuleNode.class)).getSimpleName());
  }

  /**
   * Test {@link RuleNodeClassInfo#getCurrentVersion()}.
   *
   * <p>Method under test: {@link RuleNodeClassInfo#getCurrentVersion()}
   */
  @Test
  @DisplayName("Test getCurrentVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RuleNodeClassInfo.getCurrentVersion()"})
  void testGetCurrentVersion() {
    // Arrange
    when(ruleNode.version()).thenReturn(1);

    // Act
    int actualCurrentVersion = ruleNodeClassInfo.getCurrentVersion();

    // Assert
    verify(ruleNode).version();
    assertEquals(1, actualCurrentVersion);
  }

  /**
   * Test {@link RuleNodeClassInfo#isVersioned()}.
   *
   * <ul>
   *   <li>Given {@link RuleNode} {@link RuleNode#version()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given RuleNode version() return one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeClassInfo.isVersioned()"})
  void testIsVersioned_givenRuleNodeVersionReturnOne_thenReturnTrue() {
    // Arrange
    when(ruleNode.version()).thenReturn(1);

    // Act
    boolean actualIsVersionedResult = ruleNodeClassInfo.isVersioned();

    // Assert
    verify(ruleNode).version();
    assertTrue(actualIsVersionedResult);
  }

  /**
   * Test {@link RuleNodeClassInfo#isVersioned()}.
   *
   * <ul>
   *   <li>Given {@link RuleNode} {@link RuleNode#version()} return zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given RuleNode version() return zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeClassInfo.isVersioned()"})
  void testIsVersioned_givenRuleNodeVersionReturnZero_thenReturnFalse() {
    // Arrange
    when(ruleNode.version()).thenReturn(0);

    // Act
    boolean actualIsVersionedResult = ruleNodeClassInfo.isVersioned();

    // Assert
    verify(ruleNode).version();
    assertFalse(actualIsVersionedResult);
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}, and {@link RuleNodeClassInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeClassInfo#equals(Object)}
   *   <li>{@link RuleNodeClassInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
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
   * Test {@link RuleNodeClassInfo#equals(Object)}, and {@link RuleNodeClassInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeClassInfo#equals(Object)}
   *   <li>{@link RuleNodeClassInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(null, mock(RuleNode.class));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNotEquals(ruleNodeClassInfo, new RuleNodeClassInfo(clazz, mock(RuleNode.class)));
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeClassInfo ruleNodeClassInfo = new RuleNodeClassInfo(null, mock(RuleNode.class));

    // Act and Assert
    assertNotEquals(ruleNodeClassInfo, new RuleNodeClassInfo(null, mock(RuleNode.class)));
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNotEquals(new RuleNodeClassInfo(clazz, mock(RuleNode.class)), null);
  }

  /**
   * Test {@link RuleNodeClassInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeClassInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleNodeClassInfo.equals(Object)",
    "int RuleNodeClassInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNotEquals(
        new RuleNodeClassInfo(clazz, mock(RuleNode.class)), "Different type to RuleNodeClassInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeClassInfo#RuleNodeClassInfo(Class, RuleNode)}
   *   <li>{@link RuleNodeClassInfo#toString()}
   *   <li>{@link RuleNodeClassInfo#getAnnotation()}
   *   <li>{@link RuleNodeClassInfo#getClazz()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RuleNodeClassInfo.<init>(Class, RuleNode)",
    "RuleNode RuleNodeClassInfo.getAnnotation()",
    "Class RuleNodeClassInfo.getClazz()",
    "java.lang.String RuleNodeClassInfo.toString()"
  })
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
