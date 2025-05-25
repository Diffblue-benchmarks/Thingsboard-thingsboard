package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ContactBasedEntityDetailsDiffblueTest {
  /**
   * Test {@link ContactBasedEntityDetails#getRuleEngineName()}.
   * <p>
   * Method under test: {@link ContactBasedEntityDetails#getRuleEngineName()}
   */
  @Test
  @DisplayName("Test getRuleEngineName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ContactBasedEntityDetails.getRuleEngineName()"})
  void testGetRuleEngineName() {
    // Arrange, Act and Assert
    assertEquals("id", ContactBasedEntityDetails.valueOf("ID").getRuleEngineName());
  }
}
