package org.thingsboard.server.service.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.RuleNode;

class RuleNodeClassInfoDiffblueTest {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertSame(annotation, actualAnnotation);
  }
}
