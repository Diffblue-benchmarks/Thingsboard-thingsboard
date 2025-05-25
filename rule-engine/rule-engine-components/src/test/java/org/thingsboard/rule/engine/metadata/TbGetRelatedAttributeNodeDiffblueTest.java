package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbGetRelatedAttributeNodeDiffblueTest {
  /**
   * Test new {@link TbGetRelatedAttributeNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbGetRelatedAttributeNode}
   */
  @Test
  @DisplayName("Test new TbGetRelatedAttributeNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetRelatedAttributeNode.<init>()"})
  void testNewTbGetRelatedAttributeNode() {
    // Arrange and Act
    TbGetRelatedAttributeNode actualTbGetRelatedAttributeNode = new TbGetRelatedAttributeNode();

    // Assert
    assertNull(actualTbGetRelatedAttributeNode.config);
    assertNull(actualTbGetRelatedAttributeNode.fetchTo);
  }
}
