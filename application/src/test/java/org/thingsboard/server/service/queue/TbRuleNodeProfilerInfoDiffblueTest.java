package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.msg.queue.RuleNodeInfo;

@DisabledInAotMode
class TbRuleNodeProfilerInfoDiffblueTest {
  @MockBean
  private TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo;

  /**
   * Test {@link TbRuleNodeProfilerInfo#TbRuleNodeProfilerInfo(UUID)}.
   * <p>
   * Method under test:
   * {@link TbRuleNodeProfilerInfo#TbRuleNodeProfilerInfo(UUID)}
   */
  @Test
  @DisplayName("Test new TbRuleNodeProfilerInfo(UUID)")
  void testNewTbRuleNodeProfilerInfo() {
    // Arrange
    UUID ruleNodeId = UUID.randomUUID();

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
   * Test {@link TbRuleNodeProfilerInfo#TbRuleNodeProfilerInfo(RuleNodeInfo)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleNodeProfilerInfo#TbRuleNodeProfilerInfo(RuleNodeInfo)}
   */
  @Test
  @DisplayName("Test new TbRuleNodeProfilerInfo(RuleNodeInfo); given randomUUID; then calls getId()")
  void testNewTbRuleNodeProfilerInfo_givenRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeId id = mock(RuleNodeId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(id.getId()).thenReturn(randomUUIDResult);

    // Act
    TbRuleNodeProfilerInfo actualTbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(
        new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name"));

    // Assert
    verify(id).getId();
    assertEquals(0, actualTbRuleNodeProfilerInfo.getExecutionCount());
    assertEquals(0.0d, actualTbRuleNodeProfilerInfo.getAvgExecutionTime());
    assertEquals(0L, actualTbRuleNodeProfilerInfo.getMaxExecutionTime());
    assertSame(randomUUIDResult, actualTbRuleNodeProfilerInfo.getRuleNodeId());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#TbRuleNodeProfilerInfo(RuleNodeInfo)}.
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleNodeProfilerInfo#TbRuleNodeProfilerInfo(RuleNodeInfo)}
   */
  @Test
  @DisplayName("Test new TbRuleNodeProfilerInfo(RuleNodeInfo); when RuleNodeId(UUID) with id is randomUUID")
  void testNewTbRuleNodeProfilerInfo_whenRuleNodeIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID id = UUID.randomUUID();

    // Act
    TbRuleNodeProfilerInfo actualTbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(
        new RuleNodeInfo(new RuleNodeId(id), "Rule Chain Name", "Rule Node Name"));

    // Assert
    assertEquals(0, actualTbRuleNodeProfilerInfo.getExecutionCount());
    assertEquals(0.0d, actualTbRuleNodeProfilerInfo.getAvgExecutionTime());
    assertEquals(0L, actualTbRuleNodeProfilerInfo.getMaxExecutionTime());
    assertSame(id, actualTbRuleNodeProfilerInfo.getRuleNodeId());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#record(long)}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#record(long)}
   */
  @Test
  @DisplayName("Test record(long)")
  void testRecord() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(UUID.randomUUID());

    // Act
    tbRuleNodeProfilerInfo.record(1L);

    // Assert
    assertEquals("", tbRuleNodeProfilerInfo.getLabel());
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
  void testRecord2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(UUID.randomUUID());

    // Act
    tbRuleNodeProfilerInfo.record(-1L);

    // Assert
    assertEquals("", tbRuleNodeProfilerInfo.getLabel());
    assertEquals(-1.0d, tbRuleNodeProfilerInfo.getAvgExecutionTime());
    assertEquals(0L, tbRuleNodeProfilerInfo.getMaxExecutionTime());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#record(long)}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#record(long)}
   */
  @Test
  @DisplayName("Test record(long)")
  void testRecord3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeId id = mock(RuleNodeId.class);
    when(id.getId()).thenReturn(UUID.randomUUID());
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(
        new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name"));

    // Act
    tbRuleNodeProfilerInfo.record(1L);

    // Assert
    verify(id).getId();
    assertEquals(1.0d, tbRuleNodeProfilerInfo.getAvgExecutionTime());
    assertEquals(1L, tbRuleNodeProfilerInfo.getMaxExecutionTime());
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getExecutionCount()}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getExecutionCount()}
   */
  @Test
  @DisplayName("Test getExecutionCount()")
  void testGetExecutionCount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(UUID.randomUUID());

    // Act
    int actualExecutionCount = tbRuleNodeProfilerInfo.getExecutionCount();

    // Assert
    assertEquals("", tbRuleNodeProfilerInfo.getLabel());
    assertEquals(0, actualExecutionCount);
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getExecutionCount()}.
   * <ul>
   *   <li>Given {@link RuleNodeId} {@link UUIDBased#getId()} return
   * randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getExecutionCount()}
   */
  @Test
  @DisplayName("Test getExecutionCount(); given RuleNodeId getId() return randomUUID; then calls getId()")
  void testGetExecutionCount_givenRuleNodeIdGetIdReturnRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeId id = mock(RuleNodeId.class);
    when(id.getId()).thenReturn(UUID.randomUUID());

    // Act
    int actualExecutionCount = (new TbRuleNodeProfilerInfo(new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name")))
        .getExecutionCount();

    // Assert
    verify(id).getId();
    assertEquals(0, actualExecutionCount);
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getMaxExecutionTime()}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getMaxExecutionTime()}
   */
  @Test
  @DisplayName("Test getMaxExecutionTime()")
  void testGetMaxExecutionTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(UUID.randomUUID());

    // Act
    long actualMaxExecutionTime = tbRuleNodeProfilerInfo.getMaxExecutionTime();

    // Assert
    assertEquals("", tbRuleNodeProfilerInfo.getLabel());
    assertEquals(0L, actualMaxExecutionTime);
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getMaxExecutionTime()}.
   * <ul>
   *   <li>Given {@link RuleNodeId} {@link UUIDBased#getId()} return
   * randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getMaxExecutionTime()}
   */
  @Test
  @DisplayName("Test getMaxExecutionTime(); given RuleNodeId getId() return randomUUID; then calls getId()")
  void testGetMaxExecutionTime_givenRuleNodeIdGetIdReturnRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeId id = mock(RuleNodeId.class);
    when(id.getId()).thenReturn(UUID.randomUUID());

    // Act
    long actualMaxExecutionTime = (new TbRuleNodeProfilerInfo(
        new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name"))).getMaxExecutionTime();

    // Assert
    verify(id).getId();
    assertEquals(0L, actualMaxExecutionTime);
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getAvgExecutionTime()}.
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getAvgExecutionTime()}
   */
  @Test
  @DisplayName("Test getAvgExecutionTime()")
  void testGetAvgExecutionTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(UUID.randomUUID());

    // Act
    double actualAvgExecutionTime = tbRuleNodeProfilerInfo.getAvgExecutionTime();

    // Assert
    assertEquals("", tbRuleNodeProfilerInfo.getLabel());
    assertEquals(0.0d, actualAvgExecutionTime);
  }

  /**
   * Test {@link TbRuleNodeProfilerInfo#getAvgExecutionTime()}.
   * <ul>
   *   <li>Given {@link RuleNodeId} {@link UUIDBased#getId()} return
   * randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleNodeProfilerInfo#getAvgExecutionTime()}
   */
  @Test
  @DisplayName("Test getAvgExecutionTime(); given RuleNodeId getId() return randomUUID; then calls getId()")
  void testGetAvgExecutionTime_givenRuleNodeIdGetIdReturnRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleNodeId id = mock(RuleNodeId.class);
    when(id.getId()).thenReturn(UUID.randomUUID());

    // Act
    double actualAvgExecutionTime = (new TbRuleNodeProfilerInfo(
        new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name"))).getAvgExecutionTime();

    // Assert
    verify(id).getId();
    assertEquals(0.0d, actualAvgExecutionTime);
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
  void testGettersAndSetters() {
    // Arrange
    UUID ruleNodeId = UUID.randomUUID();
    TbRuleNodeProfilerInfo tbRuleNodeProfilerInfo = new TbRuleNodeProfilerInfo(ruleNodeId);

    // Act
    String actualLabel = tbRuleNodeProfilerInfo.getLabel();

    // Assert
    assertEquals("", actualLabel);
    assertSame(ruleNodeId, tbRuleNodeProfilerInfo.getRuleNodeId());
  }
}
