package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRenameKeysNodeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbRenameKeysNode}
   *   <li>{@link TbRenameKeysNode#getKeyToUpgradeFromVersionOne()}
   *   <li>{@link TbRenameKeysNode#getNewKeyForUpgradeFromVersionZero()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRenameKeysNode.<init>()", "String TbRenameKeysNode.getKeyToUpgradeFromVersionOne()",
      "String TbRenameKeysNode.getNewKeyForUpgradeFromVersionZero()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbRenameKeysNode actualTbRenameKeysNode = new TbRenameKeysNode();
    String actualKeyToUpgradeFromVersionOne = actualTbRenameKeysNode.getKeyToUpgradeFromVersionOne();

    // Assert
    assertEquals("fromMetadata", actualKeyToUpgradeFromVersionOne);
    assertEquals("renameIn", actualTbRenameKeysNode.getNewKeyForUpgradeFromVersionZero());
  }
}
