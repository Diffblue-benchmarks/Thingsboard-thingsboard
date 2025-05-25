package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRuleNodeProfilerInfoDiffblueTest {
  /**
   * Test {@link TbRuleNodeProfilerInfo#TbRuleNodeProfilerInfo(UUID)}.
   * <ul>
   *   <li>Then return Label is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#TbRuleNodeProfilerInfo(UUID)}
   */
  @Test
  @DisplayName("Test new TbRuleNodeProfilerInfo(UUID); then return Label is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRuleNodeProfilerInfo.<init>(UUID)"})
  void testNewTbRuleNodeProfilerInfo_thenReturnLabelIsEmptyString() {
    // Arrange
    UUID ruleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    TbRuleNodeProfilerInfo actualTbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(ruleNodeId);

    // Assert
    assertEquals("", actualTbRuleNodeProfilerInfo.getLabel());
    assertEquals(0, actualTbRuleNodeProfilerInfo.getExecutionCount());
    assertEquals(0.0d, actualTbRuleNodeProfilerInfo.getAvgExecutionTime());
    assertEquals(0L, actualTbRuleNodeProfilerInfo.getMaxExecutionTime());
    assertSame(ruleNodeId, actualTbRuleNodeProfilerInfo.getRuleNodeId());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#record(long)}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#record(long)}
   */
  @Test
  @DisplayName("Test record(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRuleNodeProfilerInfo.record(long)"})
  void testRecord() {
    // Arrange
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    tbRuleNodeProfilerInfo.record(1L);

    // Assert
    assertEquals(1, tbRuleNodeProfilerInfo.getExecutionCount());
    assertEquals(1.0d, tbRuleNodeProfilerInfo.getAvgExecutionTime());
    assertEquals(1L, tbRuleNodeProfilerInfo.getMaxExecutionTime());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#record(long)}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#record(long)}
   */
  @Test
  @DisplayName("Test record(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRuleNodeProfilerInfo.record(long)"})
  void testRecord2() {
    // Arrange
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    tbRuleNodeProfilerInfo.record(-1L);

    // Assert
    assertEquals(-1.0d, tbRuleNodeProfilerInfo.getAvgExecutionTime());
    assertEquals(0L, tbRuleNodeProfilerInfo.getMaxExecutionTime());
    assertEquals(1, tbRuleNodeProfilerInfo.getExecutionCount());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getExecutionCount()}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getExecutionCount()}
   */
  @Test
  @DisplayName("Test getExecutionCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbRuleNodeProfilerInfo.getExecutionCount()"})
  void testGetExecutionCount() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TbRuleNodeProfilerInfo(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))).getExecutionCount());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getMaxExecutionTime()}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getMaxExecutionTime()}
   */
  @Test
  @DisplayName("Test getMaxExecutionTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbRuleNodeProfilerInfo.getMaxExecutionTime()"})
  void testGetMaxExecutionTime() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new TbRuleNodeProfilerInfo(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))).getMaxExecutionTime());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getAvgExecutionTime()}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getAvgExecutionTime()}
   */
  @Test
  @DisplayName("Test getAvgExecutionTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double TbRuleNodeProfilerInfo.getAvgExecutionTime()"})
  void testGetAvgExecutionTime() {
    // Arrange, Act and Assert
    assertEquals(0.0d,
        (new TbRuleNodeProfilerInfo(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))).getAvgExecutionTime());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRuleNodeProfilerInfo#getLabel()}
   *   <li>{@link TbRuleNodeProfilerInfo#getRuleNodeId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbRuleNodeProfilerInfo.getLabel()", "UUID TbRuleNodeProfilerInfo.getRuleNodeId()"})
  void testGettersAndSetters() {
    // Arrange
    UUID ruleNodeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(ruleNodeId);

    // Act
    String actualLabel = tbRuleNodeProfilerInfo.getLabel();
    UUID actualRuleNodeId = tbRuleNodeProfilerInfo.getRuleNodeId();

    // Assert
    assertEquals("", actualLabel);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualRuleNodeId.toString());
    assertSame(ruleNodeId, actualRuleNodeId);
  }
}
