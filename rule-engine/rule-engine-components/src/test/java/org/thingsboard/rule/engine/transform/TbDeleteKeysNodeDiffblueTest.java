package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbDeleteKeysNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeleteKeysNode}
   *   <li>{@link TbDeleteKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbDeleteKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDeleteKeysNode.<init>()", "String TbDeleteKeysNode.getKeyToUpgradeFromVersionOne()",
      "String TbDeleteKeysNode.getNewKeyForUpgradeFromVersionZero()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeleteKeysNode actualTbDeleteKeysNode = new TbDeleteKeysNode();
    String actualKeyToUpgradeFromVersionOne = actualTbDeleteKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("dataToFetch", actualKeyToUpgradeFromVersionOne);
    assertEquals("deleteFrom", actualTbDeleteKeysNode.getNewKeyForUpgradeFromVersionZero());
  }
}
